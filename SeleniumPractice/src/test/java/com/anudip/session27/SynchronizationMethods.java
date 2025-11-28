package com.anudip.session27;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationMethods {

	public static void main(String[] args) throws InterruptedException {
		//implicitWait();
		//explicitWait();
		//explicitWaitExample();
		fluentWait();
	}

	private static void fluentWait() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		WebElement link = wait1.until(new Function<WebDriver, WebElement>() {
//
//			@Override
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"));
//			}
//		});
		
		WebElement link = wait1.until(d->d.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")));
		link.click();
	}

	private static void explicitWaitExample() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")));
		link.click();
		
		for (String handle : driver.getWindowHandles()) {
			System.out.println(handle);
		    driver.switchTo().window(handle);
		}
		
		//WebElement contactSales = driver.findElement(By.linkText("Contact Sales"));
		//WebElement contactSales = driver.findElement(By.xpath("//button[contains(text(),'Contact Sales')]"));
		WebElement contactSales = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contact Sales")));
		contactSales.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//input[@id='Form_getForm_FullName']"))).sendKeys("Sandeep Singh");
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//input[@id='Form_getForm_Email']"))).sendKeys("sandeep.singh@anudip.org");
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//input[@id='Form_getForm_Contact']"))).sendKeys("8286150733");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		
	}

	/*
	 * //private static void explicitWait() { WebDriver driver = new ChromeDriver();
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 * driver.get(
	 * "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 * 
	 * WebElement userElement =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated
	 * (By.xpath("//input[@placeholder='Username']")));
	 * userElement.sendKeys("Admin"); WebElement userPass =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated
	 * (By.xpath("//input[@placeholder='Password']")));
	 * userPass.sendKeys("admin123"); WebElement login =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated
	 * (By.xpath("//button[normalize-space()='Login']"))); login.click(); }
	 */
	private static void explicitWait() {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));		
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		password.sendKeys("admin123");
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		submitButton.click();
	}
	
	
	
	

	private static void implicitWait() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
	}

}
