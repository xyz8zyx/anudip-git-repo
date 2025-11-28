package com.anudip.session29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPractice {

	public static void main(String[] args) {
		//Select single checkbox
		//test1();
		//Select all checkboxes
		//test2();
		//Select first 3 checkboxes
		//test3();
		//Unselect checkboxes if  they are selected
		test4();

	}

	private static void test4() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		if(!checkboxes.isEmpty() || checkboxes !=null) {
			for(int i=0;i<3;i++) {
				checkboxes.get(i).click();
			}
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//It will unselect first three checkboxes which are selected
		for(WebElement checkbox: checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
			}
		}
		
	}

	private static void test3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		if(!checkboxes.isEmpty() || checkboxes !=null) {
			for(int i=0;i<3;i++) {
				checkboxes.get(i).click();
			}
		}
		
	}

	private static void test2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		if(!checkboxes.isEmpty() || checkboxes !=null) {
			for(WebElement checkbox: checkboxes) {
				checkbox.click();
			}
		}
		
	}

	private static void test1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
	}

}
