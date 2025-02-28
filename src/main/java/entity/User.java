package entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bs_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name="street", column = @Column(name = "home_street")),
			@AttributeOverride(name="city", column = @Column(name = "home_city")),
			@AttributeOverride(name="zipcode", column = @Column(name = "home_zipcode")),
	})
	private Address address;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="customercard_id", unique = true)
	private CustomerCard card;

	public User() {
	}

	public User(String name, Address address) {
		this.name = name;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CustomerCard getCard() {
		return card;
	}

	public void setCard(CustomerCard card) {
		this.card = card;
	}
}
