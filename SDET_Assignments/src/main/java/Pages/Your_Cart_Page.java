package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Your_Cart_Page {

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement btn_checkout;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement title_your_cart;

    WebDriver driver;
    public Your_Cart_Page (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver ,this);
    }

    public void click_checkout_btn() {
        btn_checkout.click();
    }

    public boolean title_your_cart_present() {
        return title_your_cart.isDisplayed();
    }

}
