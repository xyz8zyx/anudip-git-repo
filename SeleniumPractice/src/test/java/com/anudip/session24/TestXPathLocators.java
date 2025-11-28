package com.anudip.session24;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestXPathLocators {

	public static void main(String[] args) {
		//ex1();		
		ex2();
	}

	private static void ex2() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5km84u9k2k_e&adgrpid=155259813113&hvpone=&hvptwo=&hvadid=674842289479&hvpos=&hvnetw=g&hvrand=16898837046999500013&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9050481&hvtargid=kwd-304880464215&hydadcr=14450_2316420&gad_source=1");
		List<WebElement> elements = driver.findElements(By.className("nav-li"));
		System.out.println("Total List Elements are: "+elements.size());
//		for(WebElement element : elements) {
//			System.out.println(element.getText());
//		}		
	
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Anchor Link Elements are: "+links.size());
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total Image Elements are: "+images.size());		
		//driver.quit();
	}

	private static void ex1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form"); // Open the form page
		try {
			// **Using XPath Indexing to Locate Elements**
			// 1. Enter First Name (Using XPath Index)
			WebElement firstName = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
			firstName.sendKeys("John");
			// 2. Enter Last Name (Using XPath Index)
			WebElement lastName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
			lastName.sendKeys("Doe");
			// 3. Enter Mobile Number (Using XPath Index)
			WebElement mobileNumber = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
			mobileNumber.sendKeys("9876543210");
			// 4. Select Gender Radio Button (2nd Radio Button: Male)
			WebElement genderMale = driver.findElement(By.xpath("(//input[@name='gender'])[2]"));
			genderMale.click();
			// 5. Select Hobby (1st Hobby Checkbox: Sports)
			WebElement hobbySports = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			hobbySports.click();
			// 6. Click Submit Button (Using XPath Index)
			WebElement submitButton = driver.findElement(By.xpath("(//button[@id='submit'])[1]"));
			submitButton.click();
			System.out.println("Form Submitted Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// driver.quit(); // Close the browser
		}

	}

}
