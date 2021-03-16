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
class duckduckgoTests {

    @Container
    //docker pull selenium/standalone-chrome
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions());

    @BeforeEach
    public void setUp() {
        String host = chrome.getHost();
        Integer port = chrome.getFirstMappedPort();

        // Now we have an host and port for Redis, no matter where it is running
        log.debug("host: {}, port: {}", host, port);
    }


    @Test
    void duckDuckGoHomePage() {
      log.debug("In DuckDuckGo Home Page Test");
        RemoteWebDriver webDriver = chrome.getWebDriver();
        webDriver.get("https://www.duckduckgo.com");
        assertTrue(webDriver.getTitle().contains("Duck"));
    }
}
