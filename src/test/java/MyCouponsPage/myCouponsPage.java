package MyCouponsPage;

import Utils.couponOperations;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by mert.yaman on 29/03/2017.
 * Bu classta kuponlarim sayfasini acan, kupon ismine gore oynanmis kuponun detaylarini
 * gösteren methodlar bulunur.
 */
public class myCouponsPage extends couponOperations {
    public void openMyCouponsPage(){
        scrollToTop();
        mouseMoveOnWebElementAndClick(prop.getMyAccountMenu(),prop.getMyAccountMenumyCouponsBtn());
        waitForPageLoad();
        waitForAngularLoad();
        Assert.assertTrue(getWebElementText(prop.getMyCouponsTitle()).contains("Biletlerim"));
        addLog("Kuponlarim sayfasindaki title goruntulendi.");
    }

    public void findCoupon(){
        List<WebElement> elementList=findWebElements(prop.getMyCouponsNameList());
        List<String> couponNameList = convertElementListToStringList(prop.getMyCouponsNameList());
        boolean couponFound=false;
        for (int i=0;i<couponNameList.size();i++) {
            if(couponNameList.get(i).equals(getCouponName())){
                addLog("Oynanan kupon ismi listede bulundu.");
                clickWebElement(elementList.get(i));
                waitForAngularLoad();
                couponFound=true;
                break;
            }
        }
        if(!couponFound) {
            Assert.fail("Oynanan kupon ismi listede bulunamadi.");
            return;
        }
    }

}
