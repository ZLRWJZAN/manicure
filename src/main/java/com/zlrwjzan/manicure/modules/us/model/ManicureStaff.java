package com.zlrwjzan.manicure.modules.us.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manicure_staff")
@ApiModel(value="ManicureStaff对象", description="员工表")
public class ManicureStaff implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "老师ID")
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "薪资")
    private BigDecimal pay;

    @ApiModelProperty(value = "负责项目")
    private String project;

    @ApiModelProperty(value = "项目提成")
    private BigDecimal royaltyRate;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "大头照")
    private String photoAddress;

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
