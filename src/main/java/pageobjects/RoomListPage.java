package pageobjects;

import com.microsoft.playwright.Page;

public class RoomListPage {

    private Page page;
    private String btnCreateRoom = "#createRoom";

    public RoomListPage(Page page){
        this.page = page;
    }

    public boolean isCreateRoomButtonVisible()
    {
        return page.isVisible(btnCreateRoom);
    }


}
