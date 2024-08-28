package com.test01.chap03_field.test02;

public class Run {
	public static void main(String[] args) {
		//객체
		InitField p = new InitField();
		p.info();
		
		InitField p2 = new InitField("flip",2000000,"samsung");
		p2.info();
		p.info();
		
		p.setName("iPhone");
		p.setPrice(2500000);
		InitField.setBrand("apple");
		p.info();
	}

}
