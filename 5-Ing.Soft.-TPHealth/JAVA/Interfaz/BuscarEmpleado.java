package Interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controladores.Controlador;

public class BuscarEmpleado extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtDatos;
	private String [] EmpleadoSeleccionado;

	public static void main(String[] args) {
		try {
			BuscarEmpleado dialog = new BuscarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BuscarEmpleado() {
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setBounds(100, 100, 500, 400); //limites de la ventana primeros valores x y (de donde comienza), los segundos valores el ancho y largo
		contentPane = new JPanel(); //crea un objeto
		contentPane.setBackground(Color.PINK);
		getContentPane().add(contentPane, BorderLayout.NORTH);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextField txtPalabras = new JTextField();
		contentPane.add(txtPalabras);
		txtPalabras.setColumns(35);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo = Controlador.buscarEmpleado(txtPalabras.getText());
				jtDatos.setModel(modelo);
				//Estos 4 de abajo son para que no se vea la columna de pass:
			    jtDatos.getColumn("Contraseña").setPreferredWidth(0);
			    jtDatos.getColumn("Contraseña").setMinWidth(0);
			    jtDatos.getColumn("Contraseña").setWidth(0);
			    jtDatos.getColumn("Contraseña").setMaxWidth(0);
			}
		});
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		jtDatos = new JTable();
		scrollPane.setViewportView(jtDatos);

		jtDatos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==1){ //Cuando se hace click sobre un cliente
					Controlador c = new Controlador();
					String empleado[] = null;
					try {
						empleado = c.obtenerEmpleado(Controlador.buscarEmpleado(obtenerIdEmpleado()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Modifique al empleado "+ empleado[0]);
					ActualizarEmpleado actualizarEmpleado = new ActualizarEmpleado(empleado[0],empleado[1],empleado[2]);
					actualizarEmpleado.setModal(true);
					actualizarEmpleado.setVisible(true);	
					dispose();
				}
			}
		});
		scrollPane.setViewportView(jtDatos);
	}
	private String obtenerIdEmpleado(){
		int row = jtDatos.getSelectedRow();
		DefaultTableModel modelo = (DefaultTableModel)jtDatos.getModel();
		return modelo.getValueAt(row, 0).toString(); //Esto muestra el valor de la columna 0 en la fila seleccionada
	}

	public String [] getEmpleadoSeleccionado() {
		return EmpleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(String [] empleadoSeleccionado) {
		EmpleadoSeleccionado = empleadoSeleccionado;
	}
}
