package CCLPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoNumberDuplicateChecking {

	private WebDriver driver;

	public AutoNumberDuplicateChecking(WebDriver driver) {
		this.driver = driver;
	}

//	public boolean isProformaNumberUnique(String proformaNumber) {
//		// Check if the proformaNumber is unique by searching for it in your system
//		boolean isUnique = isProformaNumberUnique(driver, proformaNumber);
//		return isUnique;
//	}

	public static String generateUniqueProformaNumber(WebDriver driver, int currentNumber) {
		String prefix = "Pi-";
		int year = 2023;
		String number;
		String proformaNumber;

		do {
			number = String.format("%05d", currentNumber);
			proformaNumber = prefix + year + "-" + number;

			// Check if the proformaNumber is unique by searching for it in your system
			boolean isUnique = isProformaNumberUnique(driver, proformaNumber);

			if (isUnique) {
				return proformaNumber;
			} else {
				currentNumber++; // If not unique, increment the current number and try again
			}
		} while (true);
	}
	

	public static boolean isProformaNumberUnique(WebDriver driver, String proformaNumber) {

		return true;

	}
//
	public void checkForDuplicateProformaNumber() {
		
		WebElement piColumn = driver.findElement(
				By.xpath("//input[@class='o_field_char o_field_widget o_quick_editable o_input o_required_modifier']"));
		
		piColumn.clear();
		piColumn.click();
		
		
		
	}
//	public void checkForDuplicateProformaNumber() {
////        ProformaNumberChecker checker = new ProformaNumberChecker(driver);
//
//		int numberOfValuesToInput = 1; // Change this to the number of values you want to input
////
//////	WebElement piColumn = driver.findElement(
//////			By.xpath("//input[@class='o_field_char o_field_widget o_quick_editable o_input o_required_modifier']"));
//////	piColumn.click();
////
//		for (int i = 1; i <= numberOfValuesToInput; i++) {
//			String autoNumber = generateUniqueProformaNumber(driver, i);
//			boolean isUnique = isProformaNumberUnique(autoNumber);
//			if(isUnique) {
//				System.out.println("Successful");
//			}
//			else {
//				System.out.println("Failed");
//			}
//
//		}

}
