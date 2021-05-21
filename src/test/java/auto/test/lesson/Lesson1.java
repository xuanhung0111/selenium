package auto.test.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Lesson1 {

	public static void main(String args[]) throws Exception {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();

		// navigates to the page consisting an iframe
		driver.get("http://demo.guru99.com/test/guru99home/");

		driver.manage().window().maximize();
		
		driver.switchTo().frame("a077aa5e"); // switching the frame by ID

		System.out.println("********We are switch to the iframe*******");
		
 		driver.findElement(By.xpath("html/body/a/img")).click();
 		
		    //Clicks the iframe
   
			System.out.println("*********We are done***************");
			Thread.sleep(3000);
		}
		// Scroll to view element
		//
		// WebElement element = driver.findElement(By.id("xuanhung"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// Thread.sleep(500);

		// WebElement el2 = driver.findElement(By.id("my-id"));
		// Actions actions = new Actions(driver);
		// actions.moveToElement(el2);
		// actions.perform();


}
