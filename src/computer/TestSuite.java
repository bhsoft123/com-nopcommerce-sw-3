package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;


    public class TestSuite extends Utility {
        String baseUrl = "https://demo.nopcommerce.com/";

        @Before
        public void setUp() {
            openBrowser(baseUrl);
        }

        @Test
        public void verifyProductArrangeInAlphaBaticalOrder() {

            //1.1 Click on Computer Menu.
            clickOnElement(By.xpath("//a[@href='/computers']"));

            //1.2 Click on Desktop
            clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

            //1.3 Select Sort By position "Name: Z to A"
            selectByVisibleTextFromDropdown(By.name("products-orderby"), "Name: Z to A");

            //1.4 Verify the Product will arrange in Descending order.
            verifyElements("error", "Name: Z to A", By.xpath("//option[contains(text(),'Name: Z to A')]"));
        }

        @Test
        public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

            //2.1 Click on Computer Menu.
            clickOnElement(By.xpath("//a[@href='/computers']"));

            //2.2 Click on Desktop
            clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));

            //2.3 Select Sort By position "Name: A to Z"
            selectByVisibleTextFromDropdown(By.name("products-orderby"), "Name: A to Z");
            Thread.sleep(1000);

            //2.4 Click on "Add To Cart"
            clickOnElement(By.xpath("(//button[@type='button'][normalize-space()='Add to cart'])[1]"));
            Thread.sleep(1000);
            //2.5 Verify the Text "Build your own computer"
            verifyElements("error", "Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));
            //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
            selectByVisibleTextFromDropdown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
            //2.7 Select "8GB [+$60.00]" using Select class.
            selectByVisibleTextFromDropdown(By.id("product_attribute_2"), "8GB [+$60.00]");
            //2.8 Select HDD radio "400 GB [+$100.00]"
            clickOnElement(By.id("product_attribute_3_7"));
            //2.9 Select OS radio "Vista Premium [+$60.00]"
            clickOnElement(By.id("product_attribute_4_9"));
            Thread.sleep(1000);
            //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
            clickOnElement(By.id("product_attribute_5_12"));
            //2.11 Verify the price "$1,475.00"
            Thread.sleep(1000);
            verifyElements("error", "$1,470.00", By.id("price-value-1"));
            //2.12 Click on "ADD TO CARD" Button.
            clickOnElement(By.id("add-to-cart-button-1"));
            //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
            verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
            clickOnElement(By.xpath("//span[@title='Close']"));
            Thread.sleep(1000);
            //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
            mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
            clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
            Thread.sleep(1000);
            //2.15 Verify the message "Shopping cart"
            verifyElements("error", "shopping cart", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
            Thread.sleep(2000);
            //2.16 Change the Qty to "2" and Click on "Update shopping cart"
            clickOnElement(By.id("updatecart"));
            WebElement quantity = driver.findElement(By.xpath("//td[@class=\"quantity\"]/child::input"));
            quantity.clear();
            quantity.sendKeys("2");
            Thread.sleep(2000);
            //2.17 Verify the Total"$2,950.00"
            verifyElements("error", "$2,950.00", By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"));
            //2.18 click on checkbox “I agree with the terms of service”
            clickOnElement(By.id("termsofservice"));
            //2.19 Click on "CHECKOUT"
            clickOnElement(By.id("checkout"));
            //2.20 Verify the Text “Welcome, Please Sign In!”
            verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
            //2.21 Click on “CHECKOUT AS GUEST” Tab
            clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
            //2.22 Fill the all mandatory field
            sendTextToElement(By.id("BillingNewAddress_FirstName"), "Orange");
            sendTextToElement(By.id("BillingNewAddress_LastName"), "Purple");
            sendTextToElement(By.id("BillingNewAddress_Email"), "orangepurple@gmail.com");
            sendTextToElement(By.id("BillingNewAddress_Company"), "Dhl ltd");
            selectByVisibleTextFromDropdown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
            sendTextToElement(By.id("BillingNewAddress_City"), "london");
            sendTextToElement(By.id("BillingNewAddress_Address1"), "14A High Street");
            sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "aa39bb");
            sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "1234567890");
            //2.23 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
            // 2.24 Click on Radio Button “Next Day Air($0.00)”
            clickOnElement(By.id("shippingoption_1"));
            //2.25 Click on “CONTINUE”
            clickOnElement(By.xpath("(//button[@class='button-1 shipping-method-next-step-button'])[1]"));
            //2.26 Select Radio Button “Credit Card”
            clickOnElement(By.className("payment-logo"));
            //2.27 Select “Master card” From Select credit card dropdown
            selectByVisibleTextFromDropdown(By.id("CreditCardType"), "Visa");
            //2.28 Fill all the details
            sendTextToElement(By.id("CardholderName"), "Orange");
            sendTextToElement(By.id("CardNumber"), "1645123456121212");
            selectByVisibleTextFromDropdown(By.id("ExpireMonth"), "02");
            selectByVisibleTextFromDropdown(By.id("ExpireYear"), "2023");
            sendTextToElement(By.id("CardCode"), "231");
            //2.29 Click on “CONTINUE”
            clickOnElement(By.className("button-1 payment-info-next-step-button"));
            //2.30 Verify “Payment Method” is “Credit Card”
            verifyElements("error", "Payment Method", By.id("CreditCardType"));
            //2.32 Verify “Shipping Method” is “Next Day Air”
            verifyElements("Shipping Method", "Next Day Air", By.id("shippingoption_1"));
            //2.34 Click on “CONFIRM”
            clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
            //2.35 Verify the Text “Thank You”
            verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
            //2.37 Click on “CONTINUE”
            clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

            //2.37 Verify the text “Welcome to our store”
            verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]\n"));

        }
        @After
        public void tearDown(){

            closeBrowser();
        }
    }

