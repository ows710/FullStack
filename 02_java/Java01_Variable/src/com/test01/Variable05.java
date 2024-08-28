package com.test01;

public class Variable05 {
	public static void main(String[] args) {
		//준비: 클래스명 변수명=new 클래스명();
		Variable05 test = new Variable05();
		//실행: 변수명.메소드명();
		test.test01();
		
		int no = 10;
		short snum = (short)no;
	}
	
	//형변환 : 타입을 변경 / 자동형변환,강제(명시적)형변환
	//						  (바꿀자료형)값 또는 (바꿀자료형)변수
	
	//데이터 처리 규칙
	//1. 같은 타입끼리만 대입 가능
	//2. 같은 타입끼리만 계산 가능
	//3. 계산의 결과도 같은 타입
	
	public void test01() {
		boolean flag = true;
		//flag = 100; boolean은 무조건 true,false만 저장.(형변환 예외)
		
		
		//자동형변환
		int num = 'A';
		System.out.println("num: " + num);
		
		char ch = 97;
		System.out.println("ch: " + ch);
		
		//int 타입의 변수를 활용하는 경우는 강제형변환을 해야 한다.
		//강제형변환
		char ch2 = (char)num;
		System.out.println("ch2: " + ch2);
		
		System.out.println("-----------------");
		
		int inum = 10;
		long lnum = 100;
		
		//다른 자료형끼리의 연산은 큰 자료형으로 자동 형변환 후 연산처리
		//int isum = inum+lnum;
		
		//1. 연산 결과를 int로 강제형변환
		int isum = (int)(inum+lnum);
		System.out.println("isum: " + isum);
		
		//2. long 타입 데이터를 강제 형변환 시켜 연산
		int isum2 = inum + (int)lnum;
		System.out.println("isum2: " + isum2);
		
		//3. 결과 값을 long 타입 변수에 저장
		long lsum = inum + lnum;
		System.out.println("lsum: " + lsum);
		
		System.out.println("-----------------");
		//정수는 실수로 자동 형변환 가능
		//실수는 정수로 강제 형변환 필요
		long lnum2 = 100;
		float fnum = lnum2;
		System.out.println("fnum: " + fnum);
		
		double dnum = 10.5;
		int inum2 = (int)dnum;
		//강제 형변환으로 인해 소수점 이하를 잘라 버리기 때문에 데이터 손실이 발생
		System.out.println("inum2: " + inum2);
		System.out.println((double)inum2);
		
	}
	
	
}
