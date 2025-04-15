package org.Sudhir.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.Sudhir.pageObjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	
	public WebDriver initializeDriver() throws IOException {
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Sudhi\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\org\\Sudhir\\resources\\GlobalData.properties");
		System.out.println(System.getProperty("usr.dir")+
				"\\src\\main\\java\\org\\Sudhir\\resources\\GlobalData.properties)");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			WebDriverManager.edgedriver().setup();
						
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	
	@BeforeTest
	public LandingPage launchApplication() throws IOException {
		
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	@AfterTest
	public void closeApplication() {
		
		driver.quit();
	}
	
}
