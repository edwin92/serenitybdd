package transportation.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy( id = "userName")
    WebElementFacade userName;

    @FindBy( id = "password")
    WebElementFacade userPassword;

    @FindBy( css = ".btn-blue")
    WebElementFacade btnLogin;

    public void setUserName(String name) {
        this.userName.type(name);
    }

    public void setUserPassword(String password) {
        this.userPassword.type(password);
    }

    public void logIn() {
        this.btnLogin.click();
    }
}
