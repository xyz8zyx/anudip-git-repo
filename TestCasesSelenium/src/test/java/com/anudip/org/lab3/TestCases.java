package com.anudip.org.lab3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestCases {
	
	public static void main(String[] args) {
		//testCase1();
		//testCase2();
		testCase3();
	}

	private static void testCase3() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		WebElement usernameText = driver.findElement(By.cssSelector("#username"));		
		usernameText.sendKeys("student");
		WebElement passwordText = driver.findElement(By.cssSelector("input[name='password']"));
		passwordText.sendKeys("Password123");
		
		WebElement loginButton = driver.findElement(By.className("btn"));
		loginButton.click();
		
		WebElement successMessage = driver.findElement(By.tagName("h1"));
		if(successMessage.getText().contains("Logged In Successfully")) {
			System.out.println("Login Test Passed");
		}else {
			System.out.println("Login Test Failed");
		}
	}

	private static void testCase2() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		
		WebElement usernameText = driver.findElement(By.name("username"));
		WebElement passwordText = driver.findElement(By.name("password"));
		
		usernameText.sendKeys("student");
		passwordText.sendKeys("Password123");
		
		WebElement loginButton = driver.findElement(By.className("btn"));
		loginButton.click();
		
		WebElement successMessage = driver.findElement(By.tagName("h1"));
		if(successMessage.getText().contains("Logged In Successfully")) {
			System.out.println("Login Test Passed");
		}else {
			System.out.println("Login Test Failed");
		}
		
	}

	private static void testCase1() {
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium WebDriver");
		searchBox.submit();
		
	}

}
