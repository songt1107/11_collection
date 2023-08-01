package edu.kh.collection.model.vo;

public class Book {

	private int num;
	private String author;
	private String name;
	private int price;
	private String publisher;
	
	
	public Book() {}
	
	public Book(int num, String author, String name, int price, String publisher) {
		this.num = num;
		this.author = author;
		this.name = name;
		this.price = price;
		this.publisher = publisher;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "[도서번호 : " + num + "/ 도서작가 : " + author + "/ 도서제목 : " + name + "/ 도서가격 : " + price + "/ 출판사 : "
				+ publisher + "]";
	}
	
	
	
	
}
