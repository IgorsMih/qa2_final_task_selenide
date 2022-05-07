package one_a_site.pages;

import one_a_site.models.UserStatic;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ShoppingCartPagePom {

    UserStatic userStatic = new UserStatic();

    private final By getProductName = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private final By getProductPrice = By.xpath("//p[@class='detailed-cart-item__price']");
    private final By turpinat = By.xpath("//input[@class='main-button cart-main-button']");
    private final By pickUpPoint = By.xpath("//input[@value='3210']");
    private final By fullName = By.xpath("//div[@class='name']");
    private final By phoneNumberVal = By.xpath("//div[@class='address']");
    private final By getFinalPrice = By.xpath("//td[@class='checkout-order-summary-total-products__price']");
    private final By clickOnDelete = By.xpath("//div[@class='detailed-cart-item__delete-wrap']");
    private final By selectProfilePicture = By.xpath("//div[@class='user-block__title']");
    private final By selectLogOff = By.id("logout_link");

    public void validateThatShoppingCartIsOpen() {
        assertEquals("https://www.1a.lv/cart", url());
    }

    public void validateNameAndPrice() {
        assertThat($(getProductName).getText()).isEqualTo(ProductPagePom.product.getProductName());
        assertThat($(getProductPrice).getText() + " / gab.").isEqualTo(ProductPagePom.product.getProductPrice());
    }

    public void turpinatShopping() {
        $(turpinat).click();
    }

    public void addressFieldsInCarts() {
        $(pickUpPoint).click();
    }

    public void validateFieldsAndFinalPrice() {
        $(fullName).scrollIntoView(false);
        assertThat($(fullName).getText()).isEqualTo(userStatic.getFirstName() + " " + userStatic.getSecondName());
        assertThat($(phoneNumberVal).getText()).isEqualTo("+371" + userStatic.getMobile() + " Mainīt");
        assertThat($(getFinalPrice).getText() + " / gab.").isEqualTo(ProductPagePom.product.getProductPrice());
    }

    public void clearShoppingCart() {
        back();
        $(clickOnDelete).click();
        switchTo().alert().accept();
    }

    public void logOff() {
        actions().moveToElement($(selectProfilePicture)).perform();
        actions().moveToElement($(selectLogOff)).click().perform();
    }

}
