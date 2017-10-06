package com.reference.backing.catalogue.service;

import java.util.Set;

import com.reference.backing.catalogue.model.ProductModel;
import com.reference.backing.catalogue.model.ProductSearchCriteria;

public interface CatalogueService {

	public ProductModel createProduct(ProductModel inputProductModel);
	
	public Boolean deleteProduct(ProductModel inputProductModel);
	
	public ProductModel getProductById(String id);
	
	public Set<ProductModel> getProductByCriteria(ProductSearchCriteria searchCriteria);
}
