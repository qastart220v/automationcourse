package online_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineShopPage  {

    public WebDriver driver;

    @FindBy(id = "SubmitCreate")
    private WebElement submitButton;
    @FindBy(id = "email_create")
    private WebElement emailCreate;
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signIn;

    public OnlineShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAccout() {
        submitButton.click();
    }






    public String getErrorMessage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        String errorMessage = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("create_account_error")))).getText();
        return errorMessage;
    }


    public void typeEmailAddress(String email) {
        emailCreate.sendKeys(email);
    }

    public void clickSignIn() {
        signIn.click();
    }


    public OnlineShopPage searchItem(String itemName) {
        enterIntoSearchField(itemName);
        clickSearchButton();
        return this;
    }


    public void enterIntoSearchField(String item) {
        driver.findElement(By.id("search_query_top")).sendKeys(item);
    }

    public void clickSearchButton() {
        driver.findElement(By.name("submit_search")).click();
    }

    public OnlineShopPage switchOnListView() {
        driver.findElement(By.id("list")).click();
        return this;
    }

    public String getTotalPrice() {
        String totalPrice = driver.findElement(By.id("total_price")).getText();
        return totalPrice;
    }

    public OnlineShopPage openShopCartSummary() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.
                visibilityOf(driver.findElement(By.xpath("//a[@title='Proceed to checkout']")))).click();

        return this;

    }

    public OnlineShopPage addItemToCart() {
        driver.findElement(By.xpath("//a[@title='Add to cart']")).click();

        return this;
    }

    public void typeEmailAddress1(String email) {
        driver.findElement(By.id("email_create")).sendKeys(email);
    }


}
