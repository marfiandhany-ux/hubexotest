package actions;

import com.microsoft.playwright.Page;
import pages.homePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class actionAddToCart {

    Page page;
    public actionAddToCart(Page page) {
        this.page = page;
    }

    public void clickAddToCartBackpack() {
        page.locator(homePage.backpackCartButton).click();
    }

    public void clickRemoveBackpack() {
        page.locator(homePage.backpackRemoveButton).click();
    }

    public void clickShoppingCart() {
        page.locator(homePage.shoppingCart).click();
    }

    public void verifyCart() {
        assertThat(page.locator(homePage.cartBadge)).hasText("1");;
    }




}
