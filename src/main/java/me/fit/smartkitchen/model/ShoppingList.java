package me.fit.smartkitchen.model;

import java.util.Set;

import javax.persistence.Entity;

@Entity

public class ShoppingList {

	private Long id;
	private String name;
	private Set<Item> list;
}
