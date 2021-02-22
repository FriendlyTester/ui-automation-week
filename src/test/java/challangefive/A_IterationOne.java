package challangefive;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RoomListPage;

import java.nio.file.Paths;
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
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideo().
                    withDir((Paths.get(System.getProperty("user.home") + "/Desktop"))).withSize(1024, 1024)
                    .done().withViewport(1024, 1024));

            BrowserContext.AddCookie cookie = new BrowserContext.AddCookie()
                    .withName("banner")
                    .withDomain("automationintesting.online")
                    .withPath("/")
                    .withExpires(1619048124)
                    .withValue("true");

            List<BrowserContext.AddCookie> cookies = List.of(
                    cookie
            );

            context.addCookies(cookies);

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


