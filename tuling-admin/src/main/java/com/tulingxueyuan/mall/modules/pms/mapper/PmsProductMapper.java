package com.tulingxueyuan.mall.modules.pms.mapper;

import com.tulingxueyuan.mall.modules.pms.model.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductUpdateInitDTO;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
public interface PmsProductMapper extends BaseMapper<PmsProduct> {

    ProductUpdateInitDTO getUpdateInfo(Long id);
}
