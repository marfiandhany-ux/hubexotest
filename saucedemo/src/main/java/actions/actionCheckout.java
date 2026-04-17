package actions;

import com.microsoft.playwright.Page;
import pages.cartPage;

public class actionCheckout {

    Page page;
    public actionCheckout(Page page) {
        this.page = page;
    }

    public void clickCheckout() {
        page.locator(cartPage.checkout).click();
    }

    public void fillShipment() {
        page.locator(cartPage.firstname).fill("Rabbit");
        page.locator(cartPage.lastname).fill("Hole");
        page.locator(cartPage.postal).fill("12345");
        page.locator(cartPage.continu).click();
    }

    public void finish() {
        page.locator(cartPage.finish).click();
    }
}
