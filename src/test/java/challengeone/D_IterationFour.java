package challengeone;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//Changing the assertions to use Hamcrest for readability

public class D_IterationFour
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

        assertThat(page.isVisible("button#createRoom"), is(true));
    }
}