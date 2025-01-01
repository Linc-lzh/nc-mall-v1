package com.tulingxueyuan.mall.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import com.tulingxueyuan.mall.modules.pms.model.dto.PmsProductCategoryDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产品分类 前端控制器
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@RestController
@RequestMapping("/productCategory")
public class PmsProductCategoryController {

    @Autowired
    PmsProductCategoryService productCategoryService;

    /**
     * get list of product by id
     *
     * @param parentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = productCategoryService.list(parentId, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

    /**
     * Update navigate status for product
     *
     * @param ids
     * @param navStatus
     * @return
     */
    @RequestMapping(value = "/update/navStatus", method = RequestMethod.POST)
    public CommonResult updateNavStatus(@RequestParam(value = "ids") List<Long> ids,
                                        @RequestParam(value = "navStatus") Integer navStatus) {
        boolean result = productCategoryService.updateNavStatus(ids, navStatus);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * Update show status for product
     *
     * @param ids
     * @param showStatus
     * @return
     */
    @RequestMapping(value = "/update/showStatus", method = RequestMethod.POST)
    public CommonResult updateShowStatus(@RequestParam(value = "ids") List<Long> ids,
                                         @RequestParam(value = "showStatus") Integer showStatus) {
        boolean result = productCategoryService.updateShowStatus(ids, showStatus);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * Delete product category
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult delete(@PathVariable Long id) {
        boolean result = productCategoryService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * Create product category info
     *
     * @param pmsProductCategory
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsProductCategoryDTO pmsProductCategoryDTO) {
        boolean result = productCategoryService.customSave(pmsProductCategoryDTO);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * get product category info by id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductCategory> getById(@PathVariable Long id) {
        PmsProductCategory pmsProductCategory = productCategoryService.getById(id);
        return CommonResult.success(pmsProductCategory);
    }

    /**
     * Update product category by id
     * @param pmsProductCategory
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@RequestBody PmsProductCategoryDTO productCategoryDTO) {
        boolean result = productCategoryService.update(productCategoryDTO);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }
}

