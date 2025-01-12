package com.tulingxueyuan.mall.modules.pms.model.dto;

import com.tulingxueyuan.mall.modules.pms.model.PmsProductAttribute;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ProductAttributeCateDTO", description="For product category attribute control")
public class ProductAttributeCateDTO {

    private Long id;

    private String name;

    private List<PmsProductAttribute> productAttributeList;
}
