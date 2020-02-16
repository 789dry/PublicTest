package cc.mrbird.febs.test.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.test.entity.Testcase;
import cc.mrbird.febs.test.service.ITestcaseService;
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
 * @date 2020-02-16 18:13:17
 */
@Slf4j
@Validated
@Controller
public class TestcaseController extends BaseController {

    @Autowired
    private ITestcaseService testcaseService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "testcase")
    public String testcaseIndex(){
        return FebsUtil.view("testcase/testcase");
    }

    @GetMapping("testcase")
    @ResponseBody
    @RequiresPermissions("testcase:list")
    public FebsResponse getAllTestcases(Testcase testcase) {
        return new FebsResponse().success().data(testcaseService.findTestcases(testcase));
    }

    @GetMapping("testcase/list")
    @ResponseBody
    @RequiresPermissions("testcase:list")
    public FebsResponse testcaseList(QueryRequest request, Testcase testcase) {
        Map<String, Object> dataTable = getDataTable(this.testcaseService.findTestcases(request, testcase));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Testcase", exceptionMessage = "新增Testcase失败")
    @PostMapping("testcase")
    @ResponseBody
    @RequiresPermissions("testcase:add")
    public FebsResponse addTestcase(@Valid Testcase testcase) {
        this.testcaseService.createTestcase(testcase);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Testcase", exceptionMessage = "删除Testcase失败")
    @GetMapping("testcase/delete")
    @ResponseBody
    @RequiresPermissions("testcase:delete")
    public FebsResponse deleteTestcase(Testcase testcase) {
        this.testcaseService.deleteTestcase(testcase);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Testcase", exceptionMessage = "修改Testcase失败")
    @PostMapping("testcase/update")
    @ResponseBody
    @RequiresPermissions("testcase:update")
    public FebsResponse updateTestcase(Testcase testcase) {
        this.testcaseService.updateTestcase(testcase);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Testcase", exceptionMessage = "导出Excel失败")
    @PostMapping("testcase/excel")
    @ResponseBody
    @RequiresPermissions("testcase:export")
    public void export(QueryRequest queryRequest, Testcase testcase, HttpServletResponse response) {
        List<Testcase> testcases = this.testcaseService.findTestcases(queryRequest, testcase).getRecords();
        ExcelKit.$Export(Testcase.class, response).downXlsx(testcases, false);
    }
}
