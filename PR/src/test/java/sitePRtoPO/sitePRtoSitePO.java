package sitePRtoPO;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class sitePRtoSitePO {

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

		// using Requisition date selection

		WebElement datePicker = driver.findElement(By.xpath("//input[@name='requisition_date']"));
		datePicker.click();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String formattedDateTime = now.format(formatter);
		WebElement dateTimeInput = driver
				.findElement(By.xpath("//input[@data-target='#datepicker142' or @id='o_field_input_111']"));
		// Replace // with // actual // locator dateTimeInput.clear();
		dateTimeInput.sendKeys(formattedDateTime);
		Thread.sleep(2000);

		// using Requisition date selection

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
		requisition_typeselectoptions.selectByVisibleText("Site Purchase");
		Thread.sleep(2000);

		WebElement purchase_typeSelect = driver.findElement(By.xpath("//select[@name='purchase_type']"));
		prioritySelect.click();
		Select purchase_typeselectoptions = new Select(purchase_typeSelect);
		purchase_typeselectoptions.selectByVisibleText("New Purchase");
		Thread.sleep(2000);

		// Selection Approved by option
		WebElement approvebyselect = driver.findElement(By.cssSelector("#o_field_input_113"));
		approvebyselect.click();
		Thread.sleep(2000); // Locate the specific option you want to click by its text
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
		Thread.sleep(2000); // Start Array Using multiple item selection with loop

		String[] dropdownItems = { "04 Way Switch - (91E6100112)" };
		int[] quantities = { 4 }; // Corresponding quantities

		// Iterate through the dropdown items and quantities
		for (int i = 0; i < dropdownItems.length; i++) {

			WebElement dropdownElementProduct = driver.findElement(
					By.xpath("//*[@id='o_field_input_168']/div[2]/div/table/tbody/tr[2]/td[1]/div/div[1]/div/input"));
			// WebElement quantityInput
			// =driver.findElement(By.xpath("//input[@name='product_qty']"));

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement quantityInput = wait1
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='product_qty']")));

			// Click the dropdown element
			dropdownElementProduct.click();

			// Wait for the specific item in the dropdown to be clickable

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement dropdownItem = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='04 Way Switch - (91E6100112)']")));
			dropdownItem.click();

			// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

			// // Click the dropdown item // dropdownItem.click();

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
		Thread.sleep(2000);

		// Pr pm Approval button Pressed
		WebElement PrPmApproval = driver.findElement(By.xpath("//button[@name='button_pm_approve']"));
		PrPmApproval.click();
		Thread.sleep(2000);

		// Pr pm-ops Approval button Pressed
		WebElement PrPmopsApproval = driver.findElement(By.xpath("//button[@name='button_pm_ops_forward']"));
		PrPmopsApproval.click();
		Thread.sleep(1000);

		// Pr forward Approval button Pressed
		WebElement PrForwardApproval = driver.findElement(By.xpath("//button[@name='button_forward']"));
		PrForwardApproval.click();
		Thread.sleep(1000);

		// Pr Final/Done Approval button Pressed
		WebElement PrFinalApproval = driver.findElement(By.xpath("//button[@name='button_done']"));
		PrFinalApproval.click();
		Thread.sleep(3000);

		System.out.println("Site Purchase requsition Successfully Completed!");
		Thread.sleep(3000);

		// order menu button Pressed
		WebElement orderMenuSelection = driver.findElement(By.xpath("//button[@title='Orders']"));
		orderMenuSelection.click();
		Thread.sleep(2000);

		// Site purchase order menu click
		WebElement sitePoSelection = driver
				.findElement(By.xpath("//a[@data-menu-xmlid='cphl_local_purchase.menu_action_site_purchase_views']"));
		sitePoSelection.click();
		Thread.sleep(2000);

		// Site purchase order create button click

		WebElement sitePoCreateButton = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
		sitePoCreateButton.click();
		Thread.sleep(3000);

		// Site purchase order vendor selection

		WebElement inputElement = driver
				.findElement(By.xpath("//div[contains(@placeholder, 'Name, TIN, Email, or Reference')]"));
		inputElement.click();
		Thread.sleep(2000);

		// Site purchase order dropdown vendor selection

		WebElement sitePoVendorSelection = driver
				.findElement(By.xpath("//li/a[text()='Billal Electric & electronics']"));
		sitePoVendorSelection.click();
		Thread.sleep(2000);

		// Site po--PR dropdown value selection work start

		WebElement prDropdownclick = driver.findElement(By.xpath("//div[@name='purchase_request_id']"));
		prDropdownclick.click();
		Thread.sleep(2000);

		WebElement firstItem = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
		// Click on the first item
		firstItem.click();
		System.out.println("Dropdown PR selection perfectly");
		Thread.sleep(3000);

		WebElement sitePObudgetclick = driver.findElement(By.xpath("//div[@name='budget_id']"));
		sitePObudgetclick.click();

//		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
//		WebElement sitePObudgetselect = wait3
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-2']/li[6]/a")));
//		sitePObudgetselect.click();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//a[text()='A. Fixed Plant Overhead - 10.Plant Tour & Travelling Exp - 2022-2023 (CPBL) (37514.83) (59800.0)']")));
		element.click();
		Thread.sleep(3000);

//		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
//		try {
//			WebElement element = wait3
//					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='ui-id-46']/li[6]/a")));
//			element.click();
//		} catch (TimeoutException e) {
//			System.err.println("Element was not found within the specified time frame.");
//		}
		Thread.sleep(2000);

		// Table td data unit price input work start :: Site po unit price input
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
		// Table td data unit price input work Close..

		// RfQ submit button work start ..
		WebElement sitPOSubmit = driver.findElement(By.xpath("//button[@title='Save record']")); // RFQ final submission
		sitPOSubmit.click();
		Thread.sleep(2000);
		// RfQ submit button work close ..
		System.out.println("Site PO Created successfully!");

	}

}
