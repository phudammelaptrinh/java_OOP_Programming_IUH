package bai11;

import java.io.Serializable;

public class Customer implements Serializable {
	private String id;
	private String name;
	private double ticketPrice;

	public Customer(String id, String name, double ticketPrice) {
		this.id = id;
		this.name = name;
		this.ticketPrice = ticketPrice;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Ticket Price: " + ticketPrice;
	}
}
