package com.chap02.throwsPrac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

	public static void main(String[] args) /*throws IOException*/ { //jvm이 처리
		try {
			//예외발생할 수 있는 코드를 포함한 실행코드를 작성
			String s = null;
			s.length();
			
			methodA();
		}catch(IOException e) {
			//해당 예외가 발생했을 때 실행할 코드를 작성
			System.out.println(e.getMessage());
			System.out.println("main()에서 처리");	
		}finally {
			//예외가 발생 하거나 정상적으로 동작을 한 다음 무조건 실행
			System.out.println("finally 실행!!");
		}
		
		System.out.println("끄으읕!!");
	}
	
	public static void methodA() throws IOException {
		methodB();
	}
	public static void methodB() throws IOException {
		methodC();
	}
	public static void methodC() throws IOException {
//		try {
//			throw new IOException();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		throw new IOException();	
		
	}

}
