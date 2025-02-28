package entity;

import entity.enums.CustomerCardStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class CustomerCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(mappedBy = "card")
	private User customer;

	private LocalDate subscriptionDate;

	private Integer points;

	@Enumerated(EnumType.STRING) // This way the status column's value will be one of the strings in enum. If EnumType.ORDINAL then the stored value would be 0,1,2...
	@Column(name="card_status")
	private CustomerCardStatus status;

	public CustomerCard() {
		subscriptionDate = LocalDate.now();
		points = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public CustomerCardStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerCardStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerCard{" +
				"id=" + id +
				", subscriptionDate=" + subscriptionDate +
				", points=" + points +
				", status=" + status +
				'}';
	}
}
