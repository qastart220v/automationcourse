import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final Logger LOG = Logger.getLogger(BaseTest.class);
    private WebDriver driver;
    private static final String BASE_URL = "http://localhost/litecart/";

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeMethod
    public void setUp() {
        LOG.info("Initialization chrome driver...");
        WebDriverManager.chromedriver().version("77.0").setup();
        setDriver(new ChromeDriver());
        driver.manage().window().maximize();
        LOG.info("Nagigation to " + BASE_URL);
        driver.navigate().to(BASE_URL);
    }

    @AfterMethod
    public  void close(){
        driver.close();
    }



}