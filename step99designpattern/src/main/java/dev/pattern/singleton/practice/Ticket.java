package dev.pattern.singleton.practice;

public abstract class Ticket {
	private long serialNumber;
	
	protected Ticket(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public long getTicketNum() {
		return serialNumber;
	}
}
