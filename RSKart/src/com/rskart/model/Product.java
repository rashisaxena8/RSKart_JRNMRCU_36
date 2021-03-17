package com.rskart.model;
import java.util.*;

public class Product {

	private long id;
	private String title;
	private float price;
	private int quantity;
	private Date mfDate;
	private Date expiryDate;

	public Product(long id, String title, float price, int quantity, Date mfDate, Date expiryDate) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.mfDate = mfDate;
		this.expiryDate = expiryDate;
	}

	public Product(long id, String title, float price, int quantity) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public Product() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getMfd() {
		return mfDate;
	}

	public void setMfd(Date mfDate) {
		this.mfDate = mfDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Product Id=" + id + "\t Title=" + title + "\t Price=" + price + "\t Quantity=" + quantity
				+ "\t Date of Manufacture= " + mfDate + "\t ExpiryDate=" + expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mfDate == null) ? 0 : mfDate.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + quantity;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Product other = (Product) obj;

		if (id != other.id)
			return false;
		return true;
	}
}