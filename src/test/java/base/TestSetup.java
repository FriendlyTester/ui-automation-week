package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestSetup {

    private Browser browser;
    protected Page page;

    @BeforeEach
    public void setUp(){
        browser = Playwright.create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().withHeadless(false));

        page = browser.newPage();
        page.navigate("https://automationintesting.online/#/admin");
    }

    @AfterEach
    public void tearDown()
    {
        browser.close();
    }
}
