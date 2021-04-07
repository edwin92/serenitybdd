package transportation.stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import transportation.steps.DemandStep;

public class DemandDefinition {

    @Steps( shared = true )
    DemandStep demandStep;

    @Dado("^Que (.*) entra al portal de transporte con usuario: (.*) y clave: (.*)$")
    public void enterToLogIn( String actorName, String userName, String userPassword) {
        demandStep.isCalled(actorName);
        demandStep.enterToLogIn(userName, userPassword);
    }

    @Cuando("^(.*) ingresa a la sección de demanda de transporte$")
    public void enterToDemand( String actorName) {
        demandStep.isCalled(actorName);
        demandStep.enterToDemand();
    }

    @Entonces("^(.*) debería visualizar la pantalla de demanda de trasporte con título: (.*)")
    public void validateTitle( String actorName, String namePage) {
        demandStep.isCalled(actorName);
        demandStep.validateTitle(namePage);
    }

    @Entonces("^(.*) debería visualizar una tabla con las cabeceras de: (.*), (.*) y (.*)")
    public void validateHeadersTitles( String actorName, String dateName, String pointName, String totalName) {
        demandStep.isCalled(actorName);
        demandStep.validateHeadersTitles( dateName, pointName, totalName);
    }

    @Entonces("^(.*) debería poder filtrar por Fecha de transporte: (.*) y Punto de recogida: (.*)")
    public void validateFilters( String actorName, String date, String point) {
        demandStep.isCalled(actorName);
        demandStep.validateFilters(date, point);
    }
}
