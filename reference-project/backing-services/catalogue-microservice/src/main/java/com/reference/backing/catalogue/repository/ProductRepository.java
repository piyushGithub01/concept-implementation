package com.reference.backing.catalogue.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reference.backing.catalogue.entity.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

	Set<ProductEntity> findByType(String type);
	
	Set<ProductEntity> findByName(String name);
	
	Set<ProductEntity> findByMaker(String maker);
	
}
