package testngProject;

import org.openqa.selenium.*;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class automationExerciseWebsite {
	WebDriver driver=new ChromeDriver();
	Actions action=new Actions(driver);
	
	@BeforeTest
	public void openApp() {
		
		
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		WebElement Logo=driver.findElement(By.xpath("//img[@alt=\"Website for automation practice\"]"));
		if(Logo.isDisplayed()) {
			System.out.println("Home page is visible successfully");
		}
		else {
			System.out.println("Home page is not visible");
		}

	}
	@Test(priority=1)
	public void clickLogin() {
		WebElement loginBtn=driver.findElement(By.xpath("//li//a//i[@class=\"fa fa-lock\"]"));
		action.moveToElement(loginBtn).click().build().perform();
		Assert.assertTrue(true);
		System.out.println("Login/sign_in button clicked successfully");
	}
	@Test(priority=2)
	public void verifyNewUserSignup() {
		String NewuserSignup=driver.findElement(By.xpath("//div//h2[text()=\"New User Signup!\"]")).getText();
		Assert.assertEquals(NewuserSignup, "New User Signup!");
		WebElement enterName=driver.findElement(By.xpath("//form[@action=\"/signup\"]//input[@name=\"name\"]"));
		enterName.sendKeys("Dummy");
		WebElement enterEmail=driver.findElement(By.xpath("//form[@action=\"/signup\"]//input[@name=\"email\"]"));
		enterEmail.sendKeys("Dummy8@gmail.com");
		driver.findElement(By.xpath("//form[@action=\"/signup\"]//button[text()=\"Signup\"]")).click();
	}
	@Test(priority=3)
	public void AccInfoPage() {
		WebElement title=driver.findElement(By.xpath("//div[@class=\"radio\"]//input[@id=\"id_gender2\"]"));
		title.click();
		WebElement pwd=driver.findElement(By.id("password"));
		pwd.sendKeys("dummy12345");
		WebElement selDayField=driver.findElement(By.xpath("//select[@id=\"days\"]"));
		WebElement selMonthField=driver.findElement(By.xpath("//select[@id=\"months\"]"));
		WebElement selYearsField=driver.findElement(By.xpath("//select[@id=\"years\"]"));
		Select select1= new Select(selDayField);
		Select select2= new Select(selMonthField);
		Select select3= new Select(selYearsField);
		select1.selectByValue("15");
		select2.selectByVisibleText("August");
		select3.selectByIndex(20);
		WebElement TC=driver.findElement(By.xpath("//input[@type=\"checkbox\" and @id=\"newsletter\"]"));
		TC.click();
		WebElement enterFname=driver.findElement(By.xpath("//input[@id=\"first_name\"]"));
		enterFname.sendKeys("DummyC");
		WebElement enterLname=driver.findElement(By.xpath("//input[@id=\"last_name\"]"));
		enterLname.sendKeys("DummyXXX");
		WebElement enterAdd=driver.findElement(By.xpath("//input[@id=\"address1\"]"));
		enterAdd.sendKeys("Abc,Gandhi Streeet,Trichy");
		WebElement selCountryField=driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select selCountry= new Select(selCountryField);
		selCountry.selectByIndex(0);
		WebElement state=driver.findElement(By.xpath("//input[@id=\"state\"]"));
		state.sendKeys("TamilNadu");
		WebElement city=driver.findElement(By.xpath("//input[@id=\"city\"]"));
		city.sendKeys("Trichy");
		WebElement zipcode=driver.findElement(By.xpath("//input[@id=\"zipcode\"]"));
		zipcode.sendKeys("621203");
		WebElement mobileNo=driver.findElement(By.xpath("//input[@id=\"mobile_number\"]"));
		mobileNo.sendKeys("9876543202");
		WebElement clickonCreateAcc=driver.findElement(By.xpath("//button[@type=\"submit\" and text()=\"Create Account\"]"));
		clickonCreateAcc.click();
		
	}
	@Test(priority=4)
	public void verifyAccCreatedMsg() {
		WebElement AccCreatedMsg=driver.findElement(By.xpath("//div//h2//child::*"));
		WebElement fullMsg=driver.findElement(By.xpath("//div//p"));
		System.out.println("Success Message :"+AccCreatedMsg.getText()+" "+fullMsg.getText());
		WebElement clickOnCtn=driver.findElement(By.xpath("//a[text()=\"Continue\"]"));
		clickOnCtn.click();
	}
	@Test(priority=5)
	public void deleteAcc() {
		WebElement deleteAcc=driver.findElement(By.xpath("//a//i[@class=\"fa fa-trash-o\"]"));
		action.moveToElement(deleteAcc).click().build().perform();
		WebElement AccdeletedMsg=driver.findElement(By.xpath("//div//h2//child::*"));
		WebElement AccdeleteFullMsg=driver.findElement(By.xpath("//div//p"));
		System.out.println("Account Deleted Message :"+AccdeletedMsg.getText()+" "+AccdeleteFullMsg.getText());
		WebElement clickOnCtn1=driver.findElement(By.xpath("//a[text()=\"Continue\"]"));
		clickOnCtn1.click();
	}
	@Test(priority=6)
	public void verifyNavigateHomePage() {
		WebElement HomePage=driver.findElement(By.xpath("(//img[@alt=\"demo website for practice\"])[1]"));
		if(HomePage.isDisplayed()) {
			System.out.println("navigate back to homepage");
		}
		else {
			System.out.println("not navigate");
		}
	}
	
	@AfterTest
	public void closeApp() {
		driver.close();
	}

}
