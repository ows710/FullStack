package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyClient {
	public static void main(String[] args) throws IOException {
		//소켓 생성
		DatagramSocket  ds = new DatagramSocket(9999);
		System.out.println("클라이언트");
		
		//받을 data 저장할 배열 생성
		byte[] buff = new byte[1024];
		
		//datagramPacket 생성
		DatagramPacket receiveP = 
				new DatagramPacket(buff, buff.length);
		
		//저장. 받자
		ds.receive(receiveP);
		System.out.println( new String(receiveP.getData()) );
		
		//종료
		ds.close();
		ds.disconnect();
	}

}
