package playwright_sample_code;

import java.nio.file.Paths;

import org.assertj.core.util.Arrays;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle.ScreenshotOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SecondTest {
	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		Browser b=pw.chromium().launch(
				new LaunchOptions().setHeadless(false));
		Page page=b.newPage();
		page.navigate("https://www.saucedemo.com/");
		System.out.println(page.title());
		
//		ScreenshotOptions sc=new ScreenshotOptions();
//		page.screenshot(sc.setPath(Paths.get("./screens/img.png")));
		

// IMPORTANT: Use Page.ScreenshotOptions (not ScreenshotOptions)
    page.screenshot(
        new Page.ScreenshotOptions().setFullPage(true)
            .setPath(Paths.get("screens/img1.png"))
    );
    

	 // Create the locator
	 Locator name = page.locator("#user-name");
	
	 // First screenshot of empty field
	 name.screenshot(new Locator.ScreenshotOptions()
	     .setPath(Paths.get("screens/img2.png")));
	
	 


		
		page.close();
		b.close();
		pw.close();
	}

}
