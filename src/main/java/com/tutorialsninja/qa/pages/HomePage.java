package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='My Account']") 
	private WebElement myAccountDropMenu;
	@FindBy(linkText="Login")
	private WebElement selectLoginOption;
	@FindBy(linkText="Register")
	private WebElement selectRegisterMenu;
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchField;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchSubmitButton;
	
	public LoginPage naviagetToLoginPage()
	{
		myAccountDropMenu.click();
		selectLoginOption.click();
		return new LoginPage(driver);
	}
	public void enterValidProductInSearchField(String validProduct)
	{
		searchField.sendKeys(validProduct);
	}
	public SearchSuccessPage clickOnSearchButton()
	{
		searchSubmitButton.click();
		return new SearchSuccessPage(driver);
	}
	
	public SearchSuccessPage searchForValidProduct(String product)
	{
		searchField.sendKeys(product);
		searchSubmitButton.click();
		return new SearchSuccessPage(driver);
	}
	public RegisterPage naviagetToRegisterPage()
	{
		myAccountDropMenu.click();
		selectRegisterMenu.click();
		return new RegisterPage(driver);
	}
	
	
 
}
