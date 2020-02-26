package Comunes;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder 
{
	private static final char PKG_SEPARATOR = '.';
	private static final char DIR_SEPARATOR = '/';
	private static final String CLASS_FILE_SUFFIX = ".class";
	private static final String BAD_PACKAGE_ERROR = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

	public static void main(String args[]) 
	{
		ClassFinder find = new ClassFinder();
		List<Class<?>> clases = find.find("casosDePrueba");

		for (Class clase : clases) {
			for (Method metodo : clase.getDeclaredMethods()) {
				if (metodo.getName().contains("testCase")) {
					System.out.println(metodo.getName());
				}
			}
		}
	}

	public static List<Class<?>> find(String scannedPackage) 
	{
		String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
		URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);
		if (scannedUrl == null) 
		{
			throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
		}
		File scannedDir = new File(scannedUrl.getFile());
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (File file : scannedDir.listFiles()) 
		{
			classes.addAll(find(file, scannedPackage));
		}
		return classes;
	}

	public static List<Class<?>> find(File file, String scannedPackage) 
	{
		List<Class<?>> classes = new ArrayList<Class<?>>();
		String resource = scannedPackage + PKG_SEPARATOR + file.getName();
		if (file.isDirectory()) 
		{
			for (File child : file.listFiles()) 
			{
				classes.addAll(find(child, resource));
			}
		}
		else if (resource.endsWith(CLASS_FILE_SUFFIX))
		{
			int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
			String className = resource.substring(0, endIndex);
			try
			{
				classes.add(Class.forName(className));
			} 
			catch (ClassNotFoundException ignore)
			{
			}
		}
		return classes;
	}

}