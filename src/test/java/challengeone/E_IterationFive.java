package challengeone;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RoomListPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//Refactoring it to use PageObjects

public class E_IterationFive
{
    @Test
    public void challengeOne()
    {
        Browser browser = Playwright.create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().withHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://automationintesting.online/#/admin");

        LoginPage loginPage = new LoginPage(page);
        loginPage.populateUsername("admin")
                .populatePassword("password");

        RoomListPage roomListPage = loginPage.clickLogin();

        assertThat(roomListPage.isCreateRoomButtonVisible(), is(true));
    }
}