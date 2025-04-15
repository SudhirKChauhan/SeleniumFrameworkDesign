package org.Sudhir.pageObjects;

import java.util.List;

import org.Sudhir.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	By cart = By.cssSelector(".fa.fa-shopping-cart");
	By productsInCart = By.cssSelector(".cartSection h3");
	
	public CartPage(WebDriver driver) {	
		
		super(driver);
		this.driver = driver;
				
	}
	
	
public void goToCart() {
		
		driver.findElement(cart).click();
	}
	public List<WebElement> getProductsFromCart() {
		
		List<WebElement> cartItems = driver.findElements(productsInCart);
		return cartItems;
		
	}
	
	public Boolean searchProductInCart(String productName) {
		
				
		Boolean cartItemPresent = getProductsFromCart().stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(productName));
		return cartItemPresent;
		
		
	}
	
	public CheckOutPage goToCheckout() {
		
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
		
		
	}
	
	
	
	
	
	

}
