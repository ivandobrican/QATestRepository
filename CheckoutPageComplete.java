package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageComplete extends BasePage{
    
    public CheckoutPageComplete (WebDriver driver) {
        super(driver); 
    }

    By completeTitle = By.className("complete-header");

    public CheckoutPageComplete verifySuccessShopping (String expectedTitle) {
        String actualTitle = readText(completeTitle);
        assertTextEquals(expectedTitle, actualTitle);
        return this;
    }
}
