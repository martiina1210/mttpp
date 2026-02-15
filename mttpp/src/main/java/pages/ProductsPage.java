package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By firstAddToCartButton = By.cssSelector(".inventory_item button");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");
    private By firstRemoveButton = By.cssSelector(".inventory_item button");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartItemCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void removeFirstProduct() {
        driver.findElement(firstRemoveButton).click();
    }

}
