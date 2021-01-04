package com.spotify.pages;

import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.spotify.EnvironmentConstant.Props;
import com.spotify.util.SnapShot;
import com.spotify.util.UtilClasses;

public class Login {
	private WebDriver driver;
	private Props pr = new Props();
	Properties props = new Properties();
	SnapShot takesnapshort = null;

	public Login(WebDriver driver, SnapShot takesnapshort) {
		this.takesnapshort = takesnapshort;
		this.driver = driver;
	}

	public void doLogin() {
		UtilClasses ut = new UtilClasses(driver);
		try {
			HashMap<String, String> details = ut.getCredential(0);
			ut.setProps(props, pr.loginlocater);
			ut.wait(500);
			ut.click(props.getProperty("loginlink"));
			takesnapshort.takeScreenShort("First Page Before Login");
			ut.iwait(5000);
			ut.sendValue(props.getProperty("usertextbox"), details.get("userid"));
			ut.sendValue(props.getProperty("password"), details.get("password"));
			takesnapshort.takeScreenShort("Before UserID and Password Inserted");
			ut.wait(1000);
			ut.click(props.getProperty("loginbutton"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}
}
