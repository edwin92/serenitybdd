package transportation.steps;

import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import transportation.pages.LoginPage;
import transportation.pages.TransportationPointPage;

import static org.junit.Assert.assertTrue;

public class LoginStep extends ScenarioActor {

    String actor;

    @Steps( shared = true )
    LoginPage loginPage;

    @Steps( shared = true )
    TransportationPointPage transportation;

    @Step( "#actor entra al portal  de transporte" )
    public void enterToLogIn() {
        loginPage.setDefaultBaseUrl("http://localhost:4200/#/login");
        loginPage.open();
    }

    @Step( "#actor inicia sesion con usuario: {0} y clave: {1}" )
    public void logIn(String user, String password) {
        loginPage.setUserName(user);
        loginPage.setUserPassword(password);
        loginPage.logIn();
    }

    @Step( "#actor deberia poder ver la pantalla principal de: {0}" )
    public void viewHomePage(String namePage) {
        String title = transportation.obtainTitle();
        assertTrue(title.equals(namePage));
    }
}
