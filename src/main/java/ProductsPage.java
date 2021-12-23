import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By shippingOptionLocator = By.id("productList");
    By productNameLocater = By.className("m-productCard__photo");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {

        return isDisplayed(shippingOptionLocator);
    }

    public void selectProduct(int i) {

        getAllProduct().get(i).click();

    }

    private List<WebElement> getAllProduct() {
        return findAll(productNameLocater);
    }

}