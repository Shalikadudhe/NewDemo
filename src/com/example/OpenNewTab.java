package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenNewTab {

	public static void main(String[] args) {

		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy()", 0, 1200);

		// it will open new TAB
		String clickon = Keys.chord(Keys.CONTROL, Keys.ENTER);

		driver.findElement(By.xpath("(//a[@class='nav-link fw-bold'])[4]")).sendKeys(clickon);

	}

}
