package dev.pattern.singleton.practice;

public class TicketMachine {
	private static int MAX_TICKET_LIMIT = 5;
	private static int currentTicketCount = 0;
	private static long[] VALID_SERIAL_NUMBERS = new long[MAX_TICKET_LIMIT];

	private static TicketMachine machine = new TicketMachine();

	private TicketMachine() {
	}

	public static Ticket getTicket() {
		Ticket ticket;
		currentTicketCount++;
		if (currentTicketCount <= MAX_TICKET_LIMIT) {
			ticket = new ValidTicket(currentTicketCount);
			VALID_SERIAL_NUMBERS[currentTicketCount-1] = currentTicketCount;
		} else {
			ticket = new InvalidTicket(0L);
		}
		
		return ticket;
	}

	public static TicketMachine operateTicketMachine() {
		return machine;
	}

	public static void checkValidTicket(Ticket ticket) {
		if (0 == ticket.getTicketNum()) {
			System.out.println("유효하지 않은 티켓입니다.");
		} else {
			System.out.println("유효한 티켓입니다.");
		}
	}

	public String toString() {
		return  Integer.toHexString(hashCode());
	}
}
