package TPFinal;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ModeloPedido {
	//Este modelo que devuelvo lo pongo en el ScrollPane:
	public static DefaultTableModel mostrarModelo(String estado) throws SQLException{
		DefaultTableModel modelo = null;
		String tabla = "pedido";
		String campos = "clave_pedido, maquinaDeCorte, detalleTrabajo,fecha_entrega,cuit2";
		modelo = Consultas.mostrarPedido(tabla, campos, estado);
		return modelo;
	}
}
