package challengeone;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

//My goal here was just to make sure all the different pieces of my approach were working. Don't care what the test was doing.
//It didn't error, but with it running headless I couldn't see anything.
public class A_IterationOne
{
    @Test
    public void challengeOne() {
        Browser browser = Playwright.create()
                .chromium()
                .launch();

        Page page = browser.newPage();
        page.navigate("https://automationintesting.online/#/admin");
        browser.close();
    }
}
