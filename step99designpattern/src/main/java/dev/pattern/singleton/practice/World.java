package dev.pattern.singleton.practice;

public class World {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			
			User user = new User();
			System.out.println((i + 1) + "번째 사용자의 고유번호는 " + user +" 입니다.");
			user.useTicketMachine();
			System.out.println((i + 1) + "번째 사용자 " + user+" 의 티켓 번호는 "+user.getMyTicket().getTicketNum() +" 입니다.");
			System.out.print("이 티켓은 ");
			TicketMachine.checkValidTicket(user.getMyTicket());
			System.out.println("=======================================================");
			
		}
	}

}
