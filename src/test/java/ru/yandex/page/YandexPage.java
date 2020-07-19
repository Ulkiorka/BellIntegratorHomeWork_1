package ru.yandex.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPage {
    private WebDriver driver;
    private final String YANDEX_LINK = "http://yandex.ru";

    @FindBy (css = ".input__control.input__input")
    WebElement searchField;

    public YandexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YandexPage openPage(){
        driver.get(YANDEX_LINK);
        return this;
    }

    public YandexSearchResultPage findWord(String name){
        searchField.sendKeys(name);
        searchField.sendKeys(Keys.ENTER);
        return new YandexSearchResultPage(driver);
    }


}
