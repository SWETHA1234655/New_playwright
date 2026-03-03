package seleniumTCs;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.*;

public class TestCase_8 {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		String homePage_Expected=driver.getTitle();
		String homePage_Actual="Automation Exercise";
		if(homePage_Expected.equals(homePage_Actual))
			System.out.println("Home page is visible successfully");
		else
			System.out.println("Home page is not visible");
		
		WebElement clickBtn=driver.findElement(By.xpath("//div[@class=\"shop-menu pull-right\"]//li//a[text()=\" Products\"]"));
		clickBtn.click();
		WebElement NavigateTproductsPage=driver.findElement(By.xpath("//h2[text()=\"All Products\"]"));
		
		if(NavigateTproductsPage.isDisplayed()) {
			System.out.println("Page is successfully navigated");
		}
		else {
			System.out.println("Page is not yet navigate");
		}
		
		WebElement productList=driver.findElement(By.xpath("//div[@class=\"features_items\"]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		if(productList.isDisplayed()) {
			System.out.println("Product list is visible");
		}
		else {
			System.out.println("Product list is not visible");
		}
		
		WebElement viewProduct=driver.findElement(By.xpath("//a[@href=\"/product_details/5\"]"));
		viewProduct.click();
		WebElement verifyViewProductPage=driver.findElement(By.xpath("//div[@class=\"view-product\"]//img[@alt=\"ecommerce website products\"]"));
		if(verifyViewProductPage.isDisplayed()) {
			System.out.println("User is landed to product detail page");
		}
		else {
			System.out.println("User is not landed to product detail page");
		}
		
		WebElement productName=driver.findElement(By.xpath("//div[@class=\"product-information\"]//h2"));
		System.out.println(productName.getText());
		
		WebElement productCatagory=driver.findElement(By.xpath("//div[@class=\"product-information\"]//p"));
		System.out.println(productCatagory.getText());
		
		WebElement Price=driver.findElement(By.xpath("//div[@class=\"product-information\"]//span//span"));
		System.out.println(Price.getText());
		
		WebElement Availability=driver.findElement(By.xpath("//div[@class=\"product-information\"]//p[2]"));
		System.out.println(Availability.getText());
		
		WebElement Condition=driver.findElement(By.xpath("//div[@class=\"product-information\"]//p[3]"));
		System.out.println(Condition.getText());
		
		WebElement Brand=driver.findElement(By.xpath("//div[@class=\"product-information\"]//p[4]"));
		System.out.println(Brand.getText());
		
		//Test case_9
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,-500);");
		
		WebElement searchElement=driver.findElement(By.id("search_product"));
		searchElement.sendKeys("Tshirt");
		
		WebElement searchBtn=driver.findElement(By.id("submit_search"));
		searchBtn.click();
		js.executeScript("window.scrollBy(0,500);");
		
		String Search_Expected=driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).getText();
		System.out.println(Search_Expected);
		
		if(Search_Expected.equals("SEARCHED PRODUCTS")) {
			System.out.println("SEARCHED PRODUCTS' is visible");
		}
		else {
			System.out.println("SEARCHED PRODUCTS' is not visible");
		}
		
		List<WebElement> searchedProducts=driver.findElements(By.xpath("//div[@class=\"product-image-wrapper\"]"));
		System.out.println(searchedProducts.size());
			
		for(WebElement title:searchedProducts) {
			String productType=title.findElement(By.xpath(".//p")).getText();
			String pt=productType.replace("-", "");
			System.out.println("Products Name :"+pt);
			if(pt.contains("TShirt") || pt.contains("Tshirt") || pt.contains("T Shirt") || pt.contains("T SHIRT"))
				System.out.println("Searched By correct products");
			else
				System.out.println("Searched By wrong products");
				
		}
		
	//	driver.close();
		
	}

}
