package com.test01;

public class MTest {
	//program : 실행할 수 있는 파일(.exe)
	//process : 실행되고 있는 상태
	//thread : 하나의 프로세스에 여러개의 쓰레드가 실행
	
	//Process - T, T, T, ...
	
	//java에서 쓰레드
	//	1. Runnable를 implements
	//	2. Thread를 extends
	
	// Thread.start()가 run()을 호출.
	public static void main(String[] args) {
		System.out.println("--- main start ---");

		Thread01 m1 = new Thread01();
		Thread01 m2 = new Thread01();
		
		//run() 메소드를 main에서 호출하여 실행한 것.
		//m1.run();
		//m2.run();
		
		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		
		//start() -> run() 호출
		t1.start();
		t2.start();
		
		
		System.out.println("--- main stop ---");
	}

}
