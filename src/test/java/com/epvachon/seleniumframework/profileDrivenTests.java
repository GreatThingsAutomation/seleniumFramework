package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest
@Slf4j
class profileDrivenTests extends BaseTest {

    private final String baseUrl;

    public profileDrivenTests(@Value("${baseUrl}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @ParameterizedTest(name = "Profile determined Chrome - {0}")
    @ValueSource(strings = {"cheese", "crackers"})
    void chromeTest(String searchTerm) {
      log.debug("In {}} Home Page Test", baseUrl);
        RemoteWebDriver webDriver = chrome.getWebDriver();
        webDriver.get(baseUrl);
        WebElement searchInput = webDriver.findElement(By.xpath("//input[@name='q' | @id='search_form_input_homepage']"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
        assertTrue(webDriver.getPageSource().contains(searchTerm));
    }


    @ParameterizedTest(name = "Profile determined Firefox - {0}")
    @ValueSource(strings = {"cheese", "crackers"})
    void fireFoxTest(String searchTerm) {
        log.debug("In {}} Home Page Test", baseUrl);
        RemoteWebDriver webDriver = firefox.getWebDriver();
        webDriver.get(baseUrl);
        WebElement searchInput = webDriver.findElement(By.xpath("//input[@name='q' | @id='search_form_input_homepage']"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
        assertEquals(searchTerm, webDriver.getTitle());
        assertTrue(webDriver.getPageSource().contains(searchTerm));
    }

}
