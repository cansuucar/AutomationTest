import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.id("addBasket");
    By productSizeLocater = By.className("m-variation__item");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public void selectProductSize(int i) {
        getAllProductSize().get(i).click();
    }

    private List<WebElement> getAllProductSize() {
        return findAll(productSizeLocater);
    }

}