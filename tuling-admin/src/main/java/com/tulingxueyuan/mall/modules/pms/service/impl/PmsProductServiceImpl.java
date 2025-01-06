package com.tulingxueyuan.mall.modules.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.modules.pms.model.PmsProduct;
import com.tulingxueyuan.mall.modules.pms.mapper.PmsProductMapper;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductConditionDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {

    @Override
    public Page list(ProductConditionDTO condition) {
        Page page = new Page(condition.getPageNum(), condition.getPageSize());

        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsProduct> lambdaWrapper = queryWrapper.lambda();
        if(!StrUtil.isBlank(condition.getKeyword())){
            lambdaWrapper.like(PmsProduct::getName, condition.getKeyword());
        }

        if(!StrUtil.isBlank(condition.getProductSn())){
            lambdaWrapper.eq(PmsProduct::getProductSn, condition.getProductSn());
        }

        if(condition.getProductCategoryId() != null && condition.getProductCategoryId() > 0){
            lambdaWrapper.eq(PmsProduct::getProductCategoryId, condition.getProductCategoryId());
        }

        if(condition.getBrandId() != null && condition.getBrandId() > 0){
            lambdaWrapper.eq(PmsProduct::getBrandId, condition.getBrandId());
        }

        if(condition.getPublishStatus() != null){
            lambdaWrapper.eq(PmsProduct::getPublishStatus, condition.getPublishStatus());
        }

        if(condition.getVerifyStatus() != null){
            lambdaWrapper.eq(PmsProduct::getVerifyStatus, condition.getVerifyStatus());
        }

        return this.page(page, lambdaWrapper);
    }
}
