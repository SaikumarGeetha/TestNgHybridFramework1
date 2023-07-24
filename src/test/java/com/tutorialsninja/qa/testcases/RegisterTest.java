package com.tutorialsninja.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.pages.RegisterSuccessPage;
import com.tutorialsninja.qa.utils.Utilities;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RegisterTest extends Base
{
	RegisterSuccessPage registerSuccessPage;
	RegisterPage registerPage;
	public RegisterTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod()
	public void setUp()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		registerPage=homePage.naviagetToRegisterPage();
	}
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() throws InterruptedException
	{
		registerSuccessPage=registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephone"),prop.getProperty("validPassword"), 
				prop.getProperty("validPassword"));
		AssertJUnit.assertEquals(registerSuccessPage.getRegisterAccountSuccessText(),dataProp.getProperty("accountSuccessfullyCreatedHeading"));
	}
	
	@Test(priority=2)
	public void verifyRegisteringAnAccountWithAllFields() throws InterruptedException
	{
		registerSuccessPage=registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephone"),prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));
		AssertJUnit.assertEquals(registerSuccessPage.getRegisterAccountSuccessText(),dataProp.getProperty("accountSuccessfullyCreatedHeading"));
		
	}
	@Test(priority=3)
	public void verifyRegisteringanAccountWithDuplicateEmail() throws InterruptedException
	{
		registerSuccessPage=registerPage.registerWithDuplicateEmail(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephone"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));
		AssertJUnit.assertTrue(registerPage.getEmailPasswordWarningMessageText());
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringAnAccountWithoutProvidingAnyFields() throws InterruptedException
	{
		registerPage.clickOnSubmittButton();
		Assert.assertTrue(registerPage.getPrivacyPolicyWarningMessageText().contains(dataProp.getProperty("privacyPolicyWarningMessage")),"Privacy Policy Warning Message is not displayed");
		Assert.assertTrue(registerPage.getFirstNameWarningMessageText().contains(dataProp.getProperty("firstNameWarningMessage")),"FirstName warning message not displayed");
		Assert.assertEquals(registerPage.getLastNameWarningMessageText(),dataProp.getProperty("lastNameWarningMessage"),"LastName error message not displayed");
		Assert.assertEquals(registerPage.getEmailWarningMessageText(),dataProp.getProperty("emailAddressWarningMessage"),"Email warning message not displayed");
		Assert.assertTrue(registerPage.getTelephoneWarningMessageText().contains(dataProp.getProperty("telephoneWarningMessage")));
		Assert.assertEquals(registerPage.getPasswordWarningMessageText(),dataProp.getProperty("passwordWarningMessage"),"Password error message not displayed");
		
		
	}

}
