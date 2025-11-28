package com.anudip.org.lab4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lab4Content {

	public static void main(String[] args) {
		// example1();
		// example2();
		// example3();
		//example4();
		
		
	}

	private static void example4() {
		WebDriver driver = new ChromeDriver();
		try {
			// Step 1: Open the website
			driver.get("https://aln.anudip.org/login/index.php");
			// XPath using text()
			WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[text()='Forgotten your username or password?']"));
			System.out.println("Forgot Password Link Found: " + forgotPasswordLink.isDisplayed());
			// Partial LinkText
			WebElement forgotPassPartial = driver.findElement(By.partialLinkText("Forgotten your"));
			System.out.println("Found using Partial LinkText: " + forgotPassPartial.isDisplayed());
			// LinkText
			WebElement forgotPassword = driver.findElement(By.linkText("Forgotten your username or password?"));
			forgotPassword.click();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step 3: Close the browser
			// driver.quit();
		}

	}

	private static void example3() {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/forgot_password");
		// Submit a dummy email to simulate a password reset message
		driver.findElement(By.id("email")).sendKeys("test@example.com");
		driver.findElement(By.id("form_submit")).click();
		// Simulate success message (you can use a real one from your application)
		// Let's assume the new page has a paragraph like this:
		// "Your password reset link has been sent to your email. Use temporary
		// password: TempPass123"
		// For demo purposes, we are injecting such a message in a real test, this
		// should be in the DOM
		String fakeText = "Your password reset link has been sent to your email. Use temporary password: TempPass123";
		// Extract password
		String extractedPassword = extractPassword(fakeText);
		System.out.println("Extracted Password: " + extractedPassword);
		driver.quit();
	}

	// Separate method to extract password from a message
	public static String extractPassword(String text) {
		if (text.contains("temporary password:")) {
			return text.split("temporary password:")[1].trim();
		}
		return null;
	}

	private static void example1() {
		WebDriver driver = new ChromeDriver();
		try {
			// Open the Anudip LMS login page
			driver.get("https://aln.anudip.org/login/index.php");
			// Maximize the browser window
			driver.manage().window().maximize();
			// Set an implicit wait for elements to be found
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// Locate the Username field and enter the username
			WebElement usernameField = driver.findElement(By.cssSelector("input[id^='user']"));
			WebElement passwordField = driver.findElement(By.cssSelector("input[id*='pass']"));
			// Enter credentials (Replace with actual username and password)
			usernameField.sendKeys("thakur.khush@anudip.org");
			passwordField.sendKeys("password");
			// Click the Login button using CSS Selector
			WebElement loginButton = driver.findElement(By.cssSelector("button[id$='btn']"));
			loginButton.click();
			// Wait for a few seconds to observe the login action
			Thread.sleep(5000);
			// Validate login success by checking if the dashboard is loaded
			if (driver.getCurrentUrl().contains("dashboard")) {
				System.out.println("Login Successful!");
			} else {
				System.out.println("Login Failed! Check credentials.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}

	}

	private static void example2() {
		WebDriver driver = new ChromeDriver();

		try {
			// Open the Anudip LMS login page
			driver.get("https://aln.anudip.org/login/index.php");
			// Maximize the browser window
			driver.manage().window().maximize();
			// Set an implicit wait for elements to be found
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement usernameField = driver.findElement(By.cssSelector("input[id^='user']"));
			WebElement passwordField = driver.findElement(By.cssSelector("input[id*='pass']"));
			// Enter credentials (Replace with actual username and password)
			usernameField.sendKeys("AF0405273");
			passwordField.sendKeys("khus123");
			// Click the Login button using CSS Selector
			WebElement loginButton = driver.findElement(By.cssSelector("button[id$='btn']"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			loginButton.click();
			Thread.sleep(20);
			System.out.println(driver.findElement(By.tagName("p")));

			if (driver.getCurrentUrl().contains("dashboard")) {
				System.out.println("Login Successful!");
			} else {
				System.out.println("Login Failed! Check credentials.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			// driver.quit();
		}
	}

}
