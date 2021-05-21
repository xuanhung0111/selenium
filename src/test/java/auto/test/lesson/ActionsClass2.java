package auto.test.lesson;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass2 {
	public static void main(String args[]) {

		String baseUrl = "http://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(txtUsername)
										.click().keyDown(txtUsername, Keys.SHIFT) // This will type hello in the uppercase
										.sendKeys(txtUsername, "hello")
										.keyUp(txtUsername, Keys.SHIFT)
										.doubleClick(txtUsername) // This will highlight the text "HELLO"
										.contextClick()           // This will bring up the context menu
										.build();                 // Close the series with the build() method

		seriesOfActions.perform();

	}

}
