package com.finance;

import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class FinanceTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://finance.i.ua/");
    }

    @Test
    public void buyCurrency(){
        String expectedResult="49 618,15";
        driver.findElement(By.xpath("//li[2]/i/span")).click();
        driver.findElement(By.id("fn_s1")).sendKeys("2000");
        WebElement rate = driver.findElement(By.xpath(".//*[@id='fn_bank']/option[21]"));
//        rate.click();
        Select rateSelect= new Select(rate);
        rateSelect.selectByVisibleText("НБУ");
        Assert.assertEquals(expectedResult,driver.findElement(By.id("fn_o1_1")).getText());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
