//Test case

//Preconditions

//1. Open browser
//2. Navigate to http://automationpractice.com/index.php

//Steps

//1. Input in search field "Blouse"
//2. Click "Search" button
//3. Click "Add to cart"
//4. Click "Proceed to checkout"

//Expected result
// Check TOTAL is $29.00

import online_pages.OnlineShopPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class OnlineShopTest extends BaseTest {

    private OnlineShopPage onlineShopPage;

    @Test
    public void verifyTotalSum() {
        final String expectedTotalPrice = "$29.00";
        onlineShopPage = new OnlineShopPage(driver);
        onlineShopPage.searchItem("Blouse").
                switchOnListView().
                addItemToCart().
                openShopCartSummary();
        String actualTotalPrice = onlineShopPage.getTotalPrice();
        Assert.assertEquals("Total price is different", expectedTotalPrice, actualTotalPrice);
    }


    @Test(dataProvider = "create account", dataProviderClass = CreateAccountDataProvider.class)
    public void verifyCreateAccountValidation(String email, String errorMessage) {
        onlineShopPage = new OnlineShopPage(driver);
        onlineShopPage.clickSignIn();
        onlineShopPage.typeEmailAddress(email);
        onlineShopPage.clickCreateAccout();
        Assert.assertEquals(errorMessage, onlineShopPage.getErrorMessage());

    }

}


