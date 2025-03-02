package entity.compositekeys.embeddable_two;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeId implements Serializable {

	@Column(name = "username_cpk_col1")
	private String username;

	@Column(name = "department_id_cpk_col2")
	private Long departmentId;

	public EmployeeId() {}

	public EmployeeId(String username, Long departmentId) {
		this.username = username;
		this.departmentId = departmentId;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		EmployeeId that = (EmployeeId) o;
		return Objects.equals(username, that.username) && Objects.equals(departmentId, that.departmentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, departmentId);
	}

}
