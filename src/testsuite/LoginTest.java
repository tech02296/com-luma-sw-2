package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 4. Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Click on sign in link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("mehul123@gmail.com");
        //Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("dream123@");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        //Verify Welcome text
        String expectedResult = "Welcome, Tester Experience!";
        String actualResult = driver.findElement(By.xpath("//span[text()='Welcome, Tester Experience!']")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult, actualResult);
    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        //Click on sign in link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter Invalid Email
        driver.findElement(By.id("email")).sendKeys("mehul123@gmail.com");
        //Enter Invalid Password
        driver.findElement(By.id("pass")).sendKeys("dream123@nmht");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        //Verify Text= The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
        String expectedResult = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualResult = driver.findElement(By.xpath("//div[@class='message-error error message']")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult, actualResult);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("mehul123@gmail.com");
        //Enter valid Password
        driver.findElement(By.id("pass")).sendKeys("dream123@");
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
        //Verify the ‘Welcome’ text is display

        //Click on down aero near Welcome
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //Click on Sign out link
        driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']")).click();
        String expectedResult1 = "You are signed out";
        String actualResult1 = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        // Verify expected and actual text
        Assert.assertEquals("Error message", expectedResult1, actualResult1);
    }
    @After
    public void setDown(){
        closeBrowser();
    }
}