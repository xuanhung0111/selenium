package auto.test.lesson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dinamic2WebTable {

	public static void main(String args[]) {
		WebDriver wd;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://demo.guru99.com/test/table.html");

		// To locate table.
		WebElement mytable = wd.findElement(By.xpath("/html/body/table/tbody"));
		// To locate rows of table.
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));

		// To calculate no of rows In table.
		int rows_count = rows_table.size();

		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			// To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);

			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {

				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();
				System.out
						.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
			}
			System.out.println("-------------------------------------------------- ");
		}
	}

	public List<String> getColumnTableName(WebDriver wd, String tableEl, String tableName) {
		System.out.println("Get Column Table Name of : " + tableName);
		List<String> columnName = new ArrayList<String>();
		List<WebElement> col = wd.findElements(By.xpath(tableEl + "//thead/tr/th/div"));
		for (int i = 0; i < col.size(); i++) {
			columnName.add(col.get(i).getText());
		}
		return columnName;
	}

	public List<Map<String, String>> getItemsTable(WebDriver wd, String tableEl, String tableName) {
		// Return List of Dict: key _ value inside the table
		List<Map<String, String>> listHashUser = new ArrayList<Map<String, String>>();
		try {
			System.out.println("Get Items in Table: " + tableName);
			List<String> columnName = getColumnTableName(wd, tableEl, tableName);

			WebElement data = wd.findElement(By.xpath(tableEl + "//tbody"));
			List<WebElement> rows_table = data.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();
			for (int row = 0; row < rows_count; row++) {
				Map<String, String> hashTable = new HashMap<String, String>();
				List<WebElement> columnsRow = rows_table.get(row).findElements(By.tagName("td"));
				ListIterator<String> iteratorColumn = columnName.listIterator();
				while (iteratorColumn.hasNext()) {
					String keyValue = iteratorColumn.next().replaceFirst(".$", "");
					int index = iteratorColumn.nextIndex();
					String value = columnsRow.get(index - 1).getText();
					hashTable.put(keyValue, value);
				}
				listHashUser.add(hashTable);
			}
			return listHashUser;
		} catch (Exception e) {
			return listHashUser;
		}
	}

	// Overridden method above
	public List<Map<String, WebElement>> getItemsTable(WebDriver wd, String tableEl, String tableName, boolean isHref) {
		// Return List of Dict: key _ WebElement inside the table
		List<Map<String, WebElement>> listHashUser = new ArrayList<Map<String, WebElement>>();

		if (isHref == true) {
			try {
				System.out.println("Get Items in Table: " + tableName);
				List<String> columnName = getColumnTableName(wd, tableEl, tableName);

				WebElement data = wd.findElement(By.xpath(tableEl + "//tbody"));

				List<WebElement> rows_table = data.findElements(By.tagName("tr"));
				int rows_count = rows_table.size();
				for (int row = 0; row < rows_count; row++) {
					Map<String, WebElement> hashTable = new HashMap<String, WebElement>();

					List<WebElement> columnsRow = rows_table.get(row).findElements(By.tagName("td"));
					ListIterator<String> iteratorColumn = columnName.listIterator();
					while (iteratorColumn.hasNext()) {
						String keyValue = iteratorColumn.next().replaceFirst(".$", "");
						int index = iteratorColumn.nextIndex();
						WebElement value = columnsRow.get(index - 1).findElement(By.className("table-cell"));
						hashTable.put(keyValue, value);
					}
					listHashUser.add(hashTable);
				}
			} catch (Exception e) {
				return listHashUser;
			}
		}
		return listHashUser;
	}

	public Map<String, String> getDictData(List<WebElement> el) {
		System.out.println("Size element is " + el.size());
		String orderKey = null;
		String orderValue = null;
		int count = 0;
		System.out.println("Push value into Key of Dict");
		Map<String, String> dataDict = new HashMap<String, String>();
		for (int i = 0; i < el.size(); i++) {
			count++;
			if (i % 2 == 0) {
				orderKey = el.get(i).getText();
				if (i == 14) {
					orderKey = "FlatformCode";
				}
			} else {
				orderValue = el.get(i).getText();
			}
			if (count % 2 == 0) {
				dataDict.put(orderKey, orderValue);
			}
		}
		return dataDict;
	}

}