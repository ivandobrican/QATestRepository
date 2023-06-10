package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By homePageTitleBy = By.className("title");
    By numberOfItemsBy = By.className("inventory_item");
    By menuButtonBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");

    public HomePage verifySuccesfulLogin (String expectedText) {
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifyNumberOfItems (int expectedItemsNumber) {
        int actualItemsNumber = countItems(numberOfItemsBy);
        assertIntegerEquals(expectedItemsNumber, actualItemsNumber);
        return this;
    }

    public HomePage clickOnMenuButton() {
        click(menuButtonBy);
        return this;
    }

    public HomePage clickOnLogoutButton () {
        click(logoutButtonBy);
        return this;
    }

    public HomePage clickOnAddToCartButtons () {
        click(addToCartButton1By);
        click(addToCartButton2By);
        return this;
    }
}