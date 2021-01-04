package com.spotify.testexcutation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotify.pages.*;
import com.spotify.util.*;

public class Final_test {
	private WebDriver driver = null;
	private SnapShot takesnapshort = null;

	@BeforeClass
	public void setProps() { 
		BrowserUtil browserUtil = new BrowserUtil();
		driver = browserUtil.getDriver("chrome");
		if (driver == null)
			System.exit(0);
		wait(5000);
		takesnapshort = new SnapShot(driver);
		takesnapshort.openWordFile("invaild path", null);
		takesnapshort.takeScreenShort("First Page");
	}

	@Test(priority = 1)
	public void runLogin() {
		Login login = new Login(driver, takesnapshort);
		login.doLogin();
		if (driver != null)
			System.out.println(driver);
	}

	@Test(priority = 2)
	public void runHeader() {
		SpotifyHeader header = new SpotifyHeader(driver, takesnapshort);
		header.headerOperation();
	}

	@Test(priority = 3)
	public void runAlbums() {
		Albums albums = new Albums(driver, takesnapshort);
		albums.actiononheader();
	}

	@Test(priority = 4)
	public void runFooter() {
		SpotifyAllClick footer = new SpotifyAllClick(driver, takesnapshort);
		footer.handleFooter();
	}

	@AfterClass
	public void closeBrowser() {
		wait(5000);
		takesnapshort.saveFile();
		driver.quit();
	}

	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {

		}
	}
}
