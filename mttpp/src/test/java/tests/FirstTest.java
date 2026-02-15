package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.MenuPage;



public class FirstTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"));
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "wrong_password");

        String errorMessage = driver.findElement(
                org.openqa.selenium.By.cssSelector("h3[data-test='error']")
        ).getText();

        Assert.assertTrue(errorMessage.contains("Username and password do not match"));
    }

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();

        String cartCount = productsPage.getCartItemCount();

        Assert.assertEquals(cartCount, "1");
    }

    @Test
    public void removeProductFromCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addFirstProductToCart();
        productsPage.removeFirstProduct();

        boolean cartIsEmpty = driver.findElements(
                org.openqa.selenium.By.className("shopping_cart_badge")
        ).isEmpty();

        Assert.assertTrue(cartIsEmpty);
    }

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        MenuPage menuPage = new MenuPage(driver);
        menuPage.logout();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucedemo"));
    }


}
