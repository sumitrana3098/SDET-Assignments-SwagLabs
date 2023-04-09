package stepDefinitions;

import com.qa.util.GenericWrappers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Login_Page;
import Pages.Home_Page;
import Pages.Your_Cart_Page;
import Pages.Checkout_Page;

public class As_3steps {

    public static WebDriver driver;
    Login_Page objLogin;
    Home_Page objHome;
    Your_Cart_Page objYourCart;
    Checkout_Page objCheckout;
    GenericWrappers objGeneric;


    @Given("open the browser")
    public void open_the_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("navigate to saucedemo login page")
    public void navigate_to_saucedemo_login_page() {
        driver.get("https://www.saucedemo.com/");
        objLogin = new Login_Page(driver);
        objHome = new Home_Page(driver);
        objYourCart = new Your_Cart_Page(driver);
        objCheckout = new Checkout_Page(driver);
        objGeneric = new GenericWrappers(driver);
    }

    @Then("swaglabs logo should Exits")
    public void swaglabs_logo_should_exits() {
        objLogin.swaglab_logo_present();
    }

    @Then("login button should Exits")
    public void login_button_should_exits() {
        Assert.assertTrue(objLogin.login_button_present());
        driver.close();
    }

    @Given("^enter Invalid (.*) and (.*)$")
    public void enter_invalid_standard_user_and(String userName, String passWord) {
        objLogin.enter_wrong_usrnm_and_pswd_using_example(userName, passWord);
    }

    @When("click on Log in button")
    public void click_on_log_in_button() {
        objLogin.click_login_btn_thru_generic_wrapper();
    }

    @Then("An error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue("Epic sadface: Password is required", objLogin.usrnm_and_pswd_not_match_msg());
        Assert.assertTrue("Epic sadface: Username is required", objLogin.usrnm_and_pswd_not_match_msg());
        Assert.assertTrue("Epic sadface: Username and password do not match any user in this service", objLogin.usrnm_and_pswd_not_match_msg());
        driver.close();
    }

    @When("^enter valid (.*) and (.*)$")
    public void enter_valid_standard_user_and_secret_sauce(String UserName, String PassWord) {
        objLogin.enter_usrnm_and_pswd_using_example2(UserName, PassWord);
    }

    @Then("should be login")
    public void should_be_login() {
        Assert.assertTrue(objHome.app_logo_present());
        driver.close();
    }

    @Given("Enter username as standard_user and password as secret_sauce")
    public void enter_username_as_standard_user_and_password_as_secret_sauce() {
        objLogin.enter_username_and_password_thru_generic_wrapper();
    }

    @When("Click on log in button")
    public void Click_on_log_in_button() {
        objLogin.click_login_btn_thru_generic_wrapper();
    }

    @Then("Able to see product page")
    public void able_to_see_product_page() {
        Assert.assertTrue(objHome.app_logo_present());
    }

    @Then("click on filter dropdown on right side")
    public void click_on_filter_dropdown_on_right_side() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
    }

    @Then("select Name\\(A to Z)")
    public void select_name_a_to_z() {
        objHome.select_name_a_to_z_thru_generic_wrapper();
    }

    @Then("able to see the product alphabetically order\\(A toZ)")
    public void able_to_see_the_product_alphabetically_order_a_to_z() {
        Assert.assertTrue(objHome.see_the_product_a_to_z());
    }

    @Then("select Name\\(Z to A)")
    public void select_name_z_to_a() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
        objHome.select_name_z_to_a_thru_generic_wrapper();
    }

    @Then("able to see the product alphabetically order\\(Z to A)")
    public void able_to_see_the_product_alphabetically_order_z_to_a() {
        Assert.assertTrue(objHome.see_the_product_z_to_a());
    }

    @Then("select Price\\(low to high)")
    public void select_price_low_to_high() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
        objHome.select_price_low_to_high_thru_generic_wrapper();
    }

    @Then("able to see the product according to increasing price order")
    public void able_to_see_the_product_according_to_increasing_price_order() {
        Assert.assertTrue(objHome.see_the_price_low_to_high());
    }

    @Then("select Price\\(high to low)")
    public void select_price_high_to_low() {
        objHome.click_filter_dropdown_thru_generic_wrapper();
        objHome.select_price_high_to_low_thru_generic_wrapper();
    }

    @Then("able to see the product according to decreasing price order")
    public void able_to_see_the_product_according_to_decreasing_price_order() {
        Assert.assertTrue(objHome.see_the_price_high_to_low());
    }

    @Then("Close The Browser")
    public void close_Browser() {
        driver.close();
    }

    @Then("Click on the menu strip on left side")
    public void click_on_the_menu_strip_on_left_side() {
        objHome.click_menu_btn_thru_generic_wrapper();
    }

    @Then("Click on logout button")
    public void click_on_logout_button() {
        objHome.menu_present();
        objHome.click_logout_btn_thru_generic_wrapper();
    }

    @Then("Able to see the login page again")
    public void able_to_see_the_login_page_again() {
        objLogin.swaglab_logo_present();
        driver.close();
        driver.quit();
    }

}



