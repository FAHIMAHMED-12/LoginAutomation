package com.Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class UserLogin {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        maximize();
        open_website();
        //small_wait();
        //user_login();
        //chrome_close();
        //Dropdown();
        //Randominput();
        randominput2();

    }
    public static void chrome_launch(){

        System.setProperty("web-driver.chrome.driver","D:\\Automation\\Browsers\\chromedriver.exe");
        driver= new ChromeDriver();
    }
    public static void chrome_close(){
        driver.close();
    }
    public static void maximize(){
        driver.manage().window().maximize();
    }
    public static void small_wait() throws InterruptedException {
        Thread.sleep(3000);
    }
    public static void open_website(){

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");

    }
    public static void user_login(){
        WebElement UserId = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        UserId.sendKeys("fahimaks417@gmail.com");
        WebElement UserPassword = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        UserPassword.sendKeys("jsdjkskj");
        WebElement LoginButton = driver.findElement(By.name("login"));
        LoginButton.click();
        String u = driver.getCurrentUrl();
        if (u.equals("https://www.facebook.com/")){
            System.out.println("Test case Passed");
        }
        else {
            System.out.println("Test case Failed");
        }

    }
    public static void Dropdown(){

        WebElement createaccount= driver.findElement(By.xpath("//*[@id=\"pageFooterChildren\"]/ul/li[1]/a"));
        createaccount.click();
        WebElement selectelement = driver.findElement(By.xpath("//*[@id=\"day\"]"));
        Select selectday = new Select(selectelement);
        selectday.selectByIndex(30);
        WebElement selectelement2 = driver.findElement(By.xpath("//*[@id=\"month\"]"));
        Select month= new Select(selectelement2);
        month.selectByIndex(3);
    }
    public static void Randominput(){
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String values = Small_chars+numbers;
        int length = 7; // You can change the lenght of the random string as per your requirement
        //String values = numbers ;
        Random randomGenerator = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = randomGenerator.nextInt(values.length());

            // get character specified by index
            // from the string
            char randomChar = values.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        System.out.println("sb===="+sb.toString());

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(sb.toString()+"@gmail.com");

    }
    public static void randominput2(){
        Random rangenerator = new Random();
        int randomInt = rangenerator.nextInt(10000000);
        String simcode= "0191";
        System.out.println(simcode+randomInt);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(simcode+randomInt);

    }
}
