package com.arrayPractice1.sample;

import java.util.Scanner;

public class ArraySample {
	public void test1() {
		int[] iarr = new int[10];
		int sum = 0;
		
		for(int i=0; i<iarr.length; i++) {
			iarr[i] = (int)(Math.random() * 100) + 1;
			System.out.print(iarr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<iarr.length; i++) {
			sum += iarr[i];
		}
		
		System.out.println("총합 : "+sum);
	}
	public void test2() {
		int[] iarr = new int[10];
		int max = 0;
		int min = 100;
		
		for(int i=0; i<iarr.length; i++) {
			iarr[i] = (int)(Math.random() * 100) + 1;
			System.out.print(iarr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<iarr.length; i++) {
			max = (max>iarr[i])?max:iarr[i];
			min = (min>iarr[i])?iarr[i]:min;
		}
		
		System.out.println("가장 큰 수 : "+max+" 가장 작은 수 : "+min);
	}
	public void test3() {
		byte[] barr = new byte[10];
		int sum = 0;
		
		for(int i=0; i<barr.length; i++) {
			barr[i] = (byte) ((byte)(Math.random() * 100) + 1);
			System.out.print(barr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<barr.length; i++) {
			if(barr[i]%2==0) {
				sum += barr[i];
			}
		}
		
		System.out.println("짝수들 총합 : "+sum);
	}
	public void test4() {
		System.out.print("문자열 입력 : ");
		String str = new Scanner(System.in).next();
		int sum = 0;
		
		for(int i=0; i<str.length(); i++) {
			int num = Integer.parseInt(str.substring(i, i+1));
			sum += num;
		}
		
		System.out.println("총합 : "+sum);
	}
	public void test5() {
		System.out.print("문자열 입력 : ");
		String str = new Scanner(System.in).next();
		int sum = 0;
		
		for(int i=0; i<str.length(); i++) {
			int num = str.charAt(i) - '0';
			sum += num;
		}
		
		System.out.println("총합 : "+sum);
	}
}
