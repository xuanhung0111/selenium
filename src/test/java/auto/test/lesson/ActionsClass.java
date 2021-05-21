package auto.test.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class ActionsClass {
	public static void main(String args[]) throws Exception {
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		
		driver.manage().window().maximize();
		
		WebElement link_Home = driver.findElement(By.linkText("Home"));
//		WebElement td_Home = driver.findElement(By.xpath("//html/body/div" + "/table/tbody/tr/td" + "/table/tbody/tr/td"
//				+ "/table/tbody/tr/td" + "/table/tbody/tr"));
		
		WebElement td_Home = driver.findElement(By.xpath("//table[@align= 'center']//table[1]//tbody/tr[1]/td[1]"));
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(link_Home).build();

		String bgColor = td_Home.getCssValue("background-color");
		System.out.println("Before hover: " + bgColor);
		
		Thread.sleep(3000);
		
		mouseOverHome.perform();
		bgColor = td_Home.getCssValue("background-color");
		System.out.println("After hover: " + bgColor);
//		driver.quit();
	}
}
