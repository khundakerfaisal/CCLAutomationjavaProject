package CPHLRFQ;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RFQ {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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

		driver.findElement(By.xpath("//button[@data-menu-xmlid='purchase.menu_procurement_management']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@data-menu-xmlid='purchase_requisition.menu_purchase_requisition_pro_mgt']"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@data-original-title='Create record']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@name='purchase_request_id']")).click();
		Thread.sleep(2000);

		WebElement firstItem = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));

		// Click on the first item
		firstItem.click();

		System.out.println("Dropdown pr selection perfectly");
		WebElement rfqVendorSelection = driver
				.findElement(By.xpath("//button[@name='action_create_multiple_quotation_form']"));
		rfqVendorSelection.click();
		Thread.sleep(3000);

		// Vendor selection multiple using Array
		String[] vendorSelectionRfq = { "Mayer Dowa Enterprice", "Chowdhury Motors" };

		for (int i = 0; i < vendorSelectionRfq.length; i++) {
			WebElement vendorDropdown = driver.findElement(By.xpath("//input[@id='o_field_input_241']"));
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

//		// Wait for the table row to become present
		WebElement row1 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@data-id='purchase.order.line_9']")));

		row1.click();

		WebElement unitPrice1Selection = row1.findElement(By.xpath("//td[@name='price_unit']/input"));
		unitPrice1Selection.clear();
		unitPrice1Selection.sendKeys("500");
		Thread.sleep(2000);

		System.out.println("Price assign suceesfully in first table data!");

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

//		// Wait for the table row to become present
		WebElement row2 = wait2.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@data-id='purchase.order.line_19']")));

		row2.click();
		Thread.sleep(2000);

		WebElement unitPrice1Selection2 = row2.findElement(By.xpath("//td[7][@name='price_unit']/input"));
		unitPrice1Selection2.clear();
		unitPrice1Selection2.sendKeys("800");
		Thread.sleep(2000);

		System.out.println("Price assign suceesfully in second table data!");

	}

}
