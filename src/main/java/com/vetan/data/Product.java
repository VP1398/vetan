package com.vetan.data;
public class Product {
	private String productName;
	private String unitsInStock;

	public Product(String productName, String unitsInStock) {
		setProductName(productName);
		setUnitsInStock(unitsInStock);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(String unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
}
