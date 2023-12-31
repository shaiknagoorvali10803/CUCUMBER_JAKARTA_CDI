package StepDefinitions;


import Utils.WebDriverProvider;

import io.cucumber.java.en.Then;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.junit.jupiter.api.Assertions;
import Page.HRM.Dashboard;
import Page.HRM.LoginPage;

public class DashboardPageStepDefinitions {
  
  @Inject
  private WebDriverProvider driverProvider;

  @Inject
  LoginPage login;
  @Inject
  Dashboard dashboard;
	  
  @Then("i will veryfy the Dashboard content Apple leave")
  public void user_should_be_able_verify_applyleave() throws InterruptedException {
	  login.verifyLoginAsValidUser();
	  String verifyUserAccess = dashboard.verifyUserAccess();
	  Assertions.assertEquals(verifyUserAccess, "Dashboard");
	  Thread.sleep(2000);
	  dashboard.verifyassignleave_link();
	  Thread.sleep(2000);
	  login.logout();
	       
  }
  
  @Then("i will veryfy the Dashboard content leave link")
  public void user_should_be_able_verify_leavelink() throws InterruptedException {
	  login.verifyLoginAsValidUser();
	  String verifyUserAccess = dashboard.verifyUserAccess();
      Assertions.assertEquals(verifyUserAccess, "Dashboard");
	  Thread.sleep(2000);
	  dashboard.verifyleavelist_link();
	  Thread.sleep(12000);
     
  }
}
