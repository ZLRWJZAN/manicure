package com.zlrwjzan.manicure.modules.us.mapper;

import com.zlrwjzan.manicure.modules.us.model.ManicureResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台资源表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-22
 */
public interface ManicureResourceMapper extends BaseMapper<ManicureResource> {
    /**
     * 获取用户所有可访问资源
     */
    List<ManicureResource> getResourceList(@Param("staffId") String staffId);
}
