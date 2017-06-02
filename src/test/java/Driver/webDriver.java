package Driver;


import Utils.folderZip;
import Utils.propertyReader;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Bu class icerisinde webdriver ile ilgili metodlar bulunur.
 * Gelen parametreye gore driveri initialize eden, testin fail etmesi durumunda
 * screenshot alan, testler tamamlandiginda browser'i kapatan metodlar bu classtadir.
 */
public class webDriver implements ICustomScreenshotGrabber {

    public static final String projectFolder = System.getProperty("user.dir");
    public static WebDriver driver;
    static String browser = System.getenv("browser");
    static propertyReader prp= new propertyReader();
    static boolean isOSMAC = prp.isOSMAC();

    @BeforeSuite
    public void initializeDriver(){
        System.out.println("is os mac: "+ isOSMAC);
        driver = getDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void closeDriver(){
        driver.quit();
//        folderZip fzip= new folderZip();
//        fzip.zipper();
//        sendMail mailSender = new sendMail();
//        mailSender.sendEmail();
    }

    public static WebDriver getDriver() {



//        if(isOSMAC){
//            System.setProperty("webdriver.gecko.driver", "browser_drivers/geckodriver_mac");
//            System.setProperty("webdriver.chrome.driver", "browser_drivers/chromedriverMAC");
//            System.setProperty("phantomjs.binary.path",  "browser_drivers/phantomjs_MAC");
//        }
//        else{
//            System.setProperty("webdriver.gecko.driver", "browser_drivers\\geckodriver.exe");
//            System.setProperty("webdriver.chrome.driver", "browser_drivers\\chromedriver.exe");
//            System.setProperty("phantomjs.binary.path",  "browser_drivers\\phantomjs.exe");
//        }


        DesiredCapabilities cab = new DesiredCapabilities();
//        setProxy(cab);



        if (browser == null) {
            cab = DesiredCapabilities.firefox();
            setProxy(cab);
            return new FirefoxDriver(cab);
        }
        switch (browser)
        {
            default:
                cab = DesiredCapabilities.firefox();
                setProxy(cab);
                return new FirefoxDriver(cab);

            case "firefox":
                cab=DesiredCapabilities.firefox();
                cab.setBrowserName("firefox");
                FirefoxDriverManager.getInstance().arch64().proxy(prp.getProxyAddress()).proxyUser(prp.getProxyUser()).proxyPass(prp.getProxyPass()).setup();
                setProxy(cab);
                return new FirefoxDriver(cab);

            case "opera":
                cab=DesiredCapabilities.opera();
                cab.setBrowserName("opera");
                OperaDriverManager.getInstance().proxy(prp.getProxyAddress()).proxyUser(prp.getProxyUser()).proxyPass(prp.getProxyPass()).setup();
                setProxy(cab);
                return new OperaDriver(cab);

            case "safari":
                return new SafariDriver(cab);

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--start-maximized");
                options.addArguments("--dns-prefetch-disable");
                options.addArguments("--always-authorize-plugins");
                cab=DesiredCapabilities.chrome();
                cab.setCapability(ChromeOptions.CAPABILITY, options);
                cab.setBrowserName("chrome");
                ChromeDriverManager.getInstance().arch64().proxy(prp.getProxyAddress()).proxyUser(prp.getProxyUser()).proxyPass(prp.getProxyPass()).setup();
                setProxy(cab);
                driver = new ChromeDriver(cab);

                if(isOSMAC){
                    Point targetPosition = new Point(0, 0);
                    driver.manage().window().setPosition(targetPosition);
                    Dimension targetSize = new Dimension(1920, 1080); //your screen resolution here
                    driver.manage().window().setSize(targetSize);
                }
                return driver;
            case "phantomjs":
                    cab = DesiredCapabilities.phantomjs();
                    cab.setBrowserName("phantomjs");
                    PhantomJsDriverManager.getInstance().arch64().proxy(prp.getProxyAddress()).proxyUser(prp.getProxyUser()).proxyPass(prp.getProxyPass()).setup();
                    setProxy(cab);
                    return new PhantomJSDriver(cab);
        }
    }
    public static void setProxy(DesiredCapabilities cab){
        Proxy proxy1 = new org.openqa.selenium.Proxy();
        proxy1.setProxyType(Proxy.ProxyType.MANUAL);
        proxy1.setHttpProxy(prp.getProxyAddress());
        proxy1.setSslProxy(prp.getProxyAddress());
        proxy1.setFtpProxy(prp.getProxyAddress());
        proxy1.setSocksUsername(prp.getProxyUser());
        proxy1.setSocksPassword(prp.getProxyPass());
        cab.setCapability(CapabilityType.PROXY, proxy1);
    }

    @Override
    public byte[] takeScreenshot() {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
//    public void setSystemProxy(){
//        //For HTTP
//        System.getProperties().put("http.proxyHost", prop.getProxyHost());
//        System.getProperties().put("http.proxyPort", prop.getProxyPort());
//        System.getProperties().put("http.proxyUser", prop.getProxyUser());
//        System.getProperties().put("http.proxyPassword", prop.getProxyPass());
//        //For HTTPS
//        System.getProperties().put("https.proxyHost", prop.getProxyHost());
//        System.getProperties().put("https.proxyPort", prop.getProxyPort());
//        System.getProperties().put("https.proxyUser", prop.getProxyUser());
//        System.getProperties().put("https.proxyPassword", prop.getProxyPass());
//    }

}
