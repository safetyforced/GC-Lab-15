package appPackage;

public class Country {  //Country object contains the country name, primary language, and GDP

	private String name;
	private String language;
	private int GDP;
	
	public Country () {
		name = "error";
		language = "error";
		GDP = -1;
	}
	
	public Country (String name, String language, int GDP) {
		this.name = name;
		this.language = language;
		this.GDP = GDP;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public int getGDP() {
		return GDP;
	}
	
}
