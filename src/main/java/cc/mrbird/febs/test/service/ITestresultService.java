package cc.mrbird.febs.test.service;

import cc.mrbird.febs.test.entity.Testresult;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author MrBird
 * @date 2020-02-16 18:13:15
 */
public interface ITestresultService extends IService<Testresult> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param testresult testresult
     * @return IPage<Testresult>
     */
    IPage<Testresult> findTestresults(QueryRequest request, Testresult testresult);

    /**
     * 查询（所有）
     *
     * @param testresult testresult
     * @return List<Testresult>
     */
    List<Testresult> findTestresults(Testresult testresult);

    /**
     * 新增
     *
     * @param testresult testresult
     */
    void createTestresult(Testresult testresult);

    /**
     * 修改
     *
     * @param testresult testresult
     */
    void updateTestresult(Testresult testresult);

    /**
     * 删除
     *
     * @param testresult testresult
     */
    void deleteTestresult(Testresult testresult);
}
