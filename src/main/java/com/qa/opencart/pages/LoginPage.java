package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage  {
	
	private Page page;
	
	//String Locators
	private String emailID = "//input[@id= 'input-email']";
	private String password = "//input[@id= 'input-password']";
	private String loginBtn = "//input[@class= 'btn btn-primary']";
	private String forgotPwdLink = "//input[@id = 'input-password']/../a[text()='Forgotten Password']";
    private String logoutLink = "//a[@class ='list-group-item'][normalize-space()='Logout']";
   
	
	public LoginPage(Page page){
		this.page = page;
	}
	
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(forgotPwdLink);
	}
	public boolean doLogin(String appUserName, String appPassword)
	{
		System.out.println("AppCreds:"+ appUserName + ":" + appPassword);
		page.fill(emailID, appUserName);
		page.fill(password, appPassword);
		
		page.click(loginBtn);
		if(page.isVisible(logoutLink))
		{
			System.out.println("User is logged in successfully...");
			return true;
		}
		return false;
	}
	
}
