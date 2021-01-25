package com.zlrwjzan.manicure.modules.us.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户预约表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manicure_appointment")
@ApiModel(value="ManicureAppointment对象", description="用户预约表")
public class ManicureAppointment implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "预约ID")
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "员工ID")
    private String staffId;

    @ApiModelProperty(value = "项目ID")
    private String projectId;

    @ApiModelProperty(value = "预约款式ID")
    private String styleId;

    @ApiModelProperty(value = "状态(1:预约,2:进行中,3:已完成,4:客户超时)")
    private String state;

    @ApiModelProperty(value = "预约时间")
    private Date time;

    @ApiModelProperty(value = "超时时间")
    private Date overTime;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private String deleted;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}
