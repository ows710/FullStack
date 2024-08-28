package com.poly.test03;

public class Dog implements Base {
	@Override
	public void bark() {
		System.out.println("멍멍");
	}
	@Override
	public void eat(String t) {
		System.out.println(t + " 먹는다.");
	}
}
