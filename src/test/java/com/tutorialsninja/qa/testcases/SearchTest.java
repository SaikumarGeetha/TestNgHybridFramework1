package com.tutorialsninja.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchSuccessPage;

public class SearchTest extends Base{
	SearchSuccessPage searchSuccessPage;
	HomePage homePage;
	public SearchTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod()
	public void setUp()
	{
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
	}
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct()
	{
		searchSuccessPage=homePage.searchForValidProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchSuccessPage.getHpProductVisible(),"Valid Product HP is not displayed in Search results page");
		
		
	}
	@Test(priority=2)
	public void verifySearchWithInValidProduct()
	{
		//dataProp.getProperty("warningTextMessage")
		searchSuccessPage=homePage.searchForValidProduct(dataProp.getProperty("inValidProduct"));
		Assert.assertEquals(searchSuccessPage.enterHondaText(),"xyz","no products in search page is not displayed");
	}
	@Test(priority=3,dependsOnMethods={"verifySearchWithInValidProduct"})
	public void verifySearchWithEmptyDetails()
	{
		searchSuccessPage=homePage.clickOnSearchButton();
		Assert.assertEquals(searchSuccessPage.clickOnSearchButton(),dataProp.getProperty("warningTextMessage"),"no products in search page is not displayed");
		
	}

}
