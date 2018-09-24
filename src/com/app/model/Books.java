package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(generator = "userid", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "userid", sequenceName = "diglib_bookid", allocationSize = 1)

	@Column(name = "book_id", length = 5)
	private int book_id;
	@Column(name = "title", length = 30)
	private String title;
	@Column(name = "description", length = 100)
	private String description;
	@Column(name = "year", length = 4)
	private int year;
	@Column(name = "publisher", length = 30)
	private String publisher;
	@Column(name = "category", length = 10)
	private String category;
	@Column(name = "quantity", length = 10)
	private int quantity;

	public Books() {
		super();
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book_related [book_id=" + book_id + ", title=" + title + ", description=" + description + ", year="
				+ year + ", publisher=" + publisher + ", category=" + category + ", quantity=" + quantity + "]";
	}

}
