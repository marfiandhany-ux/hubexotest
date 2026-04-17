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
        page.locator(cartPage.firstname).fill(utils.randomGenerator.generateRandomLetters(8));
        page.locator(cartPage.lastname).fill(utils.randomGenerator.generateRandomLetters(10));
        page.locator(cartPage.postal).fill(utils.randomGenerator.generateRandomNumbers(5));
        page.locator(cartPage.continu).click();
    }

    public void finish() {
        page.locator(cartPage.finish).click();
    }

    public void backToHome() {
        page.locator(cartPage.backtoproducts).click();
    }


}
