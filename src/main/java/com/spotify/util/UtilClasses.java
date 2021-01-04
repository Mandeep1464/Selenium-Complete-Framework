package com.spotify.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.spotify.EnvironmentConstant.Props;

public class UtilClasses {
	private WebDriver driver ;
	private Props props = new Props();
	
	public UtilClasses(WebDriver driver) {
		this.driver = driver;
		if(driver!=null)
			System.out.println("Util Driver");
	}

	public void setProps(Properties prop, String filepath) {
		try {
			FileInputStream stream = readProps(filepath);
			prop.load(stream);
		} catch (Exception e) {
			System.out.println("Exception in : setProperties()");
			e.printStackTrace();
		}
	}

	public FileInputStream readProps(String filepath) {
		try {
			return new FileInputStream(filepath);
		} catch (Exception e) {
			System.out.println("Exception in : readProperties()");
			e.printStackTrace();
		}
		return null;
	}

	public final void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public final void iwait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
	}
	
	public boolean controlClick(WebElement locater) {
		Actions actionProvider = new Actions(driver);
		Action keydown = actionProvider.keyDown(Keys.CONTROL).build();
		Action keyup = actionProvider.keyUp(Keys.CONTROL).build();

		try {
			keydown.perform();
			locater.click();
			keyup.perform();
			return true;
		} catch (Exception e) {
			System.out.println("Exception in click \t" + locater);
			e.printStackTrace();
		}
		return false;
	}
	
	

	public  List<WebElement> getWebElements(String xpath) {
		List<WebElement> data = null;
		int i = 0;
		while (data == null) {
			try {
				data = driver.findElements(By.xpath(xpath));
				
			} catch (Exception e) {
				System.out.println();
			}
			i++;
			if (i > 3)
				break;
			wait(500);
			System.out.println(i);
		}
		return data;// return first Row
	}
	public WebElement getWebElement(String xpath) {
		WebElement data = null;
		int i = 0;
		while (data == null) {
			try {
				data = driver.findElement(By.xpath(xpath));
				
			} catch (Exception e) {
				System.out.println();
			}
			i++;
			if (i > 5)
				break;
			wait(500);
			System.out.println(i);
		}
		return data;// return first Row
	}

	public void handelTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		wait(200);
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	public void handelTabSnapShot(SnapShot takesnapshort, int waitTime) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		wait(200);
		driver.switchTo().window(tabs.get(1));
		wait(waitTime);
		takesnapshort.takeScreenShort("");
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}

	public HashMap<String, String> getCredential(int rownumber) {
		ArrayList<HashMap<String, String>> data = GetRecords.read(props.credentialFile); // ReadLogin excel data
		HashMap<String, String> firstRow = data.get(rownumber); // get first Row from ArrayList as HashMap
		return firstRow;// return first Row
	}

	public boolean click(String locater) {
		try {
			driver.findElement(By.xpath(locater)).click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception in click \t" + locater);
			e.printStackTrace();
		}
		return false;
	}

	public boolean sendValue(String locater, String data) {
		try {
			driver.findElement(By.xpath(locater)).sendKeys(data);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in send Value \t" + locater);
			e.printStackTrace();
		}
		return false;
	}

	public boolean hover(String locater) {
		Actions ac = new Actions(driver);
		try {
			ac.moveToElement(driver.findElement(By.xpath(locater))).perform();
			return true;
		} catch (Exception e) {
			System.out.println("Exception in send Value \t" + locater);
			e.printStackTrace();
		}
		return false;
	}

	public boolean click(WebElement locater) {
		try {
			locater.click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception in click \t" + locater);
			e.printStackTrace();
		}
		return false;
	}


	public boolean sendValue(WebElement locater, String data) {
		try {
			locater.sendKeys(data);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in send Value \t" + locater);
			e.printStackTrace();
		}
		return false;
	}

	public boolean hover(WebElement locater) {
		Actions ac = new Actions(driver);
		try {
			ac.moveToElement(locater).perform();
			return true;
		} catch (Exception e) {
			System.out.println("Exception in send Value \t" + locater);
			e.printStackTrace();
		}
		return false;
	}

	public void scrollDown(int pixel) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0," + pixel + ")", "");
	}

	public void scrollTop() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,-1900)");

	}
}
