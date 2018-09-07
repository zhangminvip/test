package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.text.Collator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort();

	}

	// 创建Book数组
	public static Book[] createBook() {
		Book[] books = new Book[] { new Book(3, "奥德赛", "荷马"), new Book(1, "钢铁是怎样炼成的", "尼古拉·奥斯特洛夫斯基"),
				new Book(2, "红楼梦", "曹雪芹"),
				new Book(4, "红楼梦", "另有其人"),

		};

		return books;
	}
	
	// 排序方法
	public static void sort() {
		Book[] books = createBook();
		
		// 匿名内部类
		Arrays.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book a, Book b) {
				Collator instance = Collator.getInstance(Locale.CHINA);
				if (a.getBook_name().equals(b.getBook_name())) {
					
//					System.out.println(a.getAuthor()+b.getAuthor()+a.getAuthor().compareTo(b.getAuthor()));
//					return a.getAuthor().compareTo(b.getAuthor());
//					return -1;
					return instance.compare(a.getAuthor(), b.getAuthor());
				}
//				System.out.println(a.getBook_name().compareTo(b.getBook_name()));
				return instance.compare(a.getBook_name(), b.getBook_name());
			}
		});
		System.err.println(Arrays.toString(books));
	}

}

/*
 * Book 类
 */
class Book {

	private int id;
	private String book_name;
	private String author;

	
	// 构造器
	public Book(int id, String book_name, String author) {
		this.id = id;
		this.book_name = book_name;
		this.author = author;

	}
	
	// generate getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book[id = "+this.id+",book_name=" + this.book_name + ",author=" + this.author + "]";
	}

}
