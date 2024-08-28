package com.test01;

import java.util.Scanner;

public class SwitchTest02 {
	public void test1() {
		//정수 두개와 연산기호문자 1개를 입력 받아서,
		//연산기호문자(+,-,*,/)에 해당하는 계산을 수행하고 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 값: ");
		int no1 = sc.nextInt();
		System.out.print("두번째 값: ");
		int no2 = sc.nextInt();
		System.out.print("연산자(+,-,*,/): ");
		char op = sc.next().charAt(0);
		
		int res = 0;
		
		switch(op) {
		case '+':
			res = no1 + no2;
			break;
		case '-':
			res = no1 - no2;
			break;
		case '*':
			res = no1 * no2;
			break;
		case '/':
			res = no1 / no2;
			break;	
		}
		
		System.out.println(no1 + " " +op+ " " + no2 + " = " + res);
		
		
	}

	
	
	
	
	
	
	
}
