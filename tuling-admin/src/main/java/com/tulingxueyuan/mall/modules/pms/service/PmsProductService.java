package com.tulingxueyuan.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.modules.pms.model.PmsProduct;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductConditionDTO;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
public interface PmsProductService extends IService<PmsProduct> {

    Page list(ProductConditionDTO condition);
}
