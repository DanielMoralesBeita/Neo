package pageBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageBase.TestDriver;

public class InternetExplorerDriver extends org.openqa.selenium.ie.InternetExplorerDriver implements TestDriver {
	
	static String url = "http://localhost:4444";
	
	public InternetExplorerDriver(){
		super();
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	@SuppressWarnings("deprecation")
	public InternetExplorerDriver(org.openqa.selenium.Capabilities capabilities) {
		  super (capabilities);
		  manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}

	@SuppressWarnings("deprecation")
	public InternetExplorerDriver(int port) {
		super(port);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	public InternetExplorerDriver(InternetExplorerDriverService service) {
		super(service);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	public static WebDriver createInstance() throws MalformedURLException {		
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
		desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		desiredCapabilities.setJavascriptEnabled(true); 
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,   
				true); 
		desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
		desiredCapabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://www.google.com/");
		desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);         
		desiredCapabilities.setCapability("enablePersistentHover", false); 
		
		WebDriver driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
		
		return driver;
	}
		
	public void quit(){
		 super.quit();
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
	 
	 public String getBrowserVersion(){
		 return this.getCapabilities().getVersion();
	 }

	
	public void waitToElementBeSelected(WebElement... element) {
	
	}

	@Override
	public void get(String domine, String user, String pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebElement xpath() {
		// TODO Auto-generated method stub
		return null;
	}	 
}