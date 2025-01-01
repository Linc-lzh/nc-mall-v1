package com.tulingxueyuan.mall.modules.pms.mapper;

import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttribute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tulingxueyuan.mall.modules.pms.model.dto.RelationAttrInfoDTO;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 Mapper 接口
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
public interface PmsProductAttributeMapper extends BaseMapper<PmsProductAttribute> {

    List<RelationAttrInfoDTO> getRelationAttrInfoByCid(Long cId);
}
