package com.tulingxueyuan.mall.controllers;

import com.tulingxueyuan.mall.common.api.CommonResult;
import com.tulingxueyuan.mall.dto.HomeGoodsSaleDTO;
import com.tulingxueyuan.mall.dto.HomeMenusBannerDTO;
import com.tulingxueyuan.mall.dto.HomeMenusDTO;
import com.tulingxueyuan.mall.modules.pms.service.PmsProductCategoryService;
import com.tulingxueyuan.mall.modules.sms.service.SmsHomeAdvertiseService;
import com.tulingxueyuan.mall.modules.sms.model.SmsHomeAdvertise;
import com.tulingxueyuan.mall.modules.sms.service.SmsHomeCategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "HomeController", description = "首页内容管理")
@RequestMapping("/home")
public class HomeController {

    @Autowired
    PmsProductCategoryService productCategoryService;
    @Autowired
    SmsHomeAdvertiseService homeAdvertiseService;
    @Autowired
    SmsHomeCategoryService homeCategoryService;

    @RequestMapping(value = "/menus_banner", method = RequestMethod.GET)
    public CommonResult getMenus() {
        // 分类导航
        List<HomeMenusDTO> list = productCategoryService.getMenus();

        // banner
        List<SmsHomeAdvertise> homeAdvertisesList = homeAdvertiseService.getHomeBanners();

        HomeMenusBannerDTO homeMenusBannerDTO = new HomeMenusBannerDTO();
        homeMenusBannerDTO.setHomeMenusList(list);
        homeMenusBannerDTO.setHomeAdvertisesList(homeAdvertisesList);

        return CommonResult.success(homeMenusBannerDTO);
    }


    /**
     * goods_sale
     */
    @RequestMapping(value = "/goods_sale",method = RequestMethod.GET)
    public CommonResult getGoodsSale(){
        List<HomeGoodsSaleDTO> list= homeCategoryService.getGoodsSale();
        return CommonResult.success(list);
    }
}
