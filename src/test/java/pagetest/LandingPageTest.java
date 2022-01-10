package pagetest;

import org.testng.annotations.Test;

import com.dd.tests.Loginpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import TestBase.TestBase;
import pages.LandingPage;
import pages.SignupPage;

public class LandingPageTest extends TestBase {
	

	public LandingPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		
	}

	@Test(priority = 1)
	public void validateTitleTest() {
		LandingPage landingpage=new LandingPage();
		String title = landingpage.validateTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
		 
	}

	@Test(priority = 2)
	public void validatelogoTest() {
		LandingPage landingpage=new LandingPage();
		boolean logo = landingpage.validatelogo();
		Assert.assertTrue(logo);
	}

	@Test(priority = 3)
	public Loginpage validatesigninTest() {
		LandingPage landingpage=new LandingPage();
		boolean issignin = landingpage.validatelogin();
		Assert.assertTrue(issignin);
		landingpage.login();
		return new Loginpage();
	}

	@Test(priority = 4)
	public SignupPage signuptest() {
		LandingPage landingpage=new LandingPage();
		boolean issignup = landingpage.validatesigup();
		Assert.assertTrue(issignup);
		landingpage.signup();
		return new SignupPage();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
