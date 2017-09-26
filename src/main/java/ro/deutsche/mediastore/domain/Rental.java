package ro.deutsche.mediastore.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RENTALS")
@Access(AccessType.FIELD)
public class Rental implements Comparable<Date> {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="PURCHISE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	Date purchiseDate;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	@OneToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	
	@Column(name="quantity")
	BigDecimal quantity; 
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 83 * hash + Objects.hashCode(this.purchiseDate);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Rental other = (Rental) obj;
		if (!Objects.equals(this.purchiseDate, other.purchiseDate)) {
			return false;
		}
		return true;
	}

	public Date getPurchiseDate() {
		return purchiseDate;
	}

	public Product getProduct() {
		return product;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(Date o) {
		return purchiseDate.compareTo(o);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
