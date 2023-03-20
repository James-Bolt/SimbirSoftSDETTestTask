import pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases extends MainTest {

    GooglePage googlePage = new GooglePage(driver);
    private final SoftAssert softAssert = new SoftAssert();

    @Test
    public void successBuyTest() {

        googlePage = new GooglePage(driver);


        googlePage.inputStrInLogField("standard_user")
                .inputStrInPassField("secret_sauce")
                .clickContinueButtonInLogField()
                .clickAddButton()
                .clickShoppingCart()
                .clickCheckoutButton()
                .inputStrInFirstNameField("test")
                .inputStrInLastNameField("test")
                .inputStrInPostalCodeField("test")
                .clickContinueButtonInShoppingCart()
                .clickFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html",
                "No redirect");
        Assert.assertEquals(googlePage.checkCompleteOrderMessageIsVisible(), "Thank you for your order!",
                "Not displayed");
    }

    @Test
    public void loginFailTest() {

        googlePage = new GooglePage(driver);

        googlePage.inputStrInLogField("test")
                .inputStrInPassField("test")
                .clickContinueButtonInLogField();

        Assert.assertEquals(googlePage.checkErrorLogMessageIsVisible(),
                "Epic sadface: Username and password do not match any user in this service",
                "Not displayed");
    }
}
