package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

public class ConexionBD {
	private static String driver = "com.mysql.jdbc.Driver";
	//?useSSL=false es para que no me tire el error de Verificación de SSL:
	private static String urlBD = "jdbc:mysql://localhost:3307/BDDenuncias?useSSL=false";
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
		
	//Este metodo que usé para mi TPFINAL no lo llamamos ahora, llamamos al de abajo. ESTE NO --> protected static void ejectuarSql(String sql) throws SQLException
	
	protected static int ejectuarSql2(String sql) throws SQLException {
		int idDenuncia=-1;
		try{
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			if (rs != null && rs.next()) {
					idDenuncia = rs.getInt(1); //Agarra el 1er dato (el ID).
			   }
			
			st.close(); //Cierro el objeto Statement.
			ConexionBD.cerrarConexion(conexion);  //Cierro la conexión a la BD.
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		return idDenuncia;
	}
	
	public static int ejectuarSql3(String sql, int idEmpleado) throws SQLException {
		  int resultado =-1;
		  try{
		   Connection conexion = ConexionBD.establecerConexion();
		   Statement st = conexion.createStatement();
		   st.executeUpdate(sql);
		   
		   resultado = idEmpleado;
		   
		   st.close(); //Cierro el objeto Statement.
		   ConexionBD.cerrarConexion(conexion);  //Cierro la conexión a la BD.
		  }
		  catch (SQLException e) {
		   System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		  }
		  return resultado;
		 }
		 
	public static DefaultTableModel buscarEmpleado(String sql) {
		  DefaultTableModel modelo = new DefaultTableModel();
		  try {
		   Connection conexion = ConexionBD.establecerConexion();
		   Statement st = conexion.createStatement();
		   
		   ResultSet rs = st.executeQuery(sql);
		   
		   //Transformamos el ResultSet en DefaultTableModel
		   modelo.addColumn("ID Empleado");
		   modelo.addColumn("Nombre");
		   modelo.addColumn("Contraseña");
		   
		   //Recorremos los registros del ResultSet
		   Object[] registro;
		   while(rs.next()) {
		    registro = new Object[3];

		    registro[0] = rs.getObject("id_Empleado");
		    registro[1] = rs.getObject("nombre");
		    registro[2] = rs.getObject("contraseña");
		    modelo.addRow(registro);
		   }
		   
		   rs.close();
		   st.close();
		   conexion.close();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return modelo;
		 }
	
	public static int guardarNuevoEmpleado(String sql, int idEmpleado, String nombre, String contraseña) {
		  int resultado = -1;
		  try {
		   Connection conexion = ConexionBD.establecerConexion();
		   
		   //Con PreparedStatement
		   PreparedStatement pst = (PreparedStatement)conexion.prepareStatement(sql);
		   pst.setInt(1, idEmpleado);
		   pst.setString(2, nombre);
		   pst.setString(3, contraseña);
		   pst.executeUpdate();
		   
		   resultado = idEmpleado;
		   
		   pst.close();
		   conexion.close();;
		  } catch (SQLException e) {
		   System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		  }  
		  return resultado;
	}
		
	protected static DefaultTableModel traerEspecialidades(String sql){
			
			DefaultTableModel modeloTabla = new DefaultTableModel() {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
			       return false;
			    }
			};
			
			try {
				Connection conexion = ConexionBD.establecerConexion();
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				modeloTabla.addColumn("ID Especialidad");
	            modeloTabla.addColumn("Nombre");
	
	            while(rs.next()){
	                Object[] registro = new Object[2];
	
	                registro[0] = rs.getInt("idEspecialidad");
	                registro[1] = rs.getString("nombre");
	
	                modeloTabla.addRow(registro);
	                
	                //DEBUG - 
	                System.out.println("id="+registro[0]+" - nombre="+registro[1]);   
	            }
	
	            rs.close();
	            st.close();
	            ConexionBD.cerrarConexion(conexion);
			}
			catch (SQLException e) {
				System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
			}
			
			return modeloTabla;
	}
	
	protected static DefaultTableModel traerHospitalesPorEspecialidad(String sql){
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		try {
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			modeloTabla.addColumn("ID");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("Direccion");

            while(rs.next()){
                Object[] registro = new Object[3];

                registro[0] = rs.getInt("Hospital.idHospital");
                registro[1] = rs.getString("Hospital.nombre");
                registro[2] = rs.getString("Hospital.direccion");

                modeloTabla.addRow(registro);
                
                //DEBUG - 
                
                System.out.println("id="+registro[0]+" - nombre="+registro[1]+" - direccion="+registro[2]);   
            }

            rs.close();
            st.close();
            ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		
		return modeloTabla;
	}
	
	protected static DefaultTableModel traerHospitales(String sql){
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		try {
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			modeloTabla.addColumn("ID Hospital");
            modeloTabla.addColumn("Nombre");

            while(rs.next()){
                Object[] registro = new Object[2];

                registro[0] = rs.getInt("idHospital");
                registro[1] = rs.getString("nombre");

                modeloTabla.addRow(registro);
                
                //DEBUG - 
                System.out.println("id="+registro[0]+" - nombre="+registro[1]);   
            }

            rs.close();
            st.close();
            ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		
		return modeloTabla;
	}
	
	protected static DefaultTableModel traerEnfermedades(String sql){
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		try {
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			modeloTabla.addColumn("ID Enfermedad");
            modeloTabla.addColumn("Descripcion");

            while(rs.next()){
                Object[] registro = new Object[2];

                registro[0] = rs.getInt("idEnfermedad");
                registro[1] = rs.getString("descripcion");

                modeloTabla.addRow(registro);
                
                //DEBUG - 
                System.out.println("id="+registro[0]+" - nombre="+registro[1]);   
            }

            rs.close();
            st.close();
            ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		
		return modeloTabla;
	}
	
	protected static DefaultTableModel traerDatosEnfermedades(String sql){
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		try {
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			modeloTabla.addColumn("ID Enfermedad");
            modeloTabla.addColumn("Descripcion");
            modeloTabla.addColumn("Sintomas");
            modeloTabla.addColumn("Duracion");

            while(rs.next()){
                Object[] registro = new Object[4];

                registro[0] = rs.getInt("idEnfermedad");
                registro[1] = rs.getString("descripcion");
                registro[2] = rs.getString("sintomas");
                registro[3] = rs.getString("duracion");

                modeloTabla.addRow(registro);
                
                //DEBUG - 
                System.out.println("id="+registro[0]+" - nombre="+registro[1]+" - sintomas="+registro[2]+" - duracion="+registro[3]);   
            }

            rs.close();
            st.close();
            ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		
		return modeloTabla;
	}
	
public static DefaultTableModel traerDenunciaAnimal(String sql){
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		try {
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			modeloTabla.addColumn("ID Denuncia");
            modeloTabla.addColumn("Descripcion");
            modeloTabla.addColumn("Estado");
            modeloTabla.addColumn("Tipo");
            modeloTabla.addColumn("Cantidad");

            while(rs.next()){
                Object[] registro = new Object[5];

                registro[0] = rs.getInt("id_Animal");
                registro[1] = rs.getString("descripcion_denuncia");
                registro[2] = rs.getString("estado_denuncia");
                registro[3] = rs.getString("tipo_an");
                registro[4] = rs.getString("cantidad_an");

                modeloTabla.addRow(registro);
                
                //DEBUG - 
                System.out.println("id="+registro[0]+" - desc="+registro[1]+" - estado="+registro[2]+" - tipo="+registro[3]+" - cantidad="+registro[4]);   
            }

            rs.close();
            st.close();
            ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		
		return modeloTabla;
	}
	
public static DefaultTableModel traerDenunciaEspecial(String sql){
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		try {
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			modeloTabla.addColumn("ID Denuncia");
            modeloTabla.addColumn("Descripcion");
            modeloTabla.addColumn("Estado");
            modeloTabla.addColumn("Edad");
            modeloTabla.addColumn("Nivel Academico");
            modeloTabla.addColumn("Ocupacion");

            while(rs.next()){
                Object[] registro = new Object[6];

                registro[0] = rs.getInt("id_Especial");
                registro[1] = rs.getString("descripcion_denuncia");
                registro[2] = rs.getString("estado_denuncia");
                registro[3] = rs.getString("edad_esp");
                registro[4] = rs.getString("nivelAcademico_esp");
                registro[5] = rs.getString("ocupacion_esp");

                modeloTabla.addRow(registro);
                
                //DEBUG - 
                System.out.println("id="+registro[0]+" - desc="+registro[1]+" - estado="+registro[2]+" - edad="+registro[3]+" - nivelac="+registro[4]+" - ocup="+registro[5]);   
            }

            rs.close();
            st.close();
            ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		
		return modeloTabla;
	}
	
public static DefaultTableModel traerDenunciaComida(String sql){
		
		DefaultTableModel modeloTabla = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		try {
			Connection conexion = ConexionBD.establecerConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			modeloTabla.addColumn("ID Denuncia");
            modeloTabla.addColumn("Descripcion");
            modeloTabla.addColumn("Estado");
            modeloTabla.addColumn("Comida");
            modeloTabla.addColumn("Victimas");
            modeloTabla.addColumn("Enfermos");
            modeloTabla.addColumn("Internados");
            modeloTabla.addColumn("Muertos");

            while(rs.next()){
                Object[] registro = new Object[8];

                registro[0] = rs.getInt("id_Comida");
                registro[1] = rs.getString("descripcion_denuncia");
                registro[2] = rs.getString("estado_denuncia");
                registro[3] = rs.getString("comida");
                registro[4] = rs.getString("cantVictimas");
                registro[5] = rs.getString("cantEnfermos");
                registro[6] = rs.getString("cantInternados");
                registro[7] = rs.getString("cantMuertos");                
                
                modeloTabla.addRow(registro);
                
                //DEBUG - 
                System.out.println("id="+registro[0]+" - desc="+registro[1]+" - estado="+registro[2]+" - comida="+registro[3]+" - cv="+registro[4]+" - ce="+registro[5]+" - ci="+registro[6]+" - cm="+registro[7]);   
            }

            rs.close();
            st.close();
            ConexionBD.cerrarConexion(conexion);
		}
		catch (SQLException e) {
			System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
		}
		
		return modeloTabla;
	}

public static String traerContraseña(String sql) {
	  String password = "";

	  try {
	    Connection conexion = ConexionBD.establecerConexion();
	    Statement st = conexion.createStatement();
	    ResultSet rs = st.executeQuery(sql);

	        while(rs.next()){
	           password = rs.getString("contraseña");
	        }

	        rs.close();
	        st.close();
	        ConexionBD.cerrarConexion(conexion);
	  }
	  catch (SQLException e) {
	    System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
	  }
	  return password;
	}

	public static boolean idExistente(String sql) {
	  boolean resultado = false;

	  try {
	    Connection conexion = ConexionBD.establecerConexion();
	    Statement st = conexion.createStatement();
	    ResultSet rs = st.executeQuery(sql);

	          if(rs.next()) {
	            resultado = true;
	          }

	          rs.close();
	          st.close();
	          ConexionBD.cerrarConexion(conexion);
	  }
	  catch (SQLException e) {
	    System.out.println("Error de BD en el metodo ejecutarSql: " + e.getMessage());
	  }

	  return resultado;
	}


}
//Para los metodos cerrarConexion y ejecutarSql NO es necesario hacer el try y catch porque 
//el error que lanzan (throw) SQLException es un error que hereda de IO RunTimeExcepcion y no 
//de IOExcepcion (por esto no sería necesario, pero lo ponemos igualmente).