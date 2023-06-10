package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    
    public CartPage (WebDriver driver) {
        super(driver); 
    }

    String baseURL = "https://www.saucedemo.com/cart.html";
    By title1By = By.xpath("//*[@id='item_4_title_link']/div");
    By title2By = By.xpath("//*[@id='item_1_title_link']/div");
    By checkoutButtonBy = By.id("checkout");

    public CartPage basePage () {
        driver.get(baseURL);
        return this;
    }

    public CartPage verifyProductsAddedToCart (String expectedTitle1, String expectedTitle2) {
        String title1 = readText(title1By);
        String title2 = readText(title2By);
        assertTextEquals(expectedTitle1, title1);
        assertTextEquals(expectedTitle2, title2);
        return this;
    }

    public CartPage clickOnCheckoutButton () {
        click(checkoutButtonBy);
        return this;
    }

}
