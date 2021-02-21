import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class ChallengeOne
{
    private Browser browser;

    @Test
    public void LoginToRBP()
    {
        browser = Playwright.create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().withHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://automationintesting.online/#/admin");
        page.fill("#username", "admin");
        page.fill("#password", "password");
        page.click("#doLogin");
        page.screenshot(new Page.ScreenshotOptions().withPath(Paths.get("colosseum-pixel2.png")));
    }
}
