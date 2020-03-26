package tests;

import base.BaseTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    @Parameters({ "user", "username", "password" })
    public void testSuccessfulLogin(String user, String username, String password) throws IOException {

        loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        dashboardPage = loginPage.clickLoginButton();
        assertTrue(dashboardPage.getUserName().contains(user),
                "Login incorrecto");
    }
}
