package entity.compositekeys;

import java.io.Serializable;
import java.util.Objects;

public class AKey implements Serializable {

	private String name;
	private Integer age;

	public AKey() {}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		AKey aKey = (AKey) o;
		return Objects.equals(name, aKey.name) && Objects.equals(age, aKey.age);
	}

}
