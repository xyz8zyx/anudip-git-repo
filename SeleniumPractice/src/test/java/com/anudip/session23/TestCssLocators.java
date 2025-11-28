package com.anudip.session23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCssLocators {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		// Id selector example
		// driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Trousers");
		// driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Shirts");

		// class selector example
		// driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Mobile");
		// driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Laptop");

		// tag attribute example
		// driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Ball");
		// driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("Football");		
		// driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("Book");

		
		// tag class attribute example
//		driver.findElement(By.cssSelector("input.search-box-text[name=\"q\"]")).sendKeys("abcd");
//		driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("pqrs");
//		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("jojojo");
	}

}
