package cc.mrbird.febs.test.service;

import cc.mrbird.febs.test.entity.Task;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author MrBird
 * @date 2020-02-16 18:13:19
 */
public interface ITaskService extends IService<Task> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param task task
     * @return IPage<Task>
     */
    IPage<Task> findTasks(QueryRequest request, Task task);

    /**
     * 查询（所有）
     *
     * @param task task
     * @return List<Task>
     */
    List<Task> findTasks(Task task);

    /**
     * 新增
     *
     * @param task task
     */
    void createTask(Task task);

    /**
     * 修改
     *
     * @param task task
     */
    void updateTask(Task task);

    /**
     * 删除
     *
     * @param task task
     */
    void deleteTask(Task task);
}
