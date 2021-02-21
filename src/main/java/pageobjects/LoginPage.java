package pageobjects;

import com.microsoft.playwright.Page;

public class LoginPage{

    private Page page;
    private String inputUsername = "#username";
    private String inputPassword = "#password";
    private String buttonLogin = "#doLogin";

    public LoginPage(Page page){
        this.page = page;
    }

    public LoginPage populateUsername(String username)
    {
        page.fill(inputUsername, username);
        return this;
    }

    public LoginPage populatePassword(String password)
    {
        page.fill(inputPassword, password);
        return this;
    }

    public RoomListPage clickLogin() {
        page.click(buttonLogin);
        return new RoomListPage(page);
    }
}
