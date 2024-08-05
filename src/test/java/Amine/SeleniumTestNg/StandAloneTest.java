package Amine.SeleniumTestNg;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandAloneTest {
	
	static String email= "aminehamdi@gmail.com";
	static String password="22884412Ca";

	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		
		// login 
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
		
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		
		WebElement prod = products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals("IPHONE 13 PRO")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		
		
		
		
		
	
	}

}
