package com.test01;

public class WhileTest03 {
	
	public static void main(String[] args) {
		//1. 1~100까지의 숫자를 역순으로 출력.
		prn01();
		
		//2. 1~100까지의 숫자 중 2의 배수만 출력.
		prn02();
		
		//3. 1~100까지의 숫자 중, 7의 배수의 갯수와 총 합을 출력.
		prn03();
	}
	public static void prn01() {
		int i=100;
		while(i>=1) {
			System.out.println(i);
			i--;
		}
	}
	public static void prn02() {
		int i=2;
		while(i<=100) {
			System.out.println(i);
			i+=2;
		}
		
	}
	public static void prn03() {
		int count=0;
		int sum=0;
		
		int i=7;
		while(i<=100) {
			count++;
			sum += i;
			i+=7;
		}
		System.out.println("7의 배수 갯수: " + count);
		System.out.println("7의 배수 총합: "+ sum);
	
	}
}
