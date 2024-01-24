package dev.pattern.singleton.basic;

public class Company {
	private static final int EMPLOYEES = 5;

	public static void main(String[] args) {
		
	
		
		Employee[] employees = new Employee[EMPLOYEES];

		for (int i = 0; i < EMPLOYEES; i++) {
			employees[i] = new Employee("user-" + i);
			employees[i].usePrinter();
		}
	}

}
