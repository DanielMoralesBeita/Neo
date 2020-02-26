/* ***********************************************
   *  Archivo:   Funciones Comunes               *
   *  Autor:     Leonardo Zeledon V              *
   *  Proyecto:  Banca en Linea                  *
   ***********************************************
*/

package Comunes;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;

//import Comunes.Constantes;


import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class FuncionesComunes {
	
	private static Workbook workbook = null;
	private static WritableWorkbook copy = null;
	private static WritableSheet sheet = null;
	private static WritableCell cell,cellDescripcion = null;
	private static Label test,descripcion = null;
	private static JavascriptExecutor jse = null;
	private static File file,src = null;
	private static String dir,excel_resultados,day,month,year,date,format,fileName = "";
	private static Calendar c2 = null;
	private static int columnaFecha,filaTestCases,dayInt,monthInt = 0;
	private static String detalle = "";
	 public static void ExcutationJS_click(WebDriver driver,String id){
	    	
	    	jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById(\""+id+"\").click();");
	    } 
	

	static FileWriter fichero = null;
    static PrintWriter pw = null;
    static File archivoTXT = null;
    static FileReader fr = null;
    static BufferedReader br = null;
	
	public static boolean validarSiUnElementoEstaPresente(WebDriver driver,String xpath){
		
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
	
    public static void hacerClickEnUnElemento(WebDriver driver,WebElement element){
    	
    	jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();",element);
    }
   public static WebDriver elGeneralDeLosdriversAliasElDriver =null;
    public static void seleccionarLaOpcion(By elemento,String value) throws SecurityException, IOException{
		
    	try {
    		WebDriver driver = elGeneralDeLosdriversAliasElDriver;
        	
    		WebElement select = driver.findElement(elemento);
    		List<WebElement> opciones = select.findElements(By.tagName("option"));
    		for (WebElement option : opciones) {

    			if(option.getText().trim().toString().contains(value.trim().toString()) || option.getText().trim().toString().contains(value.trim().toString().toUpperCase())){
    				option.click();
    				break;
    			}
    		}
    	}catch (AssertionError | Exception e ){
    		Assert.assertEquals(false,true,"No se pudo seleccionar el valor "+value+" en el selector "+elemento);
    	}
    	
	}
    
    public static void seleccionarLaOpcionEquals(By elemento,String value) throws SecurityException, IOException{
		
    	try {
    		
    		WebDriver driver = elGeneralDeLosdriversAliasElDriver;
        	WebElement select = driver.findElement(elemento);
    	
        	List<WebElement> opciones = select.findElements(By.tagName("option"));
    		for (WebElement option : opciones) {

    			if((option.getText().trim().toString().equals(value.trim().toString()))){
    					
    				option.click();
    				break;
    			}	
    		}
    		
    	}catch (AssertionError | Exception e ){
    		Assert.assertEquals(false,true,"No se pudo seleccionar el valor "+value+" en el selector "+elemento);
    	}
    	
	}
	
    public static String obtenerFechaFolder(){

    	c2 = new GregorianCalendar();
		
		dayInt = (c2.get(Calendar.DATE));
 		monthInt = (c2.get(Calendar.MONTH) + 1);
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

	public static String crearDirectorioDeLaEvidencia(String path,String ambiente){
		
		/* Funcion para crear directorios en los cuales se va almacenar
		   las imagenes para evidenciar la ejecucion de los casos */
		try{
			dir = "";
			
			file = new File(dir);

			if (!file.exists()) {
					
				if (file.mkdirs()) {
	            	AssertJUnit.assertEquals(true, true);
				} else {
	            	AssertJUnit.assertEquals("ERROR AL CREAR EL DIRECTORIO EN: "+path,true,false);
				}
			}else {
				eliminarEvidenciaDeUnDirectorio(dir);
			}
		}
		catch (AssertionError | Exception e ){
		System.out.println("ERROR AL CREAR EL DIRECTORIO EN: "+path+" ---> "+e.getMessage());
		}
        
		return dir;
	}
	
	public static void eliminarEvidenciaDeUnDirectorio(String directorio) {
		
		try {
			File file = new File(directorio);
			
			
			if (!file.isDirectory()) {
					
				file.delete();
					
			} else if (file.isDirectory()) {
					
				File[] fileList = file.listFiles();
				for (int i = 0; i <fileList.length; i++) {
						
					File delfile = fileList[i];
					if (!delfile.isDirectory()) {

						delfile.delete();

					} else if (delfile.isDirectory()) {
						eliminarEvidenciaDeUnDirectorio(fileList[i].getPath());
					}
				}
			}
			
		} catch (AssertionError | Exception e ) {
			System.out.println("deletefile()   Exception:" + e.getMessage());
		}
	}
	public static String pasoOp="";
	public static String AuxPath="";
	public static void tomarImagen( WebDriver driver, String imageName, String path,String ambiente) throws AWTException{
		
	 
	}
	 
 
	
	public static void moverScrollAUnElemento(WebDriver UiDriver, WebElement element){
		
		/* Funcion para mover el scroll de navegador a un elemento del sistema*/
		try {
			jse = (JavascriptExecutor)UiDriver;
			jse.executeScript("arguments[0].scrollIntoView()", element); 
		}
		catch (AssertionError | Exception e ){
			
		}
	 }
	 
	public static String obtenerFechaActual(){
		
		/* Funcion para solicitar la fecha al sistema */
		date = "";
		try{
	 		c2 = new GregorianCalendar();
			
	 		dayInt = (c2.get(Calendar.DATE));
	 		monthInt = (c2.get(Calendar.MONTH) + 1);
	 		day = "";
	 		month = "";
	 		
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
	 		
	 		year = Integer.toString(c2.get(Calendar.YEAR));
	 		
	 		date = day+"/"+month+"/"+year;
		}
		catch (AssertionError | Exception e ){
			System.out.println("Error al obtener la fecha ---> "+e.getMessage().toString());
		}
		
		return date;	
	}
	
 		 public static String tiempoPruebaCadena2() {
		 long tiempoFinal=System.currentTimeMillis(); 
		 long resta=tiempoFinal - tiempoInicial;
		 return resta+""; }
		 static long  tiempoInicial  =System.currentTimeMillis(); 
	public static void esperarQueUnElementoSeaVisible(WebDriver driver,By elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(
		    ExpectedConditions.visibilityOfElementLocated(elemento)
		    //ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))
		));
	}
	
	public static Date formatearFecha(String fecha) throws ParseException {
		
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		return formateador.parse(fecha.trim().toString());
	}
	
	public static void abrirReporteApp() throws IOException {
		
		try {
			//TODO
			// fichero = new FileWriter(Constantes.Reporte_App,true);
           	// pw = new PrintWriter(fichero);
	      
		}catch(AssertionError | Exception e ){
			System.out.println("Error al abrir el Reporte");
		}
	}
	
	public static void agregarFilaEnReporteApp(String id,String nombre,String estado,String descripcion, String tipo_cliente) throws IOException {
		
		try {
			/*String error = descripcion;
			
			if(descripcion.contains("no such element") || descripcion.contains("Unable to locate element")) {
				error = "Un elemento no fue encontrado";
			}
			else if(descripcion.contains("expected")) {
				error = descripcion.split("expected")[0].toString().trim();
			}
			
			System.out.println("Caso: "+id);
			System.out.println("Nombre: "+nombre);
			System.out.println("Estado :"+estado);
			System.out.println("Error :"+error);
			
			pw.println(id+","+nombre+","+estado+","+error+",");*/
			
		}catch(Exception e ){
			System.out.println("Error al crear una fila en el reporte txt");
		}
	}
	
	 
	public static void cerrarReporteApp(){
		
		try {
			//TODO
			//pw.close();
	        //fichero.close();
	        
		}catch(Exception e ){
			System.out.println("Error al guardar el Reporte");
		}
	}
	
	public static void limpiarReporteApp() {
		 
	    try {
	    	//TODO
	    	 //PrintWriter writer = new PrintWriter(Constantes.Reporte_App);
	    	 //writer.print("");
	    	 //writer.close();

	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
 
	private static int numeroDeImagen = 0;
	public static String numeroDeImagen()
	{
		if(numeroDeImagen < 10)
		{
			return "img0"+numeroDeImagen++;
		}
		return "img"+numeroDeImagen++;
	}
	
	public static void reiniciarContadorDeImagenes()
	{
		numeroDeImagen = 0;
	}
	public static WebDriver driverBypro2=null;
	public static void validarSiUnErrorEnElSistemaEstaPresente( String detalleError) throws SecurityException, IOException{
		  
		
		try {
			
			WebElement divError = driverBypro2.findElement(By.className("unhandledErrorBox ERROR"));
			FuncionesComunes.moverScrollAUnElemento(driverBypro2, divError);
		}
		catch(AssertionError | Exception e ){
			Assert.assertEquals(FuncionesComunes.validarSiUnElementoEstaPresente(driverBypro2,
					".//p[contains(.,'Ha ocurrido un error interno')]"),false,
						"Mensaje de error interno es desplegado");
				
				Assert.assertEquals(FuncionesComunes.validarSiUnElementoEstaPresente(driverBypro2,
					".//li[contains(.,'No se pudo obtener respuesta') or contains(.,'En estos momentos no lo podemos atender') or contains(.,'Problemas de comunicación') or contains(.,'ERROR REQ') or contains(.,'Comunicación no disponible')]"),false,
						"Problemas con el sistema error de backend o procedimiento almacenado fue mostrado "+ detalleError);
		}
		
		
	}
	public static void validarSiUnErrorEnElSistemaEstaPresente(WebDriver driver ,String detalleError) throws SecurityException, IOException{
		  
		
		try {
			
			WebElement divError = driver.findElement(By.className("unhandledErrorBox ERROR"));
			FuncionesComunes.moverScrollAUnElemento(driver, divError);
		}
		catch(AssertionError | Exception e ){
			Assert.assertEquals(FuncionesComunes.validarSiUnElementoEstaPresente(driver,
					".//p[contains(.,'Ha ocurrido un error interno')]"),false,
						"Mensaje de error interno es desplegado");
				
				Assert.assertEquals(FuncionesComunes.validarSiUnElementoEstaPresente(driver,
					".//li[contains(.,'No se pudo obtener respuesta') or contains(.,'En estos momentos no lo podemos atender') or contains(.,'Problemas de comunicación') or contains(.,'ERROR REQ') or contains(.,'Comunicación no disponible')]"),false,
						"Problemas con el sistema error de backend o procedimiento almacenado fue mostrado "+ detalleError);
		}
		
		
	}
	
	public static void subirScroll() throws SecurityException, IOException {
		
		WebDriver driver = elGeneralDeLosdriversAliasElDriver;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}
	
	public static void bajarScroll() throws SecurityException, IOException {
		
		WebDriver driver = elGeneralDeLosdriversAliasElDriver;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	public void refrescarDriver() throws SecurityException, IOException {
		WebDriver driver = elGeneralDeLosdriversAliasElDriver;
		driver.navigate().refresh();
	}
}
