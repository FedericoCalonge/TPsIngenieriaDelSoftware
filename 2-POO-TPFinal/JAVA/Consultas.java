package TPFinal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Consultas extends ConexionBD { //Consultas es subclase de ConexionBD (así podemos llamar a sus metodos)
	public static void insertCliente(String cuit, String nombre, String telefono, String domicilio) throws SQLException{
		//El String sql es la consulta entera que le voy a la mandar a mi BD.
		//Los STRING dentro de values van con "triple" comilla --> '"+cuit+"' así en mi BD llega como 'cuit'.  Para los INT no hay que hacer esto.
		String sql = "insert into cliente (cuit, nombre, telefono, domicilio) VALUES ('"+ cuit +"','"+ nombre +"','"+ telefono +"','"+ domicilio +"');";
		ConexionBD.ejectuarSql(sql);
	}
	public static void insertPedido(String estado, String maquinaDeCorte, String detalleTrabajo, String fechaEntrega, String cuitCliente, String comentario) throws SQLException{
		//No insertamos la clave_pedido porque es un autoincrement en mi BD.
		String sql2 = "insert into pedido (estado, maquinaDeCorte, detalleTrabajo, fecha_entrega, cuit2, comentario) VALUES ('"+ estado +"','"+ maquinaDeCorte +"','"+ detalleTrabajo +"','"+ fechaEntrega +"','"+ cuitCliente + "','"+ comentario +"');";
		ConexionBD.ejectuarSql(sql2);
	}
	
	public static DefaultTableModel mostrarPedido(String tabla, String campos, String estado) throws SQLException{
		DefaultTableModel modelo = new DefaultTableModel(){
		    public boolean isCellEditable(int row, int column) {
		       //Todas las celdas FALSE:
		       return false;
		    }
		};
		modelo.addColumn("Clave Pedido");
		modelo.addColumn("Maquina de Corte");
		modelo.addColumn("Detalle");
		modelo.addColumn("Fecha");
		modelo.addColumn("CUIT Empresa");
		
		Connection con= ConexionBD.establecerConexion();
		
		String sql = "SELECT " + campos + " FROM " + tabla +" WHERE estado LIKE '"+ estado+"';";
		PreparedStatement ps = con.prepareStatement(sql);
		//El objeto ResultSet me trae una colección de registros, como cada registro es un
		//array de datos, lo recorro con el while (rs.next()) de abajo.
		ResultSet rs = ps.executeQuery();
		Object registro[] = new Object[5]; //Creo mi array de objetos.
		while (rs.next()){
			//Acá leemos los datos y armamos al array de objetos con estos datos y se los agregamos 
			//al modelo (con modelo.addRow(registro), donde coinciden entre si las columnas) y finalmente return modelo. 
			registro[0] = rs.getObject("clave_pedido"); //Copiamos las variables que pusimos en el registro y lo ponemos en el array de objetos.
			registro[1] = rs.getObject("maquinaDeCorte");
			registro[2] = rs.getObject("detalleTrabajo");
			registro[3] = rs.getObject("fecha_entrega");
			registro[4] = rs.getObject("cuit2");
			modelo.addRow(registro);
		}
		
		ConexionBD.cerrarConexion(con);
		return modelo;
	}
	
	public static DefaultTableModel mostrarCliente(String tabla, String campos) throws SQLException{
		DefaultTableModel modelo = new DefaultTableModel(){
		    public boolean isCellEditable(int row, int column) {
		       //Todas las celdas FALSE:
		       return false;
		    }
		};
		modelo.addColumn("CUIT");
		modelo.addColumn("Nombre");
		modelo.addColumn("Telefono");
		modelo.addColumn("Domicilio");
		
		Connection con= ConexionBD.establecerConexion();
		
		String sql = "SELECT " + campos + " FROM " + tabla +";";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		Object registro[] = new Object[4];
		while (rs.next()){
			registro[0] = rs.getObject("CUIT");
			registro[1] = rs.getObject("Nombre");
			registro[2] = rs.getObject("Telefono");
			registro[3] = rs.getObject("Domicilio");
			modelo.addRow(registro);
		}
		
		ConexionBD.cerrarConexion(con);
		return modelo;
	}
	
	public static String mostrarComentarios(int clave_pedido) throws SQLException{
		Connection con= ConexionBD.establecerConexion();
		
		String sql = "SELECT comentario FROM pedido WHERE clave_pedido LIKE '"+ clave_pedido+"';";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String resultado= "";
		
		while(rs.next()){
			resultado = rs.getString("comentario");  //Lo convierte en String.
		}
		
		ConexionBD.cerrarConexion(con);
		return resultado;
	}

	public static void modificarComentario(int clave_pedido, String comentario) throws SQLException{
		//Comilla triple para el String comentario así en SQL queda como 'comentario', para clave_pedido NO porque es int.
		String sql2 = "UPDATE Pedido SET comentario='"+ comentario+"'WHERE clave_pedido="+clave_pedido+";";
		ConexionBD.ejectuarSql(sql2);
	}
	
	public static void modificarMaquinaCortePedido(int clave_pedido, String maquinaDeCorte) throws SQLException{
			String sql2 = "UPDATE Pedido SET maquinaDeCorte='"+ maquinaDeCorte+"'WHERE clave_pedido="+clave_pedido+";";
			ConexionBD.ejectuarSql(sql2);
	}
	
	public static void modificarEstadoPedido(int clave_pedido, String estado) throws SQLException{
			String sql2 = "UPDATE Pedido SET estado='"+ estado+"'WHERE clave_pedido="+clave_pedido+";";
			ConexionBD.ejectuarSql(sql2);
	}
	
	public static String buscarCuit(String cuit) throws SQLException{
		Connection con= ConexionBD.establecerConexion();
		String sql = "SELECT cuit FROM cliente WHERE cuit= '"+ cuit+"';";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String resultado= "";
		
		while(rs.next()){
			resultado = rs.getString("cuit");  //Lo convierte en String.
		}
		
		ConexionBD.cerrarConexion(con);
		return resultado;
	}

	//Borro los pedidos que estan despachados:
	/*public static void borrarPedido() throws SQLException{
		String sql2 = "delete from pedido where estado= '"+"Despachado"+"';";
		System.out.println(sql2);
		ConexionBD.ejectuarSql(sql2);
	}*/
}

