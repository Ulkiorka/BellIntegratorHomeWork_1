package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {
    private WebDriver driver;
    private final String GOOGLE_LINK = "http://google.ru";

    private String searchField = "//input[@name='q']";

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public GooglePage openPage(){
        driver.get(GOOGLE_LINK);
        return this;
    }

    public GoogleSearchPage findWord(String name){
        driver.findElement(By.xpath(searchField)).sendKeys(name);
        driver.findElement(By.xpath(searchField)).sendKeys(Keys.ENTER);
        return new GoogleSearchPage(driver);
    }
}
