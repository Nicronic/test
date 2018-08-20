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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class StepsOfMail extends BaseUntil {
    private BaseUntil base;
    public StepsOfMail( BaseUntil base){
        this.base = base;
    }

    public boolean isElementPresent(By by) {
        try {
            base.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @Given("^Открыть страницу \"([^\"]*)\"$")
    public void открыть_страницу(String arg1) throws Throwable {
        base.driver.get(arg1);

    }

    @Then("^Проверяем что мы на странице \"([^\"]*)\"$")
    public void проверяем_что_мы_на_странице(String arg1) throws Throwable {
        base.driver.getTitle().equals(arg1);

    }
    @When("^Кликаем по кнопке Написать$")
    public void кликаем_по_кнопке_Написать() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mail-ComposeButton-Text")));

        base.driver.findElement(By.cssSelector(".mail-ComposeButton-Text")).click();

    }

    @When("^Кликаем по Кому$")
    public void кликаем_по_Кому() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='to']")));

        base.driver.findElement(By.cssSelector("[name='to']")).click();
    }


    @When("^Вводим кому отправляем \"([^\"]*)\"$")
    public void вводим_кому_отправляем(String arg1) throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 15))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='to']+span")));
        base.driver.findElement(By.cssSelector("[name='to']")).sendKeys(arg1);
    }

    @When("^Вводим тему письма \"([^\"]*)\"$")
    public void вводим_тему_письма(String arg1) throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mail-Compose-Field-Input-Controller.js-compose-field.js-editor-tabfocus-prev")));
        base.driver.findElement(By.cssSelector(".mail-Compose-Field-Input-Controller.js-compose-field.js-editor-tabfocus-prev")).sendKeys(arg1);

    }

    @When("^Вводим тело письма \"([^\"]*)\"$")
    public void вводим_тело_письма(String arg1) throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cke_contents.cke_reset div div")));
        base.driver.findElement(By.cssSelector(".cke_contents.cke_reset div")).sendKeys(arg1);

    }

    @When("^Кликаем по Отправить$")
    public void кликаем_по_Отправить() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit'] ._nb-button-text")));

        base.driver.findElement(By.cssSelector("[type='submit'] ._nb-button-text")).click();

    }



    @When("^Кликаем по Несортированные$")
    public void кликаем_по_Несортированные() throws Throwable {
        TimeUnit.SECONDS.sleep(15);
        base.driver.navigate().refresh();
        if(isElementPresent(By.cssSelector(".mail-LabelList-Item_count"))){
            WebElement element1 = (new WebDriverWait(base.driver, 4))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mail-LabelList-Item_count")));
            base.driver.findElement(By.cssSelector(".mail-LabelList-Item_count")).click();
        }

    }

    @Then("^Проверяем что письмо наше$")
    public void проверяем_что_письмо_наше() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mail-MessageSnippet-FromText' and text()='Test Тестович']")));
        base.driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText' and text()='Test Тестович']"));

    }

    @When("^Омтечаем его$")
    public void омтечаем_его() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._nb-checkbox-flag._nb-checkbox-normal-flag")));
        base.driver.findElement(By.cssSelector("._nb-checkbox-flag._nb-checkbox-normal-flag")).click();

    }

    @Then("^Кликаем по Удалить$")
    public void кликаем_по_Удалить() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-params='source=toolbar'][title='Удалить (Delete)'] .js-toolbar-item-title-delete")));
        base.driver.findElement(By.cssSelector("[data-params='source=toolbar'][title='Удалить (Delete)'] .js-toolbar-item-title-delete")).click();

    }
    @When("^Кликаем по Удаленные$")
    public void кликаем_по_Удаленные() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-params='fid=3']")));
        base.driver.findElement(By.cssSelector("[data-params='fid=3']")).click();

    }

    @When("^Перемещаем письмо во Входящие$")
    public void перемещаем_письмо_во_Входящие() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mail-Toolbar-Item-Text.js-toolbar-item-title.js-toolbar-item-title-folders-actions")));
        base.driver.findElement(By.cssSelector(".mail-Toolbar-Item-Text.js-toolbar-item-title.js-toolbar-item-title-folders-actions")).click();
        WebElement element2 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Входящие'] .js-folder-name")));
        base.driver.findElement(By.cssSelector("[title='Входящие']")).click();

    }

    @Then("^Проверяем что наше письмо на месте$")
    public void проверяем_что_наше_письмо_на_месте() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-params='fid=1']")));
        base.driver.findElement(By.cssSelector("[data-params='fid=1']")).click();
        WebElement element2 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='mail-MessageSnippet-FromText' and text()='Test Тестович']")));
        base.driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText' and text()='Test Тестович']"));

    }
    @When("^Кликаем по Избранное$")
    public void кликаем_по_Избранное() throws Throwable {
        WebElement element1 = (new WebDriverWait(base.driver, 4))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='testforopen@yandex.ru']/ancestor::div[@class='mail-MessageSnippet-Wrapper']//span[@class=' js-message-snippet-importance mail-MessageSnippet-Item mail-MessageSnippet-Item_importance mail-Icon mail-Icon-Importance']")));
        base.driver.findElement(By.xpath("//span[@title='testforopen@yandex.ru']/ancestor::div[@class='mail-MessageSnippet-Wrapper']//span[@class=' js-message-snippet-importance mail-MessageSnippet-Item mail-MessageSnippet-Item_importance mail-Icon mail-Icon-Importance']")).click();

    }
}
