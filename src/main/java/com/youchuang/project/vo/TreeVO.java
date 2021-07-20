package com.youchuang.project.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: mohuijing
 */
@Data
public class TreeVO {
    //标题
    private String title;
    //id
    private Long id;

    private List<TreeVO> children;
    //选中
    private boolean checked;
}
