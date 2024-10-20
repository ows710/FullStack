package com.chap04_wrapperClass;

public class WrapperClassTest {
	//WrapperClass
	//경우에 따라 기본 타입의 데이터를 객체로 처리. 그때 사용.
	// 예)메소드의 매개변수 인자값으로 객체만 요구할 때, 다형성 적용하고 싶을 때, Object클래스 관련 메소드 사용할 때
	
	//Boxing		: 기본자료형 > Wrapper 클래스 (자동처리 : AutoBoxing)
	//unBoxing : Wrapper 클래스 > 기본자료형 (자동처리 : AutoUnBoxing)
	public static void main(String[] args) {
		////boxing
		Integer i = new Integer(10);
		Integer i2 = new Integer(15);
		Double d = new Double(10.0);
		
		System.out.println(i.equals(i2));
		System.out.println(i.compareTo(i2));
		//i가 크다: 양수 리턴, i2가 크다: 음수 리턴, 같다: 0 리턴
		//문자와 숫자 비교 가능.
		
		
		//AutoBoxing
		short s = 10;
		Integer i3 = 5;
		Double d2 = 5.0;
		
		
		//UnBoxing
		//Wrapper 클래스를 기본자료형으로
		int ki = i3.intValue();
		double kd = d2.doubleValue();
		
		//AutoUnboxing
		int a = i;
		int b = i2;
		System.out.println("a+b: " + (a+b));
		
		abox(a+b);		//int >> (autoBoxing) >> Integer >> (다형성) >> Object
		
		test();
	}

	public static void abox(Object obj) {
		System.out.println((Integer)obj);
		System.out.println((int)obj);
	}
	
	public static void test() {
		//str->pri
		byte b = Byte.parseByte("1");
		int i = Integer.parseInt("4");
		double d = Double.parseDouble("0.2");
		boolean b1 = Boolean.parseBoolean("true");
		
		//valueOf()를 이용할 수도 있다.
		//b = Byte.valueOf("1");
		//i = Integer.valueOf("44");
		
		System.out.println(b);
		System.out.println(i);
		System.out.println(d);
		System.out.println(b1);
		
		//pri->str
		String si = Integer.valueOf(3).toString();
		String sf = Float.valueOf(3.3f).toString();
		
		String sd = 3.3+"";
	}
	
}
