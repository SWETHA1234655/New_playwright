package testngProject;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class saucedemowebsite {
	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	@Test
	public void LaunchApp() {
		
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		WebElement title=driver.findElement(By.xpath("//div[@id=\"root\"]//div[@class=\"login_logo\"]"));
		String actual_url=title.getText();
		System.out.println(actual_url);
		String Exp_url=driver.getTitle();
		System.out.println(Exp_url);
		if(actual_url.equals(Exp_url)) {
			System.out.println("Logo displayed correctly");
		}
		else {
			System.out.println("Logo is not displayed");
		}
		
	}
	@Test(priority=1,dependsOnMethods={"LaunchApp"})
	public void LoginPage() {
		WebElement uname2=driver.findElement(By.id("user-name"));
		uname2.clear();
		uname2.sendKeys("standard_user");
		WebElement pwd2=driver.findElement(By.id("password"));
		pwd2.clear();
		pwd2.sendKeys("secret_sauce");
		WebElement loginBtn1=driver.findElement(By.name("login-button"));
		loginBtn1.click();
		System.out.println("Login Successfully");
	}
	@Test(priority=2,dependsOnMethods= {"LoginPage"})
	public void getProductDetails() {
		List<WebElement> AllProds=driver.findElements(By.xpath("//div[@id=\"inventory_container\" and @class=\"inventory_container\"]//div[@class=\"inventory_item\"]"));
		System.out.println(AllProds.size());
		for(WebElement ap:AllProds) {
			WebElement PName=ap.findElement(By.xpath(".//div[@class=\"inventory_item_name \"]"));
//			System.out.println("Product: "+PName.getText());
			String PriceValue=ap.findElement(By.xpath(".//div[@class=\"inventory_item_price\"]")).getText();
			String P=PriceValue.replace("$","");
			Double Price = Double.parseDouble(P);
//			System.out.println("Price: "+P);
			
			if(Price>=15.99) {
				System.out.println("Products name: "+PName.getText());
				WebElement ATC=driver.findElement(By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory \"]"));
				ATC.click();
				
			}
			
		}
	}
	@Test(priority=3)
	public void ATCButton() {
		WebElement ATCItems=driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]"));
		ATCItems.click();
		
		WebElement checkout=driver.findElement(By.id("checkout"));
		checkout.click();
	}
	@Test(priority=4)
	public void personalDetails() {
		WebElement fname=driver.findElement(By.id("first-name"));
		fname.sendKeys("Dummy");
		
		WebElement lname=driver.findElement(By.id("last-name"));
		lname.sendKeys("Dummy123");
		
		WebElement postalcode=driver.findElement(By.id("postal-code"));
		postalcode.sendKeys("GL4 012");
		
		WebElement ClickContinue=driver.findElement(By.id("continue"));
		ClickContinue.click();
	}
	@Test(priority=5)
	public void clickOnFinish() {
		WebElement clickFinish=driver.findElement(By.id("finish"));
		clickFinish.click();
	}
	@Test(priority=6)
	public void confirmMsg() {
		WebElement orderConfirmMsg=driver.findElement(By.xpath("//div[@id=\"checkout_complete_container\"]//h2"));
		wait.until(ExpectedConditions.visibilityOf(orderConfirmMsg));
		System.out.println("Confirmation Message: "+orderConfirmMsg.getText());
		
		WebElement BTH=driver.findElement(By.xpath("//button[@id=\"back-to-products\"]"));
		BTH.click();
		
		String BTDashboard=driver.findElement(By.xpath("//div[@class=\"header_secondary_container\"]//span")).getText();
		if(BTDashboard.equals("Products")) {
			System.out.println("Landing in Dashboard Again");
		}
		else {
			System.out.println("Not back to dashboard");
		}
	}
	@AfterTest
	public void closeApp() {
		driver.close();
	}

}
