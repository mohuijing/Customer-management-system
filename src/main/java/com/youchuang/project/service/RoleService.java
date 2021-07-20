package com.youchuang.project.service;

import com.youchuang.project.entity.Role;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author mohuijing
 * @since 2021-05-15
 */
public interface RoleService extends MyService<Role> {
    /**
     * 新增角色及角色所具的资源
     * @param role
     * @return
     */
    boolean saveRole(Role role);

    boolean updateRole(Role role);

}
