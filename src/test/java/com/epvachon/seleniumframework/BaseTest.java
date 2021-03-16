package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Slf4j
@Testcontainers
public class BaseTest {

    @Container
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions());
    @Container
    public BrowserWebDriverContainer firefox = new BrowserWebDriverContainer<>()
            .withCapabilities(new FirefoxOptions());
    @Container
    public BrowserWebDriverContainer edge = new BrowserWebDriverContainer()
            .withCapabilities(new EdgeOptions());


    @BeforeEach
    public void setUp() {
        chrome.start();
        firefox.start();
        edge.start();
    }

    @AfterEach
    public void tearDown() {
        chrome.stop();
        firefox.stop();
        edge.stop();
    }
}
