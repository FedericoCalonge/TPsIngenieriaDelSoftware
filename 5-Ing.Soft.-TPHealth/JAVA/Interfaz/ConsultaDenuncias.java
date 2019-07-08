package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Dao.Consultas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import Excepciones.ExcepcionNoNumerico;
import Controladores.Validador;

public class ConsultaDenuncias extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public static void main(String[] args) {
		try {
			ConsultaDenuncias dialog = new ConsultaDenuncias();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ConsultaDenuncias() {
		setTitle("Consultar Denuncias");
		setBounds(100, 100, 364, 117);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD, 14));
		textField.setBounds(200, 11, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblIngresarId = new JLabel("Ingresar ID:");
		lblIngresarId.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIngresarId.setBounds(21, 14, 86, 20);
		contentPanel.add(lblIngresarId);
		{

		}
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Buscar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						ventanaDenuncia(textField.getText());
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
		}
	
	public void ventanaDenuncia(String codigo) {
		switch(codigo.trim().toUpperCase().charAt(0)) {
		case 'A':
			if(valorNumerico(codigo.substring(1))) { //Substring lo que le sigue, DEBE ser numérico.
				DefaultTableModel datos = Consultas.traerDenunciaAnimal(new Integer (codigo.substring(1)));
				if (datos.getRowCount()!=0) {
					MostrarTabla mostrarDenunciasAnimales = new MostrarTabla("DenunciasAnimales");
					mostrarDenunciasAnimales.setModal(true);
					mostrarDenunciasAnimales.CargarTabla(datos);
					mostrarDenunciasAnimales.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "El código NO existe");
			         dispose();
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Código erróneo");  //Por ejemplo AA2.
		         dispose();
			}
			break;
		case 'C':
				if(valorNumerico(codigo.substring(1))) { //Substring lo que le sigue, DEBE ser numérico.
				DefaultTableModel datos = Consultas.traerDenunciaComida(new Integer (codigo.substring(1)));
				if (datos.getRowCount()!=0){
					MostrarTabla mostrarDenunciasComida = new MostrarTabla("DenunciasComida");
					mostrarDenunciasComida.setModal(true);
					mostrarDenunciasComida.CargarTabla(datos);
					mostrarDenunciasComida.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "El código NO existe");
			         dispose();
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Código erróneo");
		         dispose();
			}
			
			break;
		case 'E':
				if(valorNumerico(codigo.substring(1))) { //Substring lo que le sigue, DEBE ser numérico.
				
				DefaultTableModel datos = Consultas.traerDenunciaEspecial(new Integer (codigo.substring(1)));
				if (datos.getRowCount()!=0)
					{
					MostrarTabla mostrarDenunciasEspeciales = new MostrarTabla("DenunciasEspeciales");
					mostrarDenunciasEspeciales.setModal(true);
					mostrarDenunciasEspeciales.CargarTabla(datos);
					mostrarDenunciasEspeciales.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "El código NO existe");
			         dispose();
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Código erróneo");
		         dispose();
			}
			
			break;
		default:
			JOptionPane.showMessageDialog(null, "Código erróneo");
	        dispose();
			break;
		}
	}
	
	private boolean valorNumerico(String valor) {
		try {
			Validador.validarValoresNumericos(valor);
		}
		catch(ExcepcionNoNumerico e) {
			return false;
		}
		
		return true;
	}
}