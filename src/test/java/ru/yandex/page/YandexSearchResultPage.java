package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YandexSearchResultPage {
    private WebDriver driver;

    @FindAll
    (@FindBy(css = "#search-result > li"))
    List<WebElement> links;

    public YandexSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int countResults(){
        return listOfLinks().size();
    }

    public boolean findWikiLink() {
        return listOfLinks().stream().anyMatch(x->x.getText().contains("Шпажник — Википедия"));
    }

    private List<WebElement> listOfLinks(){
        return links;
    }
}
