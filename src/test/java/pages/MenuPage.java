package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.LINK_TEXT, using ="Inicio")
    private WebElement inicioLink;
    @FindBy(how = How.LINK_TEXT, using = "Buscar")
    private WebElement buscarLink;
    @FindBy(how = How.CLASS_NAME, using = "CreatePlaylistButton")
    private WebElement crearPlaylistLink;

    public MenuPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver,this);
    }

    public SearchPage clickBuscarLink(){
        buscarLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(buscarLink));
        return new SearchPage(driver);
    }

    public PlaylistPage clickCrearPlaylistLink(){
        crearPlaylistLink.click();
        wait.until(ExpectedConditions.elementToBeClickable(crearPlaylistLink));
        return new PlaylistPage(driver);

    }



}
