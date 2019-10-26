
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.MainPage;

public class CartTests extends BaseTest {

    @Description("Some detailed test description")
    @Test
    public void verifyAddItemToCart()  {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.selectProductType("Latest  Product").
                selectProductItem("Purple Duck");

    }

    //****Домашнее задание - дописать тесты на добавление товара в корзину****
}
