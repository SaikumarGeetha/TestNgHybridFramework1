package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement alertEmailPasswordWarningMessage;

	public AccountPage login(String emailText,String passwordText)
	{
		emailField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		login.click();
		return new AccountPage(driver);
	}
	public AccountPage clickOnLoginButton()
	{
		login.click();
		return new AccountPage(driver);
	}
	
	public boolean getEmailPasswordNotMatchingWarningMessage()
	{
		boolean alertText=alertEmailPasswordWarningMessage.isDisplayed();
		return alertText;
	}
}
