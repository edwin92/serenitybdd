package transportation.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class TransportationPointPage extends PageObject {

    @FindBy( css = "h1")
    WebElementFacade title;

    public String obtainTitle( ) {
        return title.getText();
    }
}
