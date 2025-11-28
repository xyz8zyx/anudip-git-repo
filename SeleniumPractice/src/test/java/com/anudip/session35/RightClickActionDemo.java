package com.anudip.session35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickActionDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver  driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		Actions action = new Actions(driver);
		action.contextClick(button).perform();
		
		driver.findElement(By.xpath("//span[normalize-space()='Paste']")).click();
		
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

}
