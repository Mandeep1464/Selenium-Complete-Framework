package com.spotify.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.SnapShot;
import com.spotify.util.UtilClasses;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class SpotifyFooter {
	private WebDriver driver = null;
	private Props pr = new Props();
	private Properties prop = new Properties();
	private SnapShot takesnapshort = null;
	private List<WebElement> elements;

	public SpotifyFooter(WebDriver driver, SnapShot takesnapshort) {
		this.driver = driver;
		this.takesnapshort = takesnapshort;
	}

	public void handleFooter() {
		UtilClasses ut = new UtilClasses(driver);
		ut.setProps(prop, pr.SpotifyFooterLocaters);
		elements = ut.getWebElements(prop.getProperty("firstxpath"));
		Iterator<WebElement> iter = elements.iterator();
		ut.wait(5000);
		ut.scrollDown(4000);
		ut.wait(3000);
		Actions actions = new Actions(driver);
		while (iter.hasNext()) {
			WebElement element = iter.next();
			ut.wait(3000);
			actions.moveToElement(element).perform();
		}
		ut.click(prop.getProperty("about"));
		takesnapshort.takeScreenShort("Screen sort of First page of Screen");
		driver.navigate().back();
	}
}
