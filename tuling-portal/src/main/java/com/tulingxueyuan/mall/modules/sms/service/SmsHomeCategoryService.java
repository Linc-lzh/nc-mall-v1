package com.tulingxueyuan.mall.modules.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tulingxueyuan.mall.dto.HomeGoodsSaleDTO;
import com.tulingxueyuan.mall.modules.sms.model.SmsHomeCategory;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Linc
 * @since 2025-02-07
 */
public interface SmsHomeCategoryService extends IService<SmsHomeCategory> {
    List<HomeGoodsSaleDTO> getGoodsSale();
}
