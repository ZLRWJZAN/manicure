package com.zlrwjzan.manicure.modules.us.service;

import com.zlrwjzan.manicure.modules.us.model.ManicureResource;
import com.zlrwjzan.manicure.modules.us.model.ManicureStaff;

import java.util.List;

/**
 * 后台用户缓存管理Service
 * Created by macro on 2020/3/13.
 */
public interface ManicureStaffCacheService {
    /**
     * 删除后台用户资源列表缓存
     */
    void delResourceList(String staffId);

    /**
     * 获取缓存后台用户信息
     */
    ManicureStaff getAdmin(String phone);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(ManicureStaff admin);

    /**
     * 获取缓存后台用户资源列表
     */
    List<ManicureResource> getResourceList(String staffId);

    /**
     * 设置后台后台用户资源列表
     */
    void setResourceList(String staffId, List<ManicureResource> resourceList);
}
