package com.inherit.par01_inheritTest.after;

import java.util.Date;

public class Desktop extends Computer {

	//고유속성을 정의
	private boolean allInOne;
	
	public Desktop() {}

	public Desktop(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os, boolean allInOne) {
		super(brand, productNumber, productCode, productName, price, date, cpu, hdd, ram, os);
		this.allInOne = allInOne;
	}

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}

	@Override
	public String printInfo() {
		return super.printInfo()+", "+this.allInOne;
	}
}
