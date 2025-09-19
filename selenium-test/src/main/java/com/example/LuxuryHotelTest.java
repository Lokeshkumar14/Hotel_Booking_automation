package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LuxuryHotelTest {

    public static void main(String[] args) {

        // Set up the Chrome WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize and set timeout
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open the hotel website
        driver.get("https://lokeshkumar14.github.io/Hotel-website/"); // OR http://localhost:8080

        try {
            // ✅ Test Navigation - Click Gallery link
            driver.findElement(By.cssSelector("a[data-section='gallery']")).click();
            Thread.sleep(3000); // Let transition happen

            // ✅ Test Booking Navigation
            driver.findElement(By.cssSelector("a[data-section='booking']")).click();
            Thread.sleep(3000);

            // ✅ Fill Booking Form
            driver.findElement(By.id("check-in")).sendKeys("01-10-2025");
            driver.findElement(By.id("check-out")).sendKeys("20-10-2025");

            driver.findElement(By.id("room-type")).sendKeys("Suite");
            driver.findElement(By.id("adults")).sendKeys("2");
            driver.findElement(By.id("children")).sendKeys("1");

            driver.findElement(By.id("name")).sendKeys("John Doe");
            driver.findElement(By.id("email")).sendKeys("john@example.com");
            driver.findElement(By.id("phone")).sendKeys("1234567890");
            driver.findElement(By.id("special-requests")).sendKeys("High floor, early check-in");

            // Submit the booking form
            driver.findElement(By.cssSelector("#booking-form button[type='submit']")).click();
            Thread.sleep(2000);
            try {
    Thread.sleep(1000); // wait briefly for alert
    driver.switchTo().alert().accept(); // Accept the alert
    System.out.println("✅ Alert handled successfully.");
} catch (InterruptedException e) {
    System.out.println("⚠️ No alert appeared or failed to handle alert: " + e.getMessage());
}


            // ✅ Navigate to Contact Section
            driver.findElement(By.cssSelector("a[data-section='contact']")).click();
            Thread.sleep(1000);

            // ✅ Fill Contact Form
            driver.findElement(By.id("contact-name")).sendKeys("Jane Smith");
            driver.findElement(By.id("contact-email")).sendKeys("jane@example.com");
            driver.findElement(By.id("contact-subject")).sendKeys("Inquiry");
            driver.findElement(By.id("contact-message")).sendKeys("Do you offer airport shuttle services?");
            driver.findElement(By.cssSelector("#contact-form button[type='submit']")).click();

            Thread.sleep(2000); // Wait to simulate user seeing submission feedback
            try {
    Thread.sleep(1000); // Optional: wait briefly for alert to appear
    driver.switchTo().alert().accept();
    System.out.println("✅ Contact form alert handled successfully.");
} catch (InterruptedException e) {
    System.out.println("⚠️ No contact form alert appeared or error handling it: " + e.getMessage());
}

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
