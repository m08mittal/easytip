package com.easytip.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the service_item database table.
 * 
 */
@Entity
@Table(name="service_item")
public class ServiceItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="creation_date", nullable=false)
	private Timestamp creationDate;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="serviceItemBean")
	private List<Offer> offers;

	//bi-directional many-to-one association to SubCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subcategoryId")
	private SubCategory subCategory;

	public ServiceItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Offer> getOffers() {
		return this.offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public SubCategory getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

}