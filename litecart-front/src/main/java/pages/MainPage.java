package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class  MainPage {

    private static final Logger LOG = Logger.getLogger(MainPage.class);
    protected WebDriver driver;

    @FindBy(xpath = "//li[@class='account dropdown']")
    private WebElement signInButton;
    @FindBy(xpath = "//a[contains(@href,'create_account')]")
    private WebElement customerCreateButton;

    @FindBy(xpath = "//ul[contains(@class,'dnav-tabs')]//a")
    private List<WebElement> productTypeNavTabs;
    @FindBy(xpath = "//div[@class='tab-content']")
    private WebElement productsTable;

    @FindBy(xpath = "//*[@class='tab-content']")
    private WebElement itemsTable;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSignInForm() {
        signInButton.click();
    }
    @Step("Open create account")
    public CreateAccountPage openCreateAccount() {
        customerCreateButton.click();
        return new CreateAccountPage(driver);
    }

    @Step("Select product type {name}")
    public MainPage selectProductType(String name) {
        LOG.info("Selecting product type....");
        for (WebElement productType : productTypeNavTabs) {
            if (productType.getText().contains(name)) {
                productType.click();
                break;
            }
        }
        return this;
    }


    //Java7
    public void selectProductItem(String name) {
        LOG.info("Selecting product item....");
        List<WebElement> itemNames = itemsTable.findElements(By.cssSelector(".product .name"));
        for (WebElement itemName : itemNames) {
            if (itemName.getText().contains(name)) {
                itemName.click();
                break;
            }

        }

    }

    //****Домашнее задание - этот метод не выбираем product item. Найти ошибку и исправить****
    //Бонус - реализовать метод искользуя механизмы java8

    //Метод можно упростить применяя механизмы Java8 , используя StreamAPI
    public void selectProductItemJava8(final String name) {
        List<WebElement> itemNames = itemsTable.findElements(By.cssSelector(".product .name"));
        WebElement productItem = itemNames.stream().
                filter(item -> item.getText().equals(name)).
                findFirst().
                get();
        productItem.click();
    }
}
