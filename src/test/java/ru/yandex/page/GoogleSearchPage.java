package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class GoogleSearchPage {
    private WebDriver driver;

    private final String selectorItemsList="//div[@class='g']";
    private final String selectorURL = ".//div[@class='r']/a[@href]";
    private final String selectorNamePage = ".//div[@class='r']/a[@href]";

    private List<WebElement> searchItems;
    private List<Map<String,Object>> collectResults = new ArrayList<>();

    public GoogleSearchPage(WebDriver driver){
        this.driver=driver;
        searchItems =driver.findElements(By.xpath(selectorItemsList));
    }

    public GoogleSearchPage(WebDriver driver, String search){
        this.driver=driver;
        this.driver.get("https://www.google.ru/search?q="+search);
        searchItems = driver.findElements(By.xpath(selectorItemsList));
    }

    public List<Map<String, Object>> getCollectResults() {
        for(WebElement result : searchItems){
            collectResults.add(Map.of(
                    "WEB_ELEMENT", result,
                    "URL", result.findElement(By.xpath(selectorURL)).getAttribute("href"),
                    "NAME_PAGE", result.findElement(By.xpath(selectorNamePage)).getText()
            ));
        }
        return collectResults;
    }

}
