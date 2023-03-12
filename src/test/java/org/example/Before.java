package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;


public class Before extends WebElements {

    public void logIn(String email, String password) {
        driver.findElement(By.cssSelector("#m_login > div.m-grid__item.m-grid__item--fluid.m-grid__item--order-tablet-and-mobile-1.m-login__wrapper > div > m-pre-auth > div > form > div:nth-child(3)")).click();
        driver.findElement(By.id("bdvUserNameInput")).sendKeys(email);
        driver.findElement(By.id("bdvPasswordInput")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"bdvSubmitBtn\"]/button")).click();
    }
    public void goToWebsite() {
        driver.navigate().to(WebSiteURL);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Tytul strony to: " + title);
        Assert.isTrue(title.equals("Blachotrapez Ikar"), "TYTUL STRONY SIE NIE ZGADZA");
    }
    public void goToWebsite(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Tytul strony to: " + title);
        Assert.isTrue(title.equals("Blachotrapez Ikar"), "TYTUL STRONY SIE NIE ZGADZA");
    }
}

