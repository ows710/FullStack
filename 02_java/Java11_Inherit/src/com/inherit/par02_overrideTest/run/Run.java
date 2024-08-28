package com.inherit.par02_overrideTest.run;

import com.inherit.par02_overrideTest.model.vo.Book;

public class Run {
	public static void main(String[] args) {
		Book b1 = new Book("자바의 정석","김자바",500);
		Book b2 = new Book("HTML의 정석","박정석",300);
		
		
		//두 객체의 정보를 문자열로 리턴 : toString()
		System.out.println("b1= "+ b1.toString());
		System.out.println("b2= "+ b2.toString());
		
		//.toString()은 객체 호출시 jvm에 의해 자동으로 뒤에 생성.
		System.out.println("b1= "+ b1);
		System.out.println("b2= "+ b2);
		
		//
		System.out.println("b1과 b2는 같은 객체?: "+ b1.equals(b2));
		
		//얕은복사
		Book b3 = b1;
		System.out.println("b1과 b3는 같은 객체?: "+b1.equals(b3));
		
		//깊은복사
		Book b4 = new Book(b1.getTitle(), b1.getWriter(), b1.getPrice());
		
		
		System.out.println("b1과 b4는 같은 객체?: "+b1.equals(b4));
		System.out.println("b1: " + b1.hashCode());
		System.out.println("b3: " + b3.hashCode());
		System.out.println("b4: " + b4.hashCode());
		
		
		Book[] bArr = new Book[3];
		bArr[1] = new Book();
		
		
		
		
	}

}
