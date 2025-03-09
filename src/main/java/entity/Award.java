package entity;

import java.io.Serializable;

public class Award implements Serializable {

	private String title;
	private Integer year;
	private String institution;

	public Award(String title, Integer year, String institution) {
		this.title = title;
		this.year = year;
		this.institution = institution;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
