package challangesix;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RoomListPage;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class A_IterationOne {

    @Test
    public void challengeSix(){

        Playwright playwright = Playwright.create();

        List<BrowserType> browserTypes = Arrays.asList(
                playwright.chromium(),
                playwright.webkit(),
                playwright.firefox());

        for (BrowserType browserType : browserTypes) {

            Browser browser = browserType.launch(new BrowserType.LaunchOptions().withHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().withViewport(800, 600));
            Page page = context.newPage();
            page.navigate("https://automationintesting.online/#/admin");
            LoginPage loginPage = new LoginPage(page);
            loginPage.populateUsername("admin")
                    .populatePassword("password");

            RoomListPage roomListPage = loginPage.clickLogin();

            assertThat(roomListPage.isCreateRoomButtonVisible(), is(true));

            browser.close();
        }
    }
}


