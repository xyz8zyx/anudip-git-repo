package com.anudip.session21;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) {

		ChromeDriver d = new ChromeDriver();
		d.get("https://www.google.com/");
		String realTitle = d.getTitle();
		if(realTitle.equals("Googlee"))
			System.out.println("Test Pass...");
		else
			System.out.println("Test Failed...");
		
		//d.close();
		//d.quit();
		
	}

}
