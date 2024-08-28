package com.test01.chap01_encapsulation;

public class Main {

	public static void main(String[] args) {
		//	준비
		//	클래스명 변수명 = new 클래스명();
		Account a = new Account();	//Account 클래스 객체 생성
		Account b = new Account();
		//잔액조회
		a.display();
		
		a.in(100);
		a.display();
		
		a.out(50);
		a.display();
		
		//a.balance -= 50;
		
		a.out(30);
		a.display();

	}

}
