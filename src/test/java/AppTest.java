package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    //1
    @Test
    public void studentNameTest() throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("registerBtn")).click();
        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        //driver.quit();
        Assert.assertEquals(value, "Student name is required");
        driver.quit();
    }

    //2
    @Test
    public void emailTest() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("studentName")).sendKeys("abc");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Email is required");
        driver.quit();
    }

    //3
    @Test
    public void invalidEmailTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("email")).sendKeys("abc");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("registerBtn")).click();
        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Invalid email format");
        driver.quit();
    }

    //4
    @Test
    public void mobileNumberTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("mobile")).sendKeys("12345");
        driver.findElement(By.id("email")).sendKeys("abc15@gmail.com");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Mobile number should be exactly 10 digits");
        driver.quit();
    }

    //5
    @Test
    public void GenderTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("mobile")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("abc15@gmail.com");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Gender is required");
        driver.quit();
    }

    //6
    @Test
    public void DepartmentTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("mobile")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("abc15@gmail.com");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Department is required");
        driver.quit();
    }

    //7
    @Test
    public void invalidPasswordTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("mobile")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("abc15@gmail.com");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("department"));
        new Select(driver.findElement(By.id("department"))).selectByValue("CSE");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Password should be minimum 8 characters");

        driver.quit();
    }

    //8
    @Test
    public void confirmPasswordTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("password")).sendKeys("12345789");
        driver.findElement(By.id("confirmPassword")).sendKeys("54321");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("mobile")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("abc15@gmail.com");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("department"));
        new Select(driver.findElement(By.id("department"))).selectByValue("CSE");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Password and confirm password should match");

        driver.quit();
    }

    //9
    @Test
    public void termsandconditionsTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("password")).sendKeys("12345789");
        driver.findElement(By.id("confirmPassword")).sendKeys("12345789");
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("mobile")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("abc15@gmail.com");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("department"));
        new Select(driver.findElement(By.id("department"))).selectByValue("CSE");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Please accept terms and conditions");

        driver.quit();
    }

    //10
    @Test
    public void registrationTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Rineesha/Downloads/index.html");

        driver.findElement(By.id("password")).sendKeys("12345789");
        driver.findElement(By.id("confirmPassword")).sendKeys("12345789");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("male")).click();
        driver.findElement(By.id("mobile")).sendKeys("1234567890");
        driver.findElement(By.id("email")).sendKeys("abc15@gmail.com");
        driver.findElement(By.id("studentName")).sendKeys("Abc");
        driver.findElement(By.id("department"));
        new Select(driver.findElement(By.id("department"))).selectByValue("CSE");
        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(3000);
        String value = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(value, "Registration successful");

        driver.quit();
    }
    
}
