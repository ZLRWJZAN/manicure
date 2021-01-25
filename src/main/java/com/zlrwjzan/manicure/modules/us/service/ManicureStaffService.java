package com.zlrwjzan.manicure.modules.us.service;

import com.zlrwjzan.manicure.modules.us.dto.ManicureStaffParam;
import com.zlrwjzan.manicure.modules.us.model.ManicureResource;
import com.zlrwjzan.manicure.modules.us.model.ManicureStaff;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
public interface ManicureStaffService extends IService<ManicureStaff> {
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String phone);

    /**
     * 根据手机号码获取后台管理员
     */
    ManicureStaff getAdminByUsername(String phone);

    /**
     * 获取指定用户的可访问资源
     */
    List<ManicureResource> getResourceList(String adminId);

    /**
     * 员工注册
     * @param manicureStaffParam
     */
    ManicureStaff register(ManicureStaffParam manicureStaffParam);
}
