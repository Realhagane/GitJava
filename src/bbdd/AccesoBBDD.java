package bbdd;

import java.io.*;
import java.sql.*;

import ejercicio.Vehiculo;


public class AccesoBBDD {
	public static final String ARCHIVO = "vehiculos.dat";
	public static void mostrarVehiculosBBDD(Connection con) {
		if (con == null) {
			con = Conexion.conexion(ConstantesBD.URL, ConstantesBD.USUARIO, ConstantesBD.PWD);
		}
		try (PreparedStatement prst = con.prepareStatement("SELECT * FROM COCHES;");

				ResultSet rs = prst.executeQuery()) {

			while (rs.next()) {
				Vehiculo vehiculo = new Vehiculo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				System.out.println(vehiculo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public static void guardarVehiculosBBDD(Connection con) {
		if (con == null) {
			con = Conexion.conexion(ConstantesBD.URL, ConstantesBD.USUARIO, ConstantesBD.PWD);
		}
	
		PreparedStatement prst = null;
		ObjectInputStream leer = null;
		int contador = 0;
		try {
			prst = con.prepareStatement("insert into Coches values(?,?,?,?)");
			leer = new ObjectInputStream(new FileInputStream(ARCHIVO));
			while (true) {
				Vehiculo a = (Vehiculo) leer.readObject();
				prst.setString(1, a.getMatricula());
				prst.setString(2, a.getMarca());
				prst.setString(3, a.getModelo());
				prst.setInt(4, a.getAnioFabricacion());

				int registroHecho = prst.executeUpdate();
				System.out.println(a + "registrado");
				if (registroHecho > 0) {
					contador++;
				}

			}

		} catch (EOFException e) {
			System.out.println("Fichero terminado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				prst.close();
				leer.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Agregados " + contador + " registros");
	}
		
		


}
