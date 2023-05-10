package io;

import java.util.Scanner;

import ejercicio.Vehiculo;

public class CrearVehiculo {
	
	public static Vehiculo crearVehiculo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vamos a crear un coche");
		System.out.println("Introduce matricula");
		String matricula = sc.nextLine();
		System.out.println("Introduce marca");
		String marca = sc.nextLine();
		System.out.println("Introduce modelo");
		String modelo = sc.nextLine();
		System.out.println("Introduce año de fabricacion");
		int anio = Integer.parseInt(sc.nextLine());
		Vehiculo vehiculo = new Vehiculo(matricula,marca,modelo,anio);
		
		return vehiculo;
	}
}
