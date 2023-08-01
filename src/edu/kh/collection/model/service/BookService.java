package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Book;

public class BookService {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Book> bookList = new ArrayList<Book>();
	private List<Book> favList = new ArrayList<Book>();
	
	public BookService() {
		bookList.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		bookList.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개"));
		bookList.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		bookList.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		bookList.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
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
		System.out.println("7. 추천도서");
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
			case 5 : System.out.println( addFavorite() ); break;
			case 6 : System.out.println( deleteFavorite() ); break;
			case 7 : randomBook(); break;
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
		int bookNum = sc.nextInt();
		sc.nextLine();
		
		System.out.println("제목 : ");
		String name = sc.nextLine();
		
		System.out.println("작가 : ");
		String author = sc.nextLine();
		
		System.out.println("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.println("출판사 : ");
		String publisher = sc.nextLine();
		
		if( bookList.add(new Book(bookNum, name, author, price, publisher)) ){
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
		for(Book bk : bookList) {
			System.out.println(bk);
		}
		
	}
	
	
	public String updateBook() throws InputMismatchException {
		
		System.out.println("=======도서수정=======");
		
		System.out.println("도서 번호 입력 : ");
		int num = sc.nextInt();
		
		boolean bookFound = false;
		
		for (Book book : bookList) {
		if (book.getbookNum() == num) {
		bookFound = true;
		System.out.println(num + "번 도서 정보");
		System.out.println(book);
		            
		System.out.println("도서 번호: ");
		int bookNum = sc.nextInt();
		sc.nextLine();
		            
		System.out.println("제목: ");
		String name = sc.nextLine();

		System.out.println("작가: ");
	    String author = sc.nextLine();

		System.out.println("가격: ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.println("출판사: ");
		String publisher = sc.nextLine();

		int index = bookList.indexOf(book);
		 
		Book temp = bookList.set(index, new Book(bookNum, name, author, price, publisher));
		            return temp.getName() + "의 정보가 수정되었습니다";
			}
		}

		if (!bookFound) {
		return num + "번 도서를 찾을 수 없습니다.";
		} return "수정완료";
			
		    
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
			System.out.println(bookList.get(index));
			System.out.print("정말 삭제하시겠습니까?(Y/N) :");
			
			char ch = sc.next().toUpperCase().charAt(0);
			
			if(ch == 'Y') {
				Book temp = bookList.remove(index);
				return temp.getName() + "의 정보가 삭제되었습니다.";
				
			} else {
				return "취소";
			}
			
		}
		
	}
	
	
	public String addFavorite() {
		System.out.println("===== 즐겨찾기 등록 =====");
		System.out.println("등록할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		
		boolean flag = true;
		
		for(Book temp : bookList) {
			if(temp.getbookNum() == input) {
				
				favList.add(temp);
				
				flag = false;
			}
		}
		
		if(flag) {
			return "찾는 번호가 없습니다.";
		} else {
			return "등록 성공";
		}
		
		
	}
	
	
	public String deleteFavorite() {
		
		System.out.println("=====즐겨 찾기 삭제=====");
		
		System.out.print("즐겨찾기 삭제할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		
		boolean flag = true;
		
		for(Book temp : favList) {
			if(temp.getbookNum() == input) {
				
				int index = favList.indexOf(temp);
				
				favList.remove(index);
				
				flag = false;
				
				break;
			}
		}
		
		if (flag) {
			return "찾는 번호가 없습니다.";
		} else {
			return "삭제 성공";
		}
	}
	
	
	public void randomBook() {
		
		int max = bookList.size();
		int random = (int)(Math.random() * max);
		
		System.out.println(bookList.get(random).getName());
	}
	
	
}
