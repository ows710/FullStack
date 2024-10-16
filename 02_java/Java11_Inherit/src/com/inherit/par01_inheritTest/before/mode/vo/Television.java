package com.inherit.par01_inheritTest.before.mode.vo;

import java.util.Date;

public class Television {
	private String brand;
	private String productNumber;
	private String productCode;
	private String productName;
	private int price;
	private Date date;
	private int inch;
	
	public Television() {/* super();	//부모클래스 생성자 호출 */}

	public Television(String brand, String productNumber, String productCode,
			String productName, int price, Date date, int inch) {
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.date = date;
		this.inch = inch;
	}
	
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

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public void printInfo() {
		System.out.println(brand+", "+productNumber+", "+productCode+", "+productName+", "+price+", "+date+", "+inch);
	}
	
	
	
	
	
	
	
	
}