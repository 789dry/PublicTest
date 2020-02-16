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
 * @date 2020-02-16 18:13:19
 */
@Data
@TableName("t_task")
public class Task {

    /**
     * 任务ID
     */
    @TableId(value = "TASK_ID", type = IdType.AUTO)
    private Long taskId;

    /**
     * 
     */
    @TableField("DEPT_ID")
    private Long deptId;

    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private Long userId;

    /**
     * 任务名
     */
    @TableField("TASK_NAME")
    private String taskName;

    /**
     * 任务描述
     */
    @TableField("TASK_DESC")
    private String taskDesc;

    /**
     * 任务状态(未开始、进行中、结束、废弃、终止)	
     */
    @TableField("TSAK_STATUS")
    private Integer tsakStatus;

    /**
     * 开始时间
     */
    @TableField("START_TIME")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("END_TIME")
    private Date endTime;

    /**
     * 众测机型，该任务所需要覆盖的机型
     */
    @TableField("TEST_MOBILE_MODEL")
    private String testMobileModel;

    /**
     * 
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

}
