package com.collection.part04_generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestGenerics {
	//제네릭스
	//클래스나 메소드 내부에서 다룰 데이터의 타입을 지정.
	//컬렉션이 다룰 클래스타입을 제한 => 한 종류의 클래스만 저장 가능.
	
	//클래스명<클래스타입> 레퍼런스 = new 클래스명<클래스타입>();
	//ArrayList<String> list = new ArrayList<String>();
	// ==> String 객체만 저장 가능.
	
	//public void test(ArrayList<String> list)
	// 매개변수 list는 인자값으로 제네릭스가 <String>으로 선언된 ArrayList 객체만 받는다.
	
	//public ArrayList<String> test()
	
	//public class Test<T>
	//Test<String> t1;
	//Test<Integer> t2;
	
	public void test1() {
		List list = new ArrayList();
		
		list.add(new String("asdf"));
		list.add(new Book());
		list.add(new Student());
		list.add(new Car());
		
		for(int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			if(obj instanceof Book) {
				((Book) obj).printBook();
			}
			if(obj instanceof Student) {
				((Student) obj).score();
			}
			if(obj instanceof Car) {
				((Car) obj).printCar();
			}
			
		}
		
	}
	
	public void test2() {
		List<Book> list = new ArrayList<Book>();
		
		//list.add("test");
		list.add(new Book());
		list.add(new Book());
		
		for(int i=0; i<list.size(); i++) {
			Book b1 = list.get(i);
		}
		
		////////////////
		List list2 = new ArrayList();
		
		list2.add(new Book());
		list2.add(new Book());
		
		for(int i=0; i<list2.size(); i++) {
			Book b1 = (Book)list2.get(i);
		}
		
		/////////////////////////////
		HashMap<String, Book> map = new HashMap<String, Book>();
		
		//map.put("one", "test");
		map.put("one", new Book());
		map.put("two", new Book());
		map.put("three", new Book());
		
		Set<Map.Entry<String,Book>> entry = map.entrySet();
		
		
		/*Set keys = map.keySet();
		Iterator keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = (String)keyIter.next();
			Book value = (Book)map.get(key);
		}*/
		Set<String> keys = map.keySet();
		Iterator<String> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			Book value = map.get(key);
		}
	}
}
//한 클래스 파일(*.java) 여러개의 클래스를 정의할 수 있다.
class Book{
	private String title;
	public Book() {}
	public Book(String title) {
		this.title = title;
	}
	public void printBook() {
		System.out.println("printBook() call...");
	}
	@Override
	public String toString() {
		return "Book";
	}
}
class Student{
	public Student() {}
	public void score() {
		System.out.println("score() call...");
	}
	@Override
	public String toString() {
		return "Student";
	}
}
class Car{
	public Car() {}
	public void printCar() {
		System.out.println("printCar() call...");
	}
	@Override
	public String toString() {
		return "Car";
	}
}
