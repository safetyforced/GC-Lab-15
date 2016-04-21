package appPackage;

public class Country {

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

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getGDP() {
		return GDP;
	}

	public void setGDP(int gDP) {
		GDP = gDP;
	}
	
	
}
