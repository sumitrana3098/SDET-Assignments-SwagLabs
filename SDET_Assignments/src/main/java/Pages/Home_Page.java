package Pages;

import org.junit.jupiter.api.ClassOrderer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.util.GenericWrappers.ClickButton;
import static com.qa.util.GenericWrappers.FilterButton;


public class Home_Page {

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    WebElement logo_app;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement btn_menu;

    @FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")
    WebElement menu_container;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    WebElement btn_logout;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    WebElement title_item;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement btn_add_to_cart;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement icn_shopping_cart;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement btn_add_to_cart_light;

    @FindBy(className = "inventory_item_name")
    WebElement item_name;

    @FindBy(className = "inventory_item_price")
    WebElement item_price;


    @FindBy(className = "shopping_cart_link")
            WebElement Icn_shopping_cart;


    WebDriver driver;
    public Home_Page (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver ,this);
    }

    public boolean app_logo_present() {
        return logo_app.isDisplayed();
    }

    public void click_menu_btn() {
        btn_menu.click();
    }

    public boolean menu_present() {
        return menu_container.isDisplayed();
    }

    public void click_logout_btn() {
        btn_logout.click();
    }

    public void click_item_title() {
        title_item.click();
    }

    public void click_add_to_cart_backpack() {
        btn_add_to_cart.click();
    }

    public void click_shopping_cart_icn() {
        icn_shopping_cart.click();
    }

    public void click_add_to_cart_light() {
        btn_add_to_cart_light.click();
    }

    public void click_filter_dropdown_thru_generic_wrapper() {
        FilterButton("product_sort_container");
    }

    public void select_name_a_to_z_thru_generic_wrapper() {
        ClickButton("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]");
    }

    public boolean see_the_product_a_to_z() {
        return item_name.isDisplayed();
    }

    public void select_name_z_to_a_thru_generic_wrapper() {
        ClickButton("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]");
    }

    public boolean see_the_product_z_to_a() {
        return item_name.isDisplayed();
    }

    public void select_price_low_to_high_thru_generic_wrapper() {
        ClickButton("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]");
    }

    public boolean see_the_price_low_to_high() {
        return item_price.isDisplayed();
    }

    public void select_price_high_to_low_thru_generic_wrapper() {
        ClickButton("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]");
    }

    public boolean see_the_price_high_to_low() {
        return item_price.isDisplayed();
    }

    public void click_menu_btn_thru_generic_wrapper() {
        ClickButton("//*[@id=\"react-burger-menu-btn\"]");
    }

    public void click_logout_btn_thru_generic_wrapper() {
        ClickButton("//*[@id=\"logout_sidebar_link\"]");
    }

    public boolean able_to_see_items(){
        return Icn_shopping_cart.isDisplayed();
    }
}
