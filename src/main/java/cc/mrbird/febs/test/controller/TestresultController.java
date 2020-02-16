package cc.mrbird.febs.test.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.test.entity.Testresult;
import cc.mrbird.febs.test.service.ITestresultService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 *  Controller
 *
 * @author MrBird
 * @date 2020-02-16 18:13:15
 */
@Slf4j
@Validated
@Controller
public class TestresultController extends BaseController {

    @Autowired
    private ITestresultService testresultService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "testresult")
    public String testresultIndex(){
        return FebsUtil.view("testresult/testresult");
    }

    @GetMapping("testresult")
    @ResponseBody
    @RequiresPermissions("testresult:list")
    public FebsResponse getAllTestresults(Testresult testresult) {
        return new FebsResponse().success().data(testresultService.findTestresults(testresult));
    }

    @GetMapping("testresult/list")
    @ResponseBody
    @RequiresPermissions("testresult:list")
    public FebsResponse testresultList(QueryRequest request, Testresult testresult) {
        Map<String, Object> dataTable = getDataTable(this.testresultService.findTestresults(request, testresult));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Testresult", exceptionMessage = "新增Testresult失败")
    @PostMapping("testresult")
    @ResponseBody
    @RequiresPermissions("testresult:add")
    public FebsResponse addTestresult(@Valid Testresult testresult) {
        this.testresultService.createTestresult(testresult);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Testresult", exceptionMessage = "删除Testresult失败")
    @GetMapping("testresult/delete")
    @ResponseBody
    @RequiresPermissions("testresult:delete")
    public FebsResponse deleteTestresult(Testresult testresult) {
        this.testresultService.deleteTestresult(testresult);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Testresult", exceptionMessage = "修改Testresult失败")
    @PostMapping("testresult/update")
    @ResponseBody
    @RequiresPermissions("testresult:update")
    public FebsResponse updateTestresult(Testresult testresult) {
        this.testresultService.updateTestresult(testresult);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Testresult", exceptionMessage = "导出Excel失败")
    @PostMapping("testresult/excel")
    @ResponseBody
    @RequiresPermissions("testresult:export")
    public void export(QueryRequest queryRequest, Testresult testresult, HttpServletResponse response) {
        List<Testresult> testresults = this.testresultService.findTestresults(queryRequest, testresult).getRecords();
        ExcelKit.$Export(Testresult.class, response).downXlsx(testresults, false);
    }
}
