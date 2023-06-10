package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String invalidUsername = "locked_out_user";
    String standardPassword = "secret_sauce";
    String homePageTitle = "Products";
    String wrongUserErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
    String emptyUsername = "";
    String emptyUsernameErrorMsg = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordErrorMsg = "Epic sadface: Password is required";

    @Test
    public void verifySuccesfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver); 
        loginPage.basePage();
        loginPage.login(standardUsername, standardPassword);
        homePage.verifySuccesfulLogin(homePageTitle);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test 
    public void verifyInvalidUsernameLogin () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(invalidUsername, standardPassword);
        loginPage.verifyUnsuccessfulLogin(wrongUserErrorMsg);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test 
    public void verifyEmptyUsernameLogin () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(emptyUsername, standardPassword);
        loginPage.verifyUnsuccessfulLogin(emptyUsernameErrorMsg);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test 
    public void verifyEmptyPasswordLogin () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, emptyPassword);
        loginPage.verifyUnsuccessfulLogin(emptyPasswordErrorMsg);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifySuccessfulLogout ()
    {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver); 
        loginPage.basePage();
        loginPage.login(standardUsername, standardPassword);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.clickOnMenuButton();
        homePage.clickOnLogoutButton();
        loginPage.verifyLogout();

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }    
}
