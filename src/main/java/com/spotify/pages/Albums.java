package com.spotify.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.SnapShot;
import com.spotify.util.UtilClasses;

public class Albums {

	private SnapShot takesnapshort = null;
	private Props pr = new Props();
	private Properties props = new Properties();
	private WebDriver driver;

	public Albums(WebDriver driver, SnapShot takesnapshort) {
		this.driver = driver;
		this.takesnapshort = takesnapshort;
	}

	public void actiononheader() {
		UtilClasses ut = new UtilClasses(driver);
		ut.wait(5000);

		driver.navigate().to(pr.siteurl);
		ut.setProps(props, pr.AlbumsLocaters);
		ut.scrollDown(1550);
		takesnapshort.takeScreenShort("Screen Short for the Albums");
		ut.wait(5000);

		ut.click(props.getProperty("Album"));
		ut.wait(2000);
		takesnapshort.takeScreenShort("Screen Short for the respective Album");
		driver.navigate().to(pr.siteurl);
		ut.scrollDown(1550);

		List<WebElement> elements = driver.findElements(By.xpath(props.getProperty("albumresults")));

		System.out.println("Number of elements:" + elements.size());
		
		ut.wait(2000);
		
		Iterator<WebElement> iter = elements.iterator();
		while (iter.hasNext()) {

			// Iterate one by one
			WebElement item = iter.next();
			ut.wait(800);

			if (!item.getAttribute("data-sr-id").contains("3")) {

				String string = "//li[@data-sr-id='" + item.getAttribute("data-sr-id") + "']";
				ut.hover(string);
				System.out.println(item.getAttribute("data-sr-id"));

			}
		}
	}
}