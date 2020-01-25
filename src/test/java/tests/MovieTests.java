package tests;

import common.BaseTest;
import libs.Database;
import models.MovieModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MovieTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        login
                .open()
                .with("papito@ninjaplus.com", "pwd123");

        side.loggedUser().shouldHave(text("Papito"));
    }

    @Test
    public void shoudlRegisterANewMovie() {
        MovieModel movieData = new MovieModel(
                "Jumanji - Próxima fase",
                "Pré-venda",
                2020,
                "16/01/2020",
                Arrays.asList("The Rock", "Jack Black", "Kevin Hart", "Karen Gillan", "Danny DeVito"),
                "Tentado a revisitar o mundo de Jumanji, Spencer decide "
                        + "consertar o bug no jogo do game que permite que sejam transportados ao local",
                "jumanji2.jpg"
        );

        Database db = new Database();
        db.deleteMovie(movieData.title);

        movie
                .add()
                .create(movieData)
                .items().findBy(text(movieData.title)).shouldBe(visible);
    }
}
