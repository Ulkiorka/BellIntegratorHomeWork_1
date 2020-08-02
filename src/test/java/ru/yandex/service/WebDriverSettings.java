package ru.yandex.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    protected WebDriver driver;

    @BeforeEach
    public void browserSetUp(){
//        WebDriverManager.chromedriver().setup();

//        System.setProperty("webdriver.chrome.driver","C:\\temp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
