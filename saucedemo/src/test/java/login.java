import actions.actionAddToCart;
import actions.actionLogin;
import hook.Setup;
import org.testng.annotations.Test;
import pages.homePage;

import java.util.Map;

public class login extends Setup {

    @Test
    public void loginTest() throws InterruptedException {
        actionLogin login = new actionLogin(page);
        Map<String, String> creds = utils.configReader.readCredentials("credentials.txt");
        login.enterUsername(creds.get("username"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        login.verifyLogin();
        assert page.url().equals("https://www.saucedemo.com/inventory.html");
        Thread.sleep(1000);
    }

    @Test
    public void loginLocked() throws InterruptedException {
        actionLogin login = new actionLogin(page);
        Map<String, String> creds = utils.configReader.readCredentials("credentials.txt");
        login.enterUsername(creds.get("username2"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        login.verifyLocked();
        Thread.sleep(1000);
    }

    @Test
    public void loginProblem() throws InterruptedException {
        actionLogin login = new actionLogin(page);
        actionAddToCart addToCart = new actionAddToCart(page);
        Map<String, String> creds = utils.configReader.readCredentials("credentials.txt");
        login.enterUsername(creds.get("username3"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        if (page.locator(homePage.backpackCartButton).isVisible()){
            addToCart.clickAddToCartBackpack();
        }
        addToCart.clickRemoveBackpack();
        assert page.locator(homePage.backpackRemoveButton).isVisible();
        Thread.sleep(1000);
    }

    @Test
    public void loginPerformance() throws InterruptedException {
        actionLogin login = new actionLogin(page);
        Map<String, String> creds = utils.configReader.readCredentials("credentials.txt");
        login.enterUsername(creds.get("username4"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        login.verifyPerformanceGlitch();
    }

    @Test
    public void loginError() throws InterruptedException {
        actionLogin login = new actionLogin(page);
        Map<String, String> creds = utils.configReader.readCredentials("credentials.txt");
        login.enterUsername(creds.get("username5"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        login.verifyErrorUserSortingBug();
        Thread.sleep(1000);
    }

    @Test
    public void loginVisual() throws InterruptedException {
        actionLogin login = new actionLogin(page);
        Map<String, String> creds = utils.configReader.readCredentials("credentials.txt");
        login.enterUsername(creds.get("username6"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        login.verifyCartIsMisplaced();
        Thread.sleep(1000);
    }



}
