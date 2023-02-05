package com.Login;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Daraz_test{
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        //TC_01();
        //chrome_launch();
        //TC_02();
        //chrome_launch();
        //TC_03();
        //chrome_launch();
        //TC_04();
        //chrome_launch();
        TC_05();

    }

    public static void chrome_launch(){
        System.setProperty("web-driver.chrome.driver","D:\\Automation\\Browsers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void TC_01() throws InterruptedException {
        driver.get("https://www.daraz.com.bd/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"anonLogin\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/input")).sendKeys("01623721118");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[2]/input")).sendKeys("Daraz12");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[2]/div[1]/button")).click();
        Thread.sleep(3000);
        String url= driver.getCurrentUrl();
        System.out.println(url);
        if (url.equals("https://www.daraz.com.bd/")){
            System.out.println("TC_01: Pass");
        }
        else{
            System.out.println("TC_01: Fail");
        }
        driver.close();



    }
    public static void TC_02(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.daraz.com.bd/");
        driver.findElement(By.xpath("//*[@id=\"anonLogin\"]/a")).click();
        //driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/input")).sendKeys("sds");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[2]/div[1]/button")).click();
        String error=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/span")).getText();
        System.out.println(error);
        String expected= "You can't leave this empty.";
        if (error.equals(expected)){
            System.out.println("TC_002: Pass");

        }
        else{
            System.out.println("TC_002: Fail");
        }
        driver.close();
    }
    public static void TC_03(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.daraz.com.bd/");
        driver.findElement(By.xpath("//*[@id=\"anonLogin\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/input")).sendKeys("hyuwb@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[2]/div[1]/button")).click();
        String error = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[2]/span")).getText();
        String expected= "You can't leave this empty.";
        if (error.equals(expected)){
            System.out.println("TC_003: Pass");

        }
        else{
            System.out.println("TC_003: Fail");
        }
        driver.close();

    }
    public static void TC_04(){
        driver.get("https://www.daraz.com.bd/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"anonLogin\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/input")).sendKeys("asd@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[2]/input")).sendKeys("21223");
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[2]/div[1]/button")).click();
        String error_content = driver.findElement(By.className("next-feedback-content")).getText();
        String expected= "Incorrect username or password.";
        System.out.println(error_content);
        if (error_content.equals(expected)){
            System.out.println("TC_04: Pass");
        }
        else{
            System.out.println("TC_04: Fail");
        }
        driver.close();
    }
    public static void TC_05(){
        driver.get("https://www.daraz.com.bd/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"anonLogin\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/input")).sendKeys("asd");
        String Length_msg= driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/form/div/div[1]/div[1]/span")).getText();
        System.out.println(Length_msg);
        String excpected_msg="The length of the Phone or Email should be 6-60 characters.";
        if (Length_msg.equals(excpected_msg)){
            System.out.println("TC_05: Pass");
        }
        else{
            System.out.println("TC_05: Fail");
        }
        driver.close();


    }

    public static void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
