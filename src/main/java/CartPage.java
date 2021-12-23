import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    By productNameLocator = By.className("m-basket__item");
    By productRemodeLocator = By.id("removeCartItemBtn0");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts() {
        return findAll(productNameLocator);

    }

    public void removeButton() {
        click(productRemodeLocator);
    }

    public boolean checkIfProductRemove() {
        return getProducts().size() >= 0;
    }
}