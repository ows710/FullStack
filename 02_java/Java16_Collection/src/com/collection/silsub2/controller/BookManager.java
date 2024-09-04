package com.collection.silsub2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.collection.silsub2.model.dao.BookDao;
import com.collection.silsub2.model.vo.Book;

public class BookManager {
	private BookDao bd = new BookDao();
	private Scanner sc = new Scanner(System.in);
	
	//생성자
	public BookManager() {}
	
    // 도서 추가 메서드
    public void addBook(Book book) {
        try {
            int lastBookNo = bd.getLastBookNo(); // 마지막 도서 번호를 가져옴
            book.setbNo(lastBookNo + 1); // 도서 번호를 마지막 도서 번호 + 1로 설정

            // BookDao의 addBook 메소드에 해당 Book 객체 전달
            bd.addBook(book);
        } catch (NullPointerException e) {
            System.out.println("첫 도서 등록입니다. 도서 번호를 1로 설정합니다.");
            book.setbNo(1);
            bd.addBook(book);
        } catch (Exception e) {
            System.out.println("도서 추가 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 도서 삭제 메서드
    public int deleteBook(int no) {
        // BookDao의 deleteBook 메소드에 전달받은 도서 번호 전달하고 결과 리턴
        return bd.deleteBook(no);
    }

    // 도서 검색 메서드
    public int searchBook(String title) {
        // BookDao의 searchBook 메소드에 전달받은 도서 제목 전달하고 결과 리턴
        return bd.searchBook(title);
    }

    // 특정 도서 선택 메서드
    public Book selectBook(int index) {
        // BookDao의 selectBook 메소드에 전달받은 인덱스 전달하고 결과 리턴
        return bd.selectBook(index);
    }

    // 전체 도서 리스트 조회 메서드
    public ArrayList<Book> selectAll() {
        // BookDao의 selectAll 메소드를 통해 도서 전체 리스트를 전달 받아 리턴
        return bd.selectAll();
    }

    // 정렬된 도서 리스트 조회 메서드
    public Book[] sortedBookList() {
        ArrayList<Book> sortedList = bd.sortedBookList(); // 정렬된 도서 리스트를 가져옴
        Book[] barr = new Book[sortedList.size()]; // Book[] 배열 생성
        for (int i = 0; i < sortedList.size(); i++) {
            barr[i] = sortedList.get(i); // 리스트의 각 도서를 배열에 추가
        }
        return barr; // 배열 주소 값 리턴
    }

    // 도서 리스트 출력 메서드
    public void printBookList(Book[] br) {
        for (Book book : br) {
            System.out.println(book);
        }
    }
}
