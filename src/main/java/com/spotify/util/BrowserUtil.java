package com.spotify.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.spotify.EnvironmentConstant.Props;

public class BrowserUtil {
	private Props pr = new Props();

	public WebDriver getDriver(String BrowserName) {
		WebDriver driver = null;
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", pr.googleDriver);
			driver = new ChromeDriver();
		} else if (BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", pr.firefoxDriver);
//			driver = new FirefoxDriver();
		} else if (BrowserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", pr.eageDriver);
			driver = new EdgeDriver();
		} else {
			System.out.println("Options :\"" + BrowserName + "\" Dose not exist");
		}
		driver.manage().window().maximize();
		driver.navigate().to(pr.siteurl);
		return driver;
	}
}
