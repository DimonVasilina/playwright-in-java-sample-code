package com.serenitydojo.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ASimplePlaywrightTest {

    @Test
    void shouldShowThePageTitle() {
        // TODO: Write your first playwright test here

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://practicesoftwaretesting.com/");

        String title = page.title();

        Assertions.assertTrue(title.contains("Practice Software Testing"));

        browser.close();
        playwright.close();
    }

    @Test
    void shouldSearchByKeyword () {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();

        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("//input[@id='search-query']").fill("pliers");
        page.locator("//button[@type='submit']").click();

        int countOfCardBySearchResult = page.locator("//a[@class='card']").count();
        System.out.println("countOfCardBySearchResult = " + countOfCardBySearchResult);

        Assertions.assertTrue(countOfCardBySearchResult > 0, "search doesn't have result");

        page.close();
        browser.close();

    }
}
