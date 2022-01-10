package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dd.tests.Loginpage;

import TestBase.TestBase;

public class LandingPage extends TestBase {

	@FindBy(xpath = "//body[1]/div[1]/header[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/div[1]/a[1]/svg[1]/image[1]")
	//a[(@class= \"brand-name\")and (@title=\"free crm homes\)
	
	WebElement logo;

	@FindBy(xpath = "//header/div[1]/nav[1]/div[1]/div[1]/a[1]")
	WebElement login;

	@FindBy(xpath = "//span[@class='mdi-chart-bar icon icon-md']")
	WebElement signup;

	public LandingPage() {

		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {
		return driver.getTitle();

	}

	public boolean validatelogo() {
		return logo.isDisplayed();
	}

	public boolean validatelogin() {
		return login.isEnabled();
	}

	public Loginpage login() {
		login.click();
		return new Loginpage();
	}

	public boolean validatesigup() {
		return signup.isEnabled();
	}

	
	 public SignupPage signup()
	 { 
		 signup.click();
		 return new SignupPage(); 
     }
	 
}
