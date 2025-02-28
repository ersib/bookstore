package entity;

import entity.converters.BookCategoryConverter;
import entity.enums.BookCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Book {

	@Id
	private String isbn;
	@Column(name = "book_name")
	private String name;

	@ManyToOne(cascade = {CascadeType.PERSIST}) // using this cascade, it is enough to call session.persist(book) and the publisher is going to be persisted too
	//@ManyToOne
	@JoinColumn(name="publisher_code")
	private Publisher publisher;

	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(
			name = "book_authors",
			joinColumns = {@JoinColumn(name="book_isbn")},
			inverseJoinColumns = {@JoinColumn(name="author_id")}
	)
	private Set<Author> authors = new HashSet<>();

	@Convert(converter = BookCategoryConverter.class)
	//@Enumerated
	@Column(name = "book_category")
	private BookCategory category;
	
	public Book() {}
	public Book(String isbn, String name, Publisher publisher) {
		this.isbn = isbn;
		this.name = name;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	//	public List<Chapter> getChapters() {
//		return chapters;
//	}
//	public void setChapters(List<Chapter> chapters) {
//		this.chapters = chapters;
//	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", publisher="
				+ publisher + "]";
	}
}












































