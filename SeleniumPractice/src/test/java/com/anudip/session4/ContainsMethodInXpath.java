package com.anudip.session4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContainsMethodInXpath {

	public static void main(String[] args) {		
		
		//XPath contains() method
		//example1();
		
		//XPath contains() method
		//example2();
		
		//XPath starts-with() method
		//example3();
		
		//Chained XPath		
		//example4();
		
		//Use of Operator or & and in XPath
		example6();

	}

	private static void example6() {
		// TODO Auto-generated method stub
		
	}

	private static void example4() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		WebElement element = driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
		System.out.println("Element is: "+element.getText());
		boolean isElementAvailable = driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed();
		System.out.println("Is the Element Available? : "+isElementAvailable);
		
		
	}

	private static void example3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String tagName = driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).getTagName();
		System.out.println(tagName);
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("Amazon Products");
		
	}

	private static void example2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		String tagName = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).getTagName();
		System.out.println(tagName);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("Amazon Products");
		
	}

	private static void example1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");		
		String tagName = driver.findElement(By.xpath("//input[contains(@aria-label,'Goo')]")).getTagName();
		System.out.println(tagName);
		
	}

}
