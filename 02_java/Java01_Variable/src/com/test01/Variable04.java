package com.test01;

public class Variable04 {
	public static void main(String[] args) {
		//준비
		Variable04 test = new Variable04();
		//실행
		//test.printVarSize();
		test.testOverflow();
	}
	
	public void printVarSize() {
		//변수의 사이즈 출력
		System.out.println("byte의 크기: " + Byte.BYTES);
		System.out.println("short의 크기: " + Short.BYTES);
		System.out.println("int의 크기: " + Integer.BYTES);
		System.out.println("double의 크기: " + Double.BYTES);
		System.out.println("char의 크기: " + Character.BYTES);
		//java.lang 패키지에 존재하는 클래스들을 통해 타입별 크기 확인.
		//lang 패키지는 import 생략 가능
	}
	
	public void testOverflow() {
		//byte bnum = 128;
		//에러, 범위를 벗어난 값.
		
		//계산과정에서 범위를 벗어나 오버플로우 처리.
		// 최대값 127 -> 최소값 -128 : 값이 순환
		byte bnum = 127;
		bnum++; //bnum을 1 증가
		System.out.println("bnum: " + bnum);
	}
	
	
	
	
	
	
}
