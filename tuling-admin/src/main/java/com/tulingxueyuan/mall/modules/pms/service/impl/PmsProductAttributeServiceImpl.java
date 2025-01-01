package com.tulingxueyuan.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttribute;
import com.tulingxueyuan.mall.modules.pms.mapper.PmsProductAttributeMapper;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttributeCategory;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductAttributeCategoryService;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductAttributeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 服务实现类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@Service
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeMapper, PmsProductAttribute> implements PmsProductAttributeService {

    @Autowired
    PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @Override
    public Page list(Long cid, Integer type, Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum, pageSize);
        QueryWrapper<PmsProductAttribute> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PmsProductAttribute::getProductAttributeCategoryId, cid)
                .eq(PmsProductAttribute::getType, type);
        return this.page(page, queryWrapper);
    }

    @Override
    @Transactional
    public boolean create(PmsProductAttribute pmsProductAttribute) {
        boolean save = this.save(pmsProductAttribute);
        if (save) {

            UpdateWrapper<PmsProductAttributeCategory> updateWrapper = new UpdateWrapper<>();
            if(pmsProductAttribute.getType() == 0){
                updateWrapper.setSql("attribute_count=attribute_count+1");
            }
            else if(pmsProductAttribute.getType() == 1){
                updateWrapper.setSql("param_count=param_count+1");
            }
            updateWrapper.lambda().eq(PmsProductAttributeCategory::getId,
                    pmsProductAttribute.getProductAttributeCategoryId());
            pmsProductAttributeCategoryService.update(updateWrapper);
        }
        return save;
    }

    @Override
    @Transactional
    public boolean delete(List<Long> ids) {
        if(CollectionUtils.isEmpty(ids)){
            return false;
        }

        PmsProductAttribute pmsProductAttribute = null;
        for (Long id : ids) {
            pmsProductAttribute = this.getById(id);
            if(pmsProductAttribute != null)
                break;
        }

        int length = this.getBaseMapper().deleteBatchIds(ids);

        if (length > 0 && pmsProductAttribute != null) {

            UpdateWrapper<PmsProductAttributeCategory> updateWrapper = new UpdateWrapper<>();
            if(pmsProductAttribute.getType() == 0){
                updateWrapper.setSql("attribute_count=attribute_count-" + length);
            }
            else if(pmsProductAttribute.getType() == 1){
                updateWrapper.setSql("param_count=param_count-"+ length);
            }
            updateWrapper.lambda().eq(PmsProductAttributeCategory::getId,
                    pmsProductAttribute.getProductAttributeCategoryId());
            pmsProductAttributeCategoryService.update(updateWrapper);
        }

        return length > 0;
    }
}
