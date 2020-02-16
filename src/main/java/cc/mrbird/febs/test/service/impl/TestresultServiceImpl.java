package cc.mrbird.febs.test.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.test.entity.Testresult;
import cc.mrbird.febs.test.mapper.TestresultMapper;
import cc.mrbird.febs.test.service.ITestresultService;
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
 * @date 2020-02-16 18:13:15
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TestresultServiceImpl extends ServiceImpl<TestresultMapper, Testresult> implements ITestresultService {

    @Autowired
    private TestresultMapper testresultMapper;

    @Override
    public IPage<Testresult> findTestresults(QueryRequest request, Testresult testresult) {
        LambdaQueryWrapper<Testresult> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Testresult> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Testresult> findTestresults(Testresult testresult) {
	    LambdaQueryWrapper<Testresult> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createTestresult(Testresult testresult) {
        this.save(testresult);
    }

    @Override
    @Transactional
    public void updateTestresult(Testresult testresult) {
        this.saveOrUpdate(testresult);
    }

    @Override
    @Transactional
    public void deleteTestresult(Testresult testresult) {
        LambdaQueryWrapper<Testresult> wrapper = new LambdaQueryWrapper<>();
	    // TODO 设置删除条件
	    this.remove(wrapper);
	}
}
