package seleniumTCs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_10 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		driver.findElement(By.id("susbscribe_email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("subscribe")).click();
	//	if("You have been successfully subscribed!".isDisplayed)
	}

}
