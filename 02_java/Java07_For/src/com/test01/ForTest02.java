package com.test01;
import java.util.Scanner;
public class ForTest02 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//testFor1();
		//testFor2();
		//testFor3();
		testFor4();
	}

	public static void testFor1() {
		//	중첩 반복문
		for(int i = 0; i < 3; i++) {//	3번 반복하는 반복문
			
			for(int j = 0; j < 5; j++) {
				
				System.out.println("i="+i+", j="+j);
				
			}
			
		}
		
	}
	
	public static void testFor2() {
		//구구단 2단부터 9단까지 출력
		for(int i=2; i<10; i++) {
			System.out.println("===="+i+"단====");
			for(int j=1; j<10; j++) {
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
		
	}
	public static void testFor3() {
		
		System.out.print("출력할 줄 수: ");
		int row = sc.nextInt();
		
		for(int i=1; i<row; i++) {
			for(int j=0; j<3; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public static void testFor4() {
		/*	줄 수와 칸수를 입력받아 아래와 같이 출력
		 	1*****
		 	*2****
		 	**3***
		 	***4**
		 	****5*
		 	*****6
		 */
		System.out.print("줄 수: ");
		int row = sc.nextInt();
		System.out.print("칸 수: ");
		int col = sc.nextInt();
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(i==j) {
					System.out.print(i+1);
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		
	}
	
	
}
