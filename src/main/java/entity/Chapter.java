package entity;

import entity.compositekeys.ChapterId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Chapter {

	@EmbeddedId
	private ChapterId chapterId;

	private String title;

	@ManyToOne()
	@JoinColumn(name = "book_isbn")
	@MapsId("isbn")
	private Book book;

	public Chapter() {
	}

	public
	Chapter(Integer chapterNumber, String title, Book book) {
		this.chapterId = new ChapterId(chapterNumber, book.getIsbn());
		this.title = title;
		this.book = book;
	}

	public ChapterId getChapterId() {
		return chapterId;
	}

	public void setChapterId(ChapterId chapterId) {
		this.chapterId = chapterId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Chapter{" +
				"chapterId=" + chapterId +
				", title='" + title + '\'' +
				", book=" + book +
				'}';
	}

}
