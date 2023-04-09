package Pages;

import com.qa.util.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Checkout_Page {

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement txt_first_name;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement txt_last_name;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement txt_postal_code;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement btn_continue;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    WebElement btn_finish;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    WebElement msg_order_successful;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement title_checkout_your_information;

    WebDriver driver;
    public Checkout_Page (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver ,this);
    }

    public void enter_first_name() {
        txt_first_name.sendKeys("Sumit");
    }

    public void enter_last_name() {
        txt_last_name.sendKeys("Rana");
    }

    public void enter_postal_code() {
        txt_postal_code.sendKeys("246734");
    }

    public void click_continue_btn() {
        btn_continue.click();
    }

    public void click_finish_btn() {
        btn_finish.click();
    }

    public boolean order_successful_msg() {
        return msg_order_successful.isDisplayed();
    }

    public boolean title_checkout_present() {
        return title_checkout_your_information.isDisplayed();
    }

    public void enter_checkout_details(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData("C://Users//sumit.rana//OneDrive - HCL Technologies Ltd//Desktop//Rough//AutomationData.xlsx", sheetName);

        String first_name = testData.get(rowNumber).get("First Name");
        String last_name = testData.get(rowNumber).get("Last Name");
        String zip_postal_code = testData.get(rowNumber).get("Zip/Postal Code");

        txt_first_name.sendKeys(first_name);
        txt_last_name.sendKeys(last_name);
        txt_postal_code.sendKeys(zip_postal_code);
    }

}
