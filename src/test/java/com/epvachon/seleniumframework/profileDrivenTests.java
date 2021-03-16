package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@Slf4j
class profileDrivenTests extends BaseTest {

    private final String baseUrl;
    private final String searchTerm;

    public profileDrivenTests(@Value("${baseUrl}") String baseUrl,
                              @Value("${searchTerm}")String searchTerm) {
        this.baseUrl = baseUrl;
        this.searchTerm = searchTerm;
    }


    @Test
    @DisplayName("Profile determined Chrome")
    void searchEngineHomePage() {
      log.debug("In {}} Home Page Test", baseUrl);
        RemoteWebDriver webDriver = chrome.getWebDriver();
        webDriver.get(baseUrl);
        WebElement searchInput = webDriver.findElement(By.xpath("//*[@id='search_form_input_homepage'] or //input"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
        assertEquals(searchTerm, webDriver.getTitle());
    }


    @Test
    @DisplayName("Profile determined Firefox")
    void searchEngineFireFoxHomePage() {
        log.debug("In {}} Home Page Test", baseUrl);
        RemoteWebDriver webDriver = firefox.getWebDriver();
        webDriver.get(baseUrl);
        WebElement searchInput = webDriver.findElement(By.xpath("//*[@id='search_form_input_homepage'] or //input"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
        assertEquals(searchTerm, webDriver.getTitle());
    }


    @Test
    @DisplayName("Profile determined Edge")
    void searchEngineEdgeHomePage() {
        log.debug("In {}} Home Page Test", baseUrl);
        RemoteWebDriver webDriver = edge.getWebDriver();
        webDriver.get(baseUrl);
        WebElement searchInput = webDriver.findElement(By.xpath("//*[@id='search_form_input_homepage'] or //input"));
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
        assertEquals(searchTerm, webDriver.getTitle());
    }

}
