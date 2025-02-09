package com.tulingxueyuan.mall.dto;

import com.tulingxueyuan.mall.modules.ums.model.UmsResource;
import com.tulingxueyuan.mall.modules.ums.model.UmsRole;
import lombok.Data;

import java.util.List;

/***
 * @author Linc
 * @since 2025-02-09
 */
@Data
public class ResourceRoleDTO extends UmsResource {

    private List<UmsRole> roleList;
}
