package tests;

import org.junit.Test;

import pages.CartPage;
import pages.CheckoutPageComplete;
import pages.HomePage;
import pages.LoginPage;
import pages.CheckoutPageStepOne;
import pages.CheckoutPageStepTwo;

public class ShoppingTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String standardPassword = "secret_sauce";
    String homePageTitle = "Products";
    int expectedNumberOfItems = 6;
    String firstName = "Ivan";
    String lastName = "Dobrican";
    String postalCode = "26000";
    String successTitle = "Thank you for your order!";
    String product1Title = "Sauce Labs Backpack";
    String product2Title = "Sauce Labs Bolt T-Shirt";
    
    @Test
    public void numberOfItems () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, standardPassword);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.verifyNumberOfItems(expectedNumberOfItems);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyAddedProductsToCart () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, standardPassword);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.clickOnAddToCartButtons();
        cartPage.verifyProductsAddedToCart(product1Title, product2Title);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyPriceTotal () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPageStepOne checkoutStepOne = new CheckoutPageStepOne(driver);
        CheckoutPageStepTwo checkoutStepTwo = new CheckoutPageStepTwo(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, standardPassword);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.clickOnAddToCartButtons();
        cartPage.verifyProductsAddedToCart(product1Title, product2Title);
        cartPage.basePage();
        cartPage.clickOnCheckoutButton();
        checkoutStepOne.checkoutYourInformation(firstName, lastName, postalCode);
        checkoutStepTwo.verifyTotalPrice();

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifySuccessfulShopping () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPageStepOne checkoutStepOne = new CheckoutPageStepOne(driver);
        CheckoutPageStepTwo checkoutStepTwo = new CheckoutPageStepTwo(driver);
        CheckoutPageComplete checkoutComplete = new CheckoutPageComplete(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, standardPassword);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.clickOnAddToCartButtons();
        cartPage.verifyProductsAddedToCart(product1Title, product2Title);
        cartPage.basePage();
        cartPage.clickOnCheckoutButton();
        checkoutStepOne.checkoutYourInformation(firstName, lastName, postalCode);
        checkoutStepTwo.verifyTotalPrice();
        checkoutStepTwo.clickOnFinishButton();
        checkoutComplete.verifySuccessShopping(successTitle);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
