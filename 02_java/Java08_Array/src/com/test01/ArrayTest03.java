package com.test01;

public class ArrayTest03 {
	
	public void shallowCopy() {
		//얕은복사 : 레퍼런스변수에 저장된 주소만 복사.
		int[] oriArr = {1,2,3,4,5};
		int[] copyArr = oriArr;
		
		System.out.println("oriArr: " + prn(oriArr) );
		System.out.println("copyArr: " + prn(copyArr) );
		
		oriArr[0] = 99;
		
		System.out.println("oriArr: " + prn(oriArr));
		System.out.println("copyArr: " + prn(copyArr));
		
	}
	
	public String prn(int[] arr) {
			//리턴타입
		String str = "";
		for(int i=0; i<arr.length; i++) {
			str += arr[i] + " ";
		}
		
		return str;
	}
	
	public void deepCopy1() {
		//깊은복사 : 새로운 배열을 하나 생성하고 값을 복사하는 것.
		
		int[] oriArr = {1,2,3,4,5};
		int[] copyArr = new int[5];
		
		System.out.println(prn(oriArr));
		System.out.println(prn(copyArr));
		
		//for문을 이용해서 값을 1:1 복사
		for(int i=0; i<oriArr.length; i++) {
			copyArr[i] = oriArr[i];
		}
		
		System.out.println("깊은 복사 후");
		System.out.println(prn(oriArr));
		System.out.println(prn(copyArr));
		
		oriArr[0] = 99;
		
		System.out.println(prn(oriArr));
		System.out.println(prn(copyArr));
		
		System.out.println(oriArr.hashCode());
		System.out.println(copyArr.hashCode());
		
	}
	
	public void deepCopy2() {
		//다른 방식의 깊은복사
		int[] oArr = {1,2,3,4,5};
		int[] cArr = new int[10];
		
		//arraycopy() 이용
		//arraycopy(src, srcPos, dest, destPos, length)
		//src: 원본배열, srcPos: 복사시작 위치
		//dest: 카피배열, destPos:붙여넣기시작 위치
		//length: 복사될 길이
		System.arraycopy(oArr, 0, cArr, 3, oArr.length);
		
		System.out.println(prn(oArr));
		System.out.println(prn(cArr));
		
		
		cArr = new int[10];
		//clone() 이용
		System.out.println("준비된 복사본 배열: " + prn(cArr));
		System.out.println(cArr.hashCode());
		
		cArr = oArr.clone();
		
		System.out.println("복사 후 복사본 배열: " + prn(cArr));
		System.out.println(cArr.hashCode());
	}
	
	
	
}
