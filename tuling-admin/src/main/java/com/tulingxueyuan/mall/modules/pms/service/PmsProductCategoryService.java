package com.tulingxueyuan.mall.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tulingxueyuan.mall.modules.pms.model.dto.PmsProductCategoryDTO;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
public interface PmsProductCategoryService extends IService<PmsProductCategory> {
    /**
     * Get Product Category List
     * @param parentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page list(Long parentId, Integer pageNum, Integer pageSize);

    boolean updateNavStatus(List<Long> ids, Integer navStatus);

    boolean updateShowStatus(List<Long> ids, Integer showStatus);

    boolean customSave(PmsProductCategoryDTO pmsProductCategoryDTO);

    boolean update(PmsProductCategoryDTO pmsProductCategory);

    List<PmsProductCategory> getWithChildren();
}
