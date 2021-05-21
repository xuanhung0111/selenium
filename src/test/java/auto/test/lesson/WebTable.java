package auto.test.lesson;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String args[]) throws Exception {
		WebDriver wd;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();

		wd.get("http://demo.guru99.com/test/web-table-element.php");
		// No.of Columns
		List col = wd.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("No of cols are : " + col.size());
		// No.of rows
		List rows = wd.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("No of rows are : " + rows.size());

		WebElement baseTable = wd.findElement(By.tagName("table"));

		// To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
		String rowtext = tableRow.getText();
		System.out.println("Third row of table : " + rowtext);

		// to get 3rd row's 2nd column data
		WebElement cellIneed = tableRow.findElement(By.xpath("//td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed);

		// Get maxium value in column

		// No. of Columns
		double m = 0, r = 0;
		for (int i = 0; i < rows.size(); i++) {
			String max = wd.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[" + (i + 1) + "]/td[4]")).getText();
			double currentPrice = Double.parseDouble(max);
			if (currentPrice > r) {
				r = currentPrice;
			}
		}
		System.out.println(" FINALLY ---> Maximum current price is : " + r);
		}
}
