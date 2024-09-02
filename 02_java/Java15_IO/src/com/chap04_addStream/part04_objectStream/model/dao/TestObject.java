package com.chap04_addStream.part04_objectStream.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.chap04_addStream.part04_objectStream.model.dto.Member;

public class TestObject {
	public void output() {
		Member[] marr = {
				new Member("user01","pass01","이창진",20,'남',1250.7),
				new Member("user02","pass02","김창진",16,'여',1221.3),
				new Member("user03","pass03","박창진",22,'여',1234.5)
		};
		
		//ObjectOutputStream
		ObjectOutputStream objOut = null;
		
		try {
			objOut = new ObjectOutputStream(new FileOutputStream("member.txt"));
		
			for(int i=0; i<marr.length; i++) {
				objOut.writeObject(marr[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public void input() {
		Member[] mar = new Member[3];
		
		ObjectInputStream objIn = null;
		
		try {
			objIn = new ObjectInputStream(new FileInputStream("member.txt"));
			
			for(int i=0; i<mar.length; i++) {
				mar[i] = (Member) objIn.readObject();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				objIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(Member m:mar)
			System.out.println(m);
		
	}
}
