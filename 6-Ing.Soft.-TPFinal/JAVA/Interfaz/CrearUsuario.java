package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CrearUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldContrasena;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;



	public static void main(String[] args) {
		try {
			CrearUsuario dialog = new CrearUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CrearUsuario() {
		setTitle("Crear Usuario");
		setBounds(600, 100, 375, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(129,212,250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(182,255,255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!Validador.campoVacio(textFieldNombre.getText()) && !Validador.campoVacio(textFieldEmail.getText()) && !Validador.campoVacio(textFieldContrasena.getText())) {
							if(!Controlador.eMailExistente(textFieldEmail.getText()) && textFieldEmail.getText().contains("@") && textFieldEmail.getText().contains(".")){
								boolean resultado = false;

								resultado = Controlador.altaUsuario(textFieldEmail.getText(),textFieldNombre.getText(),textFieldContrasena.getText());

								if(resultado) {
									JOptionPane.showMessageDialog(null, "Usuario dado de ALTA correctmente.");
								}
								else {
									JOptionPane.showMessageDialog(null, "ERROR en la Carga");
								}
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null, "ERROR, E-mail incorrecto/ya hay un usuario con ese E-mail.");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin completar.");
						}
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(cancelarButton);
			}
		}
		contentPanel.setLayout(null);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEmail.setBounds(28, 70, 46, 20);
		contentPanel.add(lblEmail);


		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldEmail.setBounds(83, 70, 250, 20);
		contentPanel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Calibri", Font.BOLD, 16));
		lblContrasena.setBounds(28, 110, 81, 20);
		contentPanel.add(lblContrasena);

		textFieldContrasena = new JPasswordField(); //Clase para los **** en la pass. 
		textFieldContrasena.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldContrasena.setBounds(118, 110, 215, 20);
		contentPanel.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(98, 30, 235, 20);
		contentPanel.add(textFieldNombre);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNombre.setBounds(28, 30, 81, 20);
		contentPanel.add(lblNombre);

	}
}
