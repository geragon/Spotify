package login;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Dashboard;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){

        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername("gera187@hotmail.com");
        loginPage.setPassword("3sm3r4ld4c40s");
        Dashboard dashboard = loginPage.clickLoginButton();
        assertTrue(dashboard.getUserName().contains("Gerardo Aragón"),
                "Login incorrecto");

    }

}
