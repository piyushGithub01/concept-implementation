package com.reference.backing.catalogue.controller;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.reference.backing.catalogue.model.ProductModel;
import com.reference.backing.catalogue.model.ProductSearchCriteria;
import com.reference.backing.catalogue.service.CatalogueService;

@RestController
public class CatalogueServiceController implements CatalogueApi{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogueServiceController.class);
	
	@Autowired
	private CatalogueService productCatalogueService;
	
	/**
	 * 
	 */
    @Override
	public @ResponseBody ProductModel createProduct(@RequestBody ProductModel productModel) {
		LOGGER.info("received request to create product with arguments : {}", productModel);
		return productCatalogueService.createProduct(productModel);
    }
	
    /**
	 * 
	 */
    @HystrixCommand(fallbackMethod = "fallbackDeleteProduct")
    @Override
	public @ResponseBody Boolean deleteProduct(@RequestBody ProductModel productModel) {
		LOGGER.info("received request to delete product with arguments : {}", productModel);
        return productCatalogueService.deleteProduct(productModel);
    }
    
    public @ResponseBody Boolean fallbackDeleteProduct(@RequestBody ProductModel productModel) {
		LOGGER.info("fallback request to delete product with arguments : {}", productModel);
        return Boolean.FALSE;
    }
	
    /**
	 * 
	 */
    @HystrixCommand(fallbackMethod = "getFallbackProductByCriteria")
    @Override
	public @ResponseBody Set<ProductModel> getProductByCriteria(@RequestBody ProductSearchCriteria searchCriteria) {
		LOGGER.info("received request to get all product by criteria : {} ", searchCriteria);
		return productCatalogueService.getProductByCriteria(searchCriteria);
    }
    
    public @ResponseBody Set<ProductModel> getFallbackProductByCriteria(ProductSearchCriteria searchCriteria) {
		LOGGER.warn("fallback request to get all product by criteria : {} ", searchCriteria);
		Set<ProductModel> fallbackProductSet = new HashSet<>();
		return fallbackProductSet;
    }
	
    /**
	 * 
	 */
    @HystrixCommand(fallbackMethod = "getFallbackProductById")
	@Override
	public @ResponseBody ProductModel getProductById(@PathVariable("id") String id) {
		LOGGER.info("received request to get product by id: {}", id);
		return productCatalogueService.getProductById(id);
	}
    
    public @ResponseBody ProductModel getFallbackProductById(@PathVariable("id") String id) {
		LOGGER.info("fallabck request to get product by id: {}", id);
		return null;
	}
	
}
