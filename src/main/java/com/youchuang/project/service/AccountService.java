package com.youchuang.project.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.youchuang.project.dto.LoginDTO;
import com.youchuang.project.entity.Account;

/**
 * <p>
 * 账号表 服务类
 * </p>
 *
 * @author mohuijing
 * @since 2021-05-15
 */
public interface AccountService extends MyService<Account>{
    LoginDTO login(String username, String password);

    /**
     * 分页查询账号
     * @param page
     * @param wrapperr
     * @return
     */
    IPage<Account> accountPage(Page<Account> page, Wrapper<Account> wrapperr);

    /**
     * 根据accountId查询账号信息
     * @param id
     * @return
     */
    Account getAccountById(Long id);
}
