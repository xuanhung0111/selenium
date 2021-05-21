package auto.test.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessImageLinks {
	public static void main(String[] args) {
		String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		// click on the "Facebook" logo on the upper left portion
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a[title=\"Vào Trang chủ Facebook\"]")).click(); // by CSS Selector
		driver.findElement(By.xpath("//*[@id='blueBarDOMInspector']//*[@title='Vào Trang chủ Facebook']")).click(); // By Xpath

		// verify that we are now back on Facebook's homepage
		if (driver.getTitle().equals("Facebook - log in or sign up")) {
			System.out.println("We are back at Facebook's homepage");
		} else {
			System.out.println("We are NOT in Facebook's homepage");
		}
		driver.close();

	}
}
