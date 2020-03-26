package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected MenuPage menuPage;
    protected SearchPage searchPage;
    protected PlaylistPage playlistPage;


    @BeforeMethod
    public void setUp(){
        //Iniciamos Chrome con la pantalla maximizada
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(options);

        //Colocamos la url del sitio que queremos abrir
        driver.get("https://open.spotify.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);

    }

    @AfterMethod
    public void TearDown() throws InterruptedException {
        //Destruimos la instancia
        Thread.sleep(6000);
        driver.quit();
    }

}

