package com.ebay.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebay.SelectABookInEbay;

import junit.framework.Assert;

public class AddBookToCart{

	WebDriver driver;
	SelectABookInEbay selectABookInEbay;
	
		@BeforeTest
		public void Initialize() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vina\\Drivers\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.ebay.com");
			driver.manage().window().maximize();
		}
		
		
		
		@Test
		public void AddABookToCart() throws InterruptedException {
			selectABookInEbay = new SelectABookInEbay(driver);
			
			selectABookInEbay.SelectBook();
			selectABookInEbay.ValidateBook();
			selectABookInEbay.addBookToCartAndValidate();
			
		}
		
		@AfterTest
		public void TearDown() {
			selectABookInEbay = new SelectABookInEbay(driver);
			selectABookInEbay.quitBrowser();
		}
			

}
