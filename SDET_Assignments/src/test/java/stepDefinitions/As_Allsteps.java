package stepDefinitions;

import Pages.Checkout_Page;
import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Your_Cart_Page;
import com.qa.util.GenericWrappers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class As_Allsteps {

    public static WebDriver driver;
    Login_Page objLogin;
    Home_Page objHome;
    Your_Cart_Page objYourCart;
    Checkout_Page objCheckout;
    GenericWrappers objGeneric;


    @Given("Open the Browser")
    public void open_the_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("Navigate to Saucedemo login page")
    public void navigate_to_saucedemo_login_page() {
        driver.get("https://www.saucedemo.com/");
        objLogin = new Login_Page(driver);
        objHome = new Home_Page(driver);
        objYourCart = new Your_Cart_Page(driver);
        objCheckout = new Checkout_Page(driver);
        objGeneric = new GenericWrappers(driver);
    }

    @Given("Swaglabs Logo should Exist")
    public void swaglabs_logo_should_exist() {
        objLogin.swaglab_logo_present();
    }

    @When("Login Button should Exist")
    public void login_button_should_exist() {
        Assert.assertTrue(objLogin.login_button_present());
        driver.close();
    }

    @Given("^Enter Invalid (.*) and (.*)$")
    public void enter_invalid_standard_user_and(String userName, String passWord) {
        objLogin.enter_wrong_usrnm_and_pswd_using_example(userName, passWord);
    }

    @When("Click on Log in button")
    public void click_on_log_in_button() {
        objLogin.click_login_btn_thru_generic_wrapper();
    }

    @Then("An Error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue("Epic sadface: Password is required", objLogin.usrnm_and_pswd_not_match_msg());
        Assert.assertTrue("Epic sadface: Username is required", objLogin.usrnm_and_pswd_not_match_msg());
        Assert.assertTrue("Epic sadface: Username and password do not match any user in this service", objLogin.usrnm_and_pswd_not_match_msg());
        driver.close();
    }

    @Given("^Enter valid (.*) and (.*)$")
    public void enter_invalid_and_secret_sauce(String UserName, String PassWord) {
        objLogin.enter_usrnm_and_pswd_using_example2(UserName, PassWord);
    }

    @Then("Should be login")
    public void should_be_login() {
        Assert.assertTrue(objHome.app_logo_present());
        driver.close();
    }

    @Given("User give UserName and Password")
    public void user_give_user_name_and_password() {
        objLogin.enter_username();
        objLogin.enter_password();
    }

    @When("User is able to login")
    public void user_is_able_to_login() {
        objLogin.click_login_btn();
    }

    @Then("User is on SwagLab Home Page")
    public void user_is_on_swag_lab_home_page() {
        Assert.assertTrue(objHome.app_logo_present());
    }

    @Then("User added multiple products to cart")
    public void user_added_multiple_products_to_cart() {
        objHome.click_add_to_cart_backpack();
        objHome.click_add_to_cart_light();
    }

    @Then("User able to go to shopping cart page")
    public void user_able_to_go_to_shopping_cart_page() {
        objHome.click_shopping_cart_icn();
        Assert.assertTrue(objYourCart.title_your_cart_present());
    }

    @Then("User able to checkout")
    public void user_able_to_checkout() {
        objYourCart.click_checkout_btn();
        Assert.assertTrue(objCheckout.title_checkout_present());
    }

    @Then("Enter the checkout details using excel sheetname {string} and rownumber {int}")
    public void checkout_details_excel(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        objCheckout.enter_checkout_details(sheetName, rowNumber);
        objCheckout.click_continue_btn();
    }

    @Then("Finish the order and get order successful message")
    public void finish_the_order_and_get_order_successful_message() {
        objCheckout.click_finish_btn();
        Assert.assertTrue("THANK YOU FOR YOUR ORDER", objCheckout.order_successful_msg());
    }

    @Then("Close the Browser")
    public void close_the_browser() {
        driver.close();
    }

    @Given("Enter Username as standard_user and Password as secret_sauce")
    public void enter_username_as_standard_user_and_password_as_secret_sauce() {
        objLogin.enter_username_and_password_thru_generic_wrapper();
    }

    @Then("Able to see Product page")
    public void able_to_see_product_page() {
        Assert.assertTrue(objHome.app_logo_present());
    }

    @Then("Click on filter dropdown on right side")
    public void click_on_filter_dropdown_on_right_side() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
    }

    @Then("Select Name\\(A to Z)")
    public void select_name_a_to_z() {
        objHome.select_name_a_to_z_thru_generic_wrapper();
    }

    @Then("Able to see the product alphabetically order\\(A toZ)")
    public void able_to_see_the_product_alphabetically_order_a_to_z() {
        Assert.assertTrue(objHome.see_the_product_a_to_z());
    }

    @Then("Select Name\\(Z to A)")
    public void select_name_z_to_a() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
        objHome.select_name_z_to_a_thru_generic_wrapper();
    }

    @Then("Able to see the product alphabetically order\\(Z to A)")
    public void able_to_see_the_product_alphabetically_order_z_to_a() {
        Assert.assertTrue(objHome.see_the_product_z_to_a());
    }

    @Then("Select Price\\(low to high)")
    public void select_price_low_to_high() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
        objHome.select_price_low_to_high_thru_generic_wrapper();
    }

    @Then("Able to see the product according to increasing price order")
    public void able_to_see_the_product_according_to_increasing_price_order() {
        Assert.assertTrue(objHome.see_the_price_low_to_high());
    }

    @Then("Select Price\\(high to low)")
    public void select_price_high_to_low() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
        objHome.select_price_high_to_low_thru_generic_wrapper();
    }

    @Then("Able to see the product according to decreasing price order")
    public void able_to_see_the_product_according_to_decreasing_price_order() {
        Assert.assertTrue(objHome.see_the_price_high_to_low());
    }

    @Then("Click on the Menu strip on left side")
    public void click_on_the_menu_strip_on_left_side() {
        objHome.click_menu_btn_thru_generic_wrapper();
    }

    @Then("Click on Logout button")
    public void click_on_logout_button() {
        objHome.menu_present();
        objHome.click_logout_btn_thru_generic_wrapper();
    }

    @Then("Able to see the Login page again")
    public void able_to_see_the_login_page_again() {
        objLogin.swaglab_logo_present();
        driver.close();
        driver.quit();
    }

}
