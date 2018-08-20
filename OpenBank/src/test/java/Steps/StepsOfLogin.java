package Steps;
import Base.BaseUntil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class StepsOfLogin extends BaseUntil {
    private BaseUntil base;
    public StepsOfLogin( BaseUntil base){
        this.base = base;
    }

    @When("^Делаем клик по Войти в почту$")
    public void делаем_клик_по_Войти_в_почту() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-statlog='notifications.mail.logout.domik.login.big']")));

        base.driver.findElement(By.cssSelector("[data-statlog='notifications.mail.logout.domik.login.big']")).click();

    }

    @When("^Вводим логин \"([^\"]*)\"$")
    public void вводим_логин(String arg1) throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='login']")));
        base.driver.findElement(By.cssSelector("[name='login']")).sendKeys(arg1);

    }

    @When("^Вводим пароль \"([^\"]*)\"$")
    public void вводим_пароль(String arg1) throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='passwd']")));
        base.driver.findElement(By.cssSelector("[name='passwd']")).sendKeys(arg1);

    }

    @When("^Кликаем по кнопке войти$")
    public void кликаем_по_кнопке_войти() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".passport-Button-Content .passport-Button-Text")));
        base.driver.findElement(By.cssSelector(".passport-Button-Content .passport-Button-Text")).click();

    }
}
