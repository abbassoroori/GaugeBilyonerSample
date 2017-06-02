package Utils;

import BilyonerBase.baseClass;
import MyCouponsPage.myCouponsPage;
import org.testng.Assert;

/**
 * Created by mert.yaman on 27/03/2017.
 * Bu classta, kupon oynanirken betslip uzerinden kupon bilgileri alinir.
 * Daha sonra kupon iptal edilirken, bu bilgiler ile kuponlarim sayfasindaki bilgiler karsilastirilir
 */
public class couponOperations extends baseClass {
    private static double betsliptotalRatio;
    private static double betslipcouponCost;
    private static double betslipmaxWin;
    private static double balance;
    private static int betslipmisli;
    private static int betslipmatchCount;
    private static String couponName;


    public void saveCouponDetails(){
        setBetsliptotalRatio(getWebElementText(prop.getBetslipTotalRatio()));
        setBetslipcouponCost(getWebElementText(prop.getBetslipCouponCost()));
        setBetslipmaxWin(getWebElementText(prop.getBetslipMaxWin()));
        setBalance(getWebElementText(prop.getBalance()));
        setBetslipmisli(getWebElementText(prop.getBetslipMisli()));
        setBetslipmatchCount(getWebElementText(prop.getBetslipMatchCount()));
    }

    public void playCoupon(){
        clickWebElement(prop.getBetslipContinueBtn());
        if(untilElementIsClickable(prop.getBetslipPlayBtn())!=null)
            addLog("Oyna butonu goruntulendi.");
        else
            Assert.fail("Oyna butonu goruntulenemedi.\n"+getWebElementText("#uyariMetni"));
        clickWebElement(untilElementIsClickable(prop.getBetslipPlayBtn()));
        addLog("Clicked: Oyna button");
        waitForAjaxLoad();
        if(untilElementIsVisible(prop.getBetslipSuccessPlayMessage())!=null)
            addLog("Kupon basariyla oynanmistir mesaji goruntulendi.");
        else
            Assert.fail(getWebElementText("#uyariMetni"));
        double expectedBalance=getBalance()-getBetslipcouponCost();
        double balanceAfterPlay =getCurrentBalance();
        Assert.assertEquals(balanceAfterPlay,expectedBalance,"Kupon oynandiktan sonraki bakiye hatali.");
        addLog("Kupon oynandiktan sonraki bakiye dogru.");
        clickWebElement(prop.getBetslipRenameCouponBtn());
        fillInputFieldWebElement(prop.getBetslipCouponNameInput(),getCouponName());
        clickWebElement(prop.getBetslipCouponNameSaveBtn());
        Assert.assertTrue(findWebElementWithoutWait(prop.getBetslipSuccessSaveMessage()),"Kupon adi kaydedilmistir mesaji goruntulenemedi.");
        addLog("Kupon adi kaydedilmistir mesaji goruntulendi.");
    }
    public void cancelCoupon(){
        myCouponsPage couponsPage=new myCouponsPage();
        couponsPage.openMyCouponsPage();
        couponsPage.findCoupon();
        double currentBalance=getCurrentBalance();
        double expectedBalance = currentBalance + getStringToDouble(getWebElementText(prop.getMyCouponsTotalCouponCost()));
        Assert.assertEquals(getStringToDouble(getWebElementText(prop.getMyCouponsTotalRatio())),getBetsliptotalRatio(),"Betslip ve oynanmis kupondaki toplam oran degeri farkli!");
        Assert.assertEquals(getStringToDouble(getWebElementText(prop.getMyCouponsTotalCouponCost())),getBetslipcouponCost(),"Betslip ve oynanmis kupondaki kupon bedeli farkli!");
        Assert.assertEquals(getStringToDouble(getWebElementText(prop.getMyCouponsMaxWin()).replace(" TL","")),getBetslipmaxWin(),"Betslip ve oynanmis kupondaki maximum kazanc degeri farkli!");
        Assert.assertEquals(getStringToInt(getWebElementText(prop.getMyCouponsMisli())),getBetslipmisli(),"Betslip ve oynanmis kupondaki misli degeri farkli!");
        clickWebElement(prop.getMyCouponsCancelBtn());
        Assert.assertTrue(untilElementIsVisible(prop.getMyCouponsCancelSuccessMessage())!=null,"Kupon iptali basarili mesaji goruntulenmedi.");
        clickWebElement(prop.getMyCouponsCancelOKBtn());
        waitForAngularLoad();
        addLog("Kupon iptali basarili");
        Assert.assertEquals(getCurrentBalance(),expectedBalance,"Kupon iptal edildikten sonraki bakiye hatali!");
        addLog("Kupon iptal edildikten sonraki bakiye dogru.");
    }

    public double getCurrentBalance(){
        return getStringToDouble(getWebElementText(prop.getBalance()).replaceAll("\\.","").replace(",","."));
    }

    public double getBetsliptotalRatio() {
        return betsliptotalRatio;
    }

    public void setBetsliptotalRatio(String betsliptotalRatio) {
        this.betsliptotalRatio = getStringToDouble(betsliptotalRatio);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = getStringToDouble(balance.replaceAll("\\.","").replace(",","."));
    }

    public String getCouponName() {
        return couponName;
    }

    public void setBetslipcouponCost(String betslipcouponCost) {
        couponOperations.betslipcouponCost = getStringToDouble(betslipcouponCost);
    }

    public void setBetslipmaxWin(String betslipmaxWin) {
        couponOperations.betslipmaxWin = getStringToDouble(betslipmaxWin);
    }

    public void setBetslipmisli(String betslipmisli) {
        couponOperations.betslipmisli = getStringToInt(betslipmisli);
    }

    public void setBetslipmatchCount(String betslipmatchCount) {
        couponOperations.betslipmatchCount = getStringToInt(betslipmatchCount);
    }

    public void setCouponName(String couponName) {
        couponOperations.couponName = couponName;
    }

    public double getBetslipcouponCost() {
        return betslipcouponCost;
    }

    public double getBetslipmaxWin() {
        return betslipmaxWin;
    }

    public  int getBetslipmisli() {
        return betslipmisli;
    }

    public int getBetslipmatchCount() {
        return betslipmatchCount;
    }

}
