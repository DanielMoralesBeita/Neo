package paginas;
/* ***********************************************
 *  Archivo:   P_FatherOfWebPages              *
 *  Autor:     Daniel Morales Beita            *.*
 *  Proyecto:  Cyberbank                       *
 *************************************************
 *Notas:
 *Esta clase se implementa para poder actulizar el core del cyberbank a una versón.
 *Más moderna, se crea un control manual de tiempo de esperas configurables.
 *Para poder cambiar los tiempos de esperas modifique los valores de cantidadDeCiclosAesperar.
 *Keys Cambiar tiempo cambio time change time waiting driver!!
*/
import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Comunes.Browser;
import Comunes.ClaseBase;
//import Comunes.Constantes; 
import Comunes.FuncionesComunes;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import pageBase.ChromeDriver;
import pageBase.Driver;
import pageBase.Firefox_remote_driver;
import pageBase.InternetExplorerDriver;

public class BasePageObject {
	
	public  WebDriver driver2 ;
	static int id=0;
	static boolean Semaforo=true;
 
	
     int ids=0;
     public static List<WebDriver> al=new ArrayList<WebDriver>();
	public Driver baseDrier;	
	public BasePageObject(String tipo) {
		
	try {
		 id++;
		 if(id>100) {
			 id=0;
		 }
		 try {
				Thread.sleep(100+id*2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 while( Semaforo==false)
		 {
			 try {
				Thread.sleep(100+id*2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 Semaforo=false;
		 switch (tipo) {
			case BrowserType.CHROME:
				
				if(ids%2==0)
				 al.add( ChromeDriver.createInstance2());
				else
				 al.add( ChromeDriver.createInstance22());
				break;
		 	case BrowserType.FIREFOX:
		 		 al.add(  Firefox_remote_driver.createInstance());
			  break;
		 	case BrowserType.IE:
		 		 al.add( InternetExplorerDriver.createInstance());
			 break;
		 }
		
		// al.add(new Driver().Driver2(tipo));
		 al.get(ids).manage().window().maximize();
		 Semaforo=true;
		
		 ids= al.size()-1;
	 
		// al.get(ids)= Driver.driver;
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
 
	public void UrlGo(String url) {
		 al.get(ids).get(url); 
	}
	
	public String ElementoDeBusqueda="";
	public int tiempoEsperaExtraSig=1000;
	public int pasoNumero=0;
	public String paso="";
	public String CodigoDelaPagina="";
	public int cantidadDeCiclosAesperar=20;
	String FolderPathOrigins ="C:\\Evidencia"; 
	public WebDriver SoyDriverIE=null;
	 public void SF() {
			 
			
		}
	 
	 public   void ExcutationJS_click( String id){
	    	
		 JavascriptExecutor	jse = (JavascriptExecutor) al.get(ids);
		  	jse.executeScript("document.getElementById(\""+id+"\").click();");
	    }
	 public   void ExcutationJS( String Ejecucion){
	    	try {
		 JavascriptExecutor	jse = (JavascriptExecutor) al.get(ids);
		  	jse.executeScript(Ejecucion); 
	 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	 public void EscrituraRobusta_ID(String nombre_ID,String valor) {
		 try {
			if (valor != null) {
				WebElement textBox = al.get(ids).findElement(By.id(nombre_ID));
				if(null==textBox.getAttribute("readonly"))
				{textBox.clear();
				textBox.sendKeys(valor);}else {
					System.out.println("El campo:"+nombre_ID +"es readOnly y se intenta colocar el valor"+valor);
				}
			}
		 } catch (Exception e) {
			  
				e.printStackTrace();
				ExcutationJS2("document.getElementById(\""+nombre_ID+"\").value=\""+valor+"\"");
				
			}	
		 }
	 public void EscrituraRobusta_ID_Especial(String nombre_ID,String valor) {
		 try {
			if (valor != null) {
				WebElement textBox = al.get(ids).findElement(By.id(nombre_ID));
				if(null==textBox.getAttribute("readonly"))
				{
					ExcutationJS2("document.getElementById(\""+nombre_ID+"\").value=\""+valor+"\"");
				//	textBox.sendKeys(valor);
				}else {
					System.out.println("El campo:"+nombre_ID +"es readOnly y se intenta colocar el valor"+valor);
				}
			}
		 } catch (Exception e) {
			  
				e.printStackTrace();
				
				
			}	
		 }
	 public void EscrituraRobusta_ID_Especial_MyNombre(String nombre_ID) {
		 try {
			 
				WebElement textBox = al.get(ids).findElement(By.id(nombre_ID));
				if(null==textBox.getAttribute("readonly"))
				{
					ExcutationJS2("document.getElementById(\""+nombre_ID+"\").value=document.getElementById(\"operadores\").outerHTML");
				//	textBox.sendKeys(valor);
				}else {
					System.out.println("El campo:"+nombre_ID +"es readOnly y se intenta colocar el valordocument.getElementById(\\\"operadores\\\").outerHTML");
				}
			 
		 } catch (Exception e) {
			  
				e.printStackTrace();
				
				
			}	
		 }
	 
	 
	 public   String ExcutationJS2( String Ejecucion){
		
		 JavascriptExecutor	jse = (JavascriptExecutor) al.get(ids);
		 String return_value = (String) 	jse.executeScript(Ejecucion);
		 return return_value;
	    }
	 public void especialAsserttrow(long b, long c, String mensaje) throws Exception {
			// TODO Auto-generated method stub
		 if(b!=c)
			 throw new  Exception(mensaje);
		}
	 public void especialAsserttrow(int plantillasEncontrados, int cantidad, String mensaje) throws Exception {
			// TODO Auto-generated method stub
			if(plantillasEncontrados!=cantidad)
				 throw new  Exception(mensaje);
		}
		public void especialAsserttrow(boolean b, boolean c, String mensaje) throws Exception {
			// TODO Auto-generated method stub
			if(b!=c)
			 throw new  Exception(mensaje);
			
		}
		public void especialAsserttrow(String a, String b, String mensaje) throws Exception {
			if(a.compareTo(b)!=0)
				 throw new  Exception(mensaje);
			
		}
		public void especialAsserttrow(Throwable e,boolean a, boolean b)
		{
			try {
				if(a!=b)
					 throw new  Exception(e.getMessage());
	 
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
	 public void haSucedidoUnError(Exception e, String nombreDelMetodo) throws Exception {
			// TODO Auto-generated method stub
		 especialAsserttrow(true,false,"En el metodo "+ nombreDelMetodo+" ha sucedido un error "+e.getMessage());
		 //especialAsserttrow(a,b,e.toString());
		}
	public void sigEspera(String ElementoAEsperar) throws InterruptedException,  IOException, AWTException{
		try {
		pasoNumero++;
		 paso = pasoNumero+ "";
		for(int i=0;i<cantidadDeCiclosAesperar;i++) {
		Thread.sleep(tiempoEsperaExtraSig);
		 CodigoDelaPagina=al.get(ids).getPageSource().toLowerCase();
		 //Verifica que el elemento exista antes de continuar con el siguiente paso.
		if(compararPredicadoSinActualizar(ElementoAEsperar))
		{
			i=cantidadDeCiclosAesperar;
		}else {
			//Continua con la ejecucion normal, ya le dio un tiempo extra de 15 segundos.
			//Se puede configurar a mas con la cantidad de ciclos
		}
		}
		}catch (Exception e)
		{
		 System.out.println("Ha sucedido un error al esperar el elemento en la función sig detalle del error:"+e.getMessage()); 
		}
	}
	public boolean compararPredicadoSinActualizar(String predicado) {
		//Obtiene el contexto de que tiene que actulizar en otro momento
		if(CodigoDelaPagina.toLowerCase().contains(predicado.toLowerCase())==true) {
			 
			return true;
		} 
			return false;
		 
	}
	public void hacerClickEnBotonDeConfirmar(){
		
		WebElement boton = al.get(ids).findElement(By.name("_eventId_confirmar"));
		FuncionesComunes.moverScrollAUnElemento(al.get(ids),boton);
		boton.click();
	}
	public void hacerClickEnBotonDeAceptar(){
		
		WebElement boton = al.get(ids).findElement(By.name("_eventId_aceptar"));
		FuncionesComunes.moverScrollAUnElemento(al.get(ids),boton);
		boton.click();
	}
	public void cambiarLaClave(String pass, String nuevoPass, String confirmarPass){
		
		try {
			Assert.assertEquals(FuncionesComunes.validarSiUnElementoEstaPresente(al.get(ids),
				"//input[@name='claveActual' and @type='password']"),true,"TextBox de claves no estan presente");
			
			WebElement textBoxClaveActual =al.get(ids).findElement(By.xpath("//input[@name='claveActual' and @type='password']"));
			WebElement textBoxNuevaClave = al.get(ids).findElement(By.xpath("//input[@name='claveNueva' and @type='password']"));
			WebElement textBoxConfirmar = al.get(ids).findElement(By.xpath("//input[@name='claveNuevaParaVerificacion' and @type='password']"));
			
			textBoxClaveActual.sendKeys(pass);
			textBoxNuevaClave.sendKeys(nuevoPass);
			textBoxConfirmar.sendKeys(confirmarPass);
		}
		catch (AssertionError | Exception e ) {
			Assert.assertEquals(true,false,"Se presento un error mientras se realizaba el cambio de clave, revisar la funcion");
		}
	}
	public void hacerClickEnCambioDeClave(){
		
		WebElement clickMenu = al.get(ids).findElement(By.xpath("//a[contains(.,'Cambio de clave')]")); 
		FuncionesComunes.hacerClickEnUnElemento(al.get(ids), clickMenu);
	}
	public WebDriver driver;
	public Browser nuevoBrowerPapu=null;
	 
 

	
     public  boolean validarSiUnElementoEstaPresente(String xpath){
		
		try {
			al.get(ids).findElement(By.xpath(xpath));
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
     public  boolean validarSiUnElementoEstaPresente(WebDriver drivers,String xpath){
 		
		try {
			drivers.findElement(By.xpath(xpath));
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
     public   String obtenerFechaFolder(){
    	     String dir,excel_resultados,day,month,year,date,format,fileName = "";
    	    Calendar c2 = null;
     	c2 = new GregorianCalendar();
 		
 		int dayInt = (c2.get(Calendar.DATE));
  		int monthInt = (c2.get(Calendar.MONTH) + 1);
  		day = "";
  		month = "";
 		year = Integer.toString(c2.get(Calendar.YEAR));
 		
 		if(dayInt < 10){
  			day = "0"+Integer.toString(c2.get(Calendar.DATE));
  		}else{
  			day = Integer.toString(c2.get(Calendar.DATE));
  		}
  		
  		if(monthInt < 10){
  			month = "0"+Integer.toString(c2.get(Calendar.MONTH) + 1);
  		}else{
  			month = Integer.toString(c2.get(Calendar.MONTH) + 1);
  		}
  		
  		return day+"_"+month+"_"+year+"\\";
     }
 	private   int numeroDeImagen = 0;
 	public   String numeroDeImagen()
 	{
 		if(numeroDeImagen < 10)
 		{
 			return "img0"+numeroDeImagen++;
 		}
 		return "img"+numeroDeImagen++;
 	}
 	public   void moverScrollAUnElemento(WebDriver UiDriver, WebElement element){
		
		/* Funcion para mover el scroll de navegador a un elemento del sistema*/
		try {
			JavascriptExecutor jse = (JavascriptExecutor)UiDriver;
			jse.executeScript("arguments[0].scrollIntoView()", element); 
		}
		catch (AssertionError | Exception e ){
			
		}
	 }
 	
 	public  ClaseBase nuevaClaseBase;
 	
 	public void	inicializarBase(String ambiente, String tipo_cliente, String nombreDelCaso) throws IOException{
 		  nuevaClaseBase=new ClaseBase(ambiente, tipo_cliente, nombreDelCaso);

 	}
 	
public void seleccionarElCliente_online(String cliente) throws Exception{
		
		if(validarSiUnElementoEstaPresente(al.get(ids),".//*[contains(.,'Selección de cliente')]")){
			
			especialAsserttrow(validarSiUnElementoEstaPresente(al.get(ids), 
				".//li[contains(.,'"+cliente.toString().trim()+"') or "
						+ "contains(.,'"+cliente.toString().trim().toUpperCase()+"')]"), true,
							"No se pudo encontrar el cliente "+cliente+" al seleccionar el cliente");
			
			
			WebElement divPerfil = al.get(ids).findElement(By.xpath(".//li[contains(.,'"+cliente.toString().trim()+"') or "
																			+ "contains(.,'"+cliente.toString().trim().toUpperCase()+"')]"));
			
			moverScrollAUnElemento(al.get(ids), divPerfil);
			
			WebElement radioButton = divPerfil.findElement(By.xpath(".//input[@type='radio']"));
			moverScrollAUnElemento(al.get(ids), radioButton);
			
			JavascriptExecutor jse = (JavascriptExecutor) al.get(ids);
			jse.executeScript("arguments[0].click();",radioButton);
			
			WebElement continuar = al.get(ids).findElement(By.name("_eventId_continuar"));
			moverScrollAUnElemento(al.get(ids), continuar);
			hacerClickEnUnElemento(al.get(ids), continuar);
		 try{
			 //Se analiza el contexto.
			 String obtenerTexto=al.get(ids).getPageSource();
			 if(obtenerTexto.contains("En otro momento"))
			 { 
				 WebElement element = al.get(ids).findElement(By.name("_eventId_otroMomento"));
				 JavascriptExecutor jse1 = (JavascriptExecutor) al.get(ids);
					jse1.executeScript("arguments[0].click();",element);
			 }
		 }catch(Exception ex){
			 System.out.println("Error en la actualización de datos"+ex.getMessage());
		 }
		}
	}
public   void seleccionarLaOpcion2(By elemento,String value) throws SecurityException, IOException{
	
	try {
		WebElement select = al.get(ids).findElement(elemento);
		
		String idO=select.getAttribute("id");
		System.out.print("ID en la seleccion: "+idO);
		 if(idO.trim().length()==0) {
			List<WebElement> opciones = select.findElements(By.tagName("option"));
		for (WebElement option : opciones) {

			if(option.getText().trim().toString().contains(value.trim().toString()) || option.getText().trim().toString().contains(value.trim().toString().toUpperCase())){
				option.click();
				break;
			}
		}
	   }else {
		 
        this.ExcutationJS("var elemento=this.document.getElementById(\""+idO+"\"); \r\n" + 
        		"var hijos =elemento.children; \r\n" + 
        		"for(var i=0; i <hijos.length;i++){\r\n" + 
        		" \r\n" + 
        		"//console.log(hijos[i].innerHTML.includes(\""+value+"\"));\r\n" + 
        		"if(hijos[i].innerHTML.includes(\""+value+"\"))\r\n" + 
        		"{\r\n" + 
        		"console.log(hijos[i].value);\r\n" + 
        		"this.document.getElementById(\""+idO+"\").value=hijos[i].value;\r\n" + 
        		"}\r\n" + 
        		"}");}
		 
	}catch (AssertionError | Exception e ){
		Assert.assertEquals(false,true,"No se pudo seleccionar el valor "+value+" en el selector "+elemento);
	}
	
}
public   void seleccionarLaOpcion(By elemento,String value) throws SecurityException, IOException{
	
	try {
		WebElement select = al.get(ids).findElement(elemento);
		
		String idO=select.getAttribute("id");
		//if(idO.trim().length()==0) {
			List<WebElement> opciones = select.findElements(By.tagName("option"));
		for (WebElement option : opciones) {
        System.out.println("Combox del "+option.getText().trim().toString());
			if(option.getText().trim().toString().contains(value.trim().toString()) || option.getText().trim().toString().contains(value.trim().toString().toUpperCase())){
				option.click();
				break;
			}
		}
		/* IDEA fallida del hacerlo con js!!
		 * }else {
		 
        this.ExcutationJS("var elemento=this.document.getElementById(\""+idO+"\"); \r\n" + 
        		"var hijos =elemento.children; \r\n" + 
        		"for(var i=0; i <hijos.length;i++){\r\n" + 
        		" \r\n" + 
        		"//console.log(hijos[i].innerHTML.includes(\""+value+"\"));\r\n" + 
        		"if(hijos[i].innerHTML.includes(\""+value+"\"))\r\n" + 
        		"{\r\n" + 
        		"console.log(hijos[i].value);\r\n" + 
        		"this.document.getElementById(\""+idO+"\").value=hijos[i].value;\r\n" + 
        		"}\r\n" + 
        		"}");}
		/*
		*/
	}catch (AssertionError | Exception e ){
		Assert.assertEquals(false,true,"No se pudo seleccionar el valor "+value+" en el selector "+elemento);
	}
	
}
	
public static void hacerClickEnUnElemento(WebDriver driver,WebElement element){
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].click();",element);
}
	public   void validarSiUnErrorEnElSistemaEstaPresente(WebDriver driver ,String detalleError) throws SecurityException, IOException{
		  
		
		try {
			
			WebElement divError = driver.findElement(By.className("unhandledErrorBox ERROR"));
			moverScrollAUnElemento(driver, divError);
		}
		catch(AssertionError | Exception e ){
			Assert.assertEquals(validarSiUnElementoEstaPresente(driver,
					".//p[contains(.,'Ha ocurrido un error interno')]"),false,
						"Mensaje de error interno es desplegado");
				
				Assert.assertEquals(validarSiUnElementoEstaPresente(driver,
					".//li[contains(.,'No se pudo obtener respuesta') or contains(.,'En estos momentos no lo podemos atender') or contains(.,'Problemas de comunicación') or contains(.,'ERROR REQ') or contains(.,'Comunicación no disponible')]"),false,
						"Problemas con el sistema error de backend o procedimiento almacenado fue mostrado "+ detalleError);
		}
		
		
	}
 	public  void esperarQueUnElementoSeaVisible(WebDriver driver,By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(
		    ExpectedConditions.visibilityOfElementLocated(elemento)
		    //ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))
		));
	}
	public  void tomarImagen( WebDriver driver, 
								String imageName, 
								String path,
								String ambiente) throws AWTException{
		
		/* Funcion para tomar screenshot mientras los casos
		   estan siendo ejecutados */
		
		try {

			//WebDriver driver = elGeneralDeLosdriversAliasElDriver;
			if(FuncionesComunes.validarSiUnElementoEstaPresente(driver, ".//div[@id='unhandledErrorBox ERROR']")){
				WebElement divError = driver.findElement(By.xpath(".//div[@class='unhandledErrorBox ERROR']"));
				FuncionesComunes.moverScrollAUnElemento(driver, divError);
			}


			String format = "jpg";
			Object fileName = numeroDeImagen()+"."+format;
			 
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
		 
			
			String fileNamexx = imageName+numeroDeImagen()+".html";
			
			try {
			 
				if(driver.getPageSource().compareTo("ERR_SSL_PROTOCOL_ERROR")==0) {
					driver.get(driver.getCurrentUrl());
					Thread.sleep(1000);
				}
				}
				catch (Exception e){
					System.out.println("Error al tomar foto un driver ---> "+e.getMessage());
				}
			
			
			 
				
			try {
				 
				String pasadoVolver=driver.getPageSource();
				
				String ArchivoNombreCompleto ="";
				 
	 	      //  System.out.println( this.nuevoControlador.paso+"XML:" +driver.getPageSource());
	 	       try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	 	              new FileOutputStream(ArchivoNombreCompleto), "utf-8"))) {
	 	   writer.write(pasadoVolver);
	 	} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (Exception e){
			System.out.println("Error al tomar una imagen de evidencia ---> "+e.getMessage());
		}
	}
	public void EscribirClear(By ElementoXML, String Input) throws IOException, InterruptedException, BiffException, WriteException, AWTException {
		
		List<WebElement> lista = al.get(ids).findElements(ElementoXML);
		if(lista.size() >0) {
			WebElement elementoWeb = (WebElement) lista.get(0);
			elementoWeb.clear();; 
			elementoWeb.sendKeys(Input); 
			}
     }
	public void click(final By ElementoXML)  {
	 try {
		 
		List<WebElement> lista = al.get(ids).findElements(ElementoXML);
		if(lista.size() >0) {
		 WebElement elementoWeb = (WebElement) lista.get(0);
		 elementoWeb.click();
		} 
	 	} catch (Exception e) {
	 		System.out.println(e.getMessage());

           
		} 
	 
	 
   }
	public boolean clickComp(final By ElementoXML)  {
		 try {
			 
			List<WebElement> lista = al.get(ids).findElements(ElementoXML);
			if(lista.size() >0) {
			 WebElement elementoWeb = (WebElement) lista.get(0);
			 elementoWeb.click();			 
			 return true;
			} 
			return false;
		 	} catch (Exception e) {
		 		System.out.println(e.getMessage());
		 		return false;
			} 
		 
		 
	   }
	
	boolean ElementoImprimeActivo=true;
	public void consolaDeElementosEnviados(String ElementoImprimir)
	{
		
		if(ElementoImprimeActivo)
		{
			System.out.println(ElementoImprimir);
		}
	}
	//Buscan hacen las acciones.
	
	public final  By Xpathname(String input) throws  InterruptedException, IOException, AWTException {
		sigEspera(input);
		ElementoDeBusqueda="//*[@name='"+input+"']";
		consolaDeElementosEnviados(ElementoDeBusqueda);
		return By.xpath("//*[@name='"+input+"']");
	}
	public final By XpatLink(String input)throws  InterruptedException, IOException, AWTException {
		sigEspera(input);
		ElementoDeBusqueda="//*[@href='"+input+"']";
		consolaDeElementosEnviados(ElementoDeBusqueda);
		return By.xpath("//*[@href='"+input+"']");
	}
	public boolean writeSentece(String Text,final By  ElementXML) {
	 
		 try {
			 
				List<WebElement> lista =  al.get(ids).findElements(ElementXML);
				if(lista.size() >0) {
				 WebElement elementoWeb = (WebElement) lista.get(0);
				 elementoWeb.sendKeys(Text); 		 
				 return true;
				} 
				return false;
			 	} catch (Exception e) {
			 		System.out.println(e.getMessage());
			 		return false;
				} 
	}
	//Sirven para buscar los elementos.
	public final  By XpathText(String input) throws  InterruptedException, IOException, AWTException {
		sigEspera(input);
		ElementoDeBusqueda="//*[contains(text(),'"+input+"')]";
		consolaDeElementosEnviados(ElementoDeBusqueda);
		return By.xpath("//*[contains(text(),'"+input+"')]");
	}
	public final  By XpathTextStart(String input) throws  InterruptedException, IOException, AWTException {
		sigEspera(input);
		ElementoDeBusqueda="//*[starts-with(text(),'"+input+"')]";
		consolaDeElementosEnviados(ElementoDeBusqueda);
		return By.xpath("//*[starts-with(text(),'"+input+"')]");
	}
	public final By XpathTextStartDoble(String input1, String input2) throws InterruptedException, IOException, AWTException {
		sigEspera(input1);
		sigEspera(input2);
		ElementoDeBusqueda="//*[starts-with(text(),'"+input1+"') and contains(text(),'"+input2+"')]";
		consolaDeElementosEnviados(ElementoDeBusqueda);
		return By.xpath("//*[starts-with(text(),'"+input1+"') and contains(text(),'"+input2+"')]");
	}
	public final  By Xpathid(String input) throws  InterruptedException, IOException, AWTException {
		sigEspera(input);
		ElementoDeBusqueda="//*[@id='"+input+"']";
		consolaDeElementosEnviados(ElementoDeBusqueda);
		return By.xpath("//*[@id='"+input+"']");
	}
	public final  By XpathFinal(String input) throws InterruptedException, IOException, AWTException {
		sigEspera(input);
		consolaDeElementosEnviados(input);
		ElementoDeBusqueda=input;
		return By.xpath(input);
	}
	
}
