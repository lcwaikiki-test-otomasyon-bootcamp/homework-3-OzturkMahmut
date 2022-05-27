package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;


public class LoginPage {


    String loginPageTitle = "Üye Girişi - LC Waikiki";
    //CSS selectors
    By emailRadioButton = By.cssSelector(".login-form__radio-buttons .login-form__radio-buttons--first-label");
    By phoneRadioButton = By.cssSelector(".login-form__radio-buttons .login-form__radio-buttons--second-label");
    By loginFormTitle = By.cssSelector("div .login-form__title");
    By emailInputForm = By.cssSelector(".text-input[name=email]");
    By passwordInputForm = By.cssSelector(".text-input[name=password]");
    By showPasswordIcon = By.cssSelector("div .login-form__show-password-icon--img");
    By rememberMeCheckBox = By.cssSelector(".checkbox-label .checkbox-span");
    By forgotPasswordLink = By.cssSelector("div .login-form__forgot-password-link");
    By loginFormLoginButton = By.cssSelector(".login-form__button.login-form__button--bg-blue");
    By phoneTextInput = By.cssSelector(".login-form__phone.text-input");

    By emailError = By.cssSelector(".login-form > form:nth-child(2) > div:nth-child(2) > div:nth-child(2)");
    By passwordError = By.cssSelector(".login-form__password .error");
    By loginError = By.cssSelector("div .login-form__header-errors--p ");

    //Login Form ELements
    String emailType = "E-Posta";
    String  emailRadioButtonS = "E-Posta radio button";
    String  phoneRadioButtonS = "Telefon radio button";
    String loginFormTitleS = "GIRIS YAP title";
    String  emailInputFormS = "E-Posta Adresiniz text on Email";
    String  passwordInputFormS = "Şifreniz text on Password";
    String  showPasswordIconS = "Show Password Icon";
    String  rememberMeCheckBoxS = "Beni hatırla text";
    String  forgotPasswordLinkS = "Sifremi Unuttum link";
    String  loginFormLoginButtonS = "GIRIS YAP login button";
    String  phoneTextInputS = "Phone Text Box";

    WebDriver driver;
    ElementHelper helper;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new ElementHelper(driver);
        this.wait = new WebDriverWait(driver,10);
    }

    public void checkTitle(){
        helper.checkTitle(loginPageTitle);
    }

    public void setLoginType(String type){
        if(type.equals(emailType)){
            helper.click(emailRadioButton);
        }else {
            helper.click(phoneRadioButton);
        }
    }

    public void checkLoginFormElements(String element){
        if(element.equals(loginFormTitleS)){
            helper.presenceElement(loginFormTitle);
        }else if(element.equals(emailRadioButtonS)){
            helper.presenceElement(emailRadioButton);
        }else if(element.equals(phoneRadioButtonS)){
            helper.presenceElement(phoneRadioButton);
        }else if(element.equals(emailInputFormS)){
            String placeholder = helper.presenceElement(emailInputForm).getAttribute("placeholder");
            boolean contains = emailInputFormS.contains(placeholder);
            Assert.assertTrue(contains);
        }else if(element.equals(passwordInputFormS)){
            String placeholder = helper.presenceElement(passwordInputForm).getAttribute("placeholder");
            boolean contains = passwordInputFormS.contains(placeholder);
            Assert.assertTrue(contains);
        }else if(element.equals(showPasswordIconS)){
            helper.presenceElement(showPasswordIcon);
        }else if(element.equals(rememberMeCheckBoxS)){
            String text = helper.presenceElement(rememberMeCheckBox).getText();
            boolean contains = rememberMeCheckBoxS.contains(text);
            Assert.assertTrue(contains);
        }else if(element.equals(forgotPasswordLinkS)){
            helper.presenceElement(forgotPasswordLink);
        }else if(element.equals(loginFormLoginButtonS)){
            helper.presenceElement(loginFormLoginButton);
        }else if (element.equals(phoneTextInputS)){
            helper.presenceElement(phoneTextInput);
        }
    }

    public void clickLoginButton(){
        helper.click(loginFormLoginButton);
    }

    public void checkEmailErrorMessage(String errorMessage){
       String emailErrorMessage = helper.presenceElement(emailError).getText();
       Assert.assertEquals(errorMessage,emailErrorMessage);
    }

    public void checkPasswordErrorMessage(String errorMessage){
        String passwordErrorMessage = helper.presenceElement(passwordError).getText();
        Assert.assertEquals(errorMessage,passwordErrorMessage);
    }

    public void checkLoginErrorMessage(String errorMessage){
        String loginErrorMessage = helper.presenceElement(loginError).getText();
        System.out.println(loginErrorMessage);
        Assert.assertEquals(errorMessage,loginErrorMessage);
    }

    public void typeEmail(String input){
        helper.sendKey(emailInputForm,input);
    }

    public void typePassword(String input){
        helper.sendKey(passwordInputForm,input);
    }

    public void checkEmailErrorInvisibility(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(emailError));
    }

    public void checkPasswordErrorInvisibility(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(passwordError));
    }

}
