package entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ElementCollection
	@CollectionTable(name = "author_nickname", joinColumns = @JoinColumn(name="author_id"))
	@Column(name="nickname")
	private Collection<String> nickNames = new ArrayList<>();

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	@JdbcTypeCode(SqlTypes.JSON) // @JdbcTypeCode only after Hibernate 6
	private Award award;

	public Author() {
	}

	public Author(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
		book.getAuthors().add(this);
	}

	public void removeBook(Book book) {
		this.books.remove(book);
		book.getAuthors().remove(this);
	}

	public Collection<String> getNickNames() {
		return nickNames;
	}

	public void setNickNames(Collection<String> nickNames) {
		this.nickNames = nickNames;
	}

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", name='" + name + '\'' +
				", nickNames=" + nickNames +
				'}';
	}
}
