package com.youchuang.project.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface MyMapper<T> extends BaseMapper<T> {


    /**
     * 逻辑删除自带填充功能
     * @param entity
     * @return
     */
    int deleteByIdWithFill(@Param("entity") T entity);
}
