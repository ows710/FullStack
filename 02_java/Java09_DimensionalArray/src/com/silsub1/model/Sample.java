package com.silsub1.model;

import java.util.Scanner;

import com.test01.DeArrayTest01;

public class Sample {
	public void munjae1() {
		int [][] iarr = new int[4][4];
		
		//값 저장
		for(int i=0; i<iarr.length-1; i++) {
			for(int j=0; j<iarr[i].length-1; j++) {
				iarr[i][j] = (int)(Math.random()*100)+1;
			}
		}
		
		//합계
		for(int i=0; i<iarr.length-1; i++) {
			for(int j=0; j<iarr[i].length-1; j++) {
				iarr[i][3] += iarr[i][j];
				iarr[3][i] += iarr[j][i];
			}
			iarr[3][3] += iarr[i][3] + iarr[3][i];
		}
		
		new DeArrayTest01().printArray(iarr);
		
	}
	public void munjae2() {
		//배열 생성
		int iarr[][] = new int[3][];
		int[] sum = new int[iarr.length];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<iarr.length; i++) {
			System.out.print(i+"번째 1차원 배열 크기: ");
			iarr[i] = new int[sc.nextInt()];
			//생성한 배열에 값 기록
			for(int j=0; j<iarr[i].length; j++) {
				iarr[i][j] = (int)(Math.random()*100)+1;
				sum[i] += iarr[i][j];
			}
		}
		
		//출력
		for(int i=0; i<sum.length; i++) {
			if(sum[i]%5==0) {
				System.out.print(i + "행: ");
				for(int j=0; j<iarr[i].length; j++) {
					System.out.print(iarr[i][j]+" ");
				}
				System.out.println("\t합계: " +sum[i]);
			}
		}
	}
}
