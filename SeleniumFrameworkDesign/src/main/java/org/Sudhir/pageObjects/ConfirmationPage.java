package org.Sudhir.pageObjects;

import org.Sudhir.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	
	}

	By orderStatusMessage = By.cssSelector(".hero-primary");
	
	public String getOrderStatus() {
		
		String orderStatus = driver.findElement(orderStatusMessage).getText();
		return orderStatus;
			
	}

}
