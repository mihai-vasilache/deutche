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
	
	@Column(name="quantity")
	BigDecimal quantity; 
	
	@Column(name="DAYS")
	int days; 
	
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

	public int getDays() {
		return days;
	}
	
	@Override
	public int compareTo(Date o) {
		return purchiseDate.compareTo(o);
	}
	
}
