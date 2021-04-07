package transportation.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import transportation.pages.DemandPage;
import transportation.pages.LoginPage;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DemandStep extends ScenarioActor {

    String actor;

    @Steps(shared = true)
    DemandPage demandPage;

    @Steps(shared = true)
    LoginPage loginPage;

    @Step("#actor entra al portal de transporte con usuario: {0} y clave: {1}")
    public void enterToLogIn(String user, String password) {
        loginPage.setDefaultBaseUrl("http://localhost:4200/#/login");
        loginPage.open();
        loginPage.setUserName(user);
        loginPage.setUserPassword(password);
        loginPage.logIn();
    }

    @Step("#actor ingresa a la sección de demanda de transporte")
    public void enterToDemand() {
        demandPage.clickLinkDemand();
    }

    @Step("#actor debería visualizar la pantalla de demanda de trasporte con título: {0}")
    public void validateTitle(String namePage) {
        String title = demandPage.obtainTitle();
        assertTrue(title.equals(namePage));
    }

    @Step("#actor debería visualizar una tabla con las cabeceras de: {0}, {1} y {2}")
    public void validateHeadersTitles(String dateName, String pointName, String totalName) {
        List<String> listTitles = demandPage.obtainHeadersTable();
        System.out.println(listTitles);
        assertTrue(listTitles.get(0).equals(dateName));
        assertTrue(listTitles.get(1).equals(pointName));
        assertTrue(listTitles.get(2).equals(totalName));
    }

    @Step("#actor debería poder filtrar por Fecha de transporte: {0} y Punto de recogida: {1}")
    public void validateFilters(String date, String point) {
        demandPage.setTransporterFilter(point);
        demandPage.setDateFilter(date);
        List<String> listValues = demandPage.clickFilter();
        //TODO: Recorer los resultados y validar la fecha
        assertTrue(listValues.size() > 0);
    }
}
