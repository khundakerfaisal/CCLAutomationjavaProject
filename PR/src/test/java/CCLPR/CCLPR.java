package CCLPR;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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
		 * 
		 * cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"
		 * )); 
		 */		
		/*
		 * // List<WebElement> dropdownOptions =
		 * driver.findElements(By.cssSelector("#ui-id-10")); // 
		 * for (WebElement option :dropdownOptions) { // 
		 * System.out.println(option.getText()); //
		 * option.click(); // 
		 * Thread.sleep(2000); // }
		 */		
		
		List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
		int count = dropdownOptions.size();
		System.out.println(count);
		dropdownOptions.get(count-3).click();
		
			/*
			 * // using Requisition date selection
			 */

		WebElement datePicker = driver.findElement(By.xpath("//input[@name='requisition_date']"));
		datePicker.click();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		WebElement dateTimeInput = driver.findElement(By.xpath("//input[@data-target='#datepicker137' or @id='o_field_input_106']")); // Replace with actual locator
		dateTimeInput.clear();
		dateTimeInput.sendKeys(formattedDateTime);
		Thread.sleep(2000);
		
		/*
		 * // using Requisition date selection
		 */
		

		
		
		WebElement prioritySelect = driver.findElement(By.xpath("//select[@name='priority']"));
		prioritySelect.click();
		Select select = new Select(prioritySelect);
		select.selectByVisibleText("High"); 
		Thread.sleep(2000);
		
		WebElement requirement_forSelect = driver.findElement(By.xpath("//select[@name='requirement_for']"));
		prioritySelect.click();
		Select requirement_forselectoptions = new Select(requirement_forSelect);
		requirement_forselectoptions.selectByVisibleText("Operation"); 
		Thread.sleep(2000);
		
		WebElement requisition_typeSelect = driver.findElement(By.xpath("//select[@name='requisition_type']"));
		prioritySelect.click();
		Select requisition_typeselectoptions = new Select(requisition_typeSelect);
		requisition_typeselectoptions.selectByVisibleText("Local"); 
		Thread.sleep(2000);
		
		WebElement purchase_typeSelect = driver.findElement(By.xpath("//select[@name='purchase_type']"));
		prioritySelect.click();
		Select purchase_typeselectoptions = new Select(purchase_typeSelect);
		purchase_typeselectoptions.selectByVisibleText("New Purchase"); 
		Thread.sleep(2000);

		
		WebElement approvebyselect = driver.findElement(By.xpath("//input[contains(@class,'o_input ui-autocomplete-input')]"));
		approvebyselect.click();
        
        WebElement approveoptionToSelect = driver.findElement(By.xpath("//a[contains(@class, 'dropdown-item-wrapper') and text()='Administrator']"));
        approveoptionToSelect.click();
		
		

      
      
		}

}
