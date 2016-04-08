/**
 * Created by mertyaman on 08/04/16.
 */
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

public class GoogleTest {

    @Step("Su sayfaya git <link>")
    public void navigateTo(String url) throws InterruptedException {
        Driver.driver.navigate().to(url);
        Thread.sleep(2000);
    }

    @Step("Arama motoruna <searchText> yaz ve enter'a bas")
    public void enterQuery(String query) throws InterruptedException {
        WebElement searchBox = Driver.driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
        Thread.sleep(2000);
    }

    @Step("Ilk sonuc <expectedResult> cumlesini icermeli")
    public void verifySearchResult(String resultString) {
        WebElement result = Driver.driver.findElement(By.xpath(".//*[@id='rso']/div[1]/div/div/h3/a"));
        assertTrue(result.getText().contains(resultString));
    }
}
