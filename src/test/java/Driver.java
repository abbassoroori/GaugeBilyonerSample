import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.selenium.condition.DefaultConditionRunner;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a driver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the driver
    @BeforeSuite
    public void initializeDriver(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    // Close the driver instance
    @AfterSuite
    public void closeDriver(){
        driver.close();
    }


}

