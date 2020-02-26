package casosDePrueba;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod; import org.testng.annotations.Optional;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

 
import Comunes.FuncionesComunes;
 
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import pageBase.Driver;
import paginas.BasePageObject;
import paginas.P_EstadoDeCuenta;
 

public class R_00_01_Autenticacion_I{


	
	@Parameters({"ambiente"})
	@BeforeClass
	public void beforeClass(@Optional("UAT")  String ambiente) throws SecurityException, IOException {		
	//	super.beforeClass(ambiente);
	}

	@Parameters({"Url_Cyberbank"})
	@BeforeMethod
	public void beforeTest(@Optional() String Url_Cyberbank) throws SecurityException, IOException, BiffException, InterruptedException, AWTException {
		 FuncionesComunes.reiniciarContadorDeImagenes();
			
	}
	
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 1)
	public void TC0_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
	 	try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
			   Assert.assertTrue(c.casoModelo(NombreDelCaso, NombreDelCaso)==true,"Fallo en el caso "+NombreDelCaso);
		}
		catch(Exception e ){	
			   Assert.assertTrue(false==true,"Fallo en el caso "+NombreDelCaso);
			  System.out.print(e.getMessage());
			}
	}
	
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 1)
	public void TC01_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		   long id = Thread.currentThread().getId();
	        System.out.println("Before test-method. Thread id is: " + id);
	        try
			{
				  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
				  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
				   Assert.assertTrue(c.casoModelo(NombreDelCaso, NombreDelCaso)==true,"Fallo en el caso "+NombreDelCaso);
			}
			catch(Exception e ){	
				   Assert.assertTrue(false==true,"Fallo en el caso "+NombreDelCaso);
				  System.out.print(e.getMessage());
				}
	}
	
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 1)
	public void TC023_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
	    try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
			   Assert.assertTrue(c.casoModelo(NombreDelCaso, NombreDelCaso)==true,"Fallo en el caso "+NombreDelCaso);
		}
		catch(Exception e ){	
			   Assert.assertTrue(false==true,"Fallo en el caso "+NombreDelCaso);
			  System.out.print(e.getMessage());
			}
	}
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 1)
	public void TC02_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
	    try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
			   Assert.assertTrue(c.casoModelo(NombreDelCaso, NombreDelCaso)==true,"Fallo en el caso "+NombreDelCaso);
		}
		catch(Exception e ){	
			   Assert.assertTrue(false==true,"Fallo en el caso "+NombreDelCaso);
			  System.out.print(e.getMessage());
			}
	}
	
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 1)
	public void TC012_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		   long id = Thread.currentThread().getId();
	        System.out.println("Before test-method. Thread id is: " + id);
	        try
			{
				  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
				  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
				   Assert.assertTrue(c.casoModelo(NombreDelCaso, NombreDelCaso)==true,"Fallo en el caso "+NombreDelCaso);
			}
			catch(Exception e ){	
				   Assert.assertTrue(false==true,"Fallo en el caso "+NombreDelCaso);
				  System.out.print(e.getMessage());
				}
	}
	
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 1)
	public void TC022_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		String NombreDelCaso = new Exception().getStackTrace()[0].getMethodName(); 
		long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
	    try
		{
			  NombreDelCaso = new Exception().getStackTrace()[0].getMethodName();
			  P_EstadoDeCuenta c=new P_EstadoDeCuenta(BrowserType.CHROME);
			   Assert.assertTrue(c.casoModelo(NombreDelCaso, NombreDelCaso)==true,"Fallo en el caso "+NombreDelCaso);
		}
		catch(Exception e ){	
			   Assert.assertTrue(false==true,"Fallo en el caso "+NombreDelCaso);
			  System.out.print(e.getMessage());
			}
	}
	/* 
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 3)
	public void TC1_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		
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
	
	@Parameters({"ambiente","tipo_cliente"})
	@Test(priority = 2)
	public void TC3_w3schoold(@Optional("UAT")  String ambiente,@Optional("Persona")  String tipo_cliente) throws InterruptedException, BiffException, IOException, AWTException, WriteException {
		
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
	 */
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
	
}
