package ficheros;

import java.io.*;

import java.util.Scanner;

import ejercicio.Vehiculo;
import ficheros.ClaseAuxiliar;
import io.CrearVehiculo;
import ejercicio.Vehiculo;

public class AccesoDatos {
	public static final String ARCHIVO = "vehiculos.dat";




	
	
	
	//////

	public static boolean existeFichero() {
			File fichero = new File(ARCHIVO);
			
			return (fichero.exists() && fichero.length() > 0);
		}
		
		public static void darDeAlta() {
			Vehiculo vehiculo = CrearVehiculo.crearVehiculo();
			ObjectOutputStream escribir = null;
			
			
			try {
				if(existeFichero()) {
					escribir = new ClaseAuxiliar(new FileOutputStream(ARCHIVO,true));
				}else {
					escribir = new ObjectOutputStream(new FileOutputStream(ARCHIVO));
				}
				escribir.writeObject(vehiculo);
				
				escribir.close();
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
		public static void mostrarVehiculos() {
			try(ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
				
				while(true) {
					Vehiculo vehiculo = (Vehiculo) lectura.readObject();
					System.out.println(vehiculo);
				}
				
			} catch (EOFException e) {
				System.out.println("Fichero Leido");
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public static void borrarFichero() {
			File fichero = new File(ARCHIVO);
			System.out.println("Fichero borrado");
			fichero.delete();
		}

		
		
		
		
		
		
}
