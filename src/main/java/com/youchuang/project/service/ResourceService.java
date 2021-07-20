package com.youchuang.project.service;

import com.youchuang.project.entity.Resource;
import com.youchuang.project.vo.ResourceVO;
import com.youchuang.project.vo.TreeVO;

import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author mohuijing
 * @since 2021-05-15
 */
public interface ResourceService extends MyService<Resource> {

    /**
     * 根据角色id，查询角色所具有的资源
     * @param roleId
     * @return
     */
    List<ResourceVO> listResourceByRoleId(Long roleId);

    /**
     * 查询系统资源，供前端组件渲染
     * @return
     */
    List<TreeVO>listResource(Long roleId, Integer flag);
}
