package entity.compositekeys.embeddable_one;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParentPrimaryKey implements Serializable {

	private String firstname;
	private String lastname;

	public ParentPrimaryKey() {}

	public ParentPrimaryKey(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		ParentPrimaryKey that = (ParentPrimaryKey) o;
		return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, lastname);
	}
}
