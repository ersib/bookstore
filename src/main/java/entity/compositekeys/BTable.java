package entity.compositekeys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@IdClass(AKey.class)
@Entity
public class BTable {

	@Id
	private String name;
	@Id
	private Integer age;

	private String foo;

	public BTable() {
	}

	public BTable(String name, Integer age, String foo) {
		this.name = name;
		this.age = age;
		this.foo = foo;
	}

}
