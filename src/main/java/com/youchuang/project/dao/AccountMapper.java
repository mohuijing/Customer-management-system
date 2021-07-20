package com.youchuang.project.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youchuang.project.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 账号表 Mapper 接口
 * </p>
 *
 * @author mohuijing
 * @since 2021-05-15
 */
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 分页查询账号
     * @param page
     * @param wrapperr
     * @return
     */
    IPage<Account> accountPage(Page<Account> page, @Param(Constants.WRAPPER) Wrapper<Account> wrapperr);

    /**
     * 根据accountId查询账号信息
     * @param id
     * @return
     */
    Account selectAccountById(Long id);
}
