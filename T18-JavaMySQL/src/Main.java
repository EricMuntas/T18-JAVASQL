import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	static String bd = "ejercicio8";
	static String login = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:3306/" + bd;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// crear conexión
		Connection conn = null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection(url, login, password);
			String sURL = url;
			conn = DriverManager.getConnection(sURL,login,password);
			if (conn != null) {
				System.out.println("-Abierta base de datos " + url + " - Ok");
				// Crear tabla contacto
				Statement st = conn.createStatement();// Permite comandos SQL
			
				//System.out.println("-Creada tabla (contacto) - Ok");
				
				
				// Insertar datos a la tabla
				
				//PIEZAS
				
				int codigoPieza[] = { 11, 12, 13, 14, 15};
				String nombrePieza[] = { "piezaOnce", "piezaDoce", "piezaTrece", "piezaCatorze", "piezaQuince" };
				/*
				
				for (int i = 0; i < codigoPieza.length; i++) {
					st.executeUpdate(
							"INSERT INTO piezas (" +
									"codigoPieza, " + "nombrePieza) " +
									"VALUES ("+
									"'" + codigoPieza[i] + "','" +
									nombrePieza[i] +"' )");
				}
				*/
				
				//PROVEDORES
				
				String idProveedor[] = { "aaba", "aaca", "aada", "aaea", "aafa"};
				String nombreProveedor[] = { "Laringitis", "Gatito", "Hielo", "Moler", "Rama" };
				/*
				
				for (int i = 0; i < idProveedor.length; i++) {
					st.executeUpdate(
							"INSERT INTO proveedores (" +
									"idProveedor, " + "nombreProveedor) " +
									"VALUES ("+
									"'" + idProveedor[i] + "','" +
									nombreProveedor[i] +"' )");
				}
				*/
				
				//SUMINISTRA
				int precio[] = { 250, 200, 230, 100, 300};
			//	int codigoPieza2[] = { 16, 17, 13, 14, 15};
				//String idProveedor2[] = { "aaba", "aaca", "aada", "aaea", "aafa"};
				for (int i = 0; i < precio.length; i++) {
					st.executeUpdate(
							"INSERT INTO suministra (" +
									"codigoPieza, " + "idProveedor, "+ "precio) " +
									"VALUES ("+
									"'" + codigoPieza[i] + "','" +
									idProveedor[i] + "','" + precio[i] + "' )");
				}
				
				
				
				
				System.out.println("-Añadir registros a la tabla - Ok");
				// Consulta de datos
				System.out.println("-Consultar registros:");
				ResultSet rs = st.executeQuery("select * from contacto");
				while (rs.next()) {
					System.out.println(
							rs.getString(1) + " " +
									rs.getString(2) + " " +
									rs.getString(3) + " " +
									rs.getString(4));
				}
				// Borrar tabla
				/*
				st.executeUpdate("DROP TABLE contacto");
				System.out.println("-Borrar tabla contacto - Ok");
				conn.close();// Cerrar base de datos
				System.out.println("-Cerrar base de datos " + url + " - Ok");
				
				*/
			} 
		} catch (SQLException ex) {
			System.out.println(ex);
		}





	}

}
