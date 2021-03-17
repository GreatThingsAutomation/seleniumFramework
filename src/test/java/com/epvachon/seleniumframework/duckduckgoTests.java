package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@Slf4j
class duckduckgoTests extends BaseTest {

    @Test
    @DisplayName("DuckDuckGo Home Page")
    void duckDuckGoHomePage() {
      log.debug("In DuckDuckGo Home Page Test");
        RemoteWebDriver webDriver = chrome.getWebDriver();
        webDriver.get("https://www.duckduckgo.com");
        assertTrue(webDriver.getTitle().contains("Duck"));
    }
}
