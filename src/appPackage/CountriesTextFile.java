package appPackage;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	static String userCountry = "error";
	static String userLanguage = "error";
	static int userGDP = -1;
	
	public static Country addCountry() {

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
		Path countriesPath = Paths.get("countries.txt");
		File countriesFile = countriesPath.toFile();

		try {
			FileReader r = new FileReader(countriesFile);
			BufferedReader in = new BufferedReader(r);
			String line = in.readLine();
			while (line != null) {
				if (!line.equals(""))
					System.out.println(line);
				line = in.readLine();
			}
			in.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteCountry() {
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
			// catches file not found exception and prints

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
