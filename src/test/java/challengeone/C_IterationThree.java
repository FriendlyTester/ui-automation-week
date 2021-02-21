package challengeone;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Adding in the assertion, which is to check the create button is displayed

public class C_IterationThree
{
    @Test
    public void challengeOne()
    {
        Browser browser = Playwright.create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().withHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://automationintesting.online/#/admin");
        page.fill("#username", "admin");
        page.fill("#password", "password");
        page.click("#doLogin");
        assertTrue(page.isVisible("button#createRoom"));
    }
}