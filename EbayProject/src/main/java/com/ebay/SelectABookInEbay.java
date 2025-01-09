package com.ebay;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class SelectABookInEbay{
	
	  WebDriver driver;
	  public SelectABookInEbay(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	  
	  @FindBy (id = "gh-ac" )
	  WebElement searchBox;
	  
	  @FindBy (id = "gh-btn" )
	  WebElement searchButton;
	  
	  @FindBy (xpath = "//*[@id=\"item5e3601ea76\"]/div/div[2]/a/div/span" )
	  WebElement bookName;
	  
	  @FindBy (xpath = "//*[@id=\"mainContent\"]/div/div[3]/div/div/div/span" )
	  WebElement prodPrice;
	  
	  @FindBy (id = "atcBtn_btn_1" )
	  WebElement addToCartBtn;
	  
	  @FindBy (xpath = "//*[@id=\"gh-minicart-hover\"]/div/a" )
	  WebElement cart;
	
	  
		public void SelectBook() {
			searchBox.sendKeys("Books");
			searchButton.click();
			bookName.click();
		}
		
		public void ValidateBook() throws InterruptedException {
			String mainPage = driver.getWindowHandle();
			System.out.println("Ebay main page Id is -- "+mainPage);
			Thread.sleep(3000);
			
			
			Set<String> allPages = driver.getWindowHandles();
			
			for(String page: allPages) {
				if(!page.equals(mainPage)) {
					driver.switchTo().window(page);
					break;
				}
				
		}
			String prodPriceText = prodPrice.getText();
			System.out.println("Product price is --"+prodPriceText);
		}
		
		
		
		public void addBookToCartAndValidate() {
			addToCartBtn.click();
			String cartText = cart.getText();
			System.out.println("Cart text is - "+cartText);
			
			Assert.assertEquals(false, cartText.contains("0"));
			
		}
		
		public void quitBrowser() {
			driver.quit();
		}
}
