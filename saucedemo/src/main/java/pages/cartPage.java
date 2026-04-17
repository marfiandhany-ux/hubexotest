package pages;

import com.microsoft.playwright.Page;

public class cartPage {
    public static final String backpackCartButton = "#inventory-item-name";
    public static final String removeButton = "";
    public static final String checkout = "#checkout";
    public static final String firstname = "#first-name";
    public static final String lastname = "#last-name";
    public static final String postal = "#postal-code";
    public static final String continu = "#continue";
    public static final String finish = "#finish";

    Page page;

    public cartPage(Page page) {
        this.page = page;
    }

    public String removeButton(String productName) {
        // Example: remove-sauce-labs-fleece-jacket
        String removeButton = "#remove-" + productName.toLowerCase().replace(" ", "-");;
        System.out.println(removeButton);
        return removeButton;
    }
}
