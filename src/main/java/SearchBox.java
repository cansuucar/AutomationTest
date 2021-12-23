import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchBox extends BasePage {

    By searchBoxLocator = By.tagName("INPUT");
    By submitButtonLocator = By.tagName("BUTTON");


    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator, text);
        click(submitButtonLocator);
    }
}