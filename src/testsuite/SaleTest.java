package testsuite;
/**
 * 5.Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        //Click on sale menu tab
        driver.findElement(By.id("ui-id-8")).click();
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.xpath("//a[text()='Jackets']")).click();
        //Verify Jackets text is displayed
        String expectedResult1 = "Jackets";
        String actualResult1 = driver.findElement(By.xpath("//span[@class='base']")).getText();
        // Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult1, actualResult1);
        //Count the Total Item Displayed on Page
        //and print the name of all items into
        //console.
        List<WebElement> productsElement = driver.findElements(By.xpath("//a[contains(@class, 'product-item-link')]"));
        for (WebElement link : productsElement) {
            System.out.println(link.getAttribute("href"));
            System.out.println(link.getText());
            //Verify 12 items displayed
            String expectedResult2 = "12 Items";
            String actualResult2 = driver.findElement(By.id("toolbar-amount")).getText();
            // Verify expected and actual text
            Assert.assertEquals("Error message", expectedResult2, actualResult2);
        }
    }
    @After
    public void setDown() {
        closeBrowser();
    }
}

