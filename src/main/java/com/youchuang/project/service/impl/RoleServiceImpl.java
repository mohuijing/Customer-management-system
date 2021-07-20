package com.youchuang.project.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youchuang.project.dao.RoleMapper;
import com.youchuang.project.dao.RoleResourceMapper;
import com.youchuang.project.entity.Role;
import com.youchuang.project.entity.RoleResource;
import com.youchuang.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author mohuijing
 * @since 2021-05-14
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    /**
     * 新增角色及角色所具的资源
     * @param role
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveRole(Role role) {
        save(role);

        Long roleId = role.getRoleId();
        List<Long> resourceIds = role.getResourceIds();

        if (CollectionUtils.isNotEmpty(resourceIds)) {
            for (Long resourceId : resourceIds) {
                RoleResource roleResource = new RoleResource();
                roleResource.setRoleId(roleId);
                roleResource.setResourceId(resourceId);
                roleResourceMapper.insert(roleResource);
            }
        }
        return true;
    }

    /**
     * 修改角色及角色所具有的资源
     * @param role
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)

    public boolean updateRole(Role role) {
        Long roleId = role.getRoleId();

        updateById(role);

        System.out.println("role = " + role);
        System.out.println("role.getRoleId() = " + role.getRoleId());

        roleResourceMapper.delete(Wrappers.<RoleResource>lambdaQuery().eq(RoleResource::getRoleId, roleId));

        List<Long> resourceIds = role.getResourceIds();

        if (CollectionUtils.isNotEmpty(resourceIds)) {
            for (Long resourceId : resourceIds) {
                RoleResource roleResource = new RoleResource();
                roleResource.setRoleId(roleId);
                roleResource.setResourceId(resourceId);
                roleResourceMapper.insert(roleResource);
            }
        }
        return true;
    }
}
