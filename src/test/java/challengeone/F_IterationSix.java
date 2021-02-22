package challengeone;

import base.TestSetup;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RoomListPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//Refactoring to abstract out the test setup

public class F_IterationSix extends TestSetup
{
    @Test
    public void challengeOne()
    {
        LoginPage loginPage = new LoginPage(page);
        loginPage.populateUsername("admin")
                .populatePassword("password");

        RoomListPage roomListPage = loginPage.clickLogin();

        assertThat(roomListPage.isCreateRoomButtonVisible(), is(true));
    }
}