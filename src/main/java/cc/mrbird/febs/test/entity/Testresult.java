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
 * @date 2020-02-16 18:13:15
 */
@Data
@TableName("t_testresult")
public class Testresult {

    /**
     * 
     */
    @TableId(value = "RESULT_ID", type = IdType.AUTO)
    private Long resultId;

    /**
     * 
     */
    @TableField("TASK_ID")
    private Long taskId;

    /**
     * 用例ID
     */
    @TableField("TESTCASE_ID")
    private Long testcaseId;

    /**
     * 测试结果，如果通过为1，不通过则为0
     */
    @TableField("TESTRESULT")
    private Integer testresult;

    /**
     * 测试用例执行结果，以文字描述
     */
    @TableField("EXEC_RESULT")
    private String execResult;

    /**
     * 测试用例执行结果图
     */
    @TableField("EXEC_RESULT_PIC")
    private String execResultPic;

    /**
     * 测试人
     */
    @TableField("TESTER")
    private String tester;

    /**
     * 测试时间
     */
    @TableField("TEST_TIME")
    private Date testTime;

    /**
     * 手机型号
     */
    @TableField("MOBILE_MODEL")
    private String mobileModel;

    /**
     * 手机序列号
     */
    @TableField("MOBILE_SERIAL")
    private String mobileSerial;

    /**
     * 手机系统
     */
    @TableField("MOBILE_SYSTEM")
    private String mobileSystem;

    /**
     * 
     */
    @TableField("t_testcase_CASE_ID")
    private Long tTestcaseCaseId;

}
