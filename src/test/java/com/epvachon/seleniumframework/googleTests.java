package com.epvachon.seleniumframework;

import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@Slf4j
class googleTests {

    @Container
    //docker pull selenium/standalone-chrome
    public GenericContainer chrome = new GenericContainer(DockerImageName.parse("selenium/standalone-chrome"))
            .withExposedPorts(4444);

    @Rule
    public BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions());

//    @Rule
//public BrowserWebDriverContainer<?> chrome = new BrowserWebDriverContainer<>()
//    .withCapabilities(new ChromeOptions())

    @BeforeEach
    public void setUp() {
        String host = chrome.getHost();
        Integer port = chrome.getFirstMappedPort();

        // Now we have an host and port for Redis, no matter where it is running
        log.debug("host: {}, port: {}", host, port);
    }


    @Test
    void googleHomePage() {
      log.debug("In Google Home Page Test");
        RemoteWebDriver driver = chrome.getWebDriver();
    }
}
