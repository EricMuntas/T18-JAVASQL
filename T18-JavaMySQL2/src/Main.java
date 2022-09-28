import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	static String bd = "ejercicio11";
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
				
				//EQUIPOS
				
				String numeroSerie[] = { "aaba", "aaca", "aada", "aaea", "aafa"};
				String nombreEquipo[] = { "asdf1", "asdf2", "asdf3", "asdf4", "asdf5" };
				int codigoFacultad[] = {110, 111, 112, 113, 114};
				
				
				for (int i = 0; i < numeroSerie.length; i++) {
					st.executeUpdate(
							"INSERT INTO equipos (" +
									"numeroSerie, " + "nonmbreEquipo, " + "codigoFacultad) " +
									"VALUES ("+
									"'" + numeroSerie[i] + "','" +
									nombreEquipo[i] + "','" + codigoFacultad[i] + "' )");
				}
				
				
				//FACULTAD
				
				String nombreFacultad[] = { "Universidad11", "Universidad12", "Universidad13", "Universidad14", "Universidad15"};
				
				for (int i = 0; i < codigoFacultad.length; i++) {
					st.executeUpdate(
							"INSERT INTO facultad (" +
									"codigoFacultad, " + "nombreFacultad) " +
									"VALUES ("+
									"'" + codigoFacultad[i] + "','" +
									nombreFacultad[i] +"' )");
				}
				
				
				
				
				// INVESTIGADORES
				
				String dni[] = { "1234567M", "1234567N", "1234567X", "1234567Z", "1234567Y"};
				String nomAples[] = { "Nombre11", "Nombre12", "Nombre13", "Nombre14", "Nombre15"};
				
				for (int i = 0; i < dni.length; i++) {
					st.executeUpdate(
							"INSERT INTO investigadores (" +
									"dni, " + "nomAples, "+ "codigoFacultad) " +
									"VALUES ("+
									"'" + dni[i] + "','" +
									nomAples[i] + "','" + codigoFacultad[i] + "' )");
				}
				
				// RESERVA
			
				String fecha[] = {"2022-10-01"};
				
				for (int i = 0; i < dni.length; i++) {
					st.executeUpdate(
							"INSERT INTO reserva (" +
									"dni, " + "numeroSerie, "+ "comienzo, " + "fin) " +
									"VALUES ("+
									"'" + dni[i] + "','" +
									numeroSerie[i] + "','" + fecha[0] + "', " +  fecha[0]+ " )");
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
