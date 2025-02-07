package com.tulingxueyuan.mall.modules.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tulingxueyuan.mall.dto.HomeGoodsSaleDTO;
import com.tulingxueyuan.mall.modules.sms.model.SmsHomeCategory;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Linc
 * @since 2025-02-07
 */
public interface SmsHomeCategoryMapper extends BaseMapper<SmsHomeCategory> {
    List<HomeGoodsSaleDTO> getHomeCategoryWithProduct();
}
