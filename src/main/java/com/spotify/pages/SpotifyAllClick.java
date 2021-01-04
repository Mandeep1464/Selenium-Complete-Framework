package com.spotify.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.SnapShot;
import com.spotify.util.UtilClasses;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class SpotifyAllClick extends UtilClasses {
	private WebDriver driver = null;
	private Props pr = new Props();
	private Properties prop = new Properties();
	private SnapShot takesnapshort = null;
	public List<WebElement> elements;

	public SpotifyAllClick(WebDriver driver, SnapShot takesnapshort) {
		super(driver);
		this.driver = driver;
		this.takesnapshort = takesnapshort;
	}
	
	public void handleFooter() {
		setProps(prop, pr.SpotifyFooterLocaters);
		WebElement web;
		elements = driver.findElements(By.xpath(prop.getProperty("footerspotify")));
		Iterator<WebElement> iterator = elements.iterator();
		scrollDown(2000);
		while (iterator.hasNext()) {
			web = iterator.next();
			controlClick(web);
			wait(3000);
			handelTabSnapShot(takesnapshort, 2000);
		}

	}
}
