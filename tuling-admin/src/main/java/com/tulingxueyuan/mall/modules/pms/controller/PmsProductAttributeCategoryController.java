package com.tulingxueyuan.mall.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttributeCategory;
import com.tulingxueyuan.mall.modules.pms.model.dto.ProductAttributeCateDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductAttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 产品属性分类表 前端控制器
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@RestController
@RequestMapping("/productAttribute/category")
public class PmsProductAttributeCategoryController {

    @Autowired
    PmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    /**
     * Get list of product category info
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductAttributeCategory>> getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = pmsProductAttributeCategoryService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(PmsProductAttributeCategory pmsProductAttributeCategory) {
        boolean result = pmsProductAttributeCategoryService.add(pmsProductAttributeCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(PmsProductAttributeCategory pmsProductAttributeCategory) {
        boolean result = pmsProductAttributeCategoryService.updateById(pmsProductAttributeCategory);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public CommonResult delete(@PathVariable Long id) {
        boolean result = pmsProductAttributeCategoryService.removeById(id);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/list/withAttr", method = RequestMethod.GET)
    public CommonResult getListWithAttr() {
        List<ProductAttributeCateDTO> list = pmsProductAttributeCategoryService.getListWithAttr();
        return CommonResult.success(list);
    }
}

