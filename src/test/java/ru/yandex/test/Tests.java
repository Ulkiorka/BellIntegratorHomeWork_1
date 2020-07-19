package ru.yandex.test;

import ru.yandex.page.YandexPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings{

    @Test
    public void hasMoreThanThreeResults(){
        int results = new YandexPage(driver)
                .openPage()
                .findWord("гладиолус")
                .countResults();
        Assertions.assertTrue(results > 3, "Amount of search results less than 4");
    }

    @Test
    public void hasLinkOnWikipedia(){
        boolean linkIsPresent = new YandexPage(driver)
                .openPage()
                .findWord("гладиолус")
                .findWikiLink();
        Assertions.assertTrue(linkIsPresent);
    }
}
