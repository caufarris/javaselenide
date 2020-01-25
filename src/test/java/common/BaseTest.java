package common;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.MoviePage;
import pages.SideBar;

public class BaseTest {
    protected static LoginPage login;
    protected static SideBar side;
    protected static MoviePage movie;

    @BeforeMethod
    public void start() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";
        Configuration.timeout = 30000;

        login = new LoginPage();
        side = new SideBar();
        movie = new MoviePage();
    }
}
