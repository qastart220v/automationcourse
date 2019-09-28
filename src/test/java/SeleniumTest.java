import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    WebDriver driver;
    private static final String PATH_TO_DRIVER  = "/Users/oleksandr_pavliuk/IdeaProjects/automationcourse/src/main/resources/drivers/chromedriver";
    private String buttonAddToCart = "//a[@title='Add to cart']";
    private  static final String BASE_URL = "http://automationpractice.com/index.php";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }

    @Test
    public void verifyTotalPrice() throws InterruptedException {

        final String expectedTotalPrice = "$29.0";

        driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.id("list")).click();
        driver.findElement(By.xpath(buttonAddToCart)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();
        Assert.assertEquals("Total price is different",expectedTotalPrice, actualTotalPrice);

    }

    @After
    public void close() {
        driver.close();
    }


}
