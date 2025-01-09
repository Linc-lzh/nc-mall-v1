package com.tulingxueyuan.mall.modules.pms.service;

import com.tulingxueyuan.mall.modules.pms.model.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author Linc
 * @since 2024-12-26
 */
public interface PmsBrandService extends IService<PmsBrand> {

    Page list(String keyword, Integer pageNum, Integer pageSize);
}
