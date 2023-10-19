package CPHLPrToAgreementPO;

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

public class agreementPrAndPo {

	public static void main(String[] args) throws InterruptedException {

//			WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//			ChromeDriver driver = new ChromeDriver();
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

//		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
//		Thread.sleep(2000);
//
//
//		driver.findElement(By.xpath("//div[@name='budget_line_id']")).click();
//		Thread.sleep(2000);
//
//		List<WebElement> dropdownOptions = driver
//				.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
//		int count = dropdownOptions.size();
//		System.out.println(count);
//		dropdownOptions.get(count - 3).click();
//
//		// using Requisition date selection
//
//		WebElement datePicker = driver.findElement(By.xpath("//div[@name='requisition_date']"));
//		datePicker.click();
//		LocalDateTime now = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
//		String formattedDateTime = now.format(formatter);
//		WebElement dateTimeInput = driver.findElement(By.xpath("//div[@name='requisition_date']/input"));
//
////			WebElement dateTimeInput = driver
////					.findElement(By.xpath("//input[@data-target='#datepicker142' or @id='o_field_input_111']"));
//		// Replace // with // actual // locator dateTimeInput.clear();
//		dateTimeInput.sendKeys(formattedDateTime);
//		Thread.sleep(2000);
//
//		// using Requisition date selection
//
//		WebElement prioritySelect = driver.findElement(By.xpath("//select[@name='priority']"));
//		prioritySelect.click();
//		Select select = new Select(prioritySelect);
//		select.selectByVisibleText("High");
//		Thread.sleep(2000);
//
//		WebElement requirement_forSelect = driver.findElement(By.xpath("//select[@name='requirement_for']"));
//		prioritySelect.click();
//		Select requirement_forselectoptions = new Select(requirement_forSelect);
//		requirement_forselectoptions.selectByVisibleText("Operation");
//		Thread.sleep(2000);
//
//		WebElement requisition_typeSelect = driver.findElement(By.xpath("//select[@name='requisition_type']"));
//		prioritySelect.click();
//		Select requisition_typeselectoptions = new Select(requisition_typeSelect);
//		requisition_typeselectoptions.selectByVisibleText("Local");
//		Thread.sleep(2000);
//
//		WebElement purchase_typeSelect = driver.findElement(By.xpath("//select[@name='purchase_type']"));
//		prioritySelect.click();
//		Select purchase_typeselectoptions = new Select(purchase_typeSelect);
//		purchase_typeselectoptions.selectByVisibleText("New Purchase");
//		Thread.sleep(2000);
//
//		// Selection Approved by option
////			WebElement approvebyselect = driver.findElement(By.cssSelector("#o_field_input_113"));
//
//		WebElement approvebyselect = driver.findElement(By.xpath("//div[@name='assigned_to']"));
//
//		approvebyselect.click();
//		Thread.sleep(2000); // Locate the specific option you want to click by its text
//		String optionText = "Administrator"; // Replace with the option you want to select
//		WebElement optionToSelect = approvebyselect.findElement(By.xpath("//a[text()='" + optionText + "']"));
//
//		// Click on the option
//		optionToSelect.click();
//		Thread.sleep(2000);
//
//		// Start First item selection product and qty//
//
//		WebElement lineSelection = driver.findElement(By.xpath("//a[text()='Add a line']")); // Pr Add a line selection
//																								// First
//		lineSelection.click();
//		Thread.sleep(2000);
//
//		WebElement productDropdown1 = driver.findElement(By.xpath("//td[@name='product_id']")); // Product dropdown
//																								// selection
//		productDropdown1.click();
//		Thread.sleep(2000);
//
//		WebElement itemToSelect1 = driver.findElement(By.xpath("//a[contains(text(), '02 pin plug - (91E6100112)')]")); // Product
//																														// Name
//																														// selection
////		WebElement itemToSelect = driver.findElement(By.xpath("//a[contains(text(), '" + prproductName[i] + "')]"));
//
//		itemToSelect1.click();
//		Thread.sleep(2000);
//
//		WebElement itemQtySelect1 = driver.findElement(By.xpath("//input[@name='product_qty']")); // Product Qty
//																									// selection
//		itemQtySelect1.click();
//		itemQtySelect1.clear();
//		itemQtySelect1.sendKeys("5");
//
//		WebElement okButtonFirst = driver.findElement(By.xpath("//button[text()='Ok']")); // Click the "Ok" button
//
//		okButtonFirst.click();
//		Thread.sleep(2000);
//
//		itemQtySelect1.sendKeys(Keys.ENTER);
//
//		// End First item selection product and qty//
//
//		// Start Second item selection product and qty//
//
//		System.out.println("First line selection");
//
//		WebDriverWait secondwait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//		WebElement productDropdown2 = secondwait
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@name='product_id']")));
//
////		WebElement item2 = driver.findElement(By.xpath("//div[@name='product_id']"));
//		productDropdown2.click();
//		Thread.sleep(2000);
//
//		WebDriverWait secondProductwait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//		WebElement itemToSelect2 = secondProductwait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = '04 Way Switch - (91E6100112)']")));
//
//		itemToSelect2.click();
//		Thread.sleep(2000);
//
//		WebElement itemQtySelect2 = driver.findElement(By.xpath("//input[@name='product_qty']"));
//		itemQtySelect2.click();
//		itemQtySelect2.clear();
//		itemQtySelect2.sendKeys("7");
//
//		Thread.sleep(2000);
//
//		WebElement okButton2 = driver.findElement(By.xpath("//button[text()='Ok']"));
//		// Click the "Ok" button
//		okButton2.click();
//		Thread.sleep(2000);
//		System.out.println("Second  line selection");
//
//		// End Second item selection product and qty//
//		
//
//		WebElement prSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); //Save pr Button
//		prSubmit.click();
//		Thread.sleep(3000);
//		
//		//Approval process start //
//
//		// Pr Hod Approval button Pressed
//		WebElement PrHodApproval = driver.findElement(By.xpath("//button[@name='button_hod_approve']"));
//		PrHodApproval.click();
//		Thread.sleep(1000);
//
//		// Pr pm Approval button Pressed
//		WebElement PrPmApproval = driver.findElement(By.xpath("//button[@name='button_pm_approve']"));
//		PrPmApproval.click();
//		Thread.sleep(1000);
//
//		// Pr pm Ops Approval button Pressed
//		WebElement PrPmOpsApproval = driver.findElement(By.xpath("//button[@name='button_pm_ops_approve']"));
//		PrPmOpsApproval.click();
//		Thread.sleep(1000);
//
//		// Pr SCM Approval button Pressed
//		WebElement PrScmApproval = driver.findElement(By.xpath("//button[@name='button_scm_approve']"));
//		PrScmApproval.click();
//		Thread.sleep(1000);
//
//		// Pr COO Approval button Pressed
//		WebElement PrCooApproval = driver.findElement(By.xpath("//button[@name='button_coo_approved']"));
//		PrCooApproval.click();
//		Thread.sleep(1000);
//
//		// Pr Final/Done Approval button Pressed
//		WebElement PrFinalApproval = driver.findElement(By.xpath("//button[@name='button_done']"));
//		PrFinalApproval.click();
//		Thread.sleep(3000);
//
//		System.out.println("Purchase requsition Successfully Completed!");
//		Thread.sleep(3000);

		// Approval process End //

		// Order Root menu selection
		driver.findElement(By.xpath("//button[@data-menu-xmlid='purchase.menu_procurement_management']")).click();
		Thread.sleep(2000);
		// Order Root menu End

		// Agreement PO start

		driver.findElement(By.xpath("//a[@data-menu-xmlid='purchase.menu_purchase_form_action']")).click();
		Thread.sleep(2000);

		WebElement LocalAgreementPoCreated = driver
				.findElement(By.xpath("//button[@data-original-title='Create record']"));
		LocalAgreementPoCreated.click();
		Thread.sleep(3000);

		WebElement purchaseBase = driver.findElement(By.xpath("//select[@name='purchase_base']"));
		purchaseBase.click();
		Thread.sleep(2000);
		Select purchaseBaseDropdownselection = new Select(purchaseBase);
		purchaseBaseDropdownselection.selectByVisibleText("Agreement & Notesheet");

		Thread.sleep(2000);

		WebElement prDropdownSelect = driver.findElement(By.xpath("//div[@name='purchase_request_id']"));
		prDropdownSelect.click();
		Thread.sleep(2000);

		WebElement prDropdownValueSelect = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
		prDropdownValueSelect.click();
		Thread.sleep(2000);

		WebElement vendorDropdownSelect = driver
				.findElement(By.xpath("//div[contains(@placeholder, 'Name, TIN, Email, or Reference')]"));
		vendorDropdownSelect.click();
		Thread.sleep(2000);

		WebElement prVendorSelect = driver.findElement(By.xpath("//li/a[text()='Mayer Dowa Enterprice']"));
		prVendorSelect.click();
		Thread.sleep(2000);

		WebElement agreementDropdownSelect = driver.findElement(By.xpath("//div[@name='agreement_id']"));
		agreementDropdownSelect.click();
		Thread.sleep(2000);

		WebElement agreementValueSelect = driver.findElement(By.xpath("//li/a[text()='MD-101']"));
		agreementValueSelect.click();
		Thread.sleep(2000);

		WebElement budgetDropdownSelect = driver.findElement(By.xpath("//div[@name='budget_id']"));
		budgetDropdownSelect.click();
		Thread.sleep(2000);

		WebElement budgetValueSelect = driver.findElement(By.xpath(
				"//li/a[text()='A. Fixed Plant Overhead - 3.Overtime & Holiday Bill - 2022-2023 (CPBL) (923995.8200000001) (1079830.0)']"));
		budgetValueSelect.click();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Create a WebDriverWait instance with
		// a timeout (in seconds) first cell
		// selection

		WebElement firstCellRfq = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tr.o_data_row:first-child"))); // Wait
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
		unitPrice1Selection.sendKeys("600"); // input/Set First row unit price
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
		secondCellRfq.sendKeys("700"); // input/Set Second row unit price

		System.out.println("Price assign suceesfully in second table data!");

		// Local Po submit button work start ..
		WebElement LocalPOAgrementSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final
																											// submission
		LocalPOAgrementSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
		System.out.println("Local PO Agrement Created successfully!");

		WebElement scmApproval = driver.findElement(By.xpath("//button[@name='send_for_scm_approval']"));
		scmApproval.click();
		Thread.sleep(1000);
		WebElement scmCooApproval = driver.findElement(By.xpath("//button[@name='send_for_scm_coo_approval']"));
		scmCooApproval.click();
		Thread.sleep(1000);
		WebElement buttonConfirm = driver.findElement(By.xpath("//button[@name='button_confirm']"));
		buttonConfirm.click();
		Thread.sleep(1000);
		WebElement buttonApproveAgreement = driver.findElement(By.xpath("//button[@name='button_approve']"));
		buttonApproveAgreement.click();
		Thread.sleep(1000);
		
		System.out.println("Purchase Agreement successfully created");


	}
	// TODO Auto-generated method stub

}
