package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;


public class Before extends DriverAndWaits {
    public void goToWebsite(String url) {
        System.out.println("PRZECHODZIMY NA STRONE");
        driver.navigate().to(url);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Weszlismy na strone: " + title);
        Assert.isTrue(title.equals("Blachotrapez Ikar"), "TYTUL STRONY SIE NIE ZGADZA");
        System.out.println("Tytul strony jest odpowiedni");
    }
    public void logIn(String email, String password) {
        System.out.println("ROZPOCZYNAMY LOGOWANIE");
        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[2]/div/m-pre-auth/div/form/div[3]")).click();
        driver.findElement(By.id("bdvUserNameInput")).sendKeys(email);
        driver.findElement(By.id("bdvPasswordInput")).sendKeys(password);
        driver.findElement(By.id("bdvSubmitBtn")).click();
    }
}

