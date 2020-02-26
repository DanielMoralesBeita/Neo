package paginas;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;

import Comunes.Browser;
//import Comunes.Constantes;
import Comunes.FuncionesComunes;
import pageBase.Driver;

public class P_EstadoDeCuenta extends BasePageObject{

	 
 public P_EstadoDeCuenta(String tipo) {
		super(tipo); 
	}

public boolean casoModelo(String nombre, String Apellido) throws InterruptedException, IOException, AWTException{
	try
	{
	   UrlGo("https://www.google.com");
	   writeSentece("ws3schold",Xpathname("q"));
	   clickComp(Xpathname("btnK"));
	   clickComp(XpatLink("https://www.w3schools.com/"));
	   UrlGo("https://www.w3schools.com/");
	   this.al.get(this.ids).close();
	   this.al.get(this.ids).quit();
	   return true;
	}
	catch(Exception e ){	
		this.al.get(this.ids).close();
		   this.al.get(this.ids).quit();
		  System.out.print(e.getMessage());
		   return false;
		}
 }





}
