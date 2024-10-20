package com.silsub1.book.main;

import com.silsub1.book.model.vo.Book;

public class Main {
	public static void main(String[] args) {
		Book b1 = new Book("실습1","가",200);
		Book b2 = new Book("실습2","나",400);
		
		System.out.println("b1= "+ b1.toString());
		System.out.println("b2= "+ b2.toString());
		
		System.out.println("b1과 b2는 같은 값을 가진 객체인가?: "+ b1.equals(b2));
		
		//얕은복사
		Book b3 = b1;
		
		//깊은복사
		Book b4 = new Book(b1.getTitle(), b1.getAuthor(), b1.getPrice());

		System.out.println("b1과 b3는 같은 주소를 가진 객체인가?:  " + (b1.hashCode()==b3.hashCode()));
		System.out.println("b1과 b3는 같은 주소를 가진 객체인가?: " + (b1.hashCode()==b4.hashCode()));
		System.out.println("b1과 b3는 같은 값을 가진 객체인가?: "+b1.equals(b3));
		System.out.println("b1과 b4는 같은 값을 가진 객체인가?: "+b1.equals(b4));
		
	}

}
