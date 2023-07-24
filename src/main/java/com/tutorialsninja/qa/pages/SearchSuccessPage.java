package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchSuccessPage {
	
	WebDriver driver;
	public SearchSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement hpText;
	
	@FindBy(xpath="//input[@value='Search']/following-sibling::p")
	private WebElement hondaText;
	
	@FindBy(xpath="//input[@value='Search']/following-sibling::p")
	private WebElement emptyText;
	
	public boolean getHpProductVisible()
	{
		boolean hpProductText=hpText.isDisplayed();
		return hpProductText;
	}
	public String enterHondaText()
	{
		String getWarningText=hondaText.getText();
		return getWarningText;
	}
	public String clickOnSearchButton()
	{
		String getText=emptyText.getText();
		return getText;
	}
	
	

}
