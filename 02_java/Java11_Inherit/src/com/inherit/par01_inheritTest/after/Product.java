package com.inherit.par01_inheritTest.after;

import java.util.Date;

public class Product {
	//상품에 대한 공통적인 요소만 추출하여 부모클래스로 작성
	private String brand;
	private String productNumber;
	private String productCode;
	private String productName;
	private int price;
	private Date date;
	
	//생성자
	public Product() {}

	public Product(String brand, String productNumber, String productCode, String productName, int price, Date date) {
		super();
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.date = date;
		
		System.out.println("부모클래스(product) 생성자 호출 완료...");
	}
	//getter&setter
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String printInfo() {
		return brand+", "+productNumber+", "+productCode+", "
					+productName+", "+price+", "+date;
	}
	
	
	
	
	
	
	
	
	
	
}
