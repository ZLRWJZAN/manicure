package com.zlrwjzan.manicure.modules.us.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ManicureStaffParam {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @NotEmpty
    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "住址")
    private String address;
}
