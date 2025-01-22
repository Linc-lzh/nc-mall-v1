package com.tulingxueyuan.mall.modules.pms.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import com.tulingxueyuan.mall.modules.pms.model.PmsSkuStock;
import com.tulingxueyuan.mall.modules.pms.mapper.PmsSkuStockMapper;
import com.tulingxueyuan.mall.modules.pms.service.PmsSkuStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@Service
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockMapper, PmsSkuStock> implements PmsSkuStockService {

    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsSkuStockService skuStockService;

    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        QueryWrapper<PmsSkuStock> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PmsSkuStock::getProductId, pid)
                .like(!StringUtils.isEmpty(keyword), PmsSkuStock::getSkuCode, keyword);

        return skuStockService.list(queryWrapper);
    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
        //return skuStockDao.replaceList(skuStockList);
        return 0;
    }
}
