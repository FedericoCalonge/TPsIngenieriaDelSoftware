package TPFinal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaInsertarPedido extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextArea comentario;
	private JTextField textField; //detalle
	private JTextField textField_1; //fecha
	private JTable tabla;
	private String cuitDeFilaClickeada;
	
	public String getdetalleTrabajo(){return textField.getText(); }
	public String getfechaEntrega(){ return textField_1.getText(); }
	
	public static void main(String[] args) {
		try {VentanaInsertarPedido dialog = new VentanaInsertarPedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VentanaInsertarPedido() throws SQLException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 22, 378, 105);
		contentPanel.add(scrollPane);
		
		//Para que me muestre el modelo en el ScrollPane
		tabla = new JTable();
		DefaultTableModel datos = ModeloCliente.mostrarModelo(); 
		tabla.setModel(datos);
		scrollPane.setViewportView(tabla);
		
		//La V.I. cuitDeFilaClickeada guarda el valor del cuil que clickeo en el scroll panel.
		tabla.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent e) {
		         int fila = tabla.rowAtPoint(e.getPoint()); //Me devuelve la fila.
		         int columna = tabla.columnAtPoint(e.getPoint()); //Me devuelve la columna.
		         if ((fila > -1) && (columna > -1))//Si estoy fuera de estos valores, estoy fuera de la tabla.
		        	cuitDeFilaClickeada = (String)tabla.getValueAt(fila,0); //Obtengo la clave.
		      }
		   });
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setBounds(43, 203, 68, 14);
		contentPanel.add(lblComentario);
		
		comentario = new JTextArea();
		JScrollPane scrollPane_1 = new JScrollPane(comentario);
		scrollPane_1.setBounds(121, 194, 240, 34);
		contentPanel.add(scrollPane_1);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(43, 166, 68, 14);
		contentPanel.add(lblFecha);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(43, 138, 68, 14);
		contentPanel.add(lblDetalle);
		
		textField = new JTextField();
		textField.setBounds(121, 135, 120, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 163, 120, 20);
		contentPanel.add(textField_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar Pedido");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 //Aca vienen los datos del Pedido de esta Ventana y se guardan aca:
						String detalleTrabajo=getdetalleTrabajo();
						String fechaEntrega=getfechaEntrega();
						String comentarioo = comentario.getText();
						//Al insertar el Pedido, no le asignamos ninguna maquina de corte y la mandamos directamente a Oficina_Tecnica:
						String maquinaCorte=null;
						String estado="En_Oficina_Tecnica";
						try {
							Consultas.insertPedido(estado, maquinaCorte, detalleTrabajo, fechaEntrega, cuitDeFilaClickeada, comentarioo);
							setVisible(false); //cierro la ventana luego de insertar.
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Atras");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	
}
