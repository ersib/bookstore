package entity.compositekeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChapterId implements Serializable {

	@Column(name = "chapter_num")
	private Integer chapterNumber;

	@Column(name="isbn")
	private String isbn;

	public ChapterId() {}

	public ChapterId(Integer chapterNumber, String isbn) {
		this.chapterNumber = chapterNumber;
		this.isbn = isbn;
	}

	public Integer getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(Integer chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public String getBookISBN() {
		return isbn;
	}

	public void setBookISBN(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		ChapterId chapterId = (ChapterId) o;
		return Objects.equals(chapterNumber, chapterId.chapterNumber) && Objects.equals(isbn, chapterId.isbn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(chapterNumber, isbn);
	}

	@Override
	public String toString() {
		return "ChapterId{" +
				"chapterNumber=" + chapterNumber +
				", isbn='" + isbn + '\'' +
				'}';
	}

}
