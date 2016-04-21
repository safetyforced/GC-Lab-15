package appPackage;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	static String userCountry = "error";
	static String userLanguage = "error";
	static int userGDP = -1;

	public static Country addCountry() {
		// creates a new country object
		
		System.out.print("Enter a country name: ");
		userCountry = validator.getValidString("[a-z A-Z]+", 300);

		System.out.println("Enter official language:");
		userLanguage = validator.getValidString("[a-z A-Z]+", 300);

		System.out.println("Enter most recent GDP: ");
		userGDP = validator.getValidInt();

		Country country = new Country(userCountry, userLanguage, userGDP);
		return country;
	}

	public static void saveStuff(Country country) {
		// saves an individual country object to the list

		Path countriesPath = Paths.get("countries.txt");
		File countriesFile = countriesPath.toFile();

		try {
			FileReader read = new FileReader(countriesFile);
			BufferedReader in = new BufferedReader(read);
			String line = in.readLine();
			FileWriter out = new FileWriter(countriesFile);
			while (line != null) {
				if (!line.equals("")) {
					out.append(line + "\n");
					line = in.readLine();
				} else {
					break;
				}
			}
			out.append(country.getName() + "," + country.getLanguage() + "," + country.getGDP());
			out.close();
			in.close();

		} catch (FileNotFoundException e) {
			// catches file not found exception and prints

			e.printStackTrace();
		} catch (IOException e) {
			// catches file not found exception and prints

			e.printStackTrace();
		}
	}

	public static void readCountry() {
		// reads country list, creates objects for each one, then prints
		// attributes to the console

		int GDP = 0;
		String[] lineItem = new String[3];
		ArrayList<Country> countries = new ArrayList<>();

		Path countriesPath = Paths.get("countries.txt");
		File countriesFile = countriesPath.toFile();

		try {
			FileReader r = new FileReader(countriesFile);
			BufferedReader in = new BufferedReader(r);
			String line = in.readLine();

			while (line != null) {
				if (!line.equals(""))
					lineItem = line.split(",");
				GDP = Integer.parseInt(lineItem[2]);
				Country country = new Country(lineItem[0], lineItem[1], GDP);
				countries.add(country);
				line = in.readLine();
			}
			for (int i = 0; i < countries.size(); i++) {

				System.out.println(countries.get(i).getName() + " " + countries.get(i).getLanguage() + " "
						+ countries.get(i).getGDP());
			}
			in.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteCountry() {
		// finds country in list and re-prints list without entry

		Path countriesPath = Paths.get("countries.txt");
		File countriesFile = countriesPath.toFile();
		System.out.print("Enter a country name: ");

		userCountry = validator.getValidString("[a-z A-Z]+", 300);

		try {
			FileReader read = new FileReader(countriesFile);
			BufferedReader in = new BufferedReader(read);
			String line = in.readLine();
			String[] lineItem = line.split(",");
			FileWriter out = new FileWriter(countriesFile);

			while (line != null) {
				if (!line.equals("") && !lineItem[0].equalsIgnoreCase(userCountry)) {
					out.append(line + "\n");
					line = in.readLine();
					lineItem = line.split(",");
				} else {
					line = in.readLine();
					lineItem = line.split(",");
					continue;
				}
			}

			out.close();
			in.close();

		} catch (FileNotFoundException e) {
			// catches file not found exception and prints

			e.printStackTrace();
		} catch (IOException e) {
			// catches IO exception and prints

			e.printStackTrace();
		} catch (Exception e) {
			// catches all other exceptions and prints

			e.printStackTrace();
		}
	}

}
