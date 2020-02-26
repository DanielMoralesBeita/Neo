package pageBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import pageBase.ChromeDriver;
import pageBase.Driver;
//import pageBase.FireFoxDriver;
//import pageBase.InternetExplorerDriver;

public class Driver {
	public static WebDriver driver;
	public static  Driver instance;

	public Driver() {}
	public static List<WebDriver> alinstaces=new ArrayList<WebDriver>();
	/*public static Driver getInstance(String browserType) throws SecurityException, IOException {
		//return  new Driver(browserType);
		 
	}*/
	
	public static WebDriver Driver2(String browserType) throws SecurityException, IOException{
		switch (browserType) {
			case BrowserType.CHROME:
				return   ChromeDriver.createInstance2();
		 	case BrowserType.FIREFOX:
				return  Firefox_remote_driver.createInstance();
		 	case BrowserType.IE:
				return InternetExplorerDriver.createInstance();
		 default:
				return null;
 	 
		} 
		
		
	}
		
	public WebDriver obtenerDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void cerrarDriver(){
		driver.quit();
		instance = null;
	}



}
