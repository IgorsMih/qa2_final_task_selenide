package one_a_site.pages;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePagePom {

    private final By toLoginPage = By.xpath("//div[@class='user-block__title']");

    public static ChromeDriver driver;

    public void openChromeByUrl(String url) {
        Configuration.browserSize = "1960x1080";
//        Configuration.holdBrowserOpen = true; // for debugging
        open(url);
    }

    public void openLoginPage() {
        $(toLoginPage).click();
    }

}
