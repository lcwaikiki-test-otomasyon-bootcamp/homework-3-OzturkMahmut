package stepDefinitions;

import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import util.DriverFactory;

public class LoginPageSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Then("User should see Login Page")
    public void userShouldSeeLoginPage() {
        loginPage.checkTitle();
    }


    @Given("User is on Login Page")
    public void userIsOnLoginPage() {
        homePage.clickLoginButton();
    }

    @When("User clicks {string} radio button")
    public void setLoginType(String loginType) {
        loginPage.setLoginType(loginType);
    }

    @Then("User should see {string}")
    public void userShouldSee(String element) {
        loginPage.checkLoginFormElements(element);
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("should see {string} Email Error message")
    public void shouldSeeEmailErrorMessage(String errorMessage) {
        loginPage.checkEmailErrorMessage(errorMessage);
    }

    @Then("should see {string} Password Empty message")
    public void shouldSeePasswordErrorMessage(String errorMessage) {
        loginPage.checkPasswordErrorMessage(errorMessage);
    }

    @When("User types Email {string}")
    public void userTypesEmail(String email) {
        loginPage.typeEmail(email);
    }

    @When("User types Password {string}")
    public void userTypesPassword(String password) {
        loginPage.typePassword(password);
    }

    @Then("should not see Email Empty message")
    public void shouldNotSeeEmailErrorMessage() {
        loginPage.checkEmailErrorInvisibility();
    }

    @Then("should not see Password Empty message")
    public void shouldNotSeePasswordErrorMessage() {
        loginPage.checkPasswordErrorInvisibility();
    }

    @Then("should see {string} Login Error message")
    public void shouldSeeLoginErrorMessage(String error) {
        loginPage.checkLoginErrorMessage(error);
    }
}
