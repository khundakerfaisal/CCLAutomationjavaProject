package ComparativeStatement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComparativeStatementWithPO {

	public static void main(String[] args)throws InterruptedException {
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
		
		
		WebElement orderMenuSelection = driver.findElement(By.xpath("//button[@title='Orders']"));
		orderMenuSelection.click();
		Thread.sleep(2000);
		
		
		WebElement csMenuSelection = driver.findElement(By.xpath("//a[@data-menu-xmlid='cphl_purchase_comparison.menu_action_cphl_purchase_comparison_views']"));
		csMenuSelection.click();
		Thread.sleep(2000);
		
		WebElement csCreateButton = driver.findElement(By.xpath("//button[@data-original-title='Create record']"));
		csCreateButton.click();
		Thread.sleep(3000);
		
		
		WebElement csRfqNoSelection = driver.findElement(By.xpath("//div[@name='requisition_id']"));
		csRfqNoSelection.click();
		Thread.sleep(3000);
		
		WebElement firstRfqSelection = driver.findElement(By.xpath(".//li[@class='ui-menu-item'][1]/a"));
		// Click on the first item
		firstRfqSelection.click();
		System.out.println("Dropdown PR selection perfectly");
		Thread.sleep(3000);
		
		
		WebElement responseName = driver.findElement(By.xpath("//input[@name='response_name']"));
		responseName.sendKeys("This is Test cs");
		Thread.sleep(3000);
		
		
		WebElement SaveButton = driver.findElement(By.xpath("//button[@title='Save record']"));
		SaveButton.click();
		Thread.sleep(3000);
		
		
		WebElement csCompareButton = driver.findElement(By.xpath("//button[@name='action_comparative_statement']"));
		csCompareButton.click();
		Thread.sleep(3000);
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement	csVendorSelection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[2][@colspan='6']/a[text()='Select']")));

		
		WebElement csVendorSelection = driver.findElement(By.xpath("//td[2]/a[text()='Select']"));
//		csVendorSelection.sendKeys(Keys.ENTER);
		csVendorSelection.click();
		Thread.sleep(4000);
		

	}

}
