package com.chap01.runtimeException;

import java.util.Scanner;

public class RunException {	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		RunException re = new RunException();
		//re.arithEx();
		//re.classAndArrayAndNullEx();
	}
	
	//ArithmeticException인 경우
	public void arithEx() {
		int ran =0;
		double res = 0.0;
		
		//if로 해결
		/*
		System.out.print("나누려는 수를 정수로 입력: ");
		int inputNum = sc.nextInt();
		
		if(inputNum == 0){
			System.out.println("0이 아닌 값을 입력하세요!!!!!!");
		}else {
			ran = (int)(Math.random()*10)+1; 
			//res = (double)ran / inputNum;
			//System.out.printf("%d / %d = %.2f",ran,inputNum,res);
			System.out.printf("%d / %d = %d",ran,inputNum,(ran/inputNum));
		}*/
		
		System.out.print("나누려는 수를 정수로 입력: ");
		int inputNum = sc.nextInt();
		ran = (int)(Math.random()*10)+1;
		
		try {
			int result = (ran/inputNum);
			System.out.printf("%d / %d = %d", ran,inputNum,result);
		}catch(ArithmeticException e) {
			System.out.println("0을 제외하고 입력하세요!!!!!!!");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("끝!");
		
		
	}
	
	public void classAndArrayAndNullEx() {
		//ClassCaseException
		/*Object obj = 'a';
		System.out.println(obj);
		String str = (String)obj;
		System.out.println(str.length());*/
		
		//ArrayIndexOutOfBoundsException
		/*int[] arr = new int[2];
		arr[0] = 1;
		arr[1] = 2;
		
		arr[2] = 3;
		System.out.println("출력문!!");*/
		
		//NullPointerException
		String str = null;
		str.length();
		
		
	}
	
}
