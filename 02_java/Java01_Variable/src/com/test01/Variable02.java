package com.test01;

import java.util.Scanner;
//현재 위치한 패키지 외의 다른 패키지에 속한 클래스 이용할 때 import 필요

public class Variable02 {
	public static void main(String[] args) {
		//준비
		Variable02 test = new Variable02();
		//실행
		test.inputTest();
	}
	
	//java.io 패키지에서 제공하는 클래스를 이용한 키보드 입력
	public void inputTest() {
		//준비
		//클래스명 변수명 = new 클래스명();
		Scanner sc = new Scanner(System.in);
		//다른 패키지에 있는 클래스 사용시 import 필요

		//실행
		//변수명.메소드명();
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		System.out.println("입력한 이름: " + name);
		
		System.out.print("나이 입력: ");
		int age = sc.nextInt();
		System.out.println("입력한 나이: "+age+"살");
		
		System.out.print("평균 입력: ");
		double avg = sc.nextDouble();
		System.out.println("입력한 평균: "+ avg + "점");
		
		
	}
}
