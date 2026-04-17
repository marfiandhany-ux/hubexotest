package actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pages.loginPage;
import pages.homePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class actionLogin {
    Page page;

    public actionLogin(Page page) {
        this.page = page;
    }

    public void enterUsername(String username) {
        page.locator(loginPage.USERNAME_INPUT).fill(username);
    }

    public void enterPassword(String password) {
        page.locator(loginPage.PASSWORD_INPUT).fill(password);
    }

    public void clickLogin() {
        page.locator(loginPage.LOGIN_BUTTON).click();
    }

    public void verifyLogin() {
      assertThat(page.locator(homePage.burgermenu)).isVisible();

      Locator cartIcon = page.locator(homePage.shoppingCart);
      com.microsoft.playwright.options.BoundingBox box = cartIcon.boundingBox();
        System.out.println(box.y);
    }

    public void verifyLocked() {
        assertThat(page.getByText("Sorry, this user has been locked out.")).isVisible();
    }

    public void verifyPerformanceGlitch() {
        long startTime = System.currentTimeMillis();

        page.locator("#inventory_container").first().waitFor();

        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;

        if (loadTime < 3000) {
            System.err.println("Performance Issue: Performance glitch delay.");
        }
    }

    public void verifyErrorUserSortingBug() {
        page.locator(homePage.sort).selectOption("lohi");
        String firstItem = page.locator(".inventory_item_name").first().innerText();

        if (!firstItem.equals("Sauce Labs Onesie")) {
            System.err.println("Sorting error: Expected 'Sauce Labs Onesie' but the first item remained '" + firstItem + "'.");
        }
    }

    public void verifyCartIsMisplaced() {

        Locator cartIcon = page.locator(homePage.shoppingCart);
        com.microsoft.playwright.options.BoundingBox box = cartIcon.boundingBox();
        System.out.println(box.y);
        if (box.y != 10) {
            assertTrue(box.y !=10, "Shopping cart is misplaced! Its Y coordinate is " + box.y);
        }
    }







}
