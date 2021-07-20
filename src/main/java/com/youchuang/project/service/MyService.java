package com.youchuang.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.youchuang.project.dao.MyMapper;

public interface MyService<T> extends IService<T> {
    default boolean removeByIdWithFill(T entity) {
        int count = ((MyMapper<T>) getBaseMapper()).deleteByIdWithFill(entity);
        // 大于0返回true 否则返回false
        return SqlHelper.retBool(count);
    }

}

