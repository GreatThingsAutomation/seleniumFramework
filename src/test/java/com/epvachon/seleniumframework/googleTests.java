package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest
@Slf4j
class googleTests extends BaseTest {

    @Test
    @DisplayName("Google Home Page")
    void googleHomePage() {
      log.debug("In Google Home Page Test");
        RemoteWebDriver webDriver = chrome.getWebDriver();
        webDriver.get("https://www.google.com");
        assertTrue(webDriver.getTitle().contains("Google"));
    }
}
