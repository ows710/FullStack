package com.test01;

import java.util.Scanner;

public class IfTest01 {
	public void testIf() {
		//단독 if문
		//조건식의 결과가 참(true)이면 { }안에 있는 코드 실행
		//조건식의 결과가 거짓(false)이면 { }안에 있는 코드 무시하고 넘어간다.
		
		int num = 5;
		
		//짝수인지 조건을 확인
		if( num%2==0 ) {
			//조건이 참일 때 실행
			System.out.println("num의 값은 짝수입니다.");
		}
		//짝수가 아닌 조건을 확인(즉, 홀수인지 확인)
		if( num%2!=0 ) {
			System.out.println("num의 값은 홀수입니다.");
		}
		
		System.out.println("종료!");
		
	}
		
	public void testIfElse01() {
		//if else문
		//if문의 조건식의 결과가 거짓이면 else문으로 넘어감.	
		//조건이 참인 경우와 거짓인 경우에 수행하는 명령어를 따로 작성.
		//else에는 조건식 사용불가
		
		/* testIf()에서 실행 하였던 if문들을
		 * if else로 변경하여 실행 */
		
		int num = 5;
		
		if( num%2==0 ) {
			//조건이 참일 때
			//num이 짝수일 때
			System.out.println("num은 짝수입니다.");
		}else {
			//조건이 거짓일 때
			//num이 짝수가 아닐 때
			System.out.println("num은 홀수입니다.");
		}
		System.out.println("종료");
		
		
	}
	
	public void testIfElse02() {
		//50보다 큰 수인지( >=50 )
		//50보다 작은 수인지 확인 하고
		//'50보다 크다'/'50보다 작다'라고 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("0보다 큰 정수 입력: ");
		int no = sc.nextInt();
		
		if(no>=50) {
			//50보다 큰 수라면 짝수인지 홀수인지 출력
			if(no%2==0) {
				System.out.println("50보다 큰 짝수");
			}else {
				System.out.println("50보다 큰 홀수");
			}
		}else {
			System.out.println("50보다 작다.");
		}
		
	}
	
	public void testIfElse03() {
		//숫자를 하나 입력받아 양수인지 음수인지 출력.
		//단, 0이면 "0입니다"라고 출력(if 중첩)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
		int num = sc.nextInt();
		
		if(num != 0) {
			if(num>0) {
				System.out.println("양수");
			}else {
				System.out.println("음수");
			}
		}else {
				System.out.println("0입니다.");
		}
		
		
	}
}
