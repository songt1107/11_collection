package edu.kh.collection.model.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Book;

public class BookService {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Book> bookList = new LinkedList<Book>();
	
	public BookService() {
		
		
		
	}
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		
		do {
			
		
		System.out.println("<도서 목록 프로그램>");
		
		System.out.println("1. 도서등록");
		System.out.println("2. 도서조회");
		System.out.println("3. 도서수정");
		System.out.println("4. 도서삭제");
		System.out.println("5. 즐겨찾기 추가");
		System.out.println("6. 즐겨찾기 삭제");
		System.out.println("0. 프로그램 종료");
		
		System.out.println("\n메뉴 번호 선택 >>");
		
		try {
			menuNum = sc.nextInt();
			System.out.println();
			
			switch(menuNum) {
			case 1 : System.out.println( addBook() ); break;
			case 2 : selectAll(); break;
			case 3 : System.out.println( updateBook() ); break;
			case 4 : System.out.println( removeBook() ); break;
			case 5 : System.out.println("즐겨찾기 추가"); break;
			case 6 : System.out.println("즐겨찾기 삭제"); break;
			case 0 : System.out.println("프로그램 종료..."); break;
			default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
			}
			
		} catch(InputMismatchException e) {
			System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해주세요.");
			
			sc.nextLine(); 
			
			menuNum = -1;
		}
		
	} while(menuNum != 0 );
		
	}
	
	
	public String addBook() throws InputMismatchException {
		System.out.println("=======도서등록=======");
		
		System.out.println("도서 번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.println("작가 : ");
		String author = sc.nextLine();
		
		System.out.println("제목 : ");
		String name = sc.nextLine();
		
		System.out.println("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.println("출판사 : ");
		String publisher = sc.nextLine();
		
		if( bookList.add(new Book(num, author, name, price, publisher)) ){
			return "성공";
		} else {
			return "실패";
		}
		
	}
	
	
	public void selectAll() {
		System.out.println("=======도서조회=======");
		
		if(bookList.isEmpty()) {
			System.out.println("도서 정보가 없습니다");
			return;
		}
		
		int index = 0;
		for(Book bk : bookList) {
			System.out.print(index++ + "번 : ");
			System.out.println(bk);
		}
		
	}
	
	
	public String updateBook() throws InputMismatchException {
		System.out.println("=======도서수정=======");
		
		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(bookList.isEmpty()) {
			return "등록된 도서가 없습니다";
		} else if(index < 0){
			return "음수는 입력할 수 없습니다";
		} else if(index >= bookList.size() ) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
		} else {
			System.out.println(index + "번째 등록된 도서 정보");
			System.out.println(bookList.get(index));
			
			System.out.println("도서 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			System.out.println("작가 : ");
			String author = sc.nextLine();
			
			System.out.println("제목 : ");
			String name = sc.nextLine();
			
			System.out.println("가격 : ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.println("출판사 : ");
			String publisher = sc.nextLine();
			
			Book temp = bookList.set(index, new Book(num, author, name, price, publisher));
			
			return temp.getName() + "의 정보가 변경되었습니다";
			
		}
		
	}
	
	
	public String removeBook() throws InputMismatchException {
		System.out.println("=======도서삭제=======");
		
		System.out.println("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		if(bookList.isEmpty()) {
			return "등록된 도서가 없습니다";
		} else if( index < 0 ){
			return "음수는 입력할 수 없습니다";
		
		} else if( index >= bookList.size() ) {
			return "범위를 넘어선 값을 입력할 수 없습니다";
		
		} else {
			System.out.println("정말 삭제하시겠습니까?(Y/N) :");
			
			char ch = sc.next().toUpperCase().charAt(0);
			
			if(ch == 'Y') {
				Book temp = bookList.remove(index);
				return temp.getName() + "의 정보가 제거되었습니다.";
				
			} else {
				return "취소";
			}
			
		}
		
	}
	
	
}
