package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;
      
public class LoginTest extends Base {
	
	LoginPage loginPage;
	public LoginTest()
	{
		super();
	}
	public WebDriver driver;
	@BeforeMethod()
	public void setUp()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		loginPage=homePage.naviagetToLoginPage();
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="supplyTestData")
	public void verifyLoginWithValidCredentials(String email,String password) throws InterruptedException 
	{
		AccountPage accountPage = loginPage.login(email, password);
		AssertJUnit.assertTrue(accountPage.getDisplayStatusOfChangePassword());
	}
	@DataProvider()
	public Object[][] supplyTestData() 
	{
		Object [][] data= Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority=2) 
	public void verifyLoginWithInValidCredentials() throws InterruptedException
	{
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		
		AssertJUnit.assertTrue(loginPage.getEmailPasswordNotMatchingWarningMessage());
			
	}
	@Test(priority=3)
	public void verifyLoginWithInValidEmailAndValidPassword() throws InterruptedException
	{
		loginPage.login(Utilities.generateEmailWithTimeStamp(), prop.getProperty("validPassword"));
		AssertJUnit.assertTrue(loginPage.getEmailPasswordNotMatchingWarningMessage());
		
		
	}
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInValidPassword() throws InterruptedException
	{
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		AssertJUnit.assertTrue(loginPage.getEmailPasswordNotMatchingWarningMessage());
		
	
	}
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() throws InterruptedException
	{
		loginPage.clickOnLoginButton();
		AssertJUnit.assertTrue(loginPage.getEmailPasswordNotMatchingWarningMessage());
		
	}
	
	

}
