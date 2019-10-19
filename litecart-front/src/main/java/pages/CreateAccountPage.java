package pages;

import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

    protected WebDriver driver;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastName;
    @FindBy(xpath = "//select[@name='country_code']")
    private WebElement countryCode;
    @FindBy(xpath = "//div[@id='box-create-account']//input[@name='email']")
    private WebElement email;
    @FindBy(xpath = "//div[@id='box-create-account']//input[@name='password']")
    private WebElement desiredPassword;
    @FindBy(xpath = "//div[@id='box-create-account']//input[@name='confirmed_password']")
    private WebElement confirmedPassword;
    @FindBy(xpath = "//input[@name='create_account']")
    private WebElement createAccount;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCreateAccountForm(Account account) {

        typeFisrtName(account.getFirstName());
        typeLastName(account.getLastName());
        selectCountry(account.getCountry());
        typeEmail(account.getEmail());
        typeDesiredPassword(account.getDesiredPassword());
        typeConfirmedPassword(account.getConfirmPassword());
    }


    public void typeFisrtName(String name) {
        firstName.sendKeys(name);
    }

    public void typeLastName(String name) {
        lastName.sendKeys(name);
    }

    public void selectCountry(String name) {
        Select selectCountry = new Select(countryCode);
        selectCountry.selectByVisibleText(name);
    }

    public void typeEmail(String name) {
        email.sendKeys(name);
    }

    public void typeDesiredPassword(String password) {
        desiredPassword.sendKeys(password);
    }

    public void typeConfirmedPassword(String password) {
        confirmedPassword.sendKeys(password);
    }

    public void clickCreateAccount() {
        createAccount.click();
    }
}
