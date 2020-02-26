package Comunes;

/* ***********************************************
 *  Archivo:   ClaseBase                       *
 *  Autor:     Daniel Morales Beita            *.*
 *  Proyecto:  APP                             *
 *************************************************
 *Notas importantes al utlizar esta clase, tenga en cuenta
 *Advertencia: si los atributos de los test case
 *No estan publico y declarados antes de la ejecucion
 *Es probable que el Appium no logre encontrarlos o bien no son final 
 *Siempre declarar afuera las declaraciones no adentro Fin Advertencia.!!
*/
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.collections.Lists;

 
   public class ClaseBase {
	
	public String version_Actual="Autmatización versión V.1_08_2019 BEL";
 
	private static final int SECONDS = 30;
	 

	public static  WebDriver driver;
	public static  WebDriver driver2;
	
	//Se obtine con adb device
	//Del dispositivo actual, nota parametrizar esto despues es necesario para el uso de comandos.
	//En la consola de cmd cuando el driver del apinium no puede mas.
	public String SerialNumeber="ad42902e";

      EventFiringWebDriver eventHandler;
	public ClaseBase(String ambiente, String tipo_cliente, String NombreCaso) throws   IOException {
		try{	
			 this.AmbienteDelCasoDePruebas=ambiente;
		     this.TipoClienteDelCasoDePruebas=tipo_cliente;
		     this.NombreDelCasoDePruebas=NombreCaso;
		    
		  
			 // this.UsuarioDelCasoDePruebas= new Usuario(tipo_cliente,ambiente,NombreCaso);
			   
			//this.Inicializasdor_Base(ambientev,tipo_clientev,nombreCasov);
		
		} catch (Exception e) {
		System.out.println(e.getMessage() +"Error al inicializar.");	 
		}
		
}
	public void ClaseBaseOriginal(String ambientev, String tipo_clientev, String nombreCasov) throws  IOException {
		// TODO Auto-generated constructor stub
		//this.Inicializasdor_Base(ambientev,tipo_clientev,nombreCasov);
		 
	} 
	

	
public ClaseBase(int prueba)   {
	 
	}
	public String HojaResultado="Demanda I";
	/* public void fin(){
		try {
			System.out.println("Ha secedio un error:" + e.getMessage()+  NombreDelCasoDePruebas);
			Comunes.APP.FuncionesComunes.editarReporte(this.AmbienteDelCasoDePruebas,"Demanda I","001", "FALLIDO",e.getMessage().toString(),tipo_cliente);
			Comunes.APP.FuncionesComunes.agregarFilaEnReporteApp("001","Login Correcto","FALLIDO",e.getMessage().toString(),tipo_cliente);
		    }   catch (Exception e1) { 
			System.out.println("Ha secedio un error:" + e1.getMessage());
   		  }
		} */
	 public boolean NuevaBitacoraActiva=false;
	 public boolean  BitacoraActivaMongo=false;
	 public void tiempoPrueba() {
		 long tiempoFinal=System.currentTimeMillis(); 
		 long resta=tiempoFinal - tiempoInicial;
		 System.out.println("Tiempo de la prueba milisegundos: "+ resta);
		 System.out.println("Tiempo de la prueba segundos: "+ (resta/1000));
		 System.out.println("Tiempo de la prueba minutos: "+ ((resta/1000)/60));
		 System.out.println("Tiempo de la prueba horas: "+ (((resta/1000)/60)/60));
	 }
	 
	 public String tiempoPruebaCadena() {
		 long tiempoFinal=System.currentTimeMillis(); 
		 long resta=tiempoFinal - tiempoInicial;
		 return "Tiempo de la prueba milisegundos: "+ resta+"\n Tiempo de la prueba segundos: "+ (resta/1000)
				 +"\n"+"Tiempo de la prueba minutos: "+ ((resta/1000)/60)+
				 "\n Tiempo de la prueba horas: "+ (((resta/1000)/60)/60);
	 }
	 public String tiempoPruebaCadena2() {
		 long tiempoFinal=System.currentTimeMillis(); 
		 long resta=tiempoFinal - tiempoInicial;
		 return resta+""; }
	
	public int TiempoNormal= 10;
	public int TiempoMaximoEspera= 30;
	public Controlador nuevoControlador=new Controlador();
	
	public String NombreDelCasoDePruebas="";
	public String AmbienteDelCasoDePruebas="";
	public String TipoClienteDelCasoDePruebas="";
	
 
	//Por ahora se comenta la bitacora en mondb por que no esta terminada.
	//Para que el acceso sea sencillo se tendria que hacer un desarrollo de un sitio web y de mas 
	//Como no hay tiempo cre oque no hare el sitio web.
 	public  boolean ModoGodDebugerClick=false;
	public  boolean ModoGodDebugerEscribir=false;
 	//MobileBy.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[3]/android.widget.EditText[1]");
	//MobileBy.xpath("//*[@resource-id='sourceFounds']");
  
	 
	public String xmlDelInfinito="";
	public String xmlDelInfinito2="";
	 
	boolean debugActivated=false;
	public boolean debugActivatedMonster=false;
	String  pasadoVolver="";
	long tiempoInicial=System.currentTimeMillis(); 
	
	boolean YaLlamoAlMensajeDeError=false;
	String NoAvanzo="";
	String NoAvanzoX2="";
 
	                                               
	public List<By> ListaElementos=  new ArrayList<By>(); 
	public List<String>ListaPasos=  new ArrayList<String>(); 
	public List<String>ListaDatos=  new ArrayList<String>(); 
	public List<String>ListaExpresiones=  new ArrayList<String>();
	public List<String>ListaFuncion=  new ArrayList<String>(); 
	public List<String>ListaFuncion2=  new ArrayList<String>(); 
	public List<String>ListaDatoParaFuncion=  new ArrayList<String>();
	public List<String>ListaExpresionesParaFuncion=  new ArrayList<String>();

}

