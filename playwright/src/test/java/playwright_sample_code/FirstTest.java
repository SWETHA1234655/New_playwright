package playwright_sample_code;

import com.microsoft.playwright.Browser;


import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FirstTest {
	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		Browser b=pw.chromium().launch(
				new LaunchOptions().setHeadless(false));
		Page page=b.newPage();
		page.navigate("https://automationexercise.com/");
		String title1=page.locator("//title").textContent();
		System.out.println(title1);
		assertThat(page).hasTitle("Automation Exercise");
//		assertThat(page).hasTitle("Automation Exercise");
	    Locator login=page.locator("//a[text()=\" Signup / Login\"]");
//	    login.hover();
	    login.click();
	    String title2=page.title();
	    System.out.println(title2);
	    assertThat(page).hasTitle("Automation Exercise - Signup / Login");
		Locator name=page.getByPlaceholder("Name");
		name.type("a1hk11234");
		Locator email=page.locator("//form[@action='/signup']//input[@name='email']");
		email.type("khka33@gmail.com");
		page.click("//button[text()='Signup']");
		
		String title3=page.title();
		System.out.println(title3);
		assertThat(page).hasTitle("Automation Exercise - Signup");
		
		Locator sign=page.locator("//input[@id=\"id_gender1\"]");
		sign.check();
		assertThat(sign).isChecked();
		
		String storedName=page.locator("//input[@id=\"name\"]").inputValue();
		System.out.println(storedName);
		
		String storedEmail=page.locator("//input[@id=\"email\"]").inputValue();
		System.out.println(storedEmail);
		
		Locator day=page.locator("//select[@id='days']");
		day.selectOption("8");
		System.out.println(day.inputValue());
		assertThat(day.locator("option:checked")).hasText("8");
		
		Locator month=page.locator("//select[@id='months']");
//		month.click();
		month.selectOption(new SelectOption().setLabel("June"));
		String selectedMonth=month.inputValue();
		System.out.println(selectedMonth);
//		month.click();
		assertThat(month.locator("option:checked")).hasText("June");
		
		Locator year=page.locator("//select[@id='years']");
		year.selectOption(new SelectOption().setIndex(6));
		System.out.println(year.inputValue());
		assertThat(year.locator("option:checked")).hasText("2016");
		
		
		
	//	page.close();
	//	b.close();
	//	pw.close();
		
		
	}

}
