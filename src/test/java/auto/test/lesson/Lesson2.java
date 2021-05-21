package auto.test.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2 {

	public static void main(String args[]) throws Exception {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();

		// navigates to the page consisting an iframe
		
		driver.get("http://demo.guru99.com/test/guru99home/");

		driver.manage().window().maximize();

		driver.switchTo().frame("a077aa5e"); // switching the frame by ID

		driver.findElement(By.xpath("html/body/a/img")).click(); // Clicks the iframe

//		driver.switchTo().defaultContent(); // Switching back main page
		driver.switchTo().parentFrame();

		driver.findElement(By.id("philadelphia-field-email")).sendKeys("xuanhung0111@gmail.com");

		System.out.println("********We are switch to the iframe*******");

		System.out.println("*********We are done***************");
		
		Thread.sleep(3000);

	}

}
