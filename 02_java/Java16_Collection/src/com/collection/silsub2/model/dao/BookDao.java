package com.collection.silsub2.model.dao;

import java.util.ArrayList;
import java.util.Collections;

import com.collection.silsub2.model.comparator.AscCategory;
import com.collection.silsub2.model.vo.Book;

public class BookDao {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    // 기본 생성자: bookList 객체를 생성함
    public BookDao() {
        this.bookList = new ArrayList<>();
    }

    // 매개변수 생성자: 다른 리스트를 전달 받아 bookList의 초기값으로 사용함
    public BookDao(ArrayList<Book> list) {
        this.bookList = new ArrayList<>(list);
    }

    // 도서의 마지막 도서 번호를 리턴하는 메서드
    public int getLastBookNo() {
        if (bookList.isEmpty()) {
            return 0; // 리스트가 비어있다면 0 리턴
        } else {
            return bookList.get(bookList.size() - 1).getbNo(); // 마지막 도서의 번호 리턴
        }
    }

    // 전달받은 도서 객체를 bookList에 추가하는 메서드
    public void addBook(Book book) {
        bookList.add(book);
    }

    // 전달받은 도서 번호와 일치하는 도서를 bookList에서 삭제하는 메서드
    // 삭제 성공 시 1 리턴, 실패 시 0 리턴
    public int deleteBook(int no) {
        for (int i=0; i<bookList.size(); i++) {
            if (bookList.get(i).getbNo() == no) {
                bookList.remove(i);
                return 1; // 삭제 성공
            }
        }
        return 0; // 삭제할 도서를 찾지 못함
    }

    // 전달받은 도서 제목을 포함하는 bookList의 인덱스를 리턴하는 메서드
    public int searchBook(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().contains(title)) {
                return i; // 일치하는 제목이 있는 도서의 인덱스 리턴
            }
        }
        return -1; // 일치하는 도서가 없을 경우 -1 리턴
    }

    // 전달받은 인덱스를 이용하여 bookList의 해당 인덱스 Book 객체를 리턴하는 메서드
    public Book selectBook(int index) {
        if (index >= 0 && index < bookList.size()) {
            return bookList.get(index);
        }
        return null; // 잘못된 인덱스일 경우 null 리턴
    }

    // 전체 도서 리스트를 리턴하는 메서드
    public ArrayList<Book> selectAll() {
        return new ArrayList<>(bookList); // bookList의 복사본 리턴
    }

    // 카테고리순 오름차순 정렬 클래스를 이용하여 리스트를 정렬 후 리턴하는 메서드
    public ArrayList<Book> sortedBookList() {
        ArrayList<Book> sortedList = new ArrayList<>(bookList); // bookList의 복사본 생성
        Collections.sort(sortedList, new AscCategory()); // AscCategory를 이용하여 정렬
        return sortedList; // 정렬된 리스트 리턴
    }
}

