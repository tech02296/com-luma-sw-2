package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    /**
     * Write down the following test into ‘RegisterTest’
     * class
     * 1. verifyThatSignInPageDisplay
     * * click on the ‘Create an Account’ link
     * * Verify the text ‘Create New Customer Account’
     * 2. userShouldRegisterAccountSuccessfully
     * * click on the ‘Create an Account’ link
     * * Enter First name
     * * Enter Last name
     * * Click on checkbox Sign Up for Newsletter
     * * Enter Emai
     * * Enter Password
     * * Enter Confirm Password
     * * Click on Create an Account button
     * * Verify the text 'Thank you for
     * registering with Main Website Store.’
     * * Click on down aero neare Welcome
     * * Click on Sign Out link
     * * Verify the text ‘You are signed out’
     */

    String baseUrl = "https://magento.softwaretestingboard.com";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() throws InterruptedException {
        // Click on create an account link
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        //Verify the text ‘Create New Customer Account’
        String expectedResult = "Create New Customer Account";
        String actualResult = driver.findElement(By.xpath("//span[text()='Create New Customer Account']")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult, actualResult);
        Thread.sleep(2000);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        // Click on create an account link
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        // Enter First name
        driver.findElement(By.id("firstname")).sendKeys("Tester");
        // Enter Last name
        driver.findElement(By.id("lastname")).sendKeys("Experience");
        // Enter Email address
        final String randomEmail = randomEmail();
        driver.findElement(By.id("email_address")).sendKeys(randomEmail);
        Thread.sleep(2000);
        //Enter Password
        driver.findElement(By.id("password")).sendKeys("dream123@");
        Thread.sleep(2000);
        // Enter Confirm password
        driver.findElement(By.id("password-confirmation")).sendKeys("dream123@");
        Thread.sleep(2000);
        //Click on Create an Account button
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
        //Thank you for registering with Main Website Store.
        String expectedResult = "Thank you for registering with Main Website Store.";
        String actualResult = driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult, actualResult);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //Click on sign out
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String expectedResult1 = "You are signed out";
        String actualResult1 = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        // Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult1, actualResult1);
    }

    private static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @After
    public void setDown() {

        closeBrowser();
    }
}
















