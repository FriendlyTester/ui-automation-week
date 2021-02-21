package base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.microsoft.playwright.BrowserContext.*;

import java.util.ArrayList;
import java.util.List;

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
