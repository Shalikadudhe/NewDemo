package com.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoOptions {

	public static void getlinktextvaluebyusingCss() throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/about/about_privacy.htm");

		WebElement str = driver.findElement(By.cssSelector("a[href*='about_privacy']"));
		String element = str.getText();
		System.out.println("element is : " + element);
		Thread.sleep(3000);

		/// we cant click bcoz 2v more values are intercepted so use xpath
		/// str.click();

		driver.close();
	}

	public static void googleSearch() {

		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(op);

		driver.navigate().to("https://www.google.com/");

		// identify element
		WebElement p = driver.findElement(By.name("q"));
		// enter text with sendKeys() then apply submit()
		p.sendKeys("Selenium Java");
		// Explicit wait condition for search results

		System.out.println("clicked on No Thanks.....");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(5));
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
		p.submit();
		driver.close();

	}

	public static void numberOflinks() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makeinjava.com");

		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		int count = alllinks.size();
		System.out.println("links present is :" + count);

		for (WebElement link : alllinks) {

			System.out.println("link is : " + link.getText());
		}

		driver.close();
	}

	public static void findBrokenlinks() {
		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String homepage = "http://www.zlti.com";
		String url = "";
		HttpURLConnection huc = null;
		int resCode = 200;
		driver.get(homepage);

		driver.manage().window().maximize();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		Iterator<WebElement> link = allLinks.iterator();

		while (link.hasNext()) {
			url = link.next().getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;

			}

			if (!url.startsWith(homepage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {

				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				resCode = huc.getResponseCode();

				if (resCode >= 400) {

					System.out.println(url + " broken link.");
				} else {
					System.out.println(url + " Valid link.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) throws InterruptedException {
		// getlinktextvaluebyusingCss();

		// googleSearch();
		// numberOflinks();
		findBrokenlinks();
	}

}
