package com.tulingxueyuan.mall.modules.pms.mapper;

import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
public interface PmsProductCategoryMapper extends BaseMapper<PmsProductCategory> {

    List<PmsProductCategory> getWithChildren();
}
