package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Dao.Consultas;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ConsultaEnfermedades extends JDialog {
	private JTable tabla;
	private int claveDeFilaClickeada = 0;	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ConsultaEnfermedades dialog = new ConsultaEnfermedades();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConsultaEnfermedades() {
		setTitle("Consultar Enfermedades");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 206);
			contentPanel.add(scrollPane);
			//Para que me muestre el modelo en el ScrollPane
			tabla = new JTable();
			DefaultTableModel datos;
			datos = Consultas.traerEnfermedades();
			tabla.setModel(datos);
			scrollPane.setViewportView(tabla);	
		}
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Buscar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel datos;
						dispose();
						datos = Consultas.traerDatosEnfermedades(claveDeFilaClickeada);
						// Aca pensamos que claveDeFila es el ID de la especialidad (SI).
						//tabla.setVisible(false);
						MostrarTabla mostrarEnfermedades = new MostrarTabla("Enfermedades");
						mostrarEnfermedades.setModal(true);
						mostrarEnfermedades.CargarTabla(datos);
						mostrarEnfermedades.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			//Esto sirve para que reconozca que estamos clickeando la tabla que
			//se muestra en la ventana. Tuve que importar las clases MouseListener y Mouse adapter
			tabla.addMouseListener(new MouseAdapter() {
				    public void mouseClicked(MouseEvent e) {
				     int fila = tabla.rowAtPoint(e.getPoint()); //Me devuelve la fila.
				     int columna = tabla.columnAtPoint(e.getPoint()); //Me devuelve la columna.
				      if ((fila > -1) && (columna > -1))//Si estoy fuera de estos valores, estoy fuera de la tabla.
				        claveDeFilaClickeada = (int)tabla.getValueAt(fila,0); //Obtengo la clave.
				      }
				   });
		}

}