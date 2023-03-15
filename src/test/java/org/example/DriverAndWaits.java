package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverAndWaits {
    protected static WebDriver driver;
    protected static WebDriverWait driverWait;

    private final File file = new File("C:\\Users\\Kamil\\IdeaProjects\\CHROME_DRIVER_JEST_TU\\chromedriver.exe");


    public void setDefaultImplicitlyWaits() {
        setImplicitlyWaits(20_000);
    }

    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", file.getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        setDefaultImplicitlyWaits();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void setImplicitlyWaits(int milliseconds) {
        driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
    }

    public void waitForElementClickable(By locator) {
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
    }
    public void waitForLoaderToBeInvisible() {
        WebElement Loader = driver.findElement(By.id("mLoader"));
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(Loader)));
    }
    public void waitForPageFullyLoaded() {
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }
    public void waitForPageToChange(String UrlToBeDiffrentFrom)  {
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.not(ExpectedConditions.urlToBe(UrlToBeDiffrentFrom)));
    }
    public void waitForPageToBe(String DestinyUrl) {
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.urlToBe(DestinyUrl));
    }
    public void waitForElementToBeDisplayed(String id) {
        WebElement element = driver.findElement(By.id(id));
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForTextOnElementToBe(By locator, String text) {
        driverWait.ignoring(StaleElementReferenceException.class).withTimeout(Duration.ofSeconds(30))
                .until(ExpectedConditions.textToBe(locator, text));
    }
}
