package appPackage;

import java.util.*;

public class validator { // Bill's Validator class blatantly stolen for my
							// benefit

	static Scanner scan = new Scanner(System.in);

	public static int readValidInt() {
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Please enter a number: ");
		}
		int x = scan.nextInt();
		scan.nextLine();
		return x;
	}

	public static int getValidInt(int min, int max) {
		try {
			int i = readValidInt();
			while (i < min || i > max) {
				System.out.print("Please enter a number within range! (" + min + "-" + max + "): ");
				i = readValidInt();
			}
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int getValidInt() {
		try {
			int i = readValidInt();
			while (i < 0 || i > 2147483647) {
				System.out.print("Please enter a number within range! (0 and 2147483647): ");
				i = readValidInt();
			}
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static String readYorN(String x, String y) {
		String z = scan.nextLine();

		while (!(z.equalsIgnoreCase(x) || z.equalsIgnoreCase(y))) {
			System.out.print("Invalid option, use 'y' or 'n': ");
			z = scan.nextLine();
		}
		return z;
	}

	public static String readValidString(int l) {
		while (!scan.hasNextLine() && scan.nextLine().length() > l) {
			scan.nextLine();
			System.out.print("Please enter a valid option: ");
		}
		String x = scan.nextLine();
		return x;
	}

	public static String getValidString(String inputs, int length) {

		try {
			String i = readValidString(length);
			while (!(i.matches(inputs))) {
				System.out.print("Please only input the country name with letters: ");
				i = readValidString(length);
			}
			return i;

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
