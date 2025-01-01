package com.tulingxueyuan.mall.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulingxueyuan.mall.common.api.CommonPage;
import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttribute;
import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import com.tulingxueyuan.mall.modules.pms.model.dto.RelationAttrInfoDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品属性参数表 前端控制器
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
@RestController
@RequestMapping("/productAttribute")
public class PmsProductAttributeController {

    @Autowired
    PmsProductAttributeService pmsProductAttributeService;

    @RequestMapping(value = "/list/{cid}", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProductAttribute>> getList(@PathVariable Long cid,
                                                                 @RequestParam(value = "type") Integer type,
                                                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page page = pmsProductAttributeService.list(cid, type, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult create(@RequestBody PmsProductAttribute pmsProductAttribute) {
        boolean result = pmsProductAttributeService.create(pmsProductAttribute);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@RequestBody PmsProductAttribute pmsProductAttribute) {
        boolean result = pmsProductAttributeService.updateById(pmsProductAttribute);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductAttribute> getById(@PathVariable Long id) {
        PmsProductAttribute pmsProductCategory = pmsProductAttributeService.getById(id);
        return CommonResult.success(pmsProductCategory);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestParam(value="ids") List<Long> ids) {
        boolean result = pmsProductAttributeService.delete(ids);
        if (result) {
            return CommonResult.success(result);
        } else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/attrInfo/{cId}", method = RequestMethod.GET)
    public CommonResult getRelationAttrInfoByCid(@PathVariable Long cId){
        List<RelationAttrInfoDTO> relationAttrInfoDTOList = pmsProductAttributeService.getRelationAttrInfoByCid(cId);
        return CommonResult.success(relationAttrInfoDTOList);
    }
}

