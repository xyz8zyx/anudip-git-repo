package com.anudip.session30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HandlingFramesInSalenium {

	public static void main(String[] args) {
		t1();
		//t2();
		//t3();
		//t4();
		//t5();

	}

	

	/*
	 * To find frame inside page first and then do operation on the frame
	 */
	private static void t1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Frame1");
		
	}
	
	
	
	
	
	
	
	/*
	 * Switching between one frame to another frame inside web page
	 */
	private static void t2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Frame1");
		
		/*
		 * Direct switching 1 frame to another inside page is not possible
		 * so first move to default page and then switch to any frame
		 */
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello Frame2");
		
	}
	
	
	/*
	 * Switching between 3 frames inside web page
	 */
	private static void t3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Frame1");
		
		/*
		 * Direct switching 1 frame to another inside page is not possible
		 * so first move to default page and then switch to any frame
		 */
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Hello Frame2");
		
		driver.switchTo().defaultContent();
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello Frame3");
		
	}


	/*
	 * Switching between one frame to another frame inside web page
	 * and work inside inner frame
	 */
	private static void t4() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Frame1");		
		
		/*
		 * Direct switching 1 frame to another inside page is not possible
		 * so first move to default page and then switch to any frame
		 */
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello Frame3");
		
		//Switching inside inner frame possible
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		driver.findElement(By.xpath("//div[@id='i21']//div[@class='uHMk6b fsHoPb']")).click();
		
	}
	
	private static void t5() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello Frame1");		
		
		/*
		 * Direct switching 1 frame to another inside page is not possible
		 * so first move to default page and then switch to any frame
		 */
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Hello Frame3");
		
		//Switching inside inner frame possible
		driver.switchTo().frame(0);
		
//		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
//		driver.findElement(By.xpath("//div[@id='i21']//div[@class='uHMk6b fsHoPb']")).click();
		
		
		//We can use JavascriptExecutor for inner frame
    	WebElement radioButton = driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']"));
    	WebElement checkbox = driver.findElement(By.xpath("//div[@id='i21']//div[@class='uHMk6b fsHoPb']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", radioButton);
		js.executeScript("arguments[0].click();", checkbox);
	}


}
