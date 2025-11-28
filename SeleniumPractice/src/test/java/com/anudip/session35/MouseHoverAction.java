package com.anudip.session35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		WebDriver  d = new ChromeDriver();
		d.get("https://demo.nopcommerce.com/");
		d.manage().window().maximize();
		
		WebElement electronics = d.findElement(By.xpath("//a[@role='button'][normalize-space()='Electronics']"));
		WebElement cellPhones = d.findElement(By.xpath("//a[normalize-space()='Cell phones']"));
		
		Actions action = new Actions(d);
		action.moveToElement(electronics).moveToElement(cellPhones).build().perform();

	}

}
