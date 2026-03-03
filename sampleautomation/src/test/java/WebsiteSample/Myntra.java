package WebsiteSample;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		
		System.out.println("Title : "+driver.getTitle());
		
		WebElement logo=driver.findElement(By.xpath("//a[@href=\"/\"]"));
		if(logo.isDisplayed()) {
			System.out.println("Myntra logo is displayed");
		
		}
		else {
			System.out.println("myntra logo is not displayed");
		}
		
		WebElement clickMen=driver.findElement(By.xpath("//nav[@class=\"desktop-navbar\"]//a[@href=\"/shop/men\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(clickMen).perform();
		
		Thread.sleep(2000);
		WebElement clickBottomwear=driver.findElement(By.xpath("//a[starts-with(text(),\"Bottomwear\")]"));
		act.moveToElement(clickBottomwear).perform();
		
		Thread.sleep(2000);
		WebElement clickFormal=driver.findElement(By.xpath("//li//a[starts-with(text(),\"Formal Trousers\")]"));
		//act.moveToElement(clickFormal).perform();
		clickFormal.click();
		
	}

}
