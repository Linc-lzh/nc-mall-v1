package com.tulingxueyuan.mall.modules.pms.model.dto;

import com.tulingxueyuan.mall.modules.pms.model.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ProductSaveParamsDTO", description="For saving and updating product parameters")
public class ProductSaveParamsDTO extends PmsProduct{

    private List<PmsMemberPrice> memberPriceList;
    private List<PmsProductFullReduction> productFullReductionList;
    private List<PmsProductLadder> productLadderList;
    private List<PmsProductAttributeValue> productAttributeValueList;
    private List<PmsSkuStock> skuStockList;
}
