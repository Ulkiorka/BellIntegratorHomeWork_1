package ru.yandex.test;

import io.qameta.allure.Description;
import ru.yandex.page.GoogleSearchPage;
import org.junit.jupiter.api.Test;
import ru.yandex.service.WebDriverSettings;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings {

    @Test
    @Description(value = "Тест поиска гладиолуса")
    public void test1532919(){
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver, "Гладиолус");
        List<Map<String,Object>> resultSearch = googleSearchPage.getCollectResults();
        Steps.checkMoreThanThreeResults(resultSearch,  driver);
        Steps.checkLinkOnWikipedia(resultSearch,  driver);
    }
}
