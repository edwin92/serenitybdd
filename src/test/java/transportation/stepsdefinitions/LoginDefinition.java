package transportation.stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import transportation.steps.LoginStep;

public class LoginDefinition {

    @Steps( shared = true )
    LoginStep loginStep;

    @Dado("^Que (.*) entra al portal  de transporte$")
    public void enterToLogIn(String actorName) {
        loginStep.isCalled(actorName);
        loginStep.enterToLogIn();
    }

    @Cuando("^(.*) inicia sesion con usuario: (.*) y clave: (.*)$")
    public void logIn( String actorName, String userName, String userPassword ) {
        loginStep.isCalled(actorName);
        loginStep.logIn(userName, userPassword);
    }

    @Entonces("^(.*) deberia poder ver la pantalla principal de: (.*)$")
    public void viewHomePage( String actorName, String namePage) {
        loginStep.isCalled(actorName);
        loginStep.viewHomePage(namePage);
    }
}
