package com.test01;

public class Operator02 {
	public static void main(String[] args) {
		//준비와 실행을 한번에
		//new Operator02().opTest1();
		//new Operator02().opTest2();
		new Operator02().opTest3();
	}
	public void opTest1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println( "num1 + num2 = " + (num1+num2) );
		System.out.println( "num1 - num2 = " + (num1-num2) );
		System.out.println( "num1 * num2 = " + (num1*num2) );
		//나누었을 때 몫을 구하는 연산자
		System.out.println( "num1 / num2 = " + (num1/num2) );
		//나누었을 때 나머지를 구하는 연산자
		System.out.println( "num1 % num2 = " + (num1%num2) );
	}
	
	
	public void opTest2() {
		//비교연산자
		// <,>,==,!=,>=,<=
		
		int no1 = 10, no2 = 20;
		
		System.out.println(no1 != no2);
		System.out.println(no1 <= no2);
		System.out.println(no1 > no2);
		
		System.out.println("-------------");
		
		//논리비교연산자
		// &&(그리고, ~면서), ||(또는, ~거나)
		//no2가 10이상이고 30이하인지 확인
		// 10 <= no2 <= 30 ==> 자바에서는 사용 불가능한 문법
		System.out.println("no2가 10~20사이인지 확인: " +(10<=no2 && no2<=30) );
	}
	public void opTest3() {
		// &&, ||
		
		//스캐너 준비
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		//문자 하나 입력 받아 대문자인지 확인 -> ch >= 'A' && ch <= 'Z'
		System.out.print("문자 하나 입력: ");
		char ch = sc.next().charAt(0);
		
		System.out.println("영어 대문자인지 확인: " + (ch>='A' && ch<='Z'));
		
		System.out.print("계속 하시려면 y/Y를 입력하세요: ");
		ch = sc.next().charAt(0);
		
		System.out.println("영어 y인지 확인: " + (ch=='Y' || ch=='y'));
		
		
	}
}
