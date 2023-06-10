package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPageStepTwo extends HomePage{

    public CheckoutPageStepTwo (WebDriver driver) {
        super(driver); 
    }

    By itemTotalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]"); 
    By taxBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");
    By totalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]");
    By finishBy = By.id("finish");

    public CheckoutPageStepTwo verifyTotalPrice () {

        double itemTotal = Double.parseDouble(readText(itemTotalBy).substring(13));
        double tax = Double.parseDouble(readText(taxBy).substring(6));
        double total = Double.parseDouble(readText(totalBy).substring(8));
        Assert.assertEquals(total, itemTotal + tax, 000.1);
        return this;
    }

    public CheckoutPageStepTwo clickOnFinishButton () {
        click(finishBy);
        return this;
    }
    
}
