/**
 * Created by mertyaman on 08/04/16.
 */
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class HomePageTest {
    @Step("Arama sonuclarindan ilkini sec")
    public void clickFirstResult() throws InterruptedException {
        WebElement firstResult = Driver.driver.findElement(By.xpath(".//*[@id='rso']/div[1]/div/div/h3/a"));
        firstResult.click();
        Thread.sleep(4000);
    }
    @Step("Acilan sayfanin url'i <url> olmali")
    public void homePageTest(String url){
       Assert.assertEquals(Driver.driver.getCurrentUrl(),url);
    }
}
