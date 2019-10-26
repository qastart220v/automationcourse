import config.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class BaseTest {

    public static final Logger LOG = Logger.getLogger(BaseTest.class);
    private RemoteWebDriver driver;
    public static final String BROWSER_TYPE = System.getProperty("browser");


    public RemoteWebDriver getDriver() {
        return driver;
    }

    public void setDriver(RemoteWebDriver driver) {
        this.driver = driver;
    }

    @Parameters("Browser")
    @BeforeMethod
    public void setUp(@Optional String type) {
        if (BROWSER_TYPE.equals("chrome")) {
            LOG.info("Initialization chrome driver...");
            setDriver(runChromeDriver());
        } else if (BROWSER_TYPE.equals("firefox")) {
            LOG.info("Initialization firefox driver...");
            setDriver(runFireFoxDriver());
        }

        driver.manage().window().maximize();
        driver.navigate().to(Environment.getEnvironment());
    }


    private RemoteWebDriver runChromeDriver() {
         String chromeVersion  = System.getProperty("chromeV");

        if (chromeVersion == null) {
             chromeVersion = "77.0";
        } else {
            WebDriverManager.chromedriver().version(chromeVersion).setup();
        }
        WebDriverManager.chromedriver().version(chromeVersion).setup();
        setDriver(new ChromeDriver());
        return driver;
    }


    private RemoteWebDriver runFireFoxDriver() {
        final String firefoxVersion = System.getProperty("firefoxV");
        WebDriverManager.firefoxdriver().version(firefoxVersion).setup();
        setDriver(new FirefoxDriver());
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void close(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) { //Если тест упал - делаем скриншот
            LOG.error("Test is FAILED" + testResult.getTestName());
            makeAScreenshotAndReturnFilePath(driver);
        }

        if (testResult.getStatus() == ITestResult.SUCCESS) {
            LOG.info("Test is PASSED" + testResult.getTestName());
        }
        getDriver().close();
    }

    private String makeAScreenshotAndReturnFilePath(RemoteWebDriver driver) throws IOException {
        File scrFileLocal = driver.getScreenshotAs(OutputType.FILE);
        final File destFile = new File("test-output/" + scrFileLocal.getName());
        FileUtils.copyFile(scrFileLocal, destFile);
        return destFile.getName();
    }
}
