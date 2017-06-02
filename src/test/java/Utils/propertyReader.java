package Utils;

/**
 * Created by mert.yaman on 26/01/2017.
 * Bu class; properties dosyasindan pathleri okumak ve bunlara kolayca ulasabilmek icin
 * getter metodlarinin olusturuldugu classtir.
 */
public class propertyReader {

//    parameters

    private String proxyAddress                     = System.getenv("proxyAddress");
    private String proxyUser                        = System.getenv("proxyUser");
    private String proxyPass                        = System.getenv("proxyPass");
    private boolean isOSMAC                         = Boolean.parseBoolean(System.getenv("isOSMAC"));
    private String bilyonerUrl                      = System.getenv("bilyoner");

//    homepage paths

    private String userId                           = System.getenv("userId");
    private String password                         = System.getenv("password");
    private String userIdInput                      = System.getenv("userIdInput");
    private String passwordInput                    = System.getenv("passwordInput");
    private String loginBtn                         = System.getenv("loginBtn");
    private String username                         = System.getenv("bilusername");
    private String balance                          = System.getenv("balance");
    private String tribunWidget                     = System.getenv("tribunWidget");
    private String populerWidget                    = System.getenv("populerWidget");
    private String quadboxCell1                     = System.getenv("quadboxCell1");
    private String quadboxCell2                     = System.getenv("quadboxCell2");
    private String quadboxCell3                     = System.getenv("quadboxCell3");
    private String quadboxCell4                     = System.getenv("quadboxCell4");
    private String tribunWidgetPlayBtn              = System.getenv("tribunWidgetPlayBtn");
    private String tribunWidgetMatchCodeList        = System.getenv("tribunWidgetMatchCodeList");
    private String tribunWidgetTotalRatio           = System.getenv("tribunWidgetTotalRatio");
    private String popularWidgetPlayBtn             = System.getenv("popularWidgetPlayBtn");
    private String popularWidgetMatchCodeList       = System.getenv("popularWidgetMatchCodeList");
    private String popularWidgetTotalRatio          = System.getenv("popularWidgetTotalRatio");
    private String myAccountMenu                    = System.getenv("myAccountMenu");
    private String myAccountMenumyCouponsBtn        = System.getenv("myAccountMenumyCouponsBtn");


//    betslip paths

    private String betslipTotalRatio                = System.getenv("betslipTotalRatio");
    private String betslipAllMatchCodes             = System.getenv("betslipAllMatchCodes");
    private String betslipCouponCost                = System.getenv("betslipCouponCost");
    private String betslipMaxWin                    = System.getenv("betslipMaxWin");
    private String betslipMisli                     = System.getenv("betslipMisli");
    private String betslipMatchCount                = System.getenv("betslipMatchCount");
    private String betslipContinueBtn               = System.getenv("betslipContinueBtn");
    private String betslipPlayBtn                   = System.getenv("betslipPlayBtn");
    private String betslipSuccessPlayMessage        = System.getenv("betslipSuccessPlayMessage");
    private String betslipRenameCouponBtn           = System.getenv("betslipRenameCouponBtn");
    private String betslipCouponNameInput           = System.getenv("betslipCouponNameInput");
    private String betslipCouponNameSaveBtn         = System.getenv("betslipCouponNameSaveBtn");
    private String betslipSuccessSaveMessage        = System.getenv("betslipSuccessSaveMessage");


//    myCoupons page paths

    private String myCouponsTitle                   = System.getenv("myCouponsTitle");
    private String myCouponsNameList                = System.getenv("myCouponsNameList");
    private String myCouponsTotalRatio              = System.getenv("myCouponsTotalRatio");
    private String myCouponsTotalCouponCost         = System.getenv("myCouponsTotalCouponCost");
    private String myCouponsMaxWin                  = System.getenv("myCouponsMaxWin");
    private String myCouponsMisli                   = System.getenv("myCouponsMisli");
    private String myCouponsCancelBtn               = System.getenv("myCouponsCancelBtn");
    private String myCouponsCancelSuccessMessage    = System.getenv("myCouponsCancelSuccessMessage");
    private String myCouponsCancelOKBtn             = System.getenv("myCouponsCancelOKBtn");





    public String getBilyonerUrl() {
        return bilyonerUrl;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public String getProxyPass() {
        return proxyPass;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserIdInput() {
        return userIdInput;
    }

    public String getPasswordInput() {
        return passwordInput;
    }

    public String getLoginBtn() {
        return loginBtn;
    }

    public String getBalance() {
        return balance;
    }

    public boolean isOSMAC() {
        return isOSMAC;
    }

    public String getUsername() {
        return username;
    }

    public String getTribunWidget() {
        return tribunWidget;
    }

    public String getPopulerWidget() {
        return populerWidget;
    }

    public String getQuadboxCell1() {
        return quadboxCell1;
    }

    public String getQuadboxCell2() {
        return quadboxCell2;
    }

    public String getQuadboxCell3() {
        return quadboxCell3;
    }

    public String getQuadboxCell4() {
        return quadboxCell4;
    }

    public String getTribunWidgetPlayBtn() {
        return tribunWidgetPlayBtn;
    }

    public String getTribunWidgetMatchCodeList() {
        return tribunWidgetMatchCodeList;
    }

    public String getTribunWidgetTotalRatio() {
        return tribunWidgetTotalRatio;
    }

    public String getPopularWidgetPlayBtn() {
        return popularWidgetPlayBtn;
    }

    public String getPopularWidgetMatchCodeList() {
        return popularWidgetMatchCodeList;
    }

    public String getPopularWidgetTotalRatio() {
        return popularWidgetTotalRatio;
    }

    public String getBetslipTotalRatio() {
        return betslipTotalRatio;
    }

    public String getBetslipAllMatchCodes() {
        return betslipAllMatchCodes;
    }

    public String getMyAccountMenu() {
        return myAccountMenu;
    }

    public String getMyAccountMenumyCouponsBtn() {
        return myAccountMenumyCouponsBtn;
    }

    public String getMyCouponsTitle() {
        return myCouponsTitle;
    }

    public String getMyCouponsNameList() {
        return myCouponsNameList;
    }

    public String getMyCouponsTotalRatio() {
        return myCouponsTotalRatio;
    }

    public String getMyCouponsTotalCouponCost() {
        return myCouponsTotalCouponCost;
    }

    public String getMyCouponsMaxWin() {
        return myCouponsMaxWin;
    }

    public String getMyCouponsMisli() {
        return myCouponsMisli;
    }

    public String getMyCouponsCancelBtn() {
        return myCouponsCancelBtn;
    }

    public String getMyCouponsCancelSuccessMessage() {
        return myCouponsCancelSuccessMessage;
    }

    public String getMyCouponsCancelOKBtn() {
        return myCouponsCancelOKBtn;
    }

    public String getBetslipCouponCost() {
        return betslipCouponCost;
    }

    public String getBetslipMaxWin() {
        return betslipMaxWin;
    }

    public String getBetslipMisli() {
        return betslipMisli;
    }

    public String getBetslipMatchCount() {
        return betslipMatchCount;
    }

    public String getBetslipContinueBtn() {
        return betslipContinueBtn;
    }

    public String getBetslipPlayBtn() {
        return betslipPlayBtn;
    }

    public String getBetslipSuccessPlayMessage() {
        return betslipSuccessPlayMessage;
    }

    public String getBetslipRenameCouponBtn() {
        return betslipRenameCouponBtn;
    }

    public String getBetslipCouponNameInput() {
        return betslipCouponNameInput;
    }

    public String getBetslipCouponNameSaveBtn() {
        return betslipCouponNameSaveBtn;
    }

    public String getBetslipSuccessSaveMessage() {
        return betslipSuccessSaveMessage;
    }

}
