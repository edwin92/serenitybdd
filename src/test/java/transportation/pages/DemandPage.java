package transportation.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class DemandPage extends PageObject {

    @FindBy( css = "h1")
    WebElementFacade title;

    @FindBy( xpath = "/html/body/app-root/app-main-layout/div/div/section/app-nav-dash/nav/ul/li[4]/a")
    WebElementFacade linkDemand;

    @FindBy( id = "transporter")
    WebElementFacade transporterFilter;

    @FindBy( css = "input.date-ph")
    WebElementFacade dateFilter;

    @FindBy( css = "button.btn-blue")
    WebElementFacade buttonFilter;

    @FindBy(css = "th")
    List<WebElementFacade> headersTable;

    public String obtainTitle( ) { return title.getText(); }

    public List<String> obtainHeadersTable() { return headersTable.stream()
            .map( elem -> elem.getText()).collect(Collectors.toList());
    }

    public void setTransporterFilter(String point) {
        if (!StringUtils.isEmpty(point))
            this.transporterFilter.selectByVisibleText(point);
    }

    public void setDateFilter(String date) {
        if (!StringUtils.isEmpty(date))
            this.dateFilter.type(date);
    }

    public List<String> clickFilter() {
        this.buttonFilter.click();
        return findAll("/html/body/app-root/app-main-layout/div/div/section/app-demand/div/app-table/table/tbody/tr")
                                .stream()
                                .map(element -> element.getAttribute("td"))
                                .collect(Collectors.toList());
    }

    public void clickLinkDemand() {
        this.linkDemand.click();
    }



    /**
     * public List<String> obtenerResultados(){
     *         return findAll(TITULO_RESULTADO)
     *                 .stream()
     *                 .map(element -> element.getAttribute("textContent"))
     *                 .collect(Collectors.toList());
     *     }
     *
     *     public String obtenerTextoDeTituloResultado(String tituloDeResultado) {
     *         return findBy(TITULO_RESULTADO_CON_TEXTO,tituloDeResultado)
     *                 .then().findBy(DESCRIPCION_DE_TEXTO)
     *                 .then().getText();
     *     }
     */
}
