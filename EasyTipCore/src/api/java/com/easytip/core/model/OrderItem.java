package com.easytip.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the order_item database table.
 * 
 */
@Entity
@Table(name="order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private double amount;

	@Column(name="creation_date", nullable=false)
	private Timestamp creationDate;

	@Column(nullable=false)
	private int quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orderId", nullable=false)
	private Order order;

	//bi-directional many-to-one association to ItemStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_status_id", nullable=false)
	private ItemStatus itemStatus;

	//bi-directional many-to-one association to Offer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="offer_id", nullable=false)
	private Offer offer;

	public OrderItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ItemStatus getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

}