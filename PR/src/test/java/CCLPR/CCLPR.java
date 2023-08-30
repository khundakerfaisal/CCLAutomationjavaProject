package CCLPR;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.Select;

public class CCLPR {

	public static void main(String[] args) throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		ChromeOptions Option=new ChromeOptions();
		Option.addArguments("--remote-allow-origins=*");
		driver.get("http://10.10.14.196:9091/web/login");
		driver.findElement(By.name("login")).sendKeys("Test_data_migration");
		driver.findElement(By.name("password")).sendKeys("@testdata1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@title='Home Menu']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-menu-xmlid='purchase.menu_purchase_root']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='o_field_input_105']")).click();
		Thread.sleep(2000);
		
		/* using list of dropdown selection for Dropdown budget cost head
		 * // List<WebElement> dropdownOptions = driver.findElements(By.
		 * cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"
		 * )); // WebElement optionToSelect = dropdownOptions.get(0);
		 */		
		List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("#ui-id-10"));
		for (WebElement option : dropdownOptions) {
			System.out.println(option.getText());
			option.click();
			Thread.sleep(2000);
			}
		
			/*
			 * // using Requisition date selection
			 */
//		String desiredDate = "08/15/2023";
		WebElement datePicker = driver.findElement(By.xpath("//input[@data-target='#datepicker137' or @id='o_field_input_106']"));
		datePicker.click();
//		String[] parts = desiredDate.split("/");
//		String month = parts[0];
//		String day = parts[1];
//		String year = parts[2];
//		
//
//		// Locate the cell corresponding to the desired date and click it
////		WebElement dateCell = datePicker.findElement(By.xpath("//td[@data-year='" + year + "'][@data-month='" + month + "']/a[text()='" + day + "']"));
//		WebElement dateCell = datePicker.findElement(By.xpath("//td[text()='\" + day + \"'][@data-month='\" + month + \"']/a[@data-year='\" + year + \"']"));
//
//		dateCell.click();
      
      
		}

}
