package com.anudip.org.lab4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WordToPdfAutomationFixed {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Use explicit waits instead of Thread.sleep
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // Step 1: Navigate to the site
            driver.get("https://www.ilovepdf.com/word_to_pdf");

            // Step 2: Upload the Word file
            WebElement uploadInput = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']"))
            );

            // Provide the absolute path of your .docx file
            String filePath = "C:\\Anudip\\QAT\\D1357-Notes\\Session1-Notes.docx"; // change path as per your file
            uploadInput.sendKeys(filePath);

            // Step 3: Wait for "Convert to PDF" button to appear
            WebElement convertButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("processTask"))
            );

            // Step 4: Click "Convert to PDF"
            convertButton.click();

            // Step 5: Wait for the download button (optional)
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pickfiles")));
            System.out.println("✅ Conversion started successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Optional delay to see result
            try { Thread.sleep(7000); } catch (InterruptedException ignored) {}
            driver.quit();
        }
    }
}

