package com.test01;

public class ArrayTest02 {
	public static void main(String[] args) {
	
		//배열에 데이터 입력.
		char[] ch = new char[26];
		for(int i=0; i<ch.length; i++) {
			ch[i] = (char)((int)'a'+i);
		}
		
		ArrayTest02.prn(ch);
		
		//위에서 만든 배열을 거꾸로 출력
		ArrayTest02.reverse(ch);
		
		//위에서 만든 배열을 대문자로 바꾸어 출력
		ArrayTest02.upper(ch);
		
	}
	
	public static void prn(char[] ch) {
		for(int i=0; i<ch.length; i++) {
			System.out.print(ch[i] + " ");
		}
		System.out.println();
		
	}
	
	
	public static void reverse(char[] ch) {
		for(int i=ch.length-1; i>=0; i--) {
			System.out.print(ch[i] + " ");
		}
		System.out.println();
	}
	public static void upper(char[] ch) {
		for(int i=0; i<ch.length; i++) {
			//System.out.print( Character.toUpperCase(ch[i]) + " " );
			System.out.print( (char)(ch[i]-32) + " " );
		}
		System.out.println();
		prn(ch);
	}
	
}
