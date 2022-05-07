package one_a_site.pages;

import one_a_site.models.Product;
import one_a_site.modules.CreateFile;
import one_a_site.modules.WriteToFile;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ProductPagePom {

    public static Product product = new Product();
    CreateFile createFile = new CreateFile();
    WriteToFile writeToFile = new WriteToFile();

    private final By acceptCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By selectMenu = By.xpath("//span[@class='main-menu__handle-text']");
    private final By openDatortehnikaSubmenu = By.xpath("//a[@class='submenu-lvl1__link']");
    private final By openPortativieDatori = By.xpath("//img[@src='https://sb.ksd-images.lt/onea_lv/images/rich_texts/Articles/limonade5/2/3_PORTATIVIE_DATORI_2.jpg']");
    private final By openPortativieDatoriBiznesam = By.xpath("//div[@class='catalog-taxons-visual-filter-glide-slider__slide glide__slide']");
    private final By openProduct = By.xpath("//div[@class='catalog-taxons-product catalog-taxons-product--grid-view'][1]");
    private final By getProductName = By.xpath("//div[@class='product-righter google-rich-snippet']/h1");
    private final By getProductPrice = By.xpath("//span[@class='price'][1]");
    private final By addProductToShoppingCart = By.id("add_to_cart_btn");
    private final By goToShoppingCart = By.xpath("//a[@class='main-button']");

    public void findAsus() {

        sleep(5000);
        $(acceptCookies).click();
        actions().moveToElement($(selectMenu)).perform();
        actions().moveToElement($(openDatortehnikaSubmenu)).click().perform();
        $(openPortativieDatori).click();
        actions().moveToElement($(openPortativieDatoriBiznesam)).click().perform();
        sleep(1000);
        actions().moveToElement($(openProduct)).click().perform();
    }

    public void getNamePriceAndLink() {
        product.setProductName($(getProductName).getText());
        product.setProductPrice($(getProductPrice).getText());
        product.setProductLink(url());
        System.out.println("Name  = " + product.getProductName() + "\nPrice = " + product.getProductPrice() + "\nLink  = " + product.getProductLink());
//      Creating file and writing information to it
//        createFile.create();
//        writeToFile.write(product.getProductName(), product.getProductPrice(), product.getProductLink());
    }

    public void addToCart() {
        $(addProductToShoppingCart).click();
        sleep(1000);
        $(goToShoppingCart).click();
    }

}
