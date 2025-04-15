package org.Sudhir.Tests;
import java.io.IOException;
import org.Sudhir.TestComponents.BaseTest;
import org.Sudhir.pageObjects.CartPage;
import org.Sudhir.pageObjects.CheckOutPage;
import org.Sudhir.pageObjects.ConfirmationPage;
import org.Sudhir.pageObjects.LandingPage;
import org.Sudhir.pageObjects.ProductsCatalog;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SubmitOrderTest extends BaseTest{
	
	
	@Test
	public void SubmitOrder() throws IOException {
		
		String productName = "ZARA COAT 3";
		String userName = "sudhir.b.chauhan@Gmail.com";
		String password = "Practice1!";
		ProductsCatalog productsCatalog = landingPage.loginToApplication(userName, password);
		landingPage.loginToApplication(userName,password);
		productsCatalog.waitForElementToAppear(By.cssSelector(".card-body"));
		CartPage cartPage = productsCatalog.addProductToCart(productName);;		
		cartPage.goToCart();
		Boolean cartItemPresent = cartPage.searchProductInCart(productName);
		Assert.assertTrue(cartItemPresent);
		CheckOutPage checkOutPage = cartPage.goToCheckout();
		checkOutPage.goToCheckOutPage();
		checkOutPage.selectCountry("United States");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		Assert.assertTrue(confirmationPage.getOrderStatus().equalsIgnoreCase("Thankyou for the order."));
		
		
	}

}
