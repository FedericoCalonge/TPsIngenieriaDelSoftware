package TPFinal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class VentanaProduccion extends JDialog {
	private JTable tabla;
	private final JPanel contentPanel = new JPanel();
	private int claveDeFilaClickeada = 0;
	private JTextArea comentario;

	public static void main(String[] args) {
		try { VentanaProduccion dialog = new VentanaProduccion();
			  dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			  dialog.setVisible(true);
		} catch (Exception e) {
			System.out.println("Error SQLException en VentanaProduccion - main:"+e.getMessage());
		}
	}

	/* Dialog:*/
	public VentanaProduccion() throws SQLException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPedidos = new JLabel("Lista de Pedidos");
		lblPedidos.setBounds(176, 11, 107, 14);
		contentPanel.add(lblPedidos);
		
		comentario = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(comentario);
		scrollPane.setBounds(10, 36, 414, 106);
		contentPanel.add(scrollPane);
		
		//Para que me muestre el modelo en el ScrollPane:
		tabla = new JTable();
		DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Produccion");
		tabla.setModel(datos);
		scrollPane.setViewportView(tabla);
		
		//Esto sirve para que reconozca que estamos clickeando la tabla que
		//se muestra en la ventana. Tuve que importar las clases MouseListener y MouseAdapter.
		tabla.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent e){ 
		         int fila = tabla.rowAtPoint(e.getPoint()); //me devuelve la fila
		         int columna = tabla.columnAtPoint(e.getPoint());
		         if ((fila > -1) && (columna > -1))//si estoy fuera de estos valores, estoy fuera de la tabla
		        	 claveDeFilaClickeada = (int)tabla.getValueAt(fila,0); //obtengo clave
		         	 try { comentario.setText(Consultas.mostrarComentarios(claveDeFilaClickeada));
					 } catch (SQLException e1) {
						System.out.println("Error SQLException en VentanaProduccion - mouseClicked:"+e1.getMessage());
					 	}
		      }
		   });
		
		JButton btnPasarADespacho = new JButton("Pasar a despacho");
		btnPasarADespacho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultas.modificarEstadoPedido(claveDeFilaClickeada, "En_Despacho");
					Consultas.modificarComentario(claveDeFilaClickeada, comentario.getText());
					DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Produccion");
					tabla.setModel(datos);
					} catch (SQLException e1) {
						System.out.println("Error SQLException en VentanaProduccion - Pasar a despacho:"+e1.getMessage());
						}
			}
		});
		btnPasarADespacho.setBounds(279, 207, 153, 21);
		contentPanel.add(btnPasarADespacho);
		
		comentario = new JTextArea();
		
		JScrollPane scrollPane_1 = new JScrollPane(comentario);
		scrollPane_1.setBounds(10, 159, 414, 49);
		contentPanel.add(scrollPane_1);
		
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