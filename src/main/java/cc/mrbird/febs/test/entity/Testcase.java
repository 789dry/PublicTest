package cc.mrbird.febs.test.entity;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *  Entity
 *
 * @author MrBird
 * @date 2020-02-16 18:13:17
 */
@Data
@TableName("t_testcase")
public class Testcase {

    /**
     * 用例ID
     */
    @TableId(value = "CASE_ID", type = IdType.AUTO)
    private Long caseId;

    /**
     * 任务ID
     */
    @TableField("TASK_ID")
    private Long taskId;

    /**
     * 用例名
     */
    @TableField("TESTCASE_NAME")
    private String testcaseName;

    /**
     * 用例描述
     */
    @TableField("TESTCASE_DESC")
    private String testcaseDesc;

    /**
     * 用例执行步骤
     */
    @TableField("TEST_STEP")
    private String testStep;

    /**
     * 测试用例预期执行结果--文字描述
     */
    @TableField("EXPECT_RESULT")
    private String expectResult;

    /**
     * 测试用例预期执行结果--截图
     */
    @TableField("EXPECT_RESULT_PIC")
    private String expectResultPic;

    /**
     * 创建日期
     */
    @TableField("CREATE_DATE")
    private Date createDate;

    /**
     * 更新日期
     */
    @TableField("UPDATE_DATE")
    private Date updateDate;

    /**
     * 
     */
    @TableField("t_task_TASK_ID")
    private Long tTaskTaskId;

}
