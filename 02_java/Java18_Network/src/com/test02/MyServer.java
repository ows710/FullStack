package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MyServer {
	public static void main(String[] args) throws IOException {
		//UDP
		//소켓 생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("서버입니다.");
		
		//보낼 data
		byte[] buff = "UDP 테스트입니다.".getBytes();
		
		//datagram packet으로 감싼다.(보내려는 data, 보내려는 위치 정보)
		//localhost == 127.0.0.1
		DatagramPacket sendP = 
				new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 9999);
		
		//보낸다
		ds.send(sendP);
		
		//종료
		ds.close();
		ds.disconnect();
	}

}
