package com.zlrwjzan.manicure.modules.us.controller;


import com.zlrwjzan.manicure.common.api.CommonResult;
import com.zlrwjzan.manicure.modules.us.dto.ManicureStaffParam;
import com.zlrwjzan.manicure.modules.us.model.ManicureStaff;
import com.zlrwjzan.manicure.modules.us.service.ManicureStaffService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
@RestController
@RequestMapping("/us/manicureStaff")
public class ManicureStaffController {

    @Autowired
    private ManicureStaffService manicureStaffServicel;

    @ApiOperation(value = "员工注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonResult<ManicureStaff> register(@Validated @RequestBody ManicureStaffParam manicureStaffParam){
        ManicureStaff manicureStaff=manicureStaffServicel.register(manicureStaffParam);
        if(manicureStaff==null){
            return CommonResult.failed();
        }
        return CommonResult.success(manicureStaff);
    }
}

