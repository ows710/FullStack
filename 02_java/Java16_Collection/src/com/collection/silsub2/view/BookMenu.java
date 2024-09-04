package com.collection.silsub2.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.collection.silsub2.controller.BookManager;
import com.collection.silsub2.model.vo.Book;

public class BookMenu {

    private Scanner sc = new Scanner(System.in);
    private BookManager bm = new BookManager();

    // 기본 생성자
    public BookMenu() {}

    // 메인 메뉴를 출력하고 사용자 입력에 따라 BookManager의 메서드를 실행하는 메서드
    public void mainMenu() {
        while (true) {
            System.out.println("*** 도서 관리 프로그램 ***");
            System.out.println("1. 새 도서 추가");
            System.out.println("2. 도서정보 정렬 후 출력");
            System.out.println("3. 도서 삭제");
            System.out.println("4. 도서 검색출력");
            System.out.println("5. 전체 출력");
            System.out.println("6. 끝내기");
            System.out.print("메뉴 번호 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine(); // 개행 문자 처리

            switch (menu) {
                case 1:
                    bm.addBook(inputBook());
                    break;
                case 2:
                    Book[] sortedBooks = bm.sortedBookList();
                    if (sortedBooks != null && sortedBooks.length > 0) {
                        bm.printBookList(sortedBooks);
                    } else {
                        System.out.println("도서 목록이 비어있습니다.");
                    }
                    break;
                case 3:
                    int deleteResult = bm.deleteBook(inputBookNo());
                    if (deleteResult == 1) {
                        System.out.println("성공적으로 삭제");
                    } else {
                        System.out.println("삭제할 글이 존재하지 않음");
                    }
                    break;
                case 4:
                    int searchIndex = bm.searchBook(inputBookTitle());
                    if (searchIndex == -1) {
                        System.out.println("조회한 글이 존재하지 않음");
                    } else {
                        System.out.println(bm.selectBook(searchIndex));
                    }
                    break;
                case 5:
                    Book[] allBooks = bm.selectAll().toArray(new Book[0]);
                    if (allBooks == null || allBooks.length == 0) {
                        System.out.println("도서 목록이 없습니다.");
                    } else {
                        bm.printBookList(allBooks);
                    }
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    // Book 객체의 필드 값을 키보드로 입력 받아 초기화하고 Book 객체를 리턴하는 메서드
    public Book inputBook() {
        System.out.print("도서 제목: ");
        String title = sc.nextLine();

        System.out.print("도서 장르 (1:인문 / 2:자연과학 / 3:의료 / 4:기타): ");
        int category = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        System.out.print("도서 저자: ");
        String author = sc.nextLine();

        // 장르를 문자열로 변환
        String genre = "";
        switch (category) {
            case 1:
                genre = "인문";
                break;
            case 2:
                genre = "자연과학";
                break;
            case 3:
                genre = "의료";
                break;
            case 4:
                genre = "기타";
                break;
            default:
                System.out.println("잘못된 장르 선택입니다.");
                break;
        }

        return new Book(category, title, author);
    }

    // 삭제할 도서 번호를 키보드로 입력 받아 리턴하는 메서드
    public int inputBookNo() {
        System.out.print("삭제할 도서 번호: ");
        return sc.nextInt();
    }

    // 검색할 도서 제목을 키보드로 입력 받아 리턴하는 메서드
    public String inputBookTitle() {
        System.out.print("검색할 도서 제목: ");
        return sc.nextLine();
    }
}
