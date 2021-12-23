import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class Beymen_Test extends BaseTest {


    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    // Searches for "pants" on Beymen site
    public void search_a_product() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("Pantolon");
        Assertions.assertTrue(productsPage.isOnProductPage(), "The pants are listed");

    }

    @Test
    @Order(2)
    //Product selection on Beymen site
    public void select_a_product() {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(2);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Found on product detail page");

    }


    @Test
    @Order(3)
    //Add product to cart on Beymen site
    public void add_product_to_cart() {
        productDetailPage.selectProductSize(5);
        productDetailPage.addToCart();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        Assertions.assertTrue(homePage.isProductCountUp(), "Product was count increase");

    }

    @Test
    @Order(4)
    //My cart section on Beymen site
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(), "Product was added to cart!");

    }

    @Test
    @Order(5)
    //Delete cart on Beymen site
    public void delete_product_from_cart(){
        cartPage = new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        cartPage.removeButton();
        Assertions.assertTrue(cartPage.checkIfProductRemove(), "Product was remove to cart!");

    }

}