package TPFinal;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class ModeloCliente {
	//Este modelo que devuelvo lo pongo en el ScrollPane:
	public static DefaultTableModel mostrarModelo() throws SQLException{
		DefaultTableModel modelo = null;
		String tabla = "cliente";
		String campos = "cuit, nombre, telefono,domicilio";
		modelo = Consultas.mostrarCliente(tabla, campos);
		return modelo;
	}
}