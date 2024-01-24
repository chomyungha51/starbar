package dev.pattern.singleton.practice;

public class User {
	private Ticket ticket;

	public void useTicketMachine() {
		TicketMachine machine = TicketMachine.operateTicketMachine();
		System.out.println(machine+"번 머신을 사용합니다.");
		ticket = machine.getTicket();
	}

	public Ticket getMyTicket() {
		return ticket;
	}

	public String toString() {
		return Integer.toHexString(hashCode());
	}

}
