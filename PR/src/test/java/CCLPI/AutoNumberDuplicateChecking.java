package CCLPI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoNumberDuplicateChecking {

	private WebDriver driver;
	
	private List<String> generatedProformaNumbers = new ArrayList<>();
	
//	private List<String> generatedProformaNumbers = driver
//			.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item a.dropdown-item.ui-menu-item-wrapper"));
	 
	private int totalGenerated = 0;

	public AutoNumberDuplicateChecking(WebDriver driver) {
		this.driver = driver;
	}
	
	
	

	public String generateUniqueProformaNumber() {
		String prefix = "Pi-";
		int year = 2023;
		String number;
		String proformaNumber;

		do {
			// Increment the total count
			totalGenerated++;

			number = String.format("%05d", totalGenerated);
			proformaNumber = prefix + year + "-" + number;
			

			// Check if the proformaNumber is unique by searching in the generated list
			boolean isUnique = !generatedProformaNumbers.contains(proformaNumber);

			if (isUnique) {
				generatedProformaNumbers.add(proformaNumber);
				return proformaNumber;
			}
		} while (true);
	}

	public int getTotalGenerated() {
		return totalGenerated;
	}
}
