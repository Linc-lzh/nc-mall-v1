package com.tulingxueyuan.mall.modules.pms.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RelationAttrInfoDTO", description="For init saved RelationAttrInfoDTO")
public class RelationAttrInfoDTO {
    private Long attributeId;

    private Long attributeCategoryId;
}
