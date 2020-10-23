package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Pages{

        //WebDriver driver;

        /*HomePage(WebDriver driver){
                this.driver = driver;
                PageFactory.initElements(driver, this);
        }*/

        /*HomePage(WebDriver driver) {
                super(driver);
        }*/

        @FindBy(id = "user-name")
        public WebElement username;

        @FindBy(id = "password")
        public WebElement password;

        @FindBy(id = "login-button")
        public WebElement login;


        public void login(){
                username.sendKeys("standard_user");
                password.sendKeys("secret_sauce");
                login.click();
        }

        /*
        @FindBys( {
                @FindBy(className = "class1"),
                @FindBy(className = "class2")
        } )
        private List<WebElement> elementsMatchedWithBoth_class1_AND_class2;


        @FindAll({
                @FindBy(className = "class1"),
                @FindBy(className = "class2")
        })
        private List<WebElement> elementsWithEither_class1_OR_class2
        */
}
