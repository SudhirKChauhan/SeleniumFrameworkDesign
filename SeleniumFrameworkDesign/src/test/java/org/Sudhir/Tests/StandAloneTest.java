package org.Sudhir.Tests;

import java.time.Duration;
import java.util.List;

import org.Sudhir.pageObjects.LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		//LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("sudhir.b.chauhan@Gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Practice1!");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-body")));
		List<WebElement>  products = driver.findElements(By.cssSelector(".card-body"));
						
		//Assign list of web element to stream then filter products by further diving down in web element hierarachy to get text and compare
	    // with Text of the product that needs to be added to cart to buy
		
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	   //Click the button of the product that has been selected in previous step
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector(".fa.fa-shopping-cart")).click();
		
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean cartItemPresent = cartItems.stream().anyMatch(cartItem->cartItem.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(cartItemPresent);
		//Click on Checkout button
		driver.findElement(By.cssSelector(".subtotal.cf.ng-star-inserted li button")).click();
		
		//Enter Country on payment screen
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder = \"Select Country\"]")), "United States").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item.list-group-item.ng-star-inserted:first-of-type")));
		driver.findElement(By.cssSelector(".ta-item.list-group-item.ng-star-inserted:first-of-type")).click();
		
		//Click Place Order Button
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		
		String orderStatus = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(orderStatus.equalsIgnoreCase("Thankyou for the order."));
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		
	}

}
