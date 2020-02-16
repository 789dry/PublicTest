package cc.mrbird.febs.test.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.test.entity.Task;
import cc.mrbird.febs.test.mapper.TaskMapper;
import cc.mrbird.febs.test.service.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *  Service实现
 *
 * @author MrBird
 * @date 2020-02-16 18:13:19
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public IPage<Task> findTasks(QueryRequest request, Task task) {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Task> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Task> findTasks(Task task) {
	    LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createTask(Task task) {
        this.save(task);
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        this.saveOrUpdate(task);
    }

    @Override
    @Transactional
    public void deleteTask(Task task) {
        LambdaQueryWrapper<Task> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
