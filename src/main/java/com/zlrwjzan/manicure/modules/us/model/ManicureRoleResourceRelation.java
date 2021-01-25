package com.zlrwjzan.manicure.modules.us.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限资源关系表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("manicure_role_resource_relation")
@ApiModel(value="ManicureRoleResourceRelation对象", description="权限资源关系表")
public class ManicureRoleResourceRelation implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private Integer id;

    @ApiModelProperty(value = "权限ID")
    private Integer roleId;

    @ApiModelProperty(value = "资源ID")
    private Integer resourceId;


}
