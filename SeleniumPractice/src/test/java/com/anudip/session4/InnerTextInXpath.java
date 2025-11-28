package com.anudip.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InnerTextInXpath {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		boolean displayed = driver.findElement(By.xpath("//a[text()='Privacy']")).isDisplayed();
		System.out.println(displayed);
		String text = driver.findElement(By.xpath("//a[text()='Privacy']")).getText();
		System.out.println(text);

	}

}
