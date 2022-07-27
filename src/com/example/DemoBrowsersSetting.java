package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DemoBrowsersSetting {
	public static void main(String[] args) {
		
		
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		
	///	DesiredCapabilities cap=DesiredCapabilities.class;
	//	cap.setBrowserName("Chrome");
		
		ChromeOptions op=new ChromeOptions();
		// for maximize the screen
		op.addArguments("starts-maximised");
		// for not showing website is being automated 
		op.addArguments("disable-infobars");
//		op.merge(cap);
		
		WebDriver driver=new ChromeDriver(op);
		driver.get("https://www.amazon.in");
	}

}
