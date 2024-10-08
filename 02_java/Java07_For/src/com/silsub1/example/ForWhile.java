package com.silsub1.example;

import java.util.Scanner;

public class ForWhile {
	Scanner sc = new Scanner(System.in);
	
	public void printStar1() {
		System.out.print("정수 하나 입력 : ");
		int row = sc.nextInt();
		
		if(row>0) {
			for(int i=1; i<=row; i++) {
				
				for(int j=1; j<=i; j++) {
					if(i==j) {
						System.out.print(i);
					}else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}else {
			System.out.println("양수가 아닙니다.");
		}
	}
	
	public void printStar2() {
		System.out.print("정수 입력 : ");
		int no = sc.nextInt();
		if(no>0) {
			for(int i=1; i<=no; i++) {
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else if(no<0){
			for(int i=(-no); i>0; i--) {
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}else{
			System.out.println("출력 기능이 없습니다.");
		}
	}
	public void countInputCharacter() {
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		
		for(int i=0; i<str.length(); i++) {
			char tmp = str.charAt(i);
			if(	!(tmp>='a' && tmp<='z') || (tmp>='A' && tmp<='Z')	) {
				System.out.println("영문자가 아닙니다.");
				return;
			}
		}
		
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);
		
		int cnt = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ch) {
				cnt++;
			}
		}
		System.out.println("포함된 갯수 : "+cnt+" 개");
		
		
		
	}

}
