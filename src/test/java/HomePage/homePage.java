package HomePage;

import BilyonerBase.baseClass;
import Utils.couponOperations;
import com.thoughtworks.gauge.Step;
import org.testng.Assert;

import java.util.List;

/**
 * Bilyoner.com sayfasindaki testleri iceren classtir.
 * homePage.spec icerisindeki test senaryolarini execute eden metodlar bu classtadir.
 */
public class homePage extends baseClass {

    public void openHomePage(){
        setWebDriverUrl(prop.getBilyonerUrl());
        waitForPageLoad();
    }

    public void login(){
        fillInputFieldWebElement(prop.getUserIdInput(), prop.getUserId());
        fillInputFieldWebElement(prop.getPasswordInput(), prop.getPassword());
        clickWebElement(prop.getLoginBtn());
        waitForAjaxLoad();
        Assert.assertTrue(untilElementIsVisible(prop.getUsername()) != null, "Username goruntulenemedi.");
        addLog("Username goruntulendi.");
    }


    @Step("Open and validate bilyoner.com homepage")
    public void homepageTests() {
        openHomePage();
        login();
        Assert.assertTrue(untilElementIsVisible(prop.getTribunWidget()) != null, "Tribun widget'i goruntulenmedi.");
        addLog("Tribun widget'i goruntulendi.");
        Assert.assertTrue(untilElementIsVisible(prop.getPopulerWidget()) != null, "Populer kuponlar widget'i goruntulenmedi.");
        addLog("Populer kuponlar widget'i goruntulendi.");
        Assert.assertTrue(untilElementIsVisible(prop.getQuadboxCell1()) != null, "Quadbox icerisindeki 1.cell goruntulenemedi.");
        addLog("Quadbox icerisindeki 1.cell goruntulendi.");
        Assert.assertTrue(untilElementIsVisible(prop.getQuadboxCell2()) != null, "Quadbox icerisindeki 2.cell goruntulenemedi.");
        addLog("Quadbox icerisindeki 2.cell goruntulendi.");
        Assert.assertTrue(untilElementIsVisible(prop.getQuadboxCell3()) != null, "Quadbox icerisindeki 3.cell goruntulenemedi.");
        addLog("Quadbox icerisindeki 3.cell goruntulendi.");
        Assert.assertTrue(untilElementIsVisible(prop.getQuadboxCell4()) != null, "Quadbox icerisindeki 4.cell goruntulenemedi.");
        addLog("Quadbox icerisindeki 4.cell goruntulendi.");
    }

    @Step("Test tribun widget")
    public void tribunWidgetTest() {
        Assert.assertTrue(findWebElement(prop.getTribunWidgetPlayBtn())!=null,"Tribun kuponu oyna butonu goruntulenemedi.");
        addLog("Tribun kuponu oyna butonu goruntulendi.");
        clickWebElement(prop.getTribunWidgetPlayBtn());  //tribun widget play button
        List<String> matchcodesList= convertElementListToStringList(prop.getTribunWidgetMatchCodeList());  //all match codes
        List<String> matchcodelistBetslip= convertElementListToStringList(prop.getBetslipAllMatchCodes());  // betslip title + all match codes
        matchcodelistBetslip.remove(0);  // remove title from matchcode list
        Assert.assertEquals(matchcodesList.size(),matchcodelistBetslip.size(),"Tribun kuponu ve betslipteki mac sayisi esit degil!");
        addLog("Tribun kuponu ve betslipteki mac sayisi esit.");
        double totalRatioWidget=getStringToDouble(getWebElementText(prop.getTribunWidgetTotalRatio()));   // total ratio
        double totalRatioBetslip=getStringToDouble(getWebElementText(prop.getBetslipTotalRatio()));  // betslip total ratio
        Assert.assertEquals(totalRatioWidget,totalRatioBetslip,"Tribun kuponu ve betslipteki toplam oran esit degil!");
        addLog("Tribun kuponu ve betslipteki toplam oran esit.");
        couponOperations ops=new couponOperations();
        ops.saveCouponDetails();
        ops.setCouponName("tribunWidget");
        ops.playCoupon();
        ops.cancelCoupon();
    }

    @Step("Test popular widget")
    public void popularWidgetTest() {
        openHomePage();
        Assert.assertTrue(findWebElement(prop.getPopularWidgetPlayBtn())!=null,"Populer kupon oyna butonu goruntulenemedi.");
        addLog("Populer kupon oyna butonu goruntulendi.");
        clickWebElement(prop.getPopularWidgetPlayBtn());  //popular widget play button
        List<String> matchcodesList= convertElementListToStringList(prop.getPopularWidgetMatchCodeList());  //all match codes
        List<String> matchcodelistBetslip= convertElementListToStringList(prop.getBetslipAllMatchCodes());  // betslip title + all match codes
        matchcodelistBetslip.remove(0); // remove title from matchcode list
        Assert.assertEquals(matchcodesList.size(),matchcodelistBetslip.size(),"Populer kupon ve betslipteki mac sayisi esit degil!");
        addLog("Populer kupon ve betslipteki mac sayisi esit.");
        double totalRatioWidget=getStringToDouble(getWebElementText(prop.getPopularWidgetTotalRatio()));   // total ratio
        double totalRatioBetslip=getStringToDouble(getWebElementText(prop.getBetslipTotalRatio()));  // betslip total ratio
        Assert.assertEquals(totalRatioWidget,totalRatioBetslip,"Populer kupon ve betslipteki toplam oran esit degil!");
        addLog("Populer kupon ve betslipteki toplam oran esit.");
        couponOperations ops=new couponOperations();
        ops.saveCouponDetails();
        ops.setCouponName("populerWidget");
        ops.playCoupon();
        ops.cancelCoupon();
    }
}
