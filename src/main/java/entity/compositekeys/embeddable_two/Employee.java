package entity.compositekeys.embeddable_two;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@EmbeddedId
	private EmployeeId id;

	private String email;

	@ManyToOne
	@JoinColumn(name="department_id_fk")
	@MapsId("departmentId")
	private Department department;

	public Employee() {}

	public Employee(EmployeeId id, String email) {
		this.id = id;
		this.email = email;
	}

	public EmployeeId getId() {
		return id;
	}

	public void setId(EmployeeId id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", email='" + email + '\'' +
				'}';
	}
}
