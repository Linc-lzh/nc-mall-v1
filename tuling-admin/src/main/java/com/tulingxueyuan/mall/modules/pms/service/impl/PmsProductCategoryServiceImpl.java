package com.tulingxueyuan.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.modules.pms.mapper.PmsProductCategoryAttributeRelationMapper;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import com.tulingxueyuan.mall.modules.pms.mapper.PmsProductCategoryMapper;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategoryAttributeRelation;
import com.tulingxueyuan.mall.modules.pms.model.dto.PmsProductCategoryDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductCategoryAttributeRelationService;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@Service
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryMapper, PmsProductCategory> implements PmsProductCategoryService {

    @Autowired
    PmsProductCategoryAttributeRelationService relationService;

    @Autowired
    PmsProductCategoryMapper productCategoryMapper;
    /**
     * Get Product Category List
     *
     * @param parentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public Page list(Long parentId, Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum, pageSize);
        QueryWrapper<PmsProductCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PmsProductCategory::getParentId, parentId)
                .orderByAsc(PmsProductCategory::getSort);
        return this.page(page, queryWrapper);
    }

    /**
     * Update nav status
     *
     * @param ids
     * @param navStatus
     * @return
     */
    @Override
    public boolean updateNavStatus(List<Long> ids, Integer navStatus) {
        UpdateWrapper<PmsProductCategory> pmsProductCategoryUpdateWrapper = new UpdateWrapper<>();
        pmsProductCategoryUpdateWrapper.lambda()
                .set(PmsProductCategory::getNavStatus, navStatus)
                .in(PmsProductCategory::getId, ids);
        return this.update(pmsProductCategoryUpdateWrapper);
    }

    @Override
    public boolean updateShowStatus(List<Long> ids, Integer showStatus) {
        UpdateWrapper<PmsProductCategory> pmsProductCategoryUpdateWrapper = new UpdateWrapper<>();
        pmsProductCategoryUpdateWrapper.lambda()
                .set(PmsProductCategory::getShowStatus, showStatus)
                .in(PmsProductCategory::getId, ids);
        return this.update(pmsProductCategoryUpdateWrapper);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean customSave(PmsProductCategoryDTO pmsProductCategoryDTO) {
        PmsProductCategory productCategory = new PmsProductCategoryDTO();
        BeanUtils.copyProperties(pmsProductCategoryDTO, productCategory);
        productCategory.setProductCount(0);
        if(productCategory.getParentId() == 0){
            productCategory.setLevel(0);
        }
        else {
            productCategory.setLevel(1);
        }

        this.save(productCategory);
        saveAttrRelation(pmsProductCategoryDTO, productCategory);

        return true;
    }

    @Override
    public boolean update(PmsProductCategoryDTO productCategoryDTO) {
        PmsProductCategory productCategory = new PmsProductCategoryDTO();
        BeanUtils.copyProperties(productCategoryDTO, productCategory);
        this.updateById(productCategory);

        QueryWrapper<PmsProductCategoryAttributeRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(PmsProductCategoryAttributeRelation::getProductCategoryId, productCategory.getId());
        relationService.remove(queryWrapper);
        saveAttrRelation(productCategoryDTO, productCategory);

        return true;
    }

    @Override
    public List<PmsProductCategory> getWithChildren() {
        return productCategoryMapper.getWithChildren();
    }

    private boolean saveAttrRelation(PmsProductCategoryDTO productCategoryDTO, PmsProductCategory productCategory) {
        List<Long> productAttributeIdList = productCategoryDTO.getProductAttributeIdList();
        List<PmsProductCategoryAttributeRelation> list = new ArrayList<>();
        for (Long attId : productAttributeIdList) {
            PmsProductCategoryAttributeRelation productCategoryAttributeRelation = new PmsProductCategoryAttributeRelation();
            productCategoryAttributeRelation.setProductCategoryId(productCategory.getId());
            productCategoryAttributeRelation.setProductAttributeId(attId);
            list.add(productCategoryAttributeRelation);
        }
        return relationService.saveBatch(list);
    }
}
