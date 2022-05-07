package one_a_site.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import one_a_site.pages.HomePagePom;

public class HomePageStep {

    HomePagePom homePagePom = new HomePagePom();

    @Given("Open Home Page")
    public void openHomePage() {
        homePagePom.openChromeByUrl("https://www.1a.lv/");
    }

    @And("Open Login Page")
    public void openLoginPage() {
        homePagePom.openLoginPage();
    }

}
