package challengeone;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

//Now I wanted to work out how to interact with the browser and in turn the application
//Utilise the JS Docs((https://playwright.dev/) that were referenced in the readme, to get the basic commands.
//Could see how to navigate, fill and click
//Disabled headless
//Rant about headless and how no user uses your application headlessly.

public class B_IterationTwo
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
    }
}