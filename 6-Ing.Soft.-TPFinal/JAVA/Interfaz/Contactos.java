package Interfaz;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.Controlador;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Contactos extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JLabel lblParaEnviarLa;
	private JLabel lblNewLabel;
	
	public static void main(String[] args) {
		try {
			Contactos dialog = new Contactos("profe@gmail.com", "Aca enviamos la lista");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Contactos(String IdUsuarioEmisor, String mensaje) {
		getContentPane().setBackground(new Color(182,255,255));
		setBounds(100, 100, 340, 256);
		setTitle("Contactos");
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 324, 160);
			getContentPane().add(scrollPane);
			table = new JTable();
			table.setFont(new Font("Calibri", Font.BOLD, 16));
			DefaultTableModel modelo = Controlador.obtenerContactos(IdUsuarioEmisor);
			table.setDefaultEditor(Object.class, null);
			table.setModel(modelo);
			
			scrollPane.setViewportView(table);
			
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount()==2){ //Cuando se hace doble click sobre un cliente
						boolean resultado = false;
						
						resultado = Controlador.altaMensaje(IdUsuarioEmisor,obtenerEmailReceptor(),mensaje);

						if(resultado) {
							JOptionPane.showMessageDialog(null, "Lista enviada exitosamente.");
						}
						else {
							JOptionPane.showMessageDialog(null, "ERROR en el envio");
						}
						dispose();
					}
				}
			});
			scrollPane.setViewportView(table);

		}
		lblParaEnviarLa = new JLabel("Para enviar la lista a un contacto, doble");
		lblParaEnviarLa.setFont(new Font("Calibri", Font.BOLD, 16));
		lblParaEnviarLa.setBounds(20, 165, 294, 20);
		getContentPane().add(lblParaEnviarLa);
		
		lblNewLabel = new JLabel("click sobre el mismo.");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 186, 213, 20);
		getContentPane().add(lblNewLabel);

	}
	private String obtenerEmailReceptor(){
		int row = table.getSelectedRow();
		DefaultTableModel modelo = (DefaultTableModel)table.getModel();
		return modelo.getValueAt(row, 0).toString(); //Esto muestra el valor de la columna 0 en la fila seleccionada
	}
}
