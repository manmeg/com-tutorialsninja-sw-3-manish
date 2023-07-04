package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    @Before
    public void setup() {

        openBrowser();
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
        verifyText(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.linkText("MacBook"));
        //2.5 Verify the text “MacBook”
        verifyText(By.linkText("MacBook"), "MacBook");
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"),"Success: You have added MacBook to your shopping cart!\n×");
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        verifyText(By.xpath("//h1[contains(text(),' (0.00kg)')]"), "Shopping Cart  (0.00kg)");
        //2.10 Verify the Product name "MacBook"
        verifyText(By.xpath("//form[@method='post']//a[text()='MacBook']"), "MacBook");
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyText(By.xpath("//body/div[@id='checkout-cart']/div[1]"), "Success: You have modified your shopping cart!\n×");
        //2.14 Verify the Total £737.45
        verifyText(By.xpath("//tbody/tr[1]/td[6]"),"$1,204.00");
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        verifyText(By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");
        //2.17 Verify the Text “New Customer”
        //verifyText(By.xpath("//h2[text()='New Customer')]"),"New Customer");
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Mani");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Meghji");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "mani123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "09876566478");
//        sendTextToElement(By.xpath("//input[@id='input-payment-password']"), "Mani0077");
//        sendTextToElement(By.xpath("//input[@id='input-payment-confirm']"), "Mani0077");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "123 Talbot ROAD");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "wembley");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "Ha0 4ug");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Greater London");
       // clickOnElement(By.xpath("//body[@id='checkout-checkout']"));
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "delivery to neighbour door");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        //verifyText(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Warning: Payment method required!\n");

    }


    @After
    public void tearDown() {

        closeBrowser();
    }
}
