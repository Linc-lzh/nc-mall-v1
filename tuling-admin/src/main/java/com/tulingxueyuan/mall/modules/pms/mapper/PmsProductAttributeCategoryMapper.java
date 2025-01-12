package com.tulingxueyuan.mall.modules.pms.mapper;

import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttributeCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductAttributeCateDTO;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 Mapper 接口
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
public interface PmsProductAttributeCategoryMapper extends BaseMapper<PmsProductAttributeCategory> {

    List<ProductAttributeCateDTO> getListWithAttr();
}
