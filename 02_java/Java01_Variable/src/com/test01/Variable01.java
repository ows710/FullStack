package com.test01;

public class Variable01 {
	//main
	public static void main(String[] args) {
		//작성한 메소드(기능) 실행하는 코드 추가
		
		Variable01 test = new Variable01();
		//준비단계: 클래스명 변수명 = new 클래스명();
		test.declareVariable();
		//실행단계: 변수명.메소드명();
		test.initVariable();
		
		//Variable01이라는 클래스타입의 변수 test를 만들고 그안에
		//new 연산자를 통해서 Variable01객체를 생성 후 주소값 저장.
		
		
		
	}

	
	
	
	//타입 변수명 = 값; ==>변수 선언, 초기화
	//타입: 생성할 변수(방)에 어떤 종류의 데이터가 들어갈지 지정
	//변수명: 변수의 이름, 우리가 저장한 변수에 접근할 수 있는 이름.
	//값: 리터럴, 변수에 들어갈(저장) 데이터
	public void declareVariable() {
	//메소드 declareVariable()에 실습 코드 작성 후 실행
		
		//숫자
		byte bnum;
		short snum;
		int inum;
		long lnum;
		
		float fnum;
		double dnum;
		
		//논리
		boolean isTrue;
		
		//문자
		char ch;
		
		//문자열(참조형)
		String str;
		
		
		//선언한 변수에 값을 대입
		bnum = 1;
		snum = 2;
		inum = 4;
		lnum = 8L;
		
		fnum = 4.0f;
		dnum = 8.0;
		
		isTrue = false; //true or false 값만 저장
		
		ch = 'A'; //''으로 묶인 리터럴. 문자 하나!
		str = "ABC"; //""으로 묶인 리터럴. 문자 여러개
		
		//변수에 저장된 값 출력하기
		System.out.println(bnum);
		System.out.println(inum);
		System.out.println(dnum);
		System.out.println(isTrue);
		System.out.println(ch);
		System.out.println(str);
	}
	
	
	public void initVariable() {
		//변수 선언과 동시에 초기화
		
		int inum = 4;
		double dnum = 8.0;
		
		boolean isTrue = true;
		char ch = 'A';
		String str = "안녕하세요";
		
		//변수 값 출력
		System.out.println(inum);
		System.out.println(dnum);
		System.out.println(isTrue);
		System.out.println(ch);
		System.out.println(str);
		
		
		
	}
	
	
}
