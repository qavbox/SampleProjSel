package cucumbers.stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class LoginTest {

    WebDriver driver;

    @Given("user is on saucedemo login page")
    public void launchURL() throws InterruptedException {
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");*/

        System.out.println("launched url");
        Thread.sleep(2000);
    }

    @When("enter username")
    public void enter_username() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("enter password")
    public void enter_password() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("click on login")
    public void clickOnLogin() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("validate user is on product details page")
    public void validate_user_is_on_product_details_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("^enter username as \"([^\"]*)\"$")
    public void enter_username_as(String userName) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(userName);
    }

    @When("^enter password as \"([^\"]*)\"$")
    public void enter_password_as(String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(password);
    }

    @When("^enter username as ([^\"]*)$")
    public void enter_username_as_example(String userName) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(userName);
    }

    @When("^enter password as ([^\"]*)$")
    public void enter_password_as_example(String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(password);
    }

    @Then("close the browser")
    public void closeBrowser(){
        //driver.quit();
    }

    @When("enter username & password")
    public void enterUsernamePassword(DataTable table) {
        System.out.println("Datable user & password");

        List<Map<String, String>> data = table.asMaps();
        for(Map<String, String> d:data){
            System.out.println(d.get("username"));
            System.out.println(d.get("password"));
        }

    }
}
