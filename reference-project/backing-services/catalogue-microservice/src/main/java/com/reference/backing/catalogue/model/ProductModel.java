package com.reference.backing.catalogue.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ProductModel.Builder.class)
public class ProductModel implements Serializable {

	private static final long serialVersionUID = 1086963807813587456L;

	private final String productId;
	
	private final String name;
	
	private final String type;
	
	private final String maker;
	
	private final int quantity;
	
	private final double price;
	
	private final String createdBy;
	
	private final Date createdDate;
	
	private final String updatedBy;
	
	private final Date updatedDate;
	
	private final int version;
	
	private ProductModel(Builder builder){
		this.productId = builder.productId;
		this.name = builder.name;
		this.type = builder.type;
		this.maker = builder.maker;
		this.quantity = builder.quantity;
		this.price = builder.price;
		this.createdBy = builder.createdBy;
		this.createdDate = builder.createdDate;
		this.updatedBy = builder.updatedBy;
		this.updatedDate = builder.updatedDate;
		this.version = builder.version;
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

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public int getVersion() {
		return version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductModel other = (ProductModel) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("ProductModel [productId=");
		builder2.append(productId);
		builder2.append(", name=");
		builder2.append(name);
		builder2.append(", type=");
		builder2.append(type);
		builder2.append(", maker=");
		builder2.append(maker);
		builder2.append(", quantity=");
		builder2.append(quantity);
		builder2.append(", price=");
		builder2.append(price);
		builder2.append(", createdBy=");
		builder2.append(createdBy);
		builder2.append(", createdDate=");
		builder2.append(createdDate);
		builder2.append(", updatedBy=");
		builder2.append(updatedBy);
		builder2.append(", updatedDate=");
		builder2.append(updatedDate);
		builder2.append(", version=");
		builder2.append(version);
		builder2.append("]");
		return builder2.toString();
	}


	@JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
	public static class Builder{
		
		private String productId;
		
		private String name;
		
		private String type;
		
		private String maker;
		
		private int quantity;
		
		private double price;
		
		private String createdBy;
		
		private Date createdDate;
		
		private String updatedBy;
		
		private Date updatedDate;
		
		private int version;
		
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
		
		public Builder setQuantity(int quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public Builder setPrice(double price) {
			this.price = price;
			return this;
		}

		public Builder setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
			return this;
		}

		public Builder setCreatedDate(java.util.Date date) {
			this.createdDate = date;
			return this;
		}

		public Builder setUpdatedBy(String updatedBy) {
			this.updatedBy = updatedBy;
			return this;
		}

		public Builder setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
			return this;
		}

		public Builder setVersion(int version) {
			this.version = version;
			return this;
		}

		public static Builder newBuilder(){
			return new Builder();
		}
		
		public ProductModel build(){
			return new ProductModel(this);
		}
		
	}
}
