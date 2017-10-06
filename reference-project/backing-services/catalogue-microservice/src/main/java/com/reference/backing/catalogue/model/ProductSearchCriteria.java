package com.reference.backing.catalogue.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ProductSearchCriteria.Builder.class)
public class ProductSearchCriteria implements Serializable {

	private static final long serialVersionUID = 4774986171757125586L;

	private final String productId;
	
	private final String name;
	
	private final String type;
	
	private final String maker;
	
	private final double priceLowRange;
	
	private final double priceHighRange;
		
	private ProductSearchCriteria(Builder builder){
		this.productId = builder.productId;
		this.name = builder.name;
		this.type = builder.type;
		this.maker = builder.maker;
		this.priceLowRange = builder.priceLowRange;
		this.priceHighRange = builder.priceHighRange;
	}
	
	public String getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getMaker() {
		return maker;
	}

	public double getPriceLowRange() {
		return priceLowRange;
	}

	public double getPriceHighRange() {
		return priceHighRange;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("ProductSearchCriteria [productId=");
		builder2.append(productId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append(", type=");
		builder2.append(type);
		builder2.append(", maker=");
		builder2.append(maker);
		builder2.append(", priceLowRange=");
		builder2.append(priceLowRange);
		builder2.append(", priceHighRange=");
		builder2.append(priceHighRange);
		builder2.append("]");
		return builder2.toString();
	}


	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
	public static class Builder{
		
		private String productId;
		
		private String name;
		
		private String type;
		
		private String maker;
		
		private double priceLowRange;
		
		private double priceHighRange;
		
		public Builder setProductId(String productId) {
			this.productId = productId;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}
		
		public Builder setMaker(String maker) {
			this.maker = maker;
			return this;
		}
		
		public Builder setPriceLowRange(double priceLowRange) {
			this.priceLowRange = priceLowRange;
			return this;
		}
		
		public Builder setPriceHighRange(double priceHighRange) {
			this.priceHighRange = priceHighRange;
			return this;
		}

		public static Builder newBuilder(){
			return new Builder();
		}
		
		public ProductSearchCriteria build(){
			return new ProductSearchCriteria(this);
		}
		
	}
}
