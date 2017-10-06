package com.reference.backing.catalogue.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reference.backing.catalogue.model.ProductModel;
import com.reference.backing.catalogue.model.ProductSearchCriteria;

public interface CatalogueApi {

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public @ResponseBody ProductModel createProduct(@RequestBody ProductModel productModel);
	
	@RequestMapping(value = "/product/remove", method = RequestMethod.PUT)
    public @ResponseBody Boolean deleteProduct(@RequestBody ProductModel productModel);
	
	@RequestMapping(value = "/product/get-by-criteria", method = RequestMethod.PUT)
    public @ResponseBody Set<ProductModel> getProductByCriteria(@RequestBody ProductSearchCriteria searchCriteria);
	
	@RequestMapping(value = "/product/get-by-id/{id}", method = RequestMethod.GET)
	public @ResponseBody ProductModel getProductById(@PathVariable("id") String id);
}
