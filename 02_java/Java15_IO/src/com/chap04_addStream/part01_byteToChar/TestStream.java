package com.chap04_addStream.part01_byteToChar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestStream {

	public void input() {
		//ex) 보조스트림은 BufferedReader 사용 (char 단위의 스트림)
		//		기반스트림으로 System.in 사용 (byte 단위의 스트림)
		//InputStreamReader 클래스
		BufferedReader br
			= new BufferedReader(new InputStreamReader(System.in));
	
		try {
			System.out.print("문자열 입력: ");
			String val = br.readLine();
			
			System.out.println("val: " + val);
			output(val);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void output(String str) {
		//BufferedWriter, System.in,
		//					OutputStreamWriter
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write("이전에 입력받은 문자열: " + str);
			
			bw.flush();//버퍼에 잔류해 있는 내용을 밀어내기 위해 사용
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
