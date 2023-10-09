package CCLPR;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.xpath.XPath;

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
		WebDriver driver = new ChromeDriver();
//		ChromeDriver driver = new ChromeDriver();
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

		driver.findElement(By.xpath("//input[@id='o_field_input_110']")).click();
		Thread.sleep(2000);

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
				.findElement(By.xpath("//input[@data-target='#datepicker142' or @id='o_field_input_111']")); // Replace
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
		WebElement approvebyselect = driver.findElement(By.cssSelector("#o_field_input_113"));
		approvebyselect.click();
		Thread.sleep(2000);
		// Locate the specific option you want to click by its text
		String optionText = "Administrator"; // Replace with the option you want to select
		WebElement optionToSelect = approvebyselect.findElement(By.xpath("//a[text()='" + optionText + "']"));

		// Click on the option
		optionToSelect.click();
		Thread.sleep(2000);

		WebElement lineSelection = driver.findElement(By.xpath("//a[text()='Add a line']"));
		lineSelection.click();
		Thread.sleep(2000);

		// Start Using Singel item selection with out loop //

		WebElement dropdownElementProduct1 = driver.findElement(By.xpath("//td[@name='product_id']"));
		dropdownElementProduct1.click();
		Thread.sleep(2000);

		WebElement itemToSelect = driver.findElement(By.xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]"));
		itemToSelect.click();
		Thread.sleep(2000);

		WebElement prQty = driver.findElement(By.xpath("//input[@name='product_qty']"));
		prQty.clear();
		prQty.sendKeys("5.000");
		Thread.sleep(2000);

		// Invisible Modal comming for this reason it is need to close [Windows Modal OK
		// button pressed]

		WebElement okButton = driver.findElement(By.xpath("//button[text()='Ok']"));
		// Click the "Ok" button
		okButton.click();
		Thread.sleep(2000);

		// End Using Singel item selection without loop //

		// Start Using Multiple item selection with loop

		WebElement lineSelection2 = driver.findElement(By.xpath("//a[text()='Add a line']"));
		lineSelection2.click();
		Thread.sleep(2000);
		// Start Array Using multiple item selection with loop

		String[] dropdownItems = { "04 Way Switch - (91E6100112)" };
		int[] quantities = { 4 }; // Corresponding quantities

		// Iterate through the dropdown items and quantities
		for (int i = 0; i < dropdownItems.length; i++) {

			WebElement dropdownElementProduct = driver.findElement(
					By.xpath("//*[@id='o_field_input_168']/div[2]/div/table/tbody/tr[2]/td[1]/div/div[1]/div/input"));
//            WebElement quantityInput = driver.findElement(By.xpath("//input[@name='product_qty']"));

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement quantityInput = wait1
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='product_qty']")));

			// Click the dropdown element
			dropdownElementProduct.click();

			// Wait for the specific item in the dropdown to be clickable

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement dropdownItem = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='04 Way Switch - (91E6100112)']")));
//            WebElement dropdownItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + dropdownItems[i] + "']")));
			dropdownItem.click();

//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

//            // Click the dropdown item
//            dropdownItem.click();

			// Input the quantity
			quantityInput.clear();
			quantityInput.sendKeys(String.valueOf(quantities[i]));

			Thread.sleep(2000);
			try {
				Thread.sleep(3000); // Wait for 1 second (1000 milliseconds)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// End Array Using multiple product item selection with loop

		// Pr Save button Pressed
		WebElement prSubmit = driver.findElement(By.xpath("//button[@title='Save record']"));
		prSubmit.click();
		Thread.sleep(3000);

		// Pr Hod Approval button Pressed
		WebElement PrHodApproval = driver.findElement(By.xpath("//button[@name='button_hod_approve']"));
		PrHodApproval.click();
		Thread.sleep(1000);

		// Pr pm Approval button Pressed
		WebElement PrPmApproval = driver.findElement(By.xpath("//button[@name='button_pm_approve']"));
		PrPmApproval.click();
		Thread.sleep(1000);

		// Pr pm Ops Approval button Pressed
		WebElement PrPmOpsApproval = driver.findElement(By.xpath("//button[@name='button_pm_ops_approve']"));
		PrPmOpsApproval.click();
		Thread.sleep(1000);

		// Pr SCM Approval button Pressed
		WebElement PrScmApproval = driver.findElement(By.xpath("//button[@name='button_scm_approve']"));
		PrScmApproval.click();
		Thread.sleep(1000);

		// Pr COO Approval button Pressed
		WebElement PrCooApproval = driver.findElement(By.xpath("//button[@name='button_coo_approved']"));
		PrCooApproval.click();
		Thread.sleep(1000);

		// Pr Final/Done Approval button Pressed
		WebElement PrFinalApproval = driver.findElement(By.xpath("//button[@name='button_done']"));
		PrFinalApproval.click();
		Thread.sleep(3000);

		System.out.println("Purchase requsition Successfully Completed!");
		Thread.sleep(3000);

		// Request for quotation button

		WebElement rfqSelection = driver.findElement(By.xpath("//button[@name='create_purchase_agreement']"));
		rfqSelection.click();
		Thread.sleep(3000);

		// RFQ Vendor mutiple button selection

		WebElement rfqVendorSelection = driver
				.findElement(By.xpath("//button[@name='action_create_multiple_quotation_form']"));
		rfqVendorSelection.click();
		Thread.sleep(3000);

		// Vendor selection multiple using Array
		String[] vendorSelectionRfq = { "Mayer Dowa Enterprice", "Chowdhury Motors" };

		for (int i = 0; i < vendorSelectionRfq.length; i++) {
			WebElement vendorDropdown = driver.findElement(By.xpath("//input[@id='o_field_input_372']"));
//			WebElement vendorDropdown = driver.findElement(By.xpath("//div[@name='vendor_ids']"));

			vendorDropdown.click();
			Thread.sleep(200);

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement vendorSelect = wait1.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//a[text()='" + vendorSelectionRfq[i] + "']")));

			// Click the dropdown element
			vendorSelect.click();

			// Wait for the specific item in the dropdown to be clickable

			Thread.sleep(2000);
			try {
				Thread.sleep(3000); // Wait for 1 second (1000 milliseconds)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}





		// Create a WebDriverWait instance with a timeout (in seconds)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//			// Wait for the table row to become present
			WebElement row1 = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@data-id='purchase.order.line_9']")));

			row1.click();

			WebElement unitPrice1Selection = row1.findElement(By.xpath("//td[@name='price_unit']/input"));
			unitPrice1Selection.clear();
			unitPrice1Selection.sendKeys("500");
			Thread.sleep(2000);

			System.out.println("Price assign suceesfully in first table data!");
			
//			
//			try {
//
//			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
//			
//			
//			WebElement rowNumber2 = driver.findElement(By.xpath("//*[@id='o_field_input_406']/div[2]/div[1]/table/tbody/tr[2]/td[7]/input"));
//
//			// Wait for the element to be clickable
//			wait2.until(ExpectedConditions.elementToBeClickable(rowNumber2));
//
////			WebElement rowNumber2 = wait2.until(
////					ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@data-id='purchase.order.line_19']")));
////			rowNumber2.click();
//
////			WebElement unitPriceSelectionNumber2 = rowNumber2.findElement(By.xpath("//td[@name='price_unit']/input"));
////			unitPriceSelectionNumber2.clear();
////			unitPriceSelectionNumber2.sendKeys("650");
//			rowNumber2.clear();
//			rowNumber2.sendKeys("650");
//		
//			Thread.sleep(3000);
//			System.out.println("Price assign suceesfully in Second table data!");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// Close the WebDriver
//			driver.quit();
//		}

//		try {
//			// Find the table rows (tr elements) you want to work with
//			WebElement row1 = driver.findElement(By.xpath("//tr[@data-id='purchase.order.line_9']"));
//			WebElement input1 = row1.findElement(By.xpath(".//td[@name='price_unit']/input"));
//			input1.sendKeys("500");
//			Thread.sleep(2000);
//
//			WebElement row2 = driver.findElement(By.xpath("//tr[@data-id='purchase.order.line_19']"));
//
//			// Find the "price_unit" input elements within the table rows
//
//			WebElement input2 = row2.findElement(By.xpath(".//td[@name='price_unit']/input"));
//
//			// Input values into the input elements
//
//			input2.sendKeys("650");
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// Close the WebDriver
//			driver.quit();
//		}

//	public static void inputUnitPrice(WebDriver driver, String price, int rowIndex) {
//		// Find the WebElement for the price_unit field in the specified row
//////		WebElement priceUnitField = driver
////				.findElement(By.xpath("//tr[@class='o_data_row'][" + (rowIndex + 1) + "]//td[@name='price_unit']"));
//		
//		WebElement priceUnitField = driver.findElement(By.xpath("//tr[@class='o_data_row'][1]//td[@name='price_unit']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", priceUnitField);
//
//
//		// Clear the existing value (if any) in the field
//		priceUnitField.clear();
//
//		// Input the desired unit price into the price_unit field
//		priceUnitField.sendKeys(price);
//	}
	}
}
