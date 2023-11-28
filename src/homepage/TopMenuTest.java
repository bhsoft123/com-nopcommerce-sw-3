package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
        // 1.2 This method should click on the menu whatever name is passed as parameter.
        /*    1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
    select the Menu and click on it and verify the page navigation.*/
        List<WebElement> selectMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/child::li"));
        for (WebElement element : selectMenu) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }

          @Test
        public void verifyComputer(){
            selectMenu("Computers");
            verifyElements("Error","Computers",By.xpath("//h1[contains(text(),'Computers')]"));

        }
        @Test
        public void verifyElectronics(){
            selectMenu("Electronics");
            verifyElements("Error","Electronics", By.xpath("//h1[contains(text(),'Electronics')]"));
        }
        @Test
        public void verifyApparel(){
            selectMenu("Apparel");
            verifyElements("Error","Apparel",By.xpath("//h1[contains(text(),'Apparel')]"));
        }
        @Test
        public void verifyDigitalDownloads(){
            selectMenu("Digital downloads");
            verifyElements("Error","Digital downloads",By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']"));
        }

        @Test
        public void verifyBooks(){
            selectMenu("Books");
            verifyElements("Error","Books",By.xpath("//h1[contains(text(),'Books')]"));
        }

        @Test
        public void verifyJewelry(){
            selectMenu("Jewelry");
            verifyElements("Error","Jewelry",By.xpath("//h1[contains(text(),'Jewelry')]"));
        }
        @Test
        public void verifyGiftCards() {
            selectMenu("Gift Cards");
            verifyElements("error", "Gift Cards", By.xpath("//h1[contains(text(),'Gift Cards')]"));
        }
        @After
        public void tearDown(){
            closeBrowser();
        }
    }