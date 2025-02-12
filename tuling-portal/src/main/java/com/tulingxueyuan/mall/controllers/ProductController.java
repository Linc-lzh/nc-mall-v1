package com.tulingxueyuan.mall.controllers;

import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductService;
import com.tulingxueyuan.mall.dto.ProductDetailDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "ProductController",description = "商品详情服务接口")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    PmsProductService productService;

    /**
     *  取商品详情获
     * .get(`/product/detail/${this.id}`)
     */
    @RequestMapping("/detail/{id}")
    public CommonResult getProductDetail(@PathVariable Long id){
        ProductDetailDTO productDetailDTO= productService.getProductDetail(id);
        return CommonResult.success(productDetailDTO);
    }
}