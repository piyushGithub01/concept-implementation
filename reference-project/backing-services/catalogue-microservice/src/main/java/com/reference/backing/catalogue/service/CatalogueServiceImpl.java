package com.reference.backing.catalogue.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.reference.backing.catalogue.converters.ProductConverter;
import com.reference.backing.catalogue.entity.ProductEntity;
import com.reference.backing.catalogue.model.ProductModel;
import com.reference.backing.catalogue.model.ProductSearchCriteria;
import com.reference.backing.catalogue.repository.ProductRepository;

@Component
public class CatalogueServiceImpl implements CatalogueService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional
	public ProductModel createProduct(ProductModel inputProductModel) {
		ProductEntity entity = ProductConverter.convertToEntity(inputProductModel);
		entity.setProductId(UUID.randomUUID().toString());
		entity.setCreatedBy("SYSTEM");
		entity.setCreatedDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		ProductEntity savedEntity = productRepository.save(entity);
		return ProductConverter.convertToModel(savedEntity);
	}

	@Override
	@Transactional
	public Boolean deleteProduct(ProductModel inputProductModel) {
		productRepository.delete(inputProductModel.getProductId());
		return Boolean.TRUE;
	}

	@Override
	public ProductModel getProductById(String id) {
		ProductEntity item =  productRepository.findOne(id);
		if (item==null)
			return null;
		return ProductConverter.convertToModel(item);
	}

	@Override
	public Set<ProductModel> getProductByCriteria(ProductSearchCriteria searchCriteria) {
		Set<ProductModel> results = new HashSet<>();
		if (searchCriteria.getType() != null) {
			Set<ProductEntity> typeResult = productRepository.findByType(searchCriteria.getType());
			for(ProductEntity prod : typeResult){
				results.add(ProductConverter.convertToModel(prod));
			}
		}
		if (searchCriteria.getMaker() != null) {
			Set<ProductEntity> makerResult = productRepository.findByMaker(searchCriteria.getMaker());
			for(ProductEntity prod : makerResult){
				results.add(ProductConverter.convertToModel(prod));
			}
		}
		return results;
	}

}
