package com.test01;

public class DeArrayTest01 {
	public void test1() {
		//2차원 배열 선언
		
		//선언을 하게 되면 stack에 레퍼런스변수가 생성
		int[][] iarr1;
		int iarr[][];
		int[] iarr2[];
		
		//할당
		iarr1 = new int[3][5];	//	정변배열
		
		//배열의 레퍼런스를 보관하는 배열은 반드시 크기를 지정.
		iarr2 = new int[3][];
		//배열의 레퍼런스를 보관하는 배열에 각각 배열을 생성 후 할당하여 주소를 대입.
		iarr2[0] = new int[5];
		iarr2[1] = new int[5];
		iarr2[2] = new int[5];
		
		
		for(int i=0; i<iarr2.length; i++) {
			for(int j=0; j<iarr2[i].length; j++) {
				System.out.print(iarr2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public void test2() {
		//2차원 배열에 값 대입
		int[][] iarr = new int[3][5];
		
		//배열 인덱스에 접근하여 값 기록
		/*iarr[0][0] = 1;
		iarr[0][1] = 2;
		
		iarr[2][4] = 3;
		 */
		
		int value = 1;
		for(int i=0; i<iarr.length; i++) {
			for(int j=0; j<iarr[i].length; j++) {
				iarr[i][j] = value++;
			}
		}
		
		printArray(iarr);
	}
	
	//이차원 배열을 매개변수로 전달 받아 출력하는 메소드.
	public void printArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public void test3() {
		int[][] iarr = {	{1,2,3}, {4,5,6}, {7,8,9}	};
		
		printArray(iarr);
	}
	
	
	
	
	

}
