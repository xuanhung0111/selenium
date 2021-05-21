package auto.test.lesson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchNewWindow {
	public static void main(String args[]) throws Exception {

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		driver = new ChromeDriver();

		// Launching the site.
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

		String MainWindow = driver.getWindowHandle();

		System.out.println("String of Main Window: " + MainWindow);

		ArrayList tabs = new ArrayList(driver.getWindowHandles());

//		System.out.println("How many tabs window in the Browser: " + tabs.size());
		// Use the list of window handles to switch between windows
		 driver.switchTo().window((String) tabs.get(2));

		System.out.println("**** We are done on Children window***");

		// To handle all new opened window.
//		Set<String> s1 = driver.getWindowHandles();
//		Iterator<String> i1 = s1.iterator();
//
//		while (i1.hasNext()) {
//			String ChildWindow = i1.next();
//			System.out.println("Windown handle : -------------" + ChildWindow);
//			driver.switchTo().window(ChildWindow);
//		}
		// (ea082db3280dd6843ebfb08a625e3eb905c4f5ab
		
		// Windown handle : -------------CDwindow-15F619724E1B32B259BF53E92CE80F99
		// Windown handle : -------------CDwindow-F81C314E2CAAFF268E686C670B8EB4C0
		// Windown handle : -------------CDwindow-90E1C3EDA3B80E78B121CA0EF2C6501D
		
		// if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
		//
		// // Switching to Child window
		// driver.switchTo().window(ChildWindow);
		
		//
		// // Closing the Child Window.
		// driver.close();
		// }
		// }
		// Switching to Parent window i.e Main Window.

		
		
		driver.findElement(By.name("emailid")).sendKeys("xuanhung0111@gmail.com");
		
		driver.findElement(By.name("btnLogin")).click();
		driver.close();

		
		driver.switchTo().window(MainWindow);
		driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[6]/a")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul/li[8]/a")).click();
		Thread.sleep(3000);
		System.out.println("**** We are done on Main Window***");
	}
}
