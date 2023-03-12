package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ikarTestProbny {


    @BeforeTest
    public void prepareWebsite() {
        DriverAndWaits.driverSetUp();
        Before before = new Before();
        before.goToWebsite("https://uatikar.blachotrapez.eu/");
        before.logIn("t.kowalski@blachotrapez.com.pl", "QAZxswKS1@");
    }

    @Test(dataProvider = "inputData")
    public void makeOrder(String searchQuery) throws InterruptedException {
        TestMethods testMethods = new TestMethods();

        testMethods.chooseCustomer(searchQuery);

        //KONTRAHENT
        testMethods.checkCurrent("bdvCustomerBreadcrumb");
        testMethods.goNextStep();

        //DOSTAWA
        testMethods.checkCurrent("bdvDeliveryBreadcrumb");
        testMethods.goNextStep();

        //PROFIL
        testMethods.checkCurrent("bdvProfilesBreadcrumb");
        testMethods.goNextStep();

        //OBRÓBKI
        testMethods.checkCurrent("bdvProcessingProductsBreadcrumb");
        testMethods.goNextStep();

        //TOWARY HANDLOWE
        testMethods.checkCurrent("bdvCommodityGoodsBreadcrumb");
        testMethods.goNextStep();

        //USŁUGI
        testMethods.checkCurrent("bdvServicesBreadcrumb");
        testMethods.goNextStep();

        //SPRZEDAŻ 8%
        testMethods.checkCurrent("bdvEightPercentBreadcrumb");
        testMethods.goNextStep();

        //RABATY
        testMethods.checkCurrent("bdvDiscountsBreadcrumb");
        testMethods.goNextStep();

        //DODATKOWE INFORMACJE
        testMethods.checkCurrent("bdvAdditionalInformationsBreadcrumb");
        testMethods.goNextStep();

        //ZAŁĄCZNIKI
        testMethods.checkCurrent("bdvAttachmentsBreadcrumb");
        testMethods.saveAtachments();
        testMethods.goNextStep();

        //PODSUMOWANIE
        testMethods.checkCurrent("bdvSummaryBreadcrumb");


    }


    @AfterTest
    public void closeWebsite() throws InterruptedException {
        After after = new After();
        after.logOut();
        after.closeAndQuit();
    }

    @DataProvider(name = "inputData")
    public Object[][] provideData() {
        return new Object[][]{
                {"Jan Cygan"},
                {"Tomasz Nowak"},
                //{"Kacper Tader"},
                //{"Patrycja Wójciak"}
        };
    }
}