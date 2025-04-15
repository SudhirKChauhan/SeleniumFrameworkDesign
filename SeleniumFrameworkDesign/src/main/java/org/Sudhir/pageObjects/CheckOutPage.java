package org.Sudhir.pageObjects;

import org.Sudhir.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckOutPage extends AbstractComponent{
	
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(css = ".subtotal.cf.ng-star-inserted li button")
	WebElement checkOutButton;
	By country= By.cssSelector("input[placeholder = \"Select Country\"]");
	By selectCountry = By.cssSelector(".ta-item.list-group-item.ng-star-inserted:first-of-type");
	By submitButton = By.cssSelector(".btnn.action__submit.ng-star-inserted");
	
	
	
	public void goToCheckOutPage() {
		
		checkOutButton.click();
				
	}
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(country), countryName).build().perform();
		waitForElementToAppear(selectCountry);
		driver.findElement(selectCountry).click();
				
	}
	
	public ConfirmationPage submitOrder(){
		
		driver.findElement(submitButton).click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
		
		
	}

}
