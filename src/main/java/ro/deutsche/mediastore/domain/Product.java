package ro.deutsche.mediastore.domain;

import java.math.BigDecimal;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
@Access(AccessType.FIELD)
public class Product {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="PRICE")
	private BigDecimal price; 
	
	@Column(name="FREQUENT_RELEASE_POINTS")
	@Enumerated(EnumType.STRING)
	private FrequesntReleasePoints rentalFrequency;
	
	@Column(name="AGE_AUDIENCE")
	@Enumerated(EnumType.STRING)
	private AgeAudiance ageAudience;
	
	@Column(name="PRODUCT_TYPE")
	@Enumerated(EnumType.STRING)
	private ProductType productType;

	public BigDecimal getPrice() {
		return price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public FrequesntReleasePoints getRentalFrequency() {
		return rentalFrequency;
	}

	public AgeAudiance getAgeAudience() {
		return ageAudience;
	}
	
	
}
