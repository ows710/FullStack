package com.test01;
import java.util.Scanner;
public class WhileTest02 {
	public static void main(String[] args) {
		//testDoWhile1();
		testDoWhile2();
	}
	
	public static void testDoWhile1() {
		int i=1;
		
		do {
			System.out.println(i);
			i++;
		}while(i<=10);
		System.out.println("do while 종료 후 i: " + i);
		
	}
	
	public static void testDoWhile2() {
		//키보드로 영어 문자열 값을 입력받아 출력 반복.
		//단, "exit"라는 문자열을 입력하면 do while문 종료.
		Scanner sc = new Scanner(System.in);
		String str = "";
		
		do {
			System.out.print("문자열 입력: ");
			str = sc.next();
			System.out.println("str : " + str);
			
			if(str.equals("exit")) {
				System.out.println("종료!");
				break;
			}
			
		}while(true);
		
	}

	
	
}
