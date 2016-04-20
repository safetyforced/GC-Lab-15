package appPackage;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	public static void addCountry() {
		
		Path countriesPath = Paths.get("countries.txt");
		File countriesFile = countriesPath.toFile();
		System.out.print("Enter a country name: ");
		String userCountry = "Canada";

		try {
			userCountry = validator.getValidString("[a-z A-Z]+", 30);
		} catch (Exception e) {
			// catches all exceptions and prints

			e.printStackTrace();
		}

		try {
			FileReader read = new FileReader(countriesFile);
			BufferedReader in = new BufferedReader(read);
			String line = in.readLine();
			FileWriter out = new FileWriter(countriesFile);
			while (line != null) {
				if (!line.equals("")) {
					out.append(line + "\n");
					line = in.readLine(); // read another line
				} else {
					break;
				}
			}
			out.append(userCountry);
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
			while (line != null)  {
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
		
	}
}
