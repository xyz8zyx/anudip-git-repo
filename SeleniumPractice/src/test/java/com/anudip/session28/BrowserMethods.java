package com.anudip.session28;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Thread.sleep(3000);
		for (String handle : driver.getWindowHandles()) {
			System.out.println(handle);
		    driver.switchTo().window(handle);
		}
		
		//WebElement contactSales = driver.findElement(By.linkText("Contact Sales"));
		WebElement contactSales = driver.findElement(By.xpath("//button[contains(text(),'Contact Sales')]"));
		//WebElement contactSales = driver.findElement(By.xpath("//h5[normalize-space()='Contact Us']"));		
		
		if(contactSales.isDisplayed()) {
			Thread.sleep(3000);
			contactSales.click();
		}else {
			System.out.println("Link not found");
		}
		Thread.sleep(10000);
		driver.quit();
	}

}
