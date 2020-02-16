package cc.mrbird.febs.test.service;

import cc.mrbird.febs.test.entity.Testcase;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *  Service接口
 *
 * @author MrBird
 * @date 2020-02-16 18:13:17
 */
public interface ITestcaseService extends IService<Testcase> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param testcase testcase
     * @return IPage<Testcase>
     */
    IPage<Testcase> findTestcases(QueryRequest request, Testcase testcase);

    /**
     * 查询（所有）
     *
     * @param testcase testcase
     * @return List<Testcase>
     */
    List<Testcase> findTestcases(Testcase testcase);

    /**
     * 新增
     *
     * @param testcase testcase
     */
    void createTestcase(Testcase testcase);

    /**
     * 修改
     *
     * @param testcase testcase
     */
    void updateTestcase(Testcase testcase);

    /**
     * 删除
     *
     * @param testcase testcase
     */
    void deleteTestcase(Testcase testcase);
}
