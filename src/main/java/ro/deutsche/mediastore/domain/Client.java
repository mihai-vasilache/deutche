package ro.deutsche.mediastore.domain;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTS")
@Access(AccessType.FIELD)
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CUSTOMER_CATEGORY")
	@Enumerated(EnumType.STRING)
	private CustomerCategory customerCategory;

	@Column(name = "CUSTOMER_BILLING_TYPE")
	@Enumerated(EnumType.STRING)
	private CustomerBillingType customerBillingType;

	@OneToMany
	@JoinTable(
			name = "CLIENT_RENTAL",
			joinColumns = {@JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name = "RENTAL_ID", referencedColumnName = "ID", unique = true)}
	)
	Set<Rental> rentals = new TreeSet<Rental>((Rental o1, Rental o2) -> o1.getPurchiseDate().compareTo(o2.getPurchiseDate()));

	public String getName() {
		return name;
	}

	public CustomerCategory getCustomerCategory() {
		return customerCategory;
	}

	public CustomerBillingType getCustomerBillingType() {
		return customerBillingType;
	}

	public Set<Rental> getRentals() {
		return rentals;
	}
}
