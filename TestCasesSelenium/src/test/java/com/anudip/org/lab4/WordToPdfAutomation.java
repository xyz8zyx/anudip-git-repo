package com.anudip.org.lab4;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WordToPdfAutomation {
    public static void main(String[] args) {
        // Set path for ChromeDriver (update this path according to your system)
        //System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        try {
            // Step 1: Navigate to ilovepdf Word to PDF page
            driver.get("https://www.ilovepdf.com/word_to_pdf");

            // Step 2: Locate the file upload input field
            WebElement uploadBtn = driver.findElement(By.id("pickfiles"));
            System.out.println(uploadBtn.getText()+ " AND "+uploadBtn);
            
            // Step 3: Upload your Word file (provide the absolute file path)
            String filePath = "C:\\Anudip\\QAT\\D1357-Notes\\Session1-Notes.docx";  // <-- change this path
            uploadBtn.sendKeys(filePath);
            System.out.println("***********Line passed**************");

            // Step 4: Wait a few seconds for upload to complete
            Thread.sleep(10000);

            // Step 5: Click on the "Convert to PDF" button
            WebElement convertBtn = driver.findElement(By.xpath("//button[@id='processTask']"));
            System.out.println(convertBtn.getText()+ " AND "+convertBtn);
            convertBtn.click();

            // Step 6: Wait for conversion and download link to appear
            Thread.sleep(10000); // wait for processing (adjust if needed)

            // Optional Step 7: Click on "Download PDF" button (auto download starts)
            // You can skip this if browser auto-downloads the file
            WebElement downloadBtn = driver.findElement(By.id("pickfiles"));
            System.out.println("Conversion initiated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser after a delay (optional)
            try { Thread.sleep(5000); } catch (InterruptedException ignored) {}
            driver.quit();
        }
    }
}
