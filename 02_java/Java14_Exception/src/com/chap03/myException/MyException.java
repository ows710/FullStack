package com.chap03.myException;

//사용자 정의 예외클래스
public class MyException extends Exception {
	public MyException() {
		System.out.println("내가 만든 예외 클래스!!!!!");
	}
	public MyException(String msg) {
		super(msg);
	}
}
