package com.easytip.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sub_category database table.
 * 
 */
@Entity
@Table(name="sub_category")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="creation_date", nullable=false, length=45)
	private String creationDate;

	@Column(length=45)
	private String name;

	//bi-directional many-to-one association to Offer
	@OneToMany(mappedBy="subCategory")
	private List<Offer> offers;

	//bi-directional many-to-one association to ServiceItem
	@OneToMany(mappedBy="subCategory")
	private List<ServiceItem> serviceItems;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
	private Category category;

	public SubCategory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(String creationDate) {
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

	public List<ServiceItem> getServiceItems() {
		return this.serviceItems;
	}

	public void setServiceItems(List<ServiceItem> serviceItems) {
		this.serviceItems = serviceItems;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}