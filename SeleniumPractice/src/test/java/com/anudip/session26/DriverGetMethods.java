package com.anudip.session26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {

	public static void main(String[] args) throws InterruptedException {
		//driverGetMethods();
		//conditionalMethods();
	}

	
	private static void conditionalMethods() {
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C589460569870%7Cb%7Cfacebook%20create%20account%7C&placement=&creative=589460569870&keyword=facebook%20create%20account&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696221432%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-12091220328%26loc_physical_ms%3D9050481%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gad_source=1&gad_campaignid=14884913640&gbraid=0AAAAAD2MkOX4yM76Lcp5LbSaIK6WrJk1L&gclid=CjwKCAiAz_DIBhBJEiwAVH2XwBE6b1yKYbph83D1ERVUcX9SFB3no-AWpR9aegXHXK8hCoPbJxgQVRoCGvYQAvD_BwE");
		
		WebElement male = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		WebElement female = driver.findElement(By.xpath("//label[normalize-space()='Female']"));
		WebElement custom = driver.findElement(By.xpath("//label[normalize-space()='Custom']"));
		System.out.println(male.isDisplayed());
		System.out.println(female.isDisplayed());
		System.out.println(custom.isDisplayed());
		
		System.out.println("Before Selection");		
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		System.out.println(custom.isSelected());
		
		System.out.println("After Female Selection");
		female.click();
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		System.out.println(custom.isSelected());
		
		
	}

	@SuppressWarnings("unused")
	private static void driverGetMethods() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println("Title: "+driver.getTitle());
		System.out.println("Current URL: "+driver.getCurrentUrl());
		//System.out.println("Page Source: "+driver.getPageSource());
		System.out.println("Window Id: "+driver.getWindowHandle());
		System.out.println("Window Ids: "+driver.getWindowHandles());
		
	}

}
