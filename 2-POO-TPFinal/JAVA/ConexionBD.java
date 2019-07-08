package TPFinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConexionBD {
	private static String driver = "com.mysql.jdbc.Driver";
	//?useSSL=false es para que no me tire el error de Verificación de SSL:
	private static String urlBD = "jdbc:mysql://localhost:3307/BDTPFINAL?useSSL=false";
	private static String usuario = "root";
	private static String pass = "0202";

	protected static Connection establecerConexion() {
			try { //Si no encuentra ninguno de los errores del catch se ejecuta el bloque try...
				Class.forName(ConexionBD.driver).newInstance(); //Creo una nueva instancia del objeto con el nombre com.mysql.jdbc.Driver.
				Connection conexion = DriverManager.getConnection(ConexionBD.urlBD, ConexionBD.usuario, ConexionBD.pass);
				if (conexion!=null)System.out.println("Conexion a la BD OK"); 
				return conexion; //Retorno la conexion para luego usarla si es que no hubo ningun error.
			} catch (SQLException e) {
				//Si capturo algun error SQLException entonces imprime...
				System.out.println("Error de BD en el metodo establecerConexion: " + e.getMessage());
				//Sino puedo imprimir la pila en ejecucion del error que me aparece en consola en rojo con --> e.printStackTrace();
			} catch (Exception ex) {
				//Si capturo algun error Exception entonces imprime...
				System.out.println("Error general en el metodo establecerConexion: " + ex.getMessage());
			}
			return null; //Si no se ejecuta el try por algun error (porque luego del catch del error
			//sigue la ejecución del programa), devuelve null.
		}
	
	//Todo metodo con un trows lo que hace es: Si todo va bien hace lo que esta dentro del metodo
	//(en este caso el try que contiene --> conexion.close).
	//Y si ocurre algun error lo que hace es LANZAR (Throw) un Objeto que CREA de clase SQLException.
	protected static void cerrarConexion(Connection conexion)throws SQLException {
			try{ conexion.close();}
			catch (SQLException e) {
				System.out.println("Error de BD en el metodo cerrarConexion: " + e.getMessage());
			}
	}
		
	protected static void ejectuarSql(String sql) throws SQLException {
		try{
			Connection conexion = ConexionBD.establecerConexion();
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.executeUpdate(sql);
			ps.close(); //Cierro el objeto PreparedStatement.
			ConexionBD.cerrarConexion(conexion);  //Cierro la conexión a la BD.
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
	}
}
//Para los metodos cerrarConexion y ejecutarSql NO es necesario hacer el try y catch porque 
//el error que lanzan (throw) SQLException es un error que hereda de IO RunTimeExcepcion y no 
//de IOExcepcion (por esto no sería necesario, pero lo ponemos igualmente).