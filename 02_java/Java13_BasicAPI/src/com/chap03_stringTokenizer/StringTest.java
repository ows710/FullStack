package com.chap03_stringTokenizer;

import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {
		String str = "이창진,20,서울시 서초구 양재동,남";
		StringTokenizer st = new StringTokenizer(str,",");
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	
		String arr[] = str.split(",");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	//StringTokenizer
	//split()과 차이는 split은 String클래스의 메소드, 추출한 문자를 배열로 저장.
	//StringTokenizer는 클래스.
	
	//countToken(), nextToken(), hasMoreTokens() ...

}
