package cc.mrbird.febs.test.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.test.entity.Task;
import cc.mrbird.febs.test.service.ITaskService;
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
 * @date 2020-02-16 18:13:19
 */
@Slf4j
@Validated
@Controller
public class TaskController extends BaseController {

    @Autowired
    private ITaskService taskService;

    @GetMapping(FebsConstant.VIEW_PREFIX + "task")
    public String taskIndex(){
        return FebsUtil.view("task/task");
    }

    @GetMapping("task")
    @ResponseBody
    @RequiresPermissions("task:list")
    public FebsResponse getAllTasks(Task task) {
        return new FebsResponse().success().data(taskService.findTasks(task));
    }

    @GetMapping("task/list")
    @ResponseBody
    @RequiresPermissions("task:list")
    public FebsResponse taskList(QueryRequest request, Task task) {
        Map<String, Object> dataTable = getDataTable(this.taskService.findTasks(request, task));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Task", exceptionMessage = "新增Task失败")
    @PostMapping("task")
    @ResponseBody
    @RequiresPermissions("task:add")
    public FebsResponse addTask(@Valid Task task) {
        this.taskService.createTask(task);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Task", exceptionMessage = "删除Task失败")
    @GetMapping("task/delete")
    @ResponseBody
    @RequiresPermissions("task:delete")
    public FebsResponse deleteTask(Task task) {
        this.taskService.deleteTask(task);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Task", exceptionMessage = "修改Task失败")
    @PostMapping("task/update")
    @ResponseBody
    @RequiresPermissions("task:update")
    public FebsResponse updateTask(Task task) {
        this.taskService.updateTask(task);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Task", exceptionMessage = "导出Excel失败")
    @PostMapping("task/excel")
    @ResponseBody
    @RequiresPermissions("task:export")
    public void export(QueryRequest queryRequest, Task task, HttpServletResponse response) {
        List<Task> tasks = this.taskService.findTasks(queryRequest, task).getRecords();
        ExcelKit.$Export(Task.class, response).downXlsx(tasks, false);
    }
}
