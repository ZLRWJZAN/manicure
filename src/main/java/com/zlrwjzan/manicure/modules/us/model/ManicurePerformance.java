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
 * 业绩表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manicure_performance")
@ApiModel(value="ManicurePerformance对象", description="业绩表")
public class ManicurePerformance implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "日期")
    private Date date;

    @ApiModelProperty(value = "款式金额")
    private BigDecimal styleMoney;

    @ApiModelProperty(value = "老师利润")
    private BigDecimal royaltyRate;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private String deleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


}
