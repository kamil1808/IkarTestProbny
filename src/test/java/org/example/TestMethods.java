package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestMethods extends WebElements {

    public void goNextStep() {
        waitForElementClickable(By.id("bdvOrderNextStep"));
        waitForLoaderToBeInvisible();
        driver.findElement(By.id("bdvOrderNextStep")).click();
    }

    public void checkCurrent(String elementId) {

        waitForLoaderToBeInvisible();
        WebElement zakladka = driver.findElement(By.id(elementId));
        String CurrentCSSClass = zakladka.getAttribute("class");
        System.out.println("Jestesmy przy zakladce " + zakladka.getText());
        waitForLoaderToBeInvisible();
        Assert.isTrue(CurrentCSSClass.equals("current"), "OBECNA ZAKLADKA NIE PODSWIETLONA");
    }

    public void chooseCustomer(String kontrahent) throws InterruptedException {
        waitForPageFullyLoaded();
        driver.findElement(By.xpath("//*[@id=\"m_ver_menu\"]/ul/li[7]")).click();
        driver.findElement(By.xpath("//*[@id=\"m_ver_menu\"]/ul/li[7]/div/ul/li[2]")).click();
        waitForPageFullyLoaded();
        driver.findElement(By.id("bdvOpenSelectCustomerDialog")).click();

        //waitForLoaderToBeInvisible();

        driver.findElement(By.id("bdvSearchCustomersList")).sendKeys(kontrahent);

        Thread.sleep(3000);
        //waitForLoaderToBeInvisible();
        //waitForElementClickable(By.id("bdvCheckCustomer0"));

        driver.findElement(By.id("bdvCheckCustomer0")).click();

        //Assert.isTrue(driver.findElement(By.id("bdvCheckCustomer0")).isSelected(), "NIE WYBRANO POPRAWNEJ OSOBY");
        driver.findElement(By.id("bdvCustomerDialogApply0")).click();
    }

    public void clickSaveButton() {
        waitForElementClickable(By.id("bdvSaveOrder"));
        driver.findElement(By.id("bdvSaveOrder")).click();
        waitForLoaderToBeInvisible();
    }
}
