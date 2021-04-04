package me.fit.smartkitchen.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class Item {
	
	@Id
	@SequenceGenerator(name = "itemSequence", sequenceName = "item_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "itemSequence")
	private Long id;
	private String name;
	private Date expiryDate;
	private Double price;
	private Double discount;
	private String condition;
	public Item(String name, Date expiryDate, Double price, Double discount, String condition) {
		super();
		this.name = name;
		this.expiryDate = expiryDate;
		this.price = price;
		this.discount = discount;
		this.condition = condition;
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
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", expiryDate=" + expiryDate + ", price=" + price + ", discount="
				+ discount + ", condition=" + condition + "]";
	}
}
