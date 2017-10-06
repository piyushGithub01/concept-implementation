package com.reference.backing.catalogue.converters;

import com.reference.backing.catalogue.entity.ProductEntity;
import com.reference.backing.catalogue.model.ProductModel;

public class ProductConverter {
	
	public static ProductModel convertToModel (ProductEntity entity) {
		return ProductModel.Builder.newBuilder()
					.setCreatedBy(entity.getCreatedBy())
					.setCreatedDate(entity.getCreatedDate())
					.setMaker(entity.getMaker())
					.setName(entity.getName())
					.setPrice(entity.getPrice())
					.setProductId(entity.getProductId())
					.setQuantity(entity.getQuantity())
					.setType(entity.getType())
					.setUpdatedBy(entity.getUpdatedBy())
					.setUpdatedDate(entity.getUpdatedDate())
					.setVersion(entity.getVersion())
					.build();
	}
	
	public static ProductEntity convertToEntity (ProductModel model) {
		ProductEntity entity = new ProductEntity(
					model.getProductId(),
					model.getName(),
					model.getType(),
					model.getMaker(),
					model.getQuantity(),
					model.getPrice(),
					model.getCreatedBy(),
					model.getCreatedDate(),
					model.getUpdatedBy(),
					model.getUpdatedDate(),
					model.getVersion()
				);
		return entity;
	}

}
