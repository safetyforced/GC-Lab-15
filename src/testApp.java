import java.util.ArrayList;

import appPackage.CountriesTextFile;
import appPackage.Country;
import appPackage.validator;

public class testApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int selection;
		int index = 0;
		ArrayList<Country> country = new ArrayList<>();

		System.out.println("Welcome to the Countries Maintenance Application!\n");

		while (true) {
			System.out.println("1 - See the list of countries \n2 - Add a country \n3 - Remove Country \n4 - Exit\n");
			System.out.print("Enter a menu number: ");

			selection = validator.getValidInt(1, 4);

			if (selection == 1) {
				CountriesTextFile.readCountry();
			} else if (selection == 2) {
				country.add(CountriesTextFile.addCountry());
				CountriesTextFile.saveStuff(country.get(index));
				index++;
			} else if (selection == 3) {
				CountriesTextFile.deleteCountry();
			} else if (selection == 4) {
				break;
			}

		}

	}

}
