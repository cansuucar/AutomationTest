import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By cartCountLocator = By.className("o-header__userInfo--count");
    By cartContainerLocator = By.className("o-header__userInfo--count");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    private int getCartCount() {
        String countString = find(cartCountLocator).getText();
        String textReplace = countString.replace("(", "");
        String count = textReplace.replace(")", "");
        return Integer.parseInt(count);

    }

}