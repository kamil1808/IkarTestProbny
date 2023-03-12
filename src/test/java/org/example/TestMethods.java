package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestMethods extends WebElements {

    public void goNextStep() {
        waitForElementClickable(By.id("bdvOrderNextStep"));
        waitForLoader();
        driver.findElement(By.id("bdvOrderNextStep")).click();
    }

    public void checkCurrent(String elementId) {

        waitForLoader();
        WebElement zakladka = driver.findElement(By.id(elementId));
        String CurrentCSSClass = zakladka.getAttribute("class");
        System.out.println("Jestesmy przy zakladce " + zakladka.getText());
        waitForLoader();
        Assert.isTrue(CurrentCSSClass.equals("current"), "OBECNA ZAKLADKA NIE PODSWIETLONA");
    }

    public void chooseCustomer(String kontrahent) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"m_ver_menu\"]/ul/li[7]")).click();
        driver.findElement(By.xpath("//*[@id=\"m_ver_menu\"]/ul/li[7]/div/ul/li[2]")).click();

        driver.findElement(By.id("bdvOpenSelectCustomerDialog")).click();
        driver.findElement(By.id("bdvSearchCustomersList")).sendKeys(kontrahent);
        waitForElementClickable(By.id("bdvCheckCustomer0"));

        Thread.sleep(3000); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        driver.findElement(By.id("bdvCheckCustomer0")).click();
        //Assert.isTrue(driver.findElement(By.id("bdvCheckCustomer0")).isSelected(), "NIE WYBRANO POPRAWNEJ OSOBY");
        driver.findElement(By.id("bdvCustomerDialogApply0")).click();
    }

    public void saveAtachments() {
        waitForElementClickable(By.id("bdvSaveOrder"));
        driver.findElement(By.id("bdvSaveOrder")).click();
    }
}
