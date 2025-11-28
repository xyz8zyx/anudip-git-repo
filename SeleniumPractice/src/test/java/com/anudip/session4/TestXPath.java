package com.anudip.session4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestXPath {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Its me in google search ");
		//driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("Hiiiiii");
		//driver.findElement(By.xpath("//textarea[@id='APjFqb'][@name='q']")).sendKeys("Hello");
		//driver.findElement(By.xpath("//textarea[@id='APjFqb' and @name='qq']")).sendKeys("Hello John");
		driver.findElement(By.xpath("//textarea[@id='APjFqb' or @name='qq']")).sendKeys("Hello Sandy");

	}

}
