package com.spotify.EnvironmentConstant;

public class Props {
	// *******WebSite Name*******
	public final String siteurl = "https://www.spotify.com/in/";
	// *******
	public final String projectLocation = System.getProperty("user.dir");
	// *******Excel file*******
	
	public final String credentialFile = projectLocation + "\\src\\main\\java\\com\\spotify\\resources\\logincredentials.xlsx";
	// *******Properties files*******
	public final String loginlocater = projectLocation + "\\src\\main\\java\\com\\spotify\\resources\\LoginLocaters.properties";

	public final String AlbumsLocaters = projectLocation + "\\src\\main\\java\\com\\spotify\\resources\\AlbumsLocaters.properties";
	public final String headerLocators = projectLocation + "\\src\\main\\java\\com\\spotify\\resources\\headerLocators.properties";
	
	
	public final String SpotifyFooterLocaters = projectLocation + "\\src\\main\\java\\com\\spotify\\resources\\SpotifyFooterLocaters.properties";
	// *******Driver Locations*******
	public final String googleDriver = projectLocation + "\\Driver\\chromedriver.exe";
	public final String firefoxDriver = projectLocation + "\\Driver\\geckodriver.exe";
	public final String eageDriver = projectLocation + "\\Driver\\msedgedriver.exe";
}
