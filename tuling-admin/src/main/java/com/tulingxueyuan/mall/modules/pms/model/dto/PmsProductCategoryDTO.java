package com.tulingxueyuan.mall.modules.pms.model.dto;

import com.tulingxueyuan.mall.modules.pms.model.PmsProductCategory;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PmsProductCategoryDTO", description="For product category add and update")
public class PmsProductCategoryDTO extends PmsProductCategory {

    private List<Long> productAttributeIdList;
}
