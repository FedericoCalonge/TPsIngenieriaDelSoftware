package TPFinal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class VentanaOficinaTecnica extends JDialog {
//En Oficina tecnica se puede asignar los pedidos que estan en estado "Oficina_Tecnica" a una de las 6 maquinas de corte.
	private JTable tabla;
	private final JPanel contentPanel = new JPanel();
	private int claveDeFilaClickeada = 0;	
	private JTextArea comentario;
	
	public static void main(String[] args) {
		try { VentanaOficinaTecnica dialog = new VentanaOficinaTecnica();
			  dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			  dialog.setVisible(true);
		} catch (Exception e) {
			System.out.println("Error Exception en VentanaOficinaTecnica - main:"+e.getMessage());
		  }
	}

	/* Dialog: */
	public VentanaOficinaTecnica() throws SQLException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 414, 94);
		contentPanel.add(scrollPane);
		//Para que me muestre el modelo en el ScrollPane
		tabla = new JTable();
		DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica");
		tabla.setModel(datos);
		scrollPane.setViewportView(tabla);
		
		JLabel lblPedidos = new JLabel("Lista de Pedidos");
		lblPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedidos.setBounds(101, 0, 211, 23);
		contentPanel.add(lblPedidos);
		
		//Esto sirve para que reconozca que estamos clickeando la tabla que
		//se muestra en la ventana. Tuve que importar las clases MouseListener y Mouse adapter
		tabla.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent e) {
		         int fila = tabla.rowAtPoint(e.getPoint()); //Me devuelve la fila.
		         int columna = tabla.columnAtPoint(e.getPoint()); //Me devuelve la columna.
		         if ((fila > -1) && (columna > -1))//Si estoy fuera de estos valores, estoy fuera de la tabla.
		        	 claveDeFilaClickeada = (int)tabla.getValueAt(fila,0); //Obtengo la clave.
			      try { comentario.setText(Consultas.mostrarComentarios(claveDeFilaClickeada));
				  } catch (SQLException e1) {
					  System.out.println("Error SQLException en VentanaOficinaTecnica - tabla.addMouseListener:"+e1.getMessage());
				    }
		      }
		   });
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultas.modificarMaquinaCortePedido(claveDeFilaClickeada, "1 Kaliburn");
					DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica"); //Acá actualizo mi vista con la maquina seteada arriba.
					tabla.setModel(datos);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaOficinaTecnica - boton 1:"+e1.getMessage());
				}
			}
		});
		button.setBounds(81, 158, 49, 23);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultas.modificarMaquinaCortePedido(claveDeFilaClickeada, "2 Kaliburn");
					DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica");
					tabla.setModel(datos);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaOficinaTecnica - boton 2:"+e1.getMessage());
				}
			}
		});
		button_1.setBounds(129, 158, 49, 23);
		contentPanel.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultas.modificarMaquinaCortePedido(claveDeFilaClickeada, "3 Kaliburn");
					DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica");
					tabla.setModel(datos);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaOficinaTecnica - boton 3:"+e1.getMessage());
				}
			}
		});
		button_2.setBounds(174, 158, 49, 23);
		contentPanel.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultas.modificarMaquinaCortePedido(claveDeFilaClickeada, "4 Kaliburn");
					DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica");
					tabla.setModel(datos);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaOficinaTecnica - boton 4:"+e1.getMessage());
				}
			}
		});
		button_3.setBounds(212, 158, 49, 23);
		contentPanel.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultas.modificarMaquinaCortePedido(claveDeFilaClickeada, "5 Kalberg");
					DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica");
					tabla.setModel(datos);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaOficinaTecnica - boton 5:"+e1.getMessage());
				}
			}
		});
		button_4.setBounds(257, 158, 55, 23);
		contentPanel.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Consultas.modificarMaquinaCortePedido(claveDeFilaClickeada, "6 Kalberg");
					DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica");
					tabla.setModel(datos);
				} catch (SQLException e1) {
					System.out.println("Error SQLException en VentanaOficinaTecnica - boton 6:"+e1.getMessage());
				}
			}
		});
		button_5.setBounds(305, 158, 51, 23);
		contentPanel.add(button_5);
		
		JLabel lblAsignarAMaquina = new JLabel("Asignar a maquina de corte...");
		lblAsignarAMaquina.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignarAMaquina.setBounds(101, 127, 211, 31);
		contentPanel.add(lblAsignarAMaquina);
		
		comentario = new JTextArea();
		JScrollPane scrollPane_1 = new JScrollPane(comentario);
		scrollPane_1.setBounds(10, 181, 414, 59);
		contentPanel.add(scrollPane_1);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnPasarAProduccion = new JButton("Pasar a Produccion");
			btnPasarAProduccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Consultas.modificarEstadoPedido(claveDeFilaClickeada, "En_Produccion");
						Consultas.modificarComentario(claveDeFilaClickeada, comentario.getText());
						DefaultTableModel datos = ModeloPedido.mostrarModelo("En_Oficina_Tecnica"); //Acá actualizo mi vista con los que estan en Oficina_Tecnica (los que pase a Producción no estan mas).
						tabla.setModel(datos);
					} catch (SQLException e1) {
						System.out.println("Error SQLException en VentanaOficinaTecnica - Pasar a Produccion:"+e1.getMessage());
					  }
				}
			});
			
			buttonPane.add(btnPasarAProduccion);
			{   JButton cancelButton = new JButton("Atras");
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
