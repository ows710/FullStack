package com.silsub1.example;
import java.util.Scanner;
public class Munjae {
	public void test1() {
		System.out.print("국어: ");
		int kor = new Scanner(System.in).nextInt();
		System.out.print("영어: ");
		int eng = new Scanner(System.in).nextInt();
		System.out.print("수학: ");
		int math = new Scanner(System.in).nextInt();
		int sum = kor+eng+math;
		double avg = sum/3.0;
		if(kor>=40 && eng>=40 && math>=40 && avg>=60) {
			System.out.println("국어: "+kor+" 영어: "+eng+" 수학: "+math+" 합계: "+sum+" 평균: "+avg);
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
	public void test2() {
		System.out.println("*** 초기 메뉴 ***");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.print("메뉴번호 입력 : ");
		int num = new Scanner(System.in).nextInt();
		System.out.print("처리내용 : ");
		switch(num) {
		case 1:
			System.out.println("입력메뉴가 선택되었습니다.");
			break;
		case 2:
			System.out.println("수정메뉴가 선택되었습니다.");
			break;
		case 3:
			System.out.println("조회메뉴가 선택되었습니다.");
			break;
		case 4:
			System.out.println("삭제메뉴가 선택되었습니다.");
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			break;
		default:
			System.out.println("번호가 잘못 입력되었습니다.");
			System.out.println("다시 입력하십시오.");
		}
	}
	public void test3() {
		System.out.print("정수 하나 입력: ");
		int num = new Scanner(System.in).nextInt();
		if(num>0) {
			System.out.println("양수다.");
		}else {
			System.out.println("양수가 아니다.");
		}
	}
	public void test4() {
		int num = 0;
		String str = "";
		
		System.out.print("정수 하나 입력: ");
		num = new Scanner(System.in).nextInt();
		
		if(num%2==0) {
			str = "짝수다.";
		}else {
			str = "홀수다.";
		}
		
		System.out.println(str);
	}
	public void inputTest() {
		System.out.print("이름: ");
		String name = new Scanner(System.in).next();
		System.out.print("나이: ");
		int age = new Scanner(System.in).nextInt();
		System.out.print("키: ");
		double height = new Scanner(System.in).nextDouble();
		if(name!=null && name.length()>0 && age>0 && height>0) {
			System.out.println("이름: "+name);
			System.out.println("나이: "+age);
			System.out.println("키: "+height);
			System.out.println("확인: "+name+"의 나이는 "+age+"세이고, 키는 "+height+"cm 이다.");	
		}
	}
	public void test6() {
		System.out.print("첫번째 정수 : ");
		int num1 = new Scanner(System.in).nextInt();
		System.out.print("두번째 정수 : ");
		int num2 = new Scanner(System.in).nextInt();
		if(num1>0 && num2>0) {
			System.out.println(num1+" + "+num2+" = "+(num1+num2));
			System.out.println(num1+" - "+num2+" = "+(num1-num2));
			System.out.println(num1+" * "+num2+" = "+(num1*num2));
			System.out.println(num1+" / "+num2+" = "+(num1/num2));
			System.out.println(num1+" % "+num2+" = "+(num1%num2));
			
		}
	}
	public void test7() {
		int score = 0;
		char grade = ' ';
		System.out.print("점수 : ");
		score = new Scanner(System.in).nextInt();
		if(score>=90) {
			grade='A';
		}else if(score>=80) {
			grade='B';
		}else if(score>=70) {
			grade='C';
		}else if(score>=60) {
			grade='D';
		}else {
			grade='F';
		}
		System.out.println("점수 : "+score+", 학점 : "+grade);
	}
}
