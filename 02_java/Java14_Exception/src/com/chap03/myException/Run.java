package com.chap03.myException;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력: ");
		int num = sc.nextInt();
		
		try {
			checkNum(num);
		}catch(MyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void checkNum(int num) throws MyException {
		if(num<10) {
			MyException me = new MyException(num+"은 10보다 작은 수!!!!");
			throw me;
		}else {
			System.out.println(num+"은 10보다 크거나 같은 수!!");
		}
	}

}
