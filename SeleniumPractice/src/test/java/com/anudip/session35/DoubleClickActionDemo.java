package com.anudip.session35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickActionDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver  driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		WebElement txt1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement txt2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		txt1.clear();
		txt1.sendKeys("sandeep");
		
		Actions action = new Actions(driver);
		action.doubleClick(button).perform();
		
		
		if(txt2.getAttribute("value").equals("sandeep"))
			System.out.println("Text copied");
		else
			System.out.println("Something went wrong");
		
		
	}

}
