package pageBase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageBase.TestDriver;
//import Drivers.TestFireFoxProfile;


public class Firefox_remote_driver extends org.openqa.selenium.firefox.FirefoxDriver implements TestDriver{
/*static FirefoxProfile customProfile = new TestFireFoxProfile().getProfile();
	
	public FireFoxDriver() throws SecurityException, IOException{		
		super(customProfile);
		afterSetUp();
	}
	
	public FireFoxDriver(FirefoxProfile profile) throws SecurityException, IOException{
		super(profile);
		afterSetUp();
	}
	
	private void afterSetUp() throws SecurityException, IOException{
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
		
		/*Validator ffValidations= new Validator("") {
			
			public void Validate() {
	
				int currentVersion = Integer.parseInt(getBrowserVersion().split("\\.")[0]);
				if(currentVersion < 16){
					throw new RuntimeException("Increase firefox to version 16 or upper, to avoid errors.");
				}
				
				MavenConfiguration mavenConfiguration = new MavenConfiguration();
				String seleniumInPom = mavenConfiguration.getVersion("selenium-java");
				
				if(seleniumInPom == null) {
					throw new RuntimeException("please configure this dependecy in you pom.xml:	<dependency>\n<groupId>org.seleniumhq.selenium</groupId>\n<artifactId>selenium-java</artifactId>\n<version></version>\n</dependency>.");
				}
				
				int seleniumVersion = Integer.parseInt(seleniumInPom.split("\\.")[0]);
				int seleniumRelease = Integer.parseInt(seleniumInPom.split("\\.")[1]);
				if((seleniumVersion <2 || seleniumRelease < 33) && currentVersion == 22 ){
					throw new RuntimeException("FiroFox's version 22 needs at least selenium-java 2.33.0.");
				}
				else if((seleniumVersion <2 || seleniumRelease < 34) && currentVersion == 23 ){
					throw new RuntimeException("FiroFox's version 23 needs at least selenium-java 2.34.0.");
				}				
			}
		};
		//ffValidations.Validate();
	}
	
	public void get(String domine, String user, String pass){
		get("https://"+user+":"+pass+"@"+domine);       
	}
	 
	public void moveToElement(WebElement element){
		Actions builder = new Actions(this); 
		builder.moveToElement(element).build().perform();
	 }

	public void doubleClick(WebElement element){
		Actions builder = new Actions(this); 
		builder.doubleClick(element).build().perform();
	 }
	 
	public void clickAndHold(WebElement element){
		Actions builder = new Actions(this); 
		builder.clickAndHold(element).build().perform();
	 }
	  
	public void dragAndDrop(WebElement source, WebElement target){
		Actions builder = new Actions(this); 
		builder.dragAndDrop(source, target).build().perform();
	 }

	public void waitToElementBeVisible(final WebElement... element){

	 }
	 
	public void waitToElementBeEnabled(final WebElement... element){
		
		
	 }
	
	public boolean isElementPresent(By by){
	    return this.findElements(by).size() != 0;
	}
	 
	public void waitToElementBeSelected(final WebElement... element){
		
	 }
	 
	public String getBrowserVersion(){
		return this.getCapabilities().getVersion();
	 }	 */
	
	
 
	public static WebDriver createInstance()    {	
		try {
			
			
			 

		       DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
			   //capabilities.setCapability("marionette", true);
		       //capabilities.setCapability("networkConnectionEnabled", true);
		      // capabilities.setCapability("browserConnectionEnabled", true);
		       //capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		       capabilities.setCapability("browserName",BrowserType.FIREFOX); 
		       
		       /*FirefoxProfile profile = new FirefoxProfile();
		       profile.setPreference("intl.accept_languages", "en");
		       profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
		       profile.setPreference("signon.autologin.proxy", true);
		       capabilities.setCapability(FirefoxDriver.PROFILE, profile);*/


		        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
		    

				return driver;
		}
				catch (Exception e) {
					System.out.println("Falla en el catch "+e.getMessage());
					return null;
		}
	}
	
@Override
public void get(String domine, String user, String pass) {
	// TODO Auto-generated method stub
	
}

@Override
public void moveToElement(WebElement element) {
	// TODO Auto-generated method stub
	
}

@Override
public void doubleClick(WebElement element) {
	// TODO Auto-generated method stub
	
}

@Override
public void clickAndHold(WebElement element) {
	// TODO Auto-generated method stub
	
}

@Override
public void dragAndDrop(WebElement source, WebElement target) {
	// TODO Auto-generated method stub
	
}

@Override
public void waitToElementBeVisible(WebElement... element) {
	// TODO Auto-generated method stub
	
}

@Override
public void waitToElementBeEnabled(WebElement... element) {
	// TODO Auto-generated method stub
	
}

@Override
public void waitToElementBeSelected(WebElement... element) {
	// TODO Auto-generated method stub
	
}

@Override
public String getBrowserVersion() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public WebElement xpath() {
	// TODO Auto-generated method stub
	return null;
}
	
	
}
