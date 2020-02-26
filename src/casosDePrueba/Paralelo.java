package casosDePrueba;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Comunes.FuncionesComunes;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import paginas.P_EstadoDeCuenta;

public class Paralelo {
	
	@Parameters({"ambiente"})
	@BeforeClass
	public void beforeClass() throws SecurityException, IOException {		
	//	super.beforeClass(ambiente);
	}

	@Parameters({"Url_Cyberbank"})
	@BeforeMethod
	public void beforeTest() throws SecurityException, IOException, BiffException, InterruptedException, AWTException {
		 FuncionesComunes.reiniciarContadorDeImagenes();
			
	}
	@AfterMethod
	public void afterTest() throws InterruptedException, BiffException, WriteException, IOException { 
		//super.afterTest();
		 
	}
	/*@AfterMethod
	public void tearDown(ITestResult result) {
		  try
	         {
			 
	          }
	           catch(Exception e)
	           {
	             e.printStackTrace();
	           }
	    }*/
 
	@AfterClass
	public void afterClass() throws InterruptedException, BiffException, WriteException, IOException {
//	 super.afterClass();
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test2() {
		fail("Not yet implemented");
	}
	@Test
	public void test3() {
		fail("Not yet implemented");
	}
	@Test 
	public void TC0_w3schoold()  {
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
	 	try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
			  c.casoModelo(NombreDelCaso, NombreDelCaso);
		}
		catch(Exception e ){	
			  System.out.print(e.getMessage());
			}
	}
	 
	@Test 
	public void TC01_w3schoold()  {
		
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		   long id = Thread.currentThread().getId();
	        System.out.println("Before test-method. Thread id is: " + id);
	 	try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			 
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
			  c.casoModelo(NombreDelCaso, NombreDelCaso);
			/// Comunes.FuncionesComunes.driverBypro2.get("www.google.com");
			//  BasePageObject.al.get(ids).navigate().to("www.google.com");;
			
		}
		catch(Exception e ){	
	 System.out.print(e.getMessage());
			}
	}
	 
	@Test 
	public void TC02_w3schoold(){
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
	 	try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
			  c.casoModelo(NombreDelCaso, NombreDelCaso);
		 }
		catch(Exception e ){	
			  System.out.print(e.getMessage());
		 }
	}
	  
	@Test 
	public void TC1_w3schoold(){
		
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		   long id = Thread.currentThread().getId();
	        System.out.println("Before test-method. Thread id is: " + id);
	 	try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			 
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.IE);
			  c.casoModelo(NombreDelCaso, NombreDelCaso);
			/// Comunes.FuncionesComunes.driverBypro2.get("www.google.com");
			//  BasePageObject.al.get(ids).navigate().to("www.google.com");;
			
		}
		catch(Exception e ){	
	 System.out.print(e.getMessage());
			}
	}
	 
	@Test  
	public void TC3_w3schoold()  {
		
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		   long id = Thread.currentThread().getId();
	        System.out.println("Before test-method. Thread id is: " + id);
	 	try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			 
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.FIREFOX);
			  c.casoModelo(NombreDelCaso, NombreDelCaso);
			  
			/// Comunes.FuncionesComunes.driverBypro2.get("www.google.com");
			//  BasePageObject.al.get(ids).navigate().to("www.google.com");;
			
		}
		catch(Exception e ){	
	 System.out.print(e.getMessage());
			}	}
	
	
}


