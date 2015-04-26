package com.easytip.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the offer database table.
 * 
 */
@Entity
@Table(name="offer")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="creation_date", nullable=false)
	private Timestamp creationDate;

	@Column(nullable=false)
	private double price;

	@Column(name="valid_date")
	private Timestamp validDate;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="merchantId", nullable=false)
	private User user;

	//bi-directional many-to-one association to ServiceType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="service_type_id", nullable=false)
	private ServiceType serviceType;

	//bi-directional many-to-one association to ServiceItem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="service_item")
	private ServiceItem serviceItemBean;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId")
	private Category category;

	//bi-directional many-to-one association to SubCategory
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sub_category_id")
	private SubCategory subCategory;

	//bi-directional many-to-one association to OrderItem
	@OneToMany(mappedBy="offer")
	private List<OrderItem> orderItems;

	public Offer() {
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Timestamp validDate) {
		this.validDate = validDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ServiceType getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public ServiceItem getServiceItemBean() {
		return this.serviceItemBean;
	}

	public void setServiceItemBean(ServiceItem serviceItemBean) {
		this.serviceItemBean = serviceItemBean;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}