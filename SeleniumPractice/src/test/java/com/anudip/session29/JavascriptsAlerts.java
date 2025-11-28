package com.anudip.session29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptsAlerts {

	public static void main(String[] args) {
		//javascript normal alert
		//test1();
		//javascript confirm
		//test2();
		//javascript prompt
		//test3();
		//JS alerts can be handled by without switchTo() method using explicit wait
		//test4();
		//Basic Authentication alert box handling
		test5();

	}

	private static void test5() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.get("https://the-internet.herokuapp.com/basic_auth");
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.get("https://admin:123@the-internet.herokuapp.com/basic_auth");
		
		
	}

	private static void test4() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert text: "+alert.getText());
		alert.sendKeys("Singh is king");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alert.accept();
		//alert.dismiss();
		
	}

	private static void test3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text: "+alert.getText());
		alert.sendKeys("Singh is king");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//alert.accept();
		alert.dismiss();
		
	}

	private static void test2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text: "+alert.getText());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alert.accept();
		//alert.dismiss();
		
	}

	private static void test1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text: "+alert.getText());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		alert.accept();
		
	}

}
