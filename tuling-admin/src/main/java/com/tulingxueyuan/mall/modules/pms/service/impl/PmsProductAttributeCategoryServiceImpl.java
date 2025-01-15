package com.tulingxueyuan.mall.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttributeCategory;
import com.tulingxueyuan.mall.modules.pms.mapper.PmsProductAttributeCategoryMapper;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductAttributeCateDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductAttributeCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.util.List;

/**
 * <p>
 * 产品属性分类表 服务实现类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@Service
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryMapper, PmsProductAttributeCategory> implements PmsProductAttributeCategoryService {

    @Override
    public Page list(Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum, pageSize);
        return this.page(page);
    }

    @Override
    public boolean add(PmsProductAttributeCategory pmsProductAttributeCategory) {
        pmsProductAttributeCategory.setAttributeCount(0);
        pmsProductAttributeCategory.setParamCount(0);
        return this.save(pmsProductAttributeCategory);
    }

    @Override
    public List<ProductAttributeCateDTO> getListWithAttr() {
        return this.getBaseMapper().getListWithAttr();
    }
}
