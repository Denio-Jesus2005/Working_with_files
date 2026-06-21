package model.entities;

public class ProductSale {

	private String name;
	private double price;
	private int quantity;

	public ProductSale() {

	}

	public ProductSale(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double totalPrice() {
		double total = price * quantity;
		return total;
	}
	
}
