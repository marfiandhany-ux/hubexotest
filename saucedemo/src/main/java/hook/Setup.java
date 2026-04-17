package hook;


import com.aventstack.extentreports.*;
import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Setup {

    protected Playwright playwright;
    protected Browser browser;
    protected ExtentReports extent;
    protected ExtentTest test;

    protected Page page;

    @BeforeMethod
    public void testsetup(Method method){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        BrowserContext context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.saucedemo.com/");

        //test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void teardown() {
        browser.close();
        playwright.close();
    }

}
