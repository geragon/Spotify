package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class PlaylistTests extends BaseTests {

    @Test
    @Parameters({"username", "password", "playlist" })
    public void nuevaPlaylist(String username, String password, String playlist) throws IOException {

        loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        dashboardPage = loginPage.clickLoginButton();

        playlistPage = menuPage.clickCrearPlaylistLink();
        playlistPage.setPlaylistName(playlist);

    }
}
