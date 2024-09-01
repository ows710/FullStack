package com.chap01_fileTest;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		//File 클래스 테스트
		//파일이 없어도 File 객체 생성 가능.
		File file = new File("person.txt");
		System.out.println("파일명: " + file.getName());
		System.out.println("경로: " + file.getPath());
		System.out.println("경로: " + file.getAbsolutePath());
		System.out.println("용량: " + file.length());
		System.out.println("상위폴더: " + file.getParent());
		
		try {
			//파일이 없는 경우 파일을 생성
			//생성을 했다 : true 리턴
			//기존 파일이 존재 한다. : false
			boolean b = file.createNewFile();
			
			boolean b2 = file.delete();
			
			System.out.println(b);
			System.out.println(b2);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
