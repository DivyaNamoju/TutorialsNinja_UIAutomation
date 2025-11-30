package baseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ReadConfigProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebDriverBase
{
    public WebDriver driver;
    public Logger log;
    @BeforeMethod
    public void setUp()
    {
        log = LogManager.getLogger(this.getClass());
        final String BROWSER_NAME = ReadConfigProperties.getProperty("BROWSER");
        final String EXECUTION_ENV = ReadConfigProperties.getProperty("EXECUTION_ENV");
        if(EXECUTION_ENV.equalsIgnoreCase("remote"))
        {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.WIN11);
            desiredCapabilities.setBrowserName(BROWSER_NAME);

            try {
                driver = new RemoteWebDriver(new URL("http://192.168.1.39:4444/wd/hub"), desiredCapabilities);
            } catch (MalformedURLException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        else {
            System.out.println("Setting up things to run on =====> " + BROWSER_NAME);
            driver = switch (BROWSER_NAME.toLowerCase()) {
                case "chrome" -> new ChromeDriver();
                case "edge" -> new EdgeDriver();
                case "firefox" -> new FirefoxDriver();
                case "headless" -> {
                    ChromeOptions cp = new ChromeOptions();
                    cp.addArguments("--headless=new");
                    yield new ChromeDriver(cp);
                }
                default -> new ChromeDriver();
            };
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        // return driver;
        // threadLocalDriver.set(driver);
    }
    @AfterMethod
    public void quitBrowser()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
