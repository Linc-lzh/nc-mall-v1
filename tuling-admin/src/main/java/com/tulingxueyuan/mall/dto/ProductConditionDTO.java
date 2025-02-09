package com.tulingxueyuan.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/***
 * @author Linc
 * @since 2025-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ProductConditionDTO商品列表筛选条件", description="用于商品列表筛选条件参数接收")
public class ProductConditionDTO {

    private String keyword;
    private Integer pageNum;
    private Integer pageSize;
    private Integer publishStatus;
    @ApiModelProperty(value = "审核状态：0->未审核；1->审核通过")
    private Integer verifyStatus;
    @ApiModelProperty(value = "货号")
    private String productSn;
    private Long productCategoryId;
    private Long brandId;
}
