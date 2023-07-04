package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {



    @Before
    public void setup(){

        openBrowser();
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {

        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverOnElement(By.linkText("Desktops"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.linkText("Show AllDesktops"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> PRODUCTName = driver.findElements(By.xpath("//div[@class='caption']"));
        for (WebElement product :PRODUCTName){
            System.out.println(product.getText());
        }

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        mouseHoverOnElement(By.linkText("Desktops"));
        Thread.sleep(1000);
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.linkText("Show AllDesktops"));
        Thread.sleep(1000);
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");
        Thread.sleep(1000);
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Thread.sleep(1000);
        //2.5 Verify the Text "HP LP3065"
        verifyText(By.xpath("//h1[contains(text(),'HP LP3065')]"),"HP LP3065");
        Thread.sleep(1000);
        //2.6 Select Delivery Date "2011-04-22"
        driver.findElement(By.xpath("//input[@id='input-option225']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-option225']"),"2023-07-02");
        Thread.sleep(1000);
        //2.7.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        Thread.sleep(1000);
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(1000);
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyText(By.xpath("//div[text() ='Success: You have added ']"),"Success: You have added HP LP3065 to your shopping cart!\n×");
        Thread.sleep(1000);
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);
        //2.11 Verify the text "Shopping Cart"
        verifyText(By.xpath("//h1[contains(text(),' (1.00kg)')]"),"Shopping Cart  (1.00kg)");
        Thread.sleep(1000);
        //2.12 Verify the Product name "HP LP3065"
        verifyText(By.linkText("HP LP3065"),"HP LP3065");
        Thread.sleep(1000);
        //2.13 Verify the Delivery Date "2022-11-30"
        verifyText(By.xpath("//small[contains(text(),'Delivery Date:2023-07-02')]"),"Delivery Date:2023-07-02");
        Thread.sleep(1000);
        //2.14 Verify the Model "Product21"
         verifyText(By.xpath("//td[contains(text(),'Product 21')]"),"Product 21");
        Thread.sleep(1000);
        //2.15 Verify the Total "$122.00"
        verifyText(By.xpath("//tbody/tr[1]/td[6]"),"$122.00");
    }
    @After
    public void tearDown(){

        closeBrowser();
    }
}
