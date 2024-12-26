package com.tulingxueyuan.mall.modules.ums.dto;

import com.tulingxueyuan.mall.modules.ums.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 后台菜单节点封装
 * @author Linc
 * @since 2024-12-26
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}
