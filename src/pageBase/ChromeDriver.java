package pageBase;

import java.net.URL;


import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class ChromeDriver extends org.openqa.selenium.chrome.ChromeDriver implements  TestDriver {
	public ChromeDriver(){
		super();
		//manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	public ChromeDriver(ChromeDriverService service){
		super(service);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	public ChromeDriver(org.openqa.selenium.Capabilities capabilities){
		super(capabilities);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	public ChromeDriver(ChromeOptions options){
		super(options);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	public ChromeDriver(ChromeDriverService service, ChromeOptions options){
		super(service, options);
		manage().timeouts().implicitlyWait(IMPLICT_TIME, IMPLICT_TIME_UNIT );
	}
	
	private static void loadExe(){
	//	System.setProperty("webdriver.chrome.driver", Constantes.ChromeDriver);
	}
	
	public static ChromeDriver createInstance(){
		try {
		//loadExe();
	
		       DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		       ChromeOptions options = new ChromeOptions();
		       //options.addArguments("test-type");
		       //options.addArguments("--start-maximized");
		      //options.addArguments("--disable-web-security");
		       //options.addArguments("--headless");
		       //options.addArguments("--no-sandbox");
		       //options.addArguments("--allow-running-insecure-content");
		      //options.addArguments("--disable-extension");
		       //Poner en chrome chrome://version/ para ver la ruta del perfil actual.
		      //C:\Program Files (x86)\Google\Chrome\Application\chrome.exe "user-data-dir=C:\\Users\\C5060226\\AppData\\Local\\Google\\Chrome\\User Data"
		      //usar ese comando en la cosola de CMD y logearse para que deje las credenciales lista para la aplicacion !!!
		      //Eso es un punto super importante!!! recuerda que ese User-data-dir es un comando de cmd que se puede ejecutar!!!

//options.addArguments("user-data-dir=C:\\Users\\C5060226\\AppData\\Local\\Google\\Chrome\\User Data\\");
		   //capabilities.setCapability("chrome.binary",Constantes.ChromeDriver);
 	       //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		       RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://166.148.20.95:5566/wd/hub"),capabilities);
 	    // RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://166.148.20.64:5566/wd/hub"),capabilities);
 	   
 	       return  (ChromeDriver) nueov;	

		}
		catch (Exception e){
		 //loadExe();
			 
		      return null;//  new ChromeDriver();	
		}

		}
	public static WebDriver createInstance22(){
		try { 
		    ChromeOptions options = new ChromeOptions();
	 
		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	 
		    capabilities.setCapability("browserName",BrowserType.CHROME);
		  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
		  capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); 
		  capabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		  /*  System.setProperty("webdriver.chrome.driver", "C:\\Sprint\\chromedriver.exe");
		
		    options.addArguments("--start-maximized");
		      options.addArguments("--disable-web-security");
		       options.addArguments("--headless");
		       options.addArguments("--no-sandbox");
		       options.addArguments("--allow-running-insecure-content");
		       capabilities.setCapability("chrome.binary",  "C:\\Sprint\\chromedriver.exe");
		 	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			*/
		   
		   // nueov = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	       // WebDriver nueov =  new ChromeDriver();
		 	//   ChromeDriver nueov = new ChromeDriver(capabilities);
		   RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://192.168.8.100:4445/wd/hub"),capabilities);
		  
 	       return    nueov;	

		}
		catch (Exception e){
			try {//loadExe();
				 System.out.print("Error al inicializar el driver"+e.getMessage());
				   return    null;	
/*
			    ChromeOptions options = new ChromeOptions(); 
			    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 
			    capabilities.setCapability("browserName",BrowserType.CHROME);
			    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
			    capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); 
			 
		       RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		       return    nueov;	*/
			} 
		catch (Exception exx){
		    System.out.print("Error al inicializar el driver"+exx.getMessage());
			return null;//  new ChromeDriver();	
		  }
		 
		}
		
		}
	public static WebDriver createInstance2(){
		try { 
		    ChromeOptions options = new ChromeOptions();
	 
		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	 
		    capabilities.setCapability("browserName",BrowserType.CHROME);
		  capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
		  capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); 
		  capabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		  /*  System.setProperty("webdriver.chrome.driver", "C:\\Sprint\\chromedriver.exe");
		
		    options.addArguments("--start-maximized");
		      options.addArguments("--disable-web-security");
		       options.addArguments("--headless");
		       options.addArguments("--no-sandbox");
		       options.addArguments("--allow-running-insecure-content");
		       capabilities.setCapability("chrome.binary",  "C:\\Sprint\\chromedriver.exe");
		 	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			*/
		   
		   // nueov = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	       // WebDriver nueov =  new ChromeDriver();
		 	//   ChromeDriver nueov = new ChromeDriver(capabilities);
		   RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://192.168.8.100:4444/wd/hub"),capabilities);
		  
 	       return    nueov;	

		}
		catch (Exception e){
			try {//loadExe();
				 System.out.print("Error al inicializar el driver"+e.getMessage());
				   return    null;	
/*
			    ChromeOptions options = new ChromeOptions(); 
			    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 
			    capabilities.setCapability("browserName",BrowserType.CHROME);
			    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
			    capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); 
			 
		       RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		       return    nueov;	*/
			} 
		catch (Exception exx){
		    System.out.print("Error al inicializar el driver"+exx.getMessage());
			return null;//  new ChromeDriver();	
		  }
		 
		}
		
		}
	public  RemoteWebDriver createInstance23(){
		try {
			//  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\operadriver_win64\\operadriver.exe");
	 
			  System.setProperty("webdriver.chrome.driver", "C:\\Sprint\\chromedriver.exe");
	
		   // options.addArguments("--disable-web-security");
		    //options.addArguments("--start-maximized"); 
		    //options.addArguments("--disable-quic");
		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	
		   // capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		   // capabilities.setCapability("browserVersion", "");
		    capabilities.setCapability("browserName",BrowserType.CHROME);
		    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
		    capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); 
		   //  String browser = System.getProperty("browser").toUpperCase();
	 
		  
		    //capabilities.setCapability("chrome.binary","C:\\Driver\\operadriver_win64\\operadriver.exe");
		  //  options.setHeadless(true);
		    //Prueba estos
		  //   capabilities.setCapability("marionette", true);
		    //capabilities.setCapability("chrome.binary",Constantes.ChromeDriver);
		/*
		    options.addArguments("test-type");
		       options.addArguments("--start-maximized");
		      options.addArguments("--disable-web-security");
		       options.addArguments("--headless");
		       options.addArguments("--no-sandbox");
		       options.addArguments("--allow-running-insecure-content");*/
		     // options.addArguments("--disable-extension");
		       //Poner en chrome chrome://version/ para ver la ruta del perfil actual.
		      //C:\Program Files (x86)\Google\Chrome\Application\chrome.exe "user-data-dir=C:\\Users\\C5060226\\AppData\\Local\\Google\\Chrome\\User Data"
		      //usar ese comando en la cosola de CMD y logearse para que deje las credenciales lista para la aplicacion !!!
		      //Eso es un punto super importante!!! recuerda que ese User-data-dir es un comando de cmd que se puede ejecutar!!!
	
 	      //Fin de prueba estos.
		    //TODO que sea modificable por BD 
		    
		        //RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://166.148.20.64:5565/wd/hub"),capabilities);
		 //   RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://crsjce010123vm:5565/wd/hub"),capabilities);
		  //  RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://localhost:5565/wd/hub"),capabilities);
		 	
 	    // RemoteWebDriver nueov = new RemoteWebDriver(new URL("http://166.148.20.64:5565/wd/hub"),capabilities);
		    WebDriver nueov = new ChromeDriver(capabilities);
 	       return    (RemoteWebDriver)nueov;	

		}
		catch (Exception e){ e.printStackTrace();
			  return    null;	
			
		}
		
		}
	public static ChromeDriver createInstance(ChromeDriverService service){
		loadExe();
		return new ChromeDriver(service);
	}
	
	public static ChromeDriver createInstance(org.openqa.selenium.Capabilities capabilities){
		loadExe();
		return new ChromeDriver(capabilities);
	}
	
	public static ChromeDriver createInstance(ChromeOptions options){
		loadExe();
		return new ChromeDriver(options);
	}
	
	public static ChromeDriver createInstance(ChromeDriverService service, ChromeOptions options){
		loadExe();
		return new ChromeDriver(service, options);
	}
	
	public void quit(){
		 super.quit();
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

	public String getBrowserVersion(){
		 return this.getCapabilities().getVersion();
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
	public WebElement xpath() {
		// TODO Auto-generated method stub
		return null;
	}	 
}
