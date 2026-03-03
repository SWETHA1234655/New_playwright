package sampleautomation;

import java.time.Duration;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div/i[@class='icon-bg homeIconsBg term-life bgnone']")).click();
		System.out.println("Title of the page : " +driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		Thread.sleep(2000);
		
		WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameAdd")));
		name.sendKeys("Vijay");
	
		WebElement dob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dob")));
		dob.sendKeys("11/02/2002");
		
		WebElement mobile= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileNo")));
		mobile.sendKeys("9001122333");
		
	//	driver.findElement(By.id("mobileNo")).sendKeys("90011223333");
	//	driver.findElement(By.xpath("//button[@name='submitButton']")).submit();
	//	driver.findElement(By.xpath("(//input[@name=\"gender\"])[2]")).click();
		
		
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement femaleRadio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//input[@name=\"gender\"])[2]"))));
		femaleRadio.click(); */
		

		
	}

}
