package com.youchuang.project.dto;

import com.youchuang.project.entity.Account;
import lombok.Data;

/**
 * @author: mohuijing
 */
@Data
public class LoginDTO {
    /**
     * 重定向或跳转的路径
     */
    private String path;

    /**
     * 错误提示信息
     */
    private String error;

    /**
     * 当前登录人的信息
     */
    private Account account;
}

