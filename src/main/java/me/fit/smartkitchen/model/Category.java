package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Category {

	@Id
	@SequenceGenerator(name = "categorySequence", sequenceName = "category_id_sequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "categorySequence")
	private Long id;
	private String name;
	@OneToMany(mappedBy="category")
	private Set<ItemCategory> items;

	public Category() {
		super();
	}

	public Category(Long id, String name, Set<ItemCategory> items) {
		super();
		this.id = id;
		this.name = name;
		this.items = items;
	}

	public Category(String name, Set<ItemCategory> items) {
		super();
		this.name = name;
		this.items = items;
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

	public Set<ItemCategory> getItems() {
		return items;
	}

	public void setItems(Set<ItemCategory> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", items=" + items + "]";
	}

}
