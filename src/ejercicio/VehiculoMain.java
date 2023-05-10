package ejercicio;



import java.sql.Connection;
import java.util.Scanner;

import bbdd.AccesoBBDD;
import bbdd.Conexion;
import bbdd.ConstantesBD;
import ficheros.AccesoDatos;

public class VehiculoMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Connection con = Conexion.conexion(ConstantesBD.URL, ConstantesBD.USUARIO, ConstantesBD.PWD);

        do {
            System.out.println("Opciones:");
            System.out.println("1.- Introducir vehículo en el fichero");
            System.out.println("2.- Mostrar vehículos del fichero");
            System.out.println("3.- Volcar vehículos en la base de datos");
            System.out.println("4.- Mostrar vehículos de la base de datos");
            System.out.println("5.- Borrar todos los vehículos");
            System.out.println("6.- Salir");
            System.out.println("Elige operación:");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    AccesoDatos.darDeAlta();
                    break;
                case 2:
                    AccesoDatos.mostrarVehiculos();
                    break;
                case 3:
                    AccesoBBDD.guardarVehiculosBBDD(con);
                    break;
                case 4:
                    AccesoBBDD.mostrarVehiculosBBDD(con);
                    break;
                case 5:
                    AccesoDatos.borrarFichero();
                    break;
                case 6:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    Conexion.desConexion(con);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 6);

        scanner.close();
    }

}

