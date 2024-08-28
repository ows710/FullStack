package com.inherit.par01_inheritTest.before.mode.vo;
import java.util.Date;
public class Desktop {
	private String brand;					//제조사
	private String productNumber;		//상품번호
	private String productCode;			//상품코드
	private String productName;			//상품명
	private String cpu;						//cpu
	private int hdd;							//하드디스크
	private int ram;							//메인메모리
	private String os;							//운영체제
	private int price;							//가격
	private Date date;						//제조일자
	private boolean allInOne;				//일체형
	
	//기본생성자
	public Desktop() {}
	//매개변수생성자(필드 전부를 매개변수로 받는)
	public Desktop(String brand, String productNumber, String productCode, String productName, 
			String cpu, int hdd, int ram, String os, int price, Date date, boolean allInOne) {
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
		this.price = price;
		this.date = date;
		this.allInOne = allInOne;
	}
	//getter/setter
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
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public String  getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
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
	public boolean getAllInOne() {
		return allInOne;
	}
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	// +printInfo():void	==> 필드값 출력하는 메소드
	public void printInfo() {
		System.out.println(brand+", "+productNumber+", "+productCode+", "+productName+
				", "+cpu+", "+hdd+", "+ram+", "+os+", "+price+", "+date+", "+allInOne);
	}
	
}
