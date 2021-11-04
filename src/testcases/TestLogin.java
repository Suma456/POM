package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import pages.HomePage;
//import pages.LoginPage;

import pages.HomePage;
import pages.LoginPage;

public class TestLogin {
	
String driverPath = "drivers/geckodriver.exe";
    
    WebDriver driver;

    LoginPage objLogin;

    HomePage objHomePage;

    @BeforeTest

    public void setup(){

	System.setProperty("webdriver.gecko.driver", driverPath);
        
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");

    }

    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct(){

        //Create Login Page object

    objLogin = new LoginPage(driver);

    //Verify login page title

    String loginPageTitle = objLogin.getLoginTitle();
    System.out.println("Login Title:"+loginPageTitle);

    Assert.assertTrue(loginPageTitle.equals("Guru99 Bank"));

    //login to application

    objLogin.loginToGuru99("mngr321566", "medAzUd");

    // go the next page

    objHomePage = new HomePage(driver);

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mngr321566"));

}
}
