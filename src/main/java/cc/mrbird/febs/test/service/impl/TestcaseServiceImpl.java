package cc.mrbird.febs.test.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.test.entity.Testcase;
import cc.mrbird.febs.test.mapper.TestcaseMapper;
import cc.mrbird.febs.test.service.ITestcaseService;
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
 * @date 2020-02-16 18:13:17
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestcaseServiceImpl extends ServiceImpl<TestcaseMapper, Testcase> implements ITestcaseService {

    @Autowired
    private TestcaseMapper testcaseMapper;

    @Override
    public IPage<Testcase> findTestcases(QueryRequest request, Testcase testcase) {
        LambdaQueryWrapper<Testcase> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Testcase> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Testcase> findTestcases(Testcase testcase) {
	    LambdaQueryWrapper<Testcase> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createTestcase(Testcase testcase) {
        this.save(testcase);
    }

    @Override
    @Transactional
    public void updateTestcase(Testcase testcase) {
        this.saveOrUpdate(testcase);
    }

    @Override
    @Transactional
    public void deleteTestcase(Testcase testcase) {
        LambdaQueryWrapper<Testcase> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
