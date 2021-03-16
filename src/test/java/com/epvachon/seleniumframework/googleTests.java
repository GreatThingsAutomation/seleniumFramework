package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@Slf4j
class googleTests extends BaseTest {


    @Test
    void googleHomePage() {
      log.debug("In Google Home Page Test");
        RemoteWebDriver webDriver = chrome.getWebDriver();
        webDriver.get("https://www.google.com");
        assertTrue(webDriver.getTitle().contains("Google"));
    }
}
