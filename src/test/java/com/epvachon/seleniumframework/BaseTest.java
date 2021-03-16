package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Slf4j
@Testcontainers
public class BaseTest {

    ChromeOptions chromeOptions = new ChromeOptions()
            .setHeadless(true)
            .setAcceptInsecureCerts(true)
            .addArguments("start-maximized")
            .addArguments("incognito");

    FirefoxOptions firefoxOptions = new FirefoxOptions()
            .setAcceptInsecureCerts(true)
            .setHeadless(true)
            .addArguments("start-maximized")
            .addArguments("private-browsing")
            .setLogLevel(FirefoxDriverLogLevel.DEBUG);

    EdgeOptions edgeOptions = new EdgeOptions();

    @Container
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(chromeOptions);
    @Container
    public BrowserWebDriverContainer firefox = new BrowserWebDriverContainer<>()
            .withCapabilities(firefoxOptions);
    @Container
    public BrowserWebDriverContainer edge = new BrowserWebDriverContainer()
            .withCapabilities(edgeOptions);


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
