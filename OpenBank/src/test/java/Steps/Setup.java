package Steps;

import Base.BaseUntil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup extends BaseUntil {

    private BaseUntil base;
    public Setup(BaseUntil base){
        this.base = base;
    }
    @Before
    public void SetupInitialization(){

        
        System.setProperty("webdriver.chrome.driver","d:/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.setExperimentalOption("useAutomationExtension", false);
        base.driver = new ChromeDriver(options);
    }

    @After
    public void TearDown(){
        base.driver.quit();
    }
}
