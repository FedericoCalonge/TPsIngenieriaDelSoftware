package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.Controlador;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Top5 extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	public static void main(String[] args) {
		try {
			Top5 dialog = new Top5("Libro","profe@gmail.com");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Top5(String tipo, String idUsuario) {
		setBounds(100, 100, 340, 256);
		setTitle("TOP 5 " + tipo);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setFont(new Font("Calibri", Font.BOLD, 16));
			DefaultTableModel modelo = Controlador.obtenerTop5(idUsuario,tipo);
			table.setDefaultEditor(Object.class, null);
			table.setModel(modelo);
			
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(182,255,255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Enviar a");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String mensaje = Controlador.crearMensaje(table.getModel());
						Contactos contactos = new Contactos(idUsuario,mensaje);
						contactos.setModal(true);
						contactos.setVisible(true);
						dispose();
					}
				});
				okButton.setFont(new Font("Calibri", Font.BOLD, 16));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setFont(new Font("Calibri", Font.BOLD, 16));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
