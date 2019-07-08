package TPFinal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaAdmin extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	//Getter para los resultados que mas abajo los uso:
	public String getCuit(){ return textField.getText(); }
	public String getNombre(){ return textField_1.getText(); }
	public String getTelefono(){ return textField_2.getText(); }
	public String getDomicilio(){ return textField_3.getText(); }
	
	public static void main(String[] args) {
		try {
			VentanaAdmin dialog = new VentanaAdmin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Dialog: */
	public VentanaAdmin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Administracion");
			lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
			lblNewLabel.setBounds(170, 10, 105, 23);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(64, 83, 79, 23);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblCuit = new JLabel("CUIT");
			lblCuit.setBounds(64, 52, 79, 23);
			contentPanel.add(lblCuit);
		}
		{
			JLabel lblDomicilio = new JLabel("Domicilio");
			lblDomicilio.setBounds(64, 145, 79, 23);
			contentPanel.add(lblDomicilio);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(136, 84, 160, 20);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(136, 117, 160, 20);
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(136, 146, 160, 20);
			contentPanel.add(textField_3);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(136, 52, 160, 20);
			contentPanel.add(textField);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setBounds(64, 111, 79, 23);
			contentPanel.add(lblTelefono);
		}
		{
			JButton button = new JButton("Insertar Pedido");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						VentanaInsertarPedido vip=new VentanaInsertarPedido();
						vip.setModal(true);
						vip.setVisible(true);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			});
			button.setBounds(64, 194, 138, 23);
			contentPanel.add(button);
		}
		
		JButton btnInsertarCliente = new JButton("Insertar Cliente");
		btnInsertarCliente.setBounds(245, 194, 138, 23);
		contentPanel.add(btnInsertarCliente);
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Si estoy aca dentro, complete todos los datos (todos los get) y apreté el boton de Insertar Cliente y Pedido. 
				setVisible(false); //Cierro la VentanaAdmin al insertar el Cliente y Pedido.
				//Aca vienen lo datos del Cliente de la VentanaAdmin y se guardan aca:
				String cuit=getCuit();
				String nombre=getNombre();
				String telefono=getTelefono();
				String domicilio=getDomicilio();
				
				try {//Insertamos el cliente a mi BD:
					if(cuit.equals(Consultas.buscarCuit(cuit))){
						//Mensaje de alerta si el cuit ya existe en mi BD:
						VentanaAlerta va=new VentanaAlerta("El Cuit ya existe!");
						//VentanaAdrministracion tiene que ser JDIALOG para poder hacer lo de set.Modal.
						va.setModal(true);
						va.setVisible(true);
					}
					else{Consultas.insertCliente(cuit, nombre, telefono, domicilio);
					}
				} catch (SQLException e1) { System.out.println("Error al insertar cliente:"+e1.getMessage());
			}
		}
		});
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			{
				JButton cancelButton = new JButton("Atras");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			}
		}
	}
}

