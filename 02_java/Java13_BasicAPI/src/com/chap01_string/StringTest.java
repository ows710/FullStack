package com.chap01_string;

public class StringTest {

	public static void main(String[] args) {
		//test1();
		test2();
	}
	
	//String 클래스
	//immutable(변경불가)
	public static void test1() {
		//1. 문자열을 리터럴로 생성
		String str = "abc";
		String str1 = "abc";
		
		System.out.println(str);
		System.out.println(str1);
		
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		
		//2. 생성자를 이용한 문자열 생성
		String str3 = new String("abc");
		String str4 = new String("abc");
		
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		//hashcode 오버라이딩
		System.out.println("---------------");
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		System.out.println(str == str1);
		System.out.println(str3 == str4);	
	}
	
	public static void test2() {
		String str = "abc";
		
		//charAt(i)
		System.out.println(str.charAt(1));
		//concat(String) : 합치기
		System.out.println(str.concat("def"));
		System.out.println(str);
		//contains(String) : 포함여부
		System.out.println(str.contains("ac"));
		//equals(String) : 비교
		System.out.println(str.equals("abc"));
		//length() : 문자열 길이
		System.out.println(str.length());
		
		//split() : 문자열을 구분.
		String str1 = "a,b,c,d,ef";
		String[] arr = str1.split(",");
		for(String s : arr) {
			System.out.println(s);
		}
		
		//toUpperCase() : 대문자로 변경 <==> toLowerCase()
		System.out.println(str.toUpperCase());
		//substring() : 잘라내기
		System.out.println(str1.substring(2,5));
		//trim() : 공백제거
		String str2 = "           ab c   ";
		System.out.println(str2);
		System.out.println(str2.trim());
		
	}
	
	
	
	
	
	

}
