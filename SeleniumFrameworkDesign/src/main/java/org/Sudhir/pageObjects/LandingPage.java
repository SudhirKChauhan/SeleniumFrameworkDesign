package org.Sudhir.pageObjects;

import org.Sudhir.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
			
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	public ProductsCatalog loginToApplication(String username, String password) {
		
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		submit.click();
		ProductsCatalog productsCatalog = new ProductsCatalog(driver);
		return productsCatalog;
		
		
		
		
		
		
		
				
	}
	
	
	
	
	
			
	
}
