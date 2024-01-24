package dev.pattern.singleton.basic;

public class CompanyPrinter {

	private static CompanyPrinter printer = new CompanyPrinter();

	private CompanyPrinter() {}

	public static CompanyPrinter getPrinter() {
		return printer;
	}

	public static void print(String content) {
		System.out.println(content);
	}

	@Override
	public String toString() {
		return "Serial No." + Integer.toHexString(hashCode());
	}
}
