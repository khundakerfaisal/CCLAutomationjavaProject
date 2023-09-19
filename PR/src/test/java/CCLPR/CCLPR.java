package CCLPR;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.support.ui.Select;

public class CCLPR {

	public static void main(String[] args) throws InterruptedException {

//		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions Option = new ChromeOptions();
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

		driver.findElement(By.xpath("//input[@id='o_field_input_106']")).click();
		Thread.sleep(2000);

		/*
		 * using list of dropdown selection for Dropdown budget cost head
		 * 
		 * cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"
		 * ));
		 */
		/*
		 * // List<WebElement> dropdownOptions =
		 * driver.findElements(By.cssSelector("#ui-id-10")); // for (WebElement option
		 * :dropdownOptions) { // System.out.println(option.getText()); //
		 * option.click(); // Thread.sleep(2000); // }
		 */

		List<WebElement> dropdownOptions = driver
				.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
		int count = dropdownOptions.size();
		System.out.println(count);
		dropdownOptions.get(count - 3).click();

		/*
		 * // using Requisition date selection
		 */

		WebElement datePicker = driver.findElement(By.xpath("//input[@name='requisition_date']"));
		datePicker.click();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		WebElement dateTimeInput = driver
				.findElement(By.xpath("//input[@data-target='#datepicker137' or @id='o_field_input_107']")); // Replace
																												// with
																												// actual
																												// locator
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

		// Selection Approved by option 
		WebElement approvebyselect = driver.findElement(By.cssSelector("#o_field_input_109"));
		approvebyselect.click();
		Thread.sleep(2000);
		// Locate the specific option you want to click by its text
		String optionText = "Administrator"; // Replace with the option you want to select
		WebElement optionToSelect = approvebyselect.findElement(By.xpath("//a[text()='" + optionText + "']"));

		// Click on the option
		optionToSelect.click();
		
		WebElement lineSelection= driver.findElement(By.xpath("//a[text()='Add a line']"));
		lineSelection.click();
		Thread.sleep(2000);
		
		WebElement dropdownElementProduct = driver.findElement(By.xpath("//td[@name='product_id']"));
		dropdownElementProduct.click();
		Thread.sleep(2000);
		
		 WebElement itemToSelect = driver.findElement(By.xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]"));
	     itemToSelect.click();
	     Thread.sleep(2000);
	     
	     WebElement prQty = driver.findElement(By.xpath("//input[@name='product_qty']"));
	     prQty.clear();
         prQty.sendKeys("5.000");
         Thread.sleep(2000);
         
         //Invisible Modal comming for this reason it is need to close [Windows Modal OK button pressed]
        
        WebElement okButton = driver.findElement(By.xpath("//button[text()='Ok']"));
        // Click the "Ok" button
        okButton.click();

		/*
		 * //Second line Product add purpose WebElement lineSelection2=
		 * driver.findElement(By.xpath("//a[text()='Add a line']"));
		 * lineSelection2.click(); Thread.sleep(2000);
		 * 
		 * 
		 * //Second Product selection WebElement dropdownElementProduct2 =
		 * driver.findElement(By.xpath("//td[@name='product_id']"));
		 * dropdownElementProduct2.click(); Thread.sleep(2000);
		 * 
		 * //Second Product item final selection
		 * 
		 * WebElement item2ToSelect = driver.findElement(By.
		 * xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]"));
		 * item2ToSelect.click(); Thread.sleep(3000); // WebElement item2ToSelect =
		 * driver.findElement(By.
		 * xpath("//a[contains(text(), '04 Way Switch - (9137503800)')]")); //
		 * item2ToSelect.click(); // Thread.sleep(2000);
		 * 
		 * 
		 * 
		 * 
		 * WebElement prQty2 =
		 * driver.findElement(By.xpath("//input[@name='product_qty']")); prQty2.clear();
		 * prQty2.sendKeys("4");
		 * 
		 * Thread.sleep(2000);
		 * 
		 * //Invisible Modal comming for this reason it is need to close [Windows Modal
		 * OK button pressed]
		 * 
		 * WebElement okButton2 = driver.findElement(By.xpath("//button[text()='Ok']"));
		 * // Click the "Ok" button okButton2.click(); Thread.sleep(2000);
		 */
       //Pr Save button Pressed
       WebElement prSubmit = driver.findElement(By.xpath("//button[@title='Save record']"));
       prSubmit.click();
       Thread.sleep(3000);
       
     //Pr Hod Approval button Pressed
       WebElement PrHodApproval = driver.findElement(By.xpath("//button[@name='button_hod_approve']"));
       PrHodApproval.click();
       Thread.sleep(3000);
       
       //Pr pm Approval button Pressed
       WebElement PrPmApproval = driver.findElement(By.xpath("//button[@name='button_pm_approve']"));
       PrPmApproval.click();
       Thread.sleep(3000);
       
       //Pr pm Ops Approval button Pressed
       WebElement PrPmOpsApproval = driver.findElement(By.xpath("//button[@name='button_pm_ops_approve']"));
       PrPmOpsApproval.click();
       Thread.sleep(3000);
       
       //Pr SCM Approval button Pressed
       WebElement PrScmApproval = driver.findElement(By.xpath("//button[@name='button_scm_approve']"));
       PrScmApproval.click();
       Thread.sleep(3000);
       
       
       //Pr COO Approval button Pressed
       WebElement PrCooApproval = driver.findElement(By.xpath("//button[@name='button_coo_approved']"));
       PrCooApproval.click();
       Thread.sleep(3000);
       
       //Pr Final/Done Approval button Pressed
       WebElement PrFinalApproval = driver.findElement(By.xpath("//button[@name='button_done']"));
       PrFinalApproval.click();
       Thread.sleep(3000);
       
       
       System.out.println("Purchase requsition Successfully Completed!");
       Thread.sleep(3000);
       





	}

}
