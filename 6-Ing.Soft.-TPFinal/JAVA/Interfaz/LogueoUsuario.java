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

public class LogueoUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldContrasena;
	private JTextField textFieldEmail;

	public static void main(String[] args) {
		try {
			LogueoUsuario dialog = new LogueoUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LogueoUsuario() {
		setTitle("Iniciar Sesión");
		setBounds(600, 100, 375, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(129,212,250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(182,255,255));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Entrar");
				okButton.setFont(new Font("Calibri", Font.BOLD, 16));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!Validador.campoVacio(textFieldEmail.getText()) && !Validador.campoVacio(textFieldContrasena.getText())) {
							if(Controlador.verificarDatos(textFieldEmail.getText(),textFieldContrasena.getText())) { //Aca entraria la verificacion del E-mail y contrasena
								VentanaMenu ventanaMenu = new VentanaMenu(textFieldEmail.getText());
								dispose();
								ventanaMenu.setVisible(true);
							}
							else{
								JOptionPane.showMessageDialog(null, "El e-mail o la contrasena NO es correcta.");
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Hay campos obligatorios sin completar.");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.setFont(new Font("Calibri", Font.BOLD, 16));
				cancelarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
						dispose();
						ventanaPrincipal.setVisible(true);
					}
				});
				cancelarButton.setActionCommand("Cancel");
				buttonPane.add(cancelarButton);
			}
		}
		contentPanel.setLayout(null);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEmail.setBounds(29, 30, 46, 20);
		contentPanel.add(lblEmail);


		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldEmail.setBounds(84, 30, 250, 20);
		contentPanel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setFont(new Font("Calibri", Font.BOLD, 16));
		lblContrasena.setBounds(29, 75, 81, 20);
		contentPanel.add(lblContrasena);

		textFieldContrasena = new JPasswordField(); //Clase para los **** en la pass. 
		textFieldContrasena.setFont(new Font("Calibri", Font.BOLD, 16));
		textFieldContrasena.setBounds(119, 75, 215, 20);
		contentPanel.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);

	}
}
