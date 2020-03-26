package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTests extends BaseTests {

    @Test
    @Parameters({"songName", "artistName"})
    public void searchSong(String SongName, String artistName){
        searchPage = menuPage.clickBuscarLink();
        searchPage.setSongName(SongName);
        searchPage.validateMainSong(SongName);
        searchPage.validateSongList(SongName,artistName);
    }

    @Test
    @Parameters({"songName", "artistName"})
    public void playSong(String SongName, String artistName){
        searchPage = menuPage.clickBuscarLink();
        searchPage.setSongName(SongName);
        searchPage.validateMainSong(SongName);
        searchPage.validateSongList(SongName,artistName);
        searchPage.playMainSong(SongName);
    }
}
