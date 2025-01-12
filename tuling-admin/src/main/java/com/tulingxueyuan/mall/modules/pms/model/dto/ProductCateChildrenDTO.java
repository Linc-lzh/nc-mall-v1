package com.tulingxueyuan.mall.modules.pms.model.dto;

import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ProductCateChildrenDTO", description="For product list and product category control")
public class ProductCateChildrenDTO {

    private Long id;

    private String name;

    private List<PmsProductCategory> children;
}
