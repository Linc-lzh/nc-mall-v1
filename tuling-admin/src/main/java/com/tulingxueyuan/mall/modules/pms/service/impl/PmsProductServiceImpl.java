package com.tulingxueyuan.mall.modules.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tulingxueyuan.mall.modules.pms.model.PmsMemberPrice;
import com.tulingxueyuan.mall.modules.pms.model.PmsProduct;
import com.tulingxueyuan.mall.modules.pms.mapper.PmsProductMapper;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductConditionDTO;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductSaveParamsDTO;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductUpdateInitDTO;
import com.tulingxueyuan.mall.modules.pms.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

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

    @Autowired
    PmsProductMapper productMapper;

    @Autowired
    PmsMemberPriceService memberPriceService;

    @Autowired
    PmsProductLadderService productLadderService;

    @Autowired
    PmsProductFullReductionService productFullReductionService;

    @Autowired
    PmsSkuStockService skuStockService;

    @Autowired
    PmsProductAttributeValueService productAttributeValueService;

    @Override
    public Page list(ProductConditionDTO condition) {
        Page page = new Page(condition.getPageNum(), condition.getPageSize());

        QueryWrapper<PmsProduct> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsProduct> lambdaWrapper = queryWrapper.lambda();
        if (!StrUtil.isBlank(condition.getKeyword())) {
            lambdaWrapper.like(PmsProduct::getName, condition.getKeyword());
        }

        if (!StrUtil.isBlank(condition.getProductSn())) {
            lambdaWrapper.eq(PmsProduct::getProductSn, condition.getProductSn());
        }

        if (condition.getProductCategoryId() != null && condition.getProductCategoryId() > 0) {
            lambdaWrapper.eq(PmsProduct::getProductCategoryId, condition.getProductCategoryId());
        }

        if (condition.getBrandId() != null && condition.getBrandId() > 0) {
            lambdaWrapper.eq(PmsProduct::getBrandId, condition.getBrandId());
        }

        if (condition.getPublishStatus() != null) {
            lambdaWrapper.eq(PmsProduct::getPublishStatus, condition.getPublishStatus());
        }

        if (condition.getVerifyStatus() != null) {
            lambdaWrapper.eq(PmsProduct::getVerifyStatus, condition.getVerifyStatus());
        }
        lambdaWrapper.orderByAsc(PmsProduct::getSort);
        return this.page(page, lambdaWrapper);
    }

    @Override
    public boolean updateStatus(Integer status, List<Long> ids, SFunction<PmsProduct, ?> getStatus) {
        UpdateWrapper<PmsProduct> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(getStatus, status)
                .in(PmsProduct::getId, ids);
        return this.update(updateWrapper);
    }

    @Override
    @Transactional
    public boolean create(ProductSaveParamsDTO productSaveParamsDTO) {
        PmsProduct product = productSaveParamsDTO;
        product.setId(null);
        boolean result = this.save(product);

        if (result) {
            switch (product.getPromotionType()) {
                case 2:
                    saveManyList(productSaveParamsDTO.getMemberPriceList(), product.getId(), memberPriceService);
                    break;
                case 3:
                    saveManyList(productSaveParamsDTO.getProductLadderList(), product.getId(), productLadderService);
                    break;
                case 4:
                    saveManyList(productSaveParamsDTO.getProductFullReductionList(), product.getId(), productFullReductionService);
                    break;
            }

            saveManyList(productSaveParamsDTO.getSkuStockList(), product.getId(), skuStockService);
            saveManyList(productSaveParamsDTO.getProductAttributeValueList(), product.getId(), productAttributeValueService);
        }
        return result;
    }

    @Override
    public ProductUpdateInitDTO getUpdateInfo(Long id) {
        return productMapper.getUpdateInfo(id);
    }

    @Override
    @Transactional
    public boolean update(ProductSaveParamsDTO productSaveParamsDTO) {
        PmsProduct product = productSaveParamsDTO;
        boolean result = this.updateById(product);

        if (result) {
            switch (product.getPromotionType()) {
                case 2:
                    deleteManyListByProductId(product.getId(), memberPriceService);
                    saveManyList(productSaveParamsDTO.getMemberPriceList(), product.getId(), memberPriceService);
                    break;
                case 3:
                    deleteManyListByProductId(product.getId(), productLadderService);
                    saveManyList(productSaveParamsDTO.getProductLadderList(), product.getId(), productLadderService);
                    break;
                case 4:
                    deleteManyListByProductId(product.getId(), productFullReductionService);
                    saveManyList(productSaveParamsDTO.getProductFullReductionList(), product.getId(), productFullReductionService);
                    break;
            }

            deleteManyListByProductId(product.getId(), skuStockService);
            saveManyList(productSaveParamsDTO.getSkuStockList(), product.getId(), skuStockService);

            deleteManyListByProductId(product.getId(), productAttributeValueService);
            saveManyList(productSaveParamsDTO.getProductAttributeValueList(), product.getId(), productAttributeValueService);
        }
        return result;
    }

    public void deleteManyListByProductId(Long productId, IService service){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("product_id", productId);
        service.remove(queryWrapper);
    }

    public void saveManyList(List list, Long productId, IService service) {
        if (CollectionUtils.isEmpty(list)) return;
        try {
            for (Object obj : list) {
                Method setProductIdMethod = obj.getClass().getMethod("setProductId", Long.class);

                Method setId = obj.getClass().getMethod("setId", Long.class);
                setId.invoke(obj, (Long)null);

                setProductIdMethod.invoke(obj, productId);
            }

            service.saveBatch(list);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
