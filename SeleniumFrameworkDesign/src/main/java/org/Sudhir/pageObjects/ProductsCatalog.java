package org.Sudhir.pageObjects;

import java.util.List;

import org.Sudhir.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsCatalog extends AbstractComponent{

	WebDriver driver;
	
	public ProductsCatalog(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
			
	@FindBy(css = ".card-body")
	List<WebElement> products;
	
	@FindBy(css= ".ng-animating")
	WebElement spinner;
	
		
	By productBy = By.cssSelector(".card-body");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".toast-container");
	
	
	public List<WebElement> getProductsList() {
		
		
		waitForElementToAppear(productBy);
		return products;
		
				
	}
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProductsList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public CartPage addProductToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		CartPage cartPage = new CartPage(driver);
		return cartPage;
					
	}

	
}
