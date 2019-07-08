package TPFinal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaDespacho extends JDialog {
	private JTable tabla;
	private final JPanel contentPanel = new JPanel();
	private int claveDeFilaClickeada;
	private JTextArea comentario;
	
	public static void main(String[] args) {
		try { VentanaDespacho dialog = new VentanaDespacho();
			  dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			  dialog.setVisible(true);
		} catch (Exception e) {
			System.out.println("Error Exception en VentanaDespacho - main:"+e.getMessage());
		  }
	}

	/*Dialog*/
	public VentanaDespacho() throws SQLException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 414, 114);
		contentPanel.add(scrollPane);
		//Para que me muestre el modelo en el ScrollPane
		tabla = new JTable();
		DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Despacho"); 
		tabla.setModel(datos);
		scrollPane.setViewportView(tabla);
		
		//Esto sirve para que reconozca que estamos clickeando la tabla que
		//se muestra en la ventana. Tuve que importar las clases MouseListener y Mouse adapter
		tabla.addMouseListener(new MouseAdapter()  {
		      public void mouseClicked(MouseEvent e){
		         int fila = tabla.rowAtPoint(e.getPoint()); //me devuelve la fila
		         int columna = tabla.columnAtPoint(e.getPoint());
		         if ((fila > -1) && (columna > -1))//si estoy fuera de estos valores, estoy fuera de la tabla
		        	 claveDeFilaClickeada = (int)tabla.getValueAt(fila,0); //obtengo clave
					 try {  comentario.setText(Consultas.mostrarComentarios(claveDeFilaClickeada));
					 } catch (SQLException e1) {
						 System.out.println("Error SQLException en VentanaDespacho - tabla.addMouseListener:"+e1.getMessage());
					   }
		      }
		});

		JLabel lblListaDePedidos = new JLabel("Lista de Pedidos");
		lblListaDePedidos.setBounds(166, 11, 98, 14);
		contentPanel.add(lblListaDePedidos);
		
		comentario = new JTextArea(); 
		JScrollPane scrollPane_1 = new JScrollPane(comentario);
		scrollPane_1.setBounds(10, 157, 414, 72);
		contentPanel.add(scrollPane_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnDespachar = new JButton("Despachar");
			btnDespachar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Consultas.modificarEstadoPedido(claveDeFilaClickeada, "Despachado");
						//Consultas.borrarPedido(); //Los pedidos en estado=Despachado los elimino de mi BD.
						Consultas.modificarComentario(claveDeFilaClickeada, comentario.getText());
						DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Despacho"); //Acá actualizo mi vista.
						tabla.setModel(datos);
					} catch (SQLException e1) {
						System.out.println("Error SQLException en VentanaDespacho - Despachar:"+e1.getMessage());
					  }
				}
			});
			buttonPane.add(btnDespachar);
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
