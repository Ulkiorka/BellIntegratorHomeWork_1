package ru.yandex.test;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ru.yandex.service.Utils;

import java.util.List;
import java.util.Map;


public class Steps {

    @Step("Шаг 1. Проверка наличия более чем 3 результатов")
    public static void checkMoreThanThreeResults(List<Map<String, Object>>resultSearch,WebDriver driver){
        int count = 3;
        if(resultSearch.size() > count){
            Assertions.assertTrue(true);
        }
        else {
            Utils.getScreen(driver);
            Assertions.assertTrue(false,"Amount of search results less than "+ (count+1) );
        }
    }


    @Step("Шаг2. Проверка наличия ссылки на википедию")
    public static void checkLinkOnWikipedia(List<Map<String, Object>>resultSearch, WebDriver driver){
        if (resultSearch.stream().anyMatch(x->x.get("URL").toString().contains("ru.wikipedia.org"))){
            Assertions.assertTrue(true);
        }
        else{
            Utils.getScreen(driver);
            Assertions.assertTrue(false,"There is no link to Wikipedia");
        }
    }
}
