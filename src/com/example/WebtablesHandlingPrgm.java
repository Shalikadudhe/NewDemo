package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtablesHandlingPrgm {

     public static void main(String[] args) {
    	 System.setProperty("Webdriver.chrome.driver", "chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://demo.guru99.com/test/web-table-element.php");
    	
    List<WebElement> col=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
    	
    	System.out.println("number of cols :"+col.size());
    	
    List<WebElement> row=driver.findElements(By.xpath("//font[@class='green']"));
	System.out.println("number of rows :"+row.size());
    	
	
    	
	}

}
