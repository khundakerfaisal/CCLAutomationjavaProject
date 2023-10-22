package LocalPOWithCS;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CSbasedLocalPO {

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

		driver.findElement(By.xpath("//div[@name='budget_line_id']")).click();
		Thread.sleep(2000);

		List<WebElement> dropdownOptions = driver
				.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
		int count = dropdownOptions.size();
		System.out.println(count);
		dropdownOptions.get(count - 3).click();

		// using Requisition date selection
		WebElement datePicker = driver.findElement(By.xpath("//input[@name='requisition_date']"));
		datePicker.click();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		WebElement dateTimeInput = driver.findElement(By.xpath("//div[@name='requisition_date']/input")); // Replace
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
		WebElement approvebyselect = driver.findElement(By.xpath("//div[@name='assigned_to']"));
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

		// Order root menu selection

		WebElement rfqSelection = driver.findElement(By.xpath("//button[@name='create_purchase_agreement']"));
		rfqSelection.click();
		Thread.sleep(3000);

//		// RFQ Vendor mutiple button selection
//
		WebElement rfqVendorSelection = driver
				.findElement(By.xpath("//button[@name='action_create_multiple_quotation_form']"));
		rfqVendorSelection.click();
		Thread.sleep(3000);

//		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
//		Thread.sleep(2000);

//		driver.findElement(By.xpath("//div[@name='purchase_request_id']")).click();
//		Thread.sleep(2000);
//
//		// PR First dropdown value selection work start
//
//		WebElement firstItem = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
//		// Click on the first item
//		firstItem.click();
//		System.out.println("Dropdown PR selection perfectly");
//		WebElement rfqVendorSelection = driver
//				.findElement(By.xpath("//button[@name='action_create_multiple_quotation_form']"));
//		rfqVendorSelection.click();
//		Thread.sleep(3000);

		// PR First dropdown value selection work close

		// Vendor selection multiple using Array
		String[] vendorSelectionRfq = { "Mayer Dowa Enterprice", "Chowdhury Motors" };

		for (int i = 0; i < vendorSelectionRfq.length; i++) {
			WebElement vendorDropdown = driver.findElement(By.xpath("//div[@name='vendor_ids']"));
//					WebElement vendorDropdown = driver.findElement(By.xpath("//div[@name='vendor_ids']"));

			vendorDropdown.click();
			Thread.sleep(2000);

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

		// Table td data unit price input work start
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Create a WebDriverWait instance with
																				// a timeout (in seconds) first cell
																				// selection

		WebElement firstCellRfq = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@data-id='purchase.order.line_9']"))); // Wait
																															// for
																															// the
																															// First
																															// table
																															// cell
																															// selection

		firstCellRfq.click();
		WebElement unitPrice1Selection = firstCellRfq.findElement(By.xpath("//td[@name='price_unit']/input")); // First
																												// row
																												// price
																												// input
																												// button
																												// click
		unitPrice1Selection.clear();
		unitPrice1Selection.sendKeys("500"); // input/Set First row unit price
		unitPrice1Selection.sendKeys(Keys.ENTER); // Enter Second selected cell
		Thread.sleep(2000);

		System.out.println("Price assign suceesfully in first table data!");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30)); // Create a WebDriverWait instance with
																					// a timeout (in seconds) Second
																					// cell selection
		WebElement secondCellRfq = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//td[@class='o_data_cell o_field_cell o_list_number o_required_modifier']/input[@name='price_unit']"))); // Second
																															// row
																															// price
																															// input
																															// button
																															// click
		secondCellRfq.click();
		secondCellRfq.clear();
		secondCellRfq.sendKeys("800"); // input/Set Second row unit price

		System.out.println("Price assign suceesfully in second table data!");
		// Table td data unit price input work Close..

		// RfQ submit button work start ..
		WebElement rfqSubmit = driver.findElement(By.xpath("//button[@name='action_multiple_quotation_save']")); // RFQ
																													// final
																													// submission
		rfqSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
		System.out.println("RFQ Submission successfully!");

		WebElement rfqFinalSubmit = driver.findElement(
				By.xpath("//button[@class='btn btn-primary o_form_button_save' and @title='Save record']")); // RFQ
																												// final
																												// submission
		rfqFinalSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
		System.out.println("RFQ Final Submission successfully!");

		driver.quit();

	}

}
