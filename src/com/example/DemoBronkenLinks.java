package com.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBronkenLinks {
	public static void main(String[] args) {

		System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String homepage = "https://www.makeinjava.com";
		String url = "";
		int resCode = 200;
		HttpURLConnection huc = null;

		driver.get(homepage);

		List<WebElement> alllink = driver.findElements(By.tagName("a"));

		Iterator<WebElement> itr = alllink.iterator();
		while (itr.hasNext()) {
			url = itr.next().getAttribute("href");
			System.out.print(url + " : ");

			if (url == null || url.isEmpty()) {
				System.out.println(url +" url is not belongs to anchor tag..");
				continue;

			}
			if (!url.startsWith(homepage)) {
				System.out.println(url+" link is belongs to another domain , skipping it.");
				continue;

			}
			try {
				huc=(HttpURLConnection) new URL(url).openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				if(resCode>=400) {
					System.out.println(url+" Link is Broken");
					
				}else {
					System.out.println(url+ " Link is valid");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
  