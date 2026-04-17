import actions.*;
import hook.Setup;
import org.testng.annotations.Test;

import java.util.Map;

public class shoppingCart extends Setup {

    @Test
    public void checkoutFlow() throws InterruptedException {
        actionLogin login = new actionLogin(page);
        actionAddToCart addToCart = new actionAddToCart(page);
        actionCheckout checkout = new actionCheckout(page);
        Map<String, String> creds = utils.configReader.readCredentials("credentials.txt");

        login.enterUsername(creds.get("username"));
        login.enterPassword(creds.get("password"));
        login.clickLogin();
        login.verifyLogin();
        addToCart.clickAddToCartBackpack();
        addToCart.verifyCart();
        addToCart.clickShoppingCart();
        checkout.clickCheckout();
        checkout.fillShipment();
        Thread.sleep(1000);
        checkout.finish();
        checkout.backToHome();
        login.verifyLogin();

        Thread.sleep(1000);
    }

}
