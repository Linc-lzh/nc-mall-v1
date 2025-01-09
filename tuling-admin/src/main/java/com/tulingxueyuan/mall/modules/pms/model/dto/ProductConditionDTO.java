package com.tulingxueyuan.mall.modules.pms.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ProductConditionDTO", description="For product filter parameter")
public class ProductConditionDTO {
    private String keyword;
    private Integer pageNum;
    private Integer pageSize;
    private Integer publishStatus;
    private Integer verifyStatus;
    private String productSn;
    private Long productCategoryId;
    private Long brandId;
}
