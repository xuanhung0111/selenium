package auto.test.lesson;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
	public static void main(String args[]) throws Exception {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://demo.guru99.com/test/guru99home/");

		driver.manage().window().maximize();

		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println("********We are switch to the iframe*******:   " + size);
		
		List<WebElement> listEl = driver.findElements(By.tagName("iframe"));
		
		System.out.println("********List size*******:   " + listEl.size());
		
		for(int i =0; i < listEl.size(); i++) {
			
			System.out.println("********Frame name of " +  i + "*****" +  listEl.get(i).getAttribute("id"));
		}
		
	}
}
