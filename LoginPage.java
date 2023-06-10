package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver driver) {
        super(driver); 
    }

    String baseURL = "https://www.saucedemo.com/";
    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");
    By errorContainer = By.className("error-message-container");

    public LoginPage basePage () {
        driver.get(baseURL);
        return this;
    }

    public LoginPage login (String username, String password) {
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin (String expextedText) {
        String actualText = readText(errorContainer);
        assertTextEquals(expextedText, actualText);
        return this;
    }

    public LoginPage verifyLogout () {
        waitVisibility(usernameBy);
        waitVisibility(passwordBy);
        waitVisibility(loginButtonBy);
        return this;
    }
    
}
