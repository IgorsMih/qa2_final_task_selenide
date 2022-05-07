package one_a_site.pages;

import one_a_site.models.UserStatic;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class LoginPagePom {

    UserStatic userStatic = new UserStatic();

    private final By loginName = By.xpath("//input[@name='user[email]']");
    private final By loginPassword = By.xpath("//input[@name='user[password]']");
    private final By submitButton = By.xpath("//input[@class='users-session-form__submit']");

    public void validateThatLoginPageIsOpen() {
        assertEquals("https://www.1a.lv/users/sign_in", url());
    }

    public void enterLoginNameAndPasswordAndSubmit(String name, String password) {
        if ("IMEmail".equals(name)) {
            name = userStatic.getLoginName();
        } else name = "gmail@gmail.com";
        $(loginName).sendKeys(name);

        if ("IMPSW".equals(password)) {
            password = userStatic.getPassword();
        } else password = "None";
        $(loginPassword).sendKeys(password);
        $(submitButton).click();
    }

}


