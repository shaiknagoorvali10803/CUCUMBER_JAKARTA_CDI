package StepDefinitions;

import Page.Google.GooglePage;
import Utils.ScenarioContext;
import Utils.SeleniumUtils;
import Utils.WebDriverProvider;
import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;
public class GoogleSteps {
    @Inject
    protected WebDriverProvider driverProvider;
    @Inject
    private GooglePage googlePage;
    @Inject
    ScenarioContext scenarioContext;

    @PostConstruct
    private void init( ){
        PageFactory.initElements(this.driverProvider.getInstance(), this);
       }

   @Given("I am on the google site")
    public void launchSite() {
        this.googlePage.goTo();
        }
    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.search(keyword);
        }

    @Then("I should see search results page")
    public void clickSearch() throws IOException {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(4));
        Assertions.assertTrue(this.googlePage.isAt());
        SeleniumUtils.insertScreenShot(driverProvider.getInstance(),scenarioContext,"getting Count");

       }
    @Then("I should see at least {int} results")
    public void verifyResults(int count) throws InterruptedException, IOException {
        Assertions.assertTrue(this.googlePage.getCount() >= count);
        SeleniumUtils.singleClick(driverProvider.getInstance(),By.xpath("//a[normalize-space()='Images']"));
        SeleniumUtils.insertScreenShot(driverProvider.getInstance(),scenarioContext,"imgaes");
        Thread.sleep(3000);
        System.out.println("Current Thread Number "+ Thread.currentThread().getThreadGroup() +"thread number"+ Thread.currentThread().getId());
        driverProvider.getInstance().findElement(By.xpath("//a[normalize-space()='Videos']")).click();
        SeleniumUtils.insertScreenShot(driverProvider.getInstance(),scenarioContext,"videos");
        Thread.sleep(3000);
    }
 }
