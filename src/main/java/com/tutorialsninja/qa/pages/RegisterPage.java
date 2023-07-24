package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	@FindBy(id="input-lastname")
	private WebElement lastName;
	@FindBy(name="email")
	private WebElement emailField;
	@FindBy(name="telephone")
	private WebElement telephoneField;
	@FindBy(name="password")
	private WebElement passwordField;
	@FindBy(name="confirm")
	private WebElement confirmPasswordField;
	@FindBy(name="agree")
	private WebElement agreebox;
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement newslLetterButton;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement emailPasswordWarningMessage;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement privacyPlocyWarningMessage;
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	private WebElement emailWarningMessage;
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	public void enterFirstName(String firstNameText)
	{
		firstName.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText)
	{
		lastName.sendKeys(lastNameText);
	}
	public void enterEmailField(String emailFieldText)
	{
		emailField.sendKeys(emailFieldText);
	}
	public void enterTelephoneField(String telephoneText)
	{
		telephoneField.sendKeys(telephoneText);
	}
	public void enterpasswordField(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	public void enterConfirmpasswordField(String confirmPasswordText)
	{
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	public void clickOnAgree()
	{
		agreebox.click();
	}
	public RegisterSuccessPage clickOnSubmittButton()
	{
		submitButton.click();
		return new RegisterSuccessPage(driver);
	}
	public void clickOnNewsLetterButton()
	{
		newslLetterButton.click();
	}
	public RegisterSuccessPage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailFieldText,String telephoneText,String passwordText,String confirmPasswordText)
	{
		firstName.sendKeys(firstNameText);
		lastName.sendKeys(lastNameText);
		emailField.sendKeys(emailFieldText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmPasswordText);
		agreebox.click();
		submitButton.click();
		return new RegisterSuccessPage(driver);
	}
	public RegisterSuccessPage registerWithAllFields(String firstNameText,String lastNameText,String emailFieldText,String telephoneText,String passwordText,String confirmPasswordText)
	{
		firstName.sendKeys(firstNameText);
		lastName.sendKeys(lastNameText);
		emailField.sendKeys(emailFieldText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmPasswordText);
		newslLetterButton.click();
		agreebox.click();
		submitButton.click();
		return new RegisterSuccessPage(driver);
	}
	public RegisterSuccessPage registerWithDuplicateEmail(String firstNameText,String lastNameText,String emailFieldText,String telephoneText,String passwordText,String confirmPasswordText)
	{
		firstName.sendKeys(firstNameText);
		lastName.sendKeys(lastNameText);
		emailField.sendKeys(emailFieldText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(confirmPasswordText);
		newslLetterButton.click();
		agreebox.click();
		submitButton.click();
		return new RegisterSuccessPage(driver);
	}
	
	
	public boolean getEmailPasswordWarningMessageText()
	{
		boolean emailpasswordtext=emailPasswordWarningMessage.isDisplayed();
		return emailpasswordtext;
	}
	public String getPrivacyPolicyWarningMessageText()
	{
		String privacyWarningText=privacyPlocyWarningMessage.getText();
		return privacyWarningText;
	}
	public String getFirstNameWarningMessageText()
	{
		String firstNameWarningText=firstNameWarningMessage.getText();
		return firstNameWarningText;
	}
	public String getLastNameWarningMessageText()
	{
		String lastNameWarningText=lastNameWarningMessage.getText();
		return lastNameWarningText;
	}
	public String getEmailWarningMessageText()
	{
		String emailWarningText=emailWarningMessage.getText();
		return emailWarningText;
	}
	public String getTelephoneWarningMessageText()
	{
		String tephoneWarningText=telephoneWarningMessage.getText();
		return tephoneWarningText;
	}
	public String getPasswordWarningMessageText()
	{
		String passwordWarningText=passwordWarningMessage.getText();
		return passwordWarningText;
	}
}
