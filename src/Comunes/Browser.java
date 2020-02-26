package Comunes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

 
 
import pageBase.Driver;
public class Browser {
	public static List<Driver> listaDrivers=new ArrayList<Driver>();
	
	
	public void CerradoTotalMagico() {
		
		for(int i=0;i<listaDrivers.size();i++)
		{
			if(listaDrivers.get(i).driver!=null )
			{
				try {
					
					listaDrivers.get(i).driver.quit();
				}catch(Exception e){
					System.out.println("Error al realizar el quit total"+e.getMessage());
				}
			}
		}
	}
	public Driver driver;

	public Browser(String browserType) throws SecurityException, IOException {
		
		//driver = Driver.getInstance(browserType);
		 driver.obtenerDriver().get("https://www.google.com/");
		Browser.listaDrivers.add(driver);
	}
 
 
	public void url(String url){
			 
	 
		
	 
	}
	
}
