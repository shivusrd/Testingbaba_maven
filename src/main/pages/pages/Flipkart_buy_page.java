package pages;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import applicationutility.Applicationutility;
import baselibrary.Baselibrary;
import baselibrary.Flipkart_baselibrary;
import waitutility.Waitutility;

public class Flipkart_buy_page extends Baselibrary

{
	public Flipkart_buy_page()

	{
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@class=\"_2KpZ6l _2doB4z\"]")
	private WebElement close;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div/div[1]/a/div[2]")

	private WebElement mobile;

	@FindBy(xpath = "//*[@class=\"_1_3w1N\"][text()='Login']")
	private WebElement loginpage;

	@FindBy(xpath = " //body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	private WebElement email;

	@FindBy(xpath = " //body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	private WebElement password;

	@FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	private WebElement login;
	
	@FindBy(xpath="//*[@class=\"_3704LK\"]")
	private WebElement comb;
	
	@FindBy(className ="col-1-12")
	private WebElement button;
	
	@FindBy(xpath ="//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div[1]")
	private WebElement button2;
	
	@FindBy(xpath ="//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	private WebElement button3;
	



	//*[@id='container']/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/div/ul/li[1]/button
	public void login() throws InterruptedException

	{
		close.click();
		loginpage.click();
		email.sendKeys("8171765673");

		password.sendKeys("Shivu@srd1");

		login.click();
		Thread.sleep(5000);
	}
	
	public void AddtoCart() throws InterruptedException 
	
	{
		comb.sendKeys("comb");
		button.click();
		Thread.sleep(5000);
		button2.click();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
	    Thread.sleep(6000);
	    driver.navigate();
	    button3.click();
	    
	}
	
	

}
