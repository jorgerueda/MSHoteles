/**
 * 
 */
package PrimeraEntrega.Presentacion.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Negocio.Transfer.TransferClienteStandar;
import PrimeraEntrega.Negocio.Transfer.TransferClienteVip;
import PrimeraEntrega.Negocio.Transfer.TransferReserva;
import PrimeraEntrega.Presentacion.Controlador.Evento;
import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

public class GUIMostrarReserva extends javax.swing.JFrame {

	static private GUIMostrarReserva mostrarReserva;

	/** Creates new form NuevaReserva */
	private GUIMostrarReserva() {
		initComponents();
	}

	static public GUIMostrarReserva obtenerInstancia() {
		if (mostrarReserva == null) {
			mostrarReserva = new GUIMostrarReserva();
		}

		return mostrarReserva;
	}

	private void initComponents() {

		jLabelPrecio = new javax.swing.JLabel();
		jLabelFechaEntrada = new javax.swing.JLabel();
		jLabelFechaSalida = new javax.swing.JLabel();
		jFormattedTextFieldFechaEntrada = new javax.swing.JFormattedTextField();
		jFormattedTextFieldFechaSalida = new javax.swing.JFormattedTextField();
		jLabelDNICliente = new javax.swing.JLabel();
		jFormattedTextFieldDNICliente = new javax.swing.JFormattedTextField();
		jLabelNumHabitacion = new javax.swing.JLabel();
		jLabelNumHabitacion.setVisible(false);
		jFormattedTextFieldNumHabitacion = new javax.swing.JFormattedTextField();
		jFormattedTextFieldNumHabitacion.setVisible(false);
		jFormattedTextFieldPrecio = new javax.swing.JFormattedTextField();
		jLabelNumOcupantes = new javax.swing.JLabel();
		jFormattedTextFieldNumOcupantes = new javax.swing.JFormattedTextField();
		jButtonAceptar = new javax.swing.JButton();
		jLabelIDReserva = new javax.swing.JLabel();
		jFormattedTextFieldIDReserva = new javax.swing.JFormattedTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaNumHabitacion = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabelPrecio.setText("Precio");

		jLabelFechaEntrada.setText("Fecha de Entrada");

		jLabelFechaSalida.setText("Fecha Salida");

		jFormattedTextFieldFechaEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
		jFormattedTextFieldFechaEntrada.setText("dd/mm/aaaa");
		jFormattedTextFieldFechaEntrada.setToolTipText("");

		jFormattedTextFieldFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(""))));
		jFormattedTextFieldFechaSalida.setText("dd/mm/aaaa");
		jFormattedTextFieldFechaSalida.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextFieldFechaSalidaActionPerformed(evt);
			}
		});

		jLabelDNICliente.setText("ID cliente");

		jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAceptarActionPerformed(evt);
			}
		});

		jLabelNumHabitacion.setText("num Habitacion");

		jLabelNumOcupantes.setText("num Ocupante");

		jButtonAceptar.setText("Aceptar");

		jLabelIDReserva.setText("ID Reserva");

		jTextAreaNumHabitacion.setColumns(20);
		jTextAreaNumHabitacion.setRows(5);
		jScrollPane1.setViewportView(jTextAreaNumHabitacion);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabelDNICliente).addComponent(jLabelPrecio))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jFormattedTextFieldPrecio,
																javax.swing.GroupLayout.PREFERRED_SIZE, 107,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jFormattedTextFieldDNICliente,
																javax.swing.GroupLayout.PREFERRED_SIZE, 183,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup().addComponent(jLabelFechaEntrada)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jFormattedTextFieldFechaEntrada,
														javax.swing.GroupLayout.PREFERRED_SIZE, 123,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabelNumOcupantes)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jFormattedTextFieldNumOcupantes,
																javax.swing.GroupLayout.PREFERRED_SIZE, 81,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabelNumHabitacion).addGap(18, 18, 18)
														.addComponent(jFormattedTextFieldNumHabitacion,
																javax.swing.GroupLayout.PREFERRED_SIZE, 81,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup().addComponent(jLabelFechaSalida)
												.addGap(41, 41, 41).addComponent(jFormattedTextFieldFechaSalida,
														javax.swing.GroupLayout.PREFERRED_SIZE, 122,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addGroup(layout.createSequentialGroup().addComponent(jLabelIDReserva)
										.addGap(18, 18, 18).addComponent(jFormattedTextFieldIDReserva,
												javax.swing.GroupLayout.PREFERRED_SIZE, 135,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGap(6, 6, 6)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButtonAceptar).addGap(84, 84, 84)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelIDReserva).addComponent(jFormattedTextFieldIDReserva,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelFechaEntrada).addComponent(jLabelFechaSalida)
								.addComponent(jFormattedTextFieldFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jFormattedTextFieldFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup().addGap(35, 35, 35)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelPrecio)
										.addComponent(jFormattedTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelNumOcupantes))
								.addGap(17, 17, 17))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jFormattedTextFieldNumOcupantes,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelDNICliente)
								.addComponent(jFormattedTextFieldDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelNumHabitacion).addComponent(jFormattedTextFieldNumHabitacion,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButtonAceptar).addGap(20, 20, 20)))));
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// Borra lo anterior
				jFormattedTextFieldDNICliente.setText("");
				jFormattedTextFieldFechaEntrada.setText("dd/mm/aaaa");
				jFormattedTextFieldFechaSalida.setText("dd/mm/aaaa");
				jFormattedTextFieldNumHabitacion.setText("");
				jFormattedTextFieldNumOcupantes.setText("");
				jFormattedTextFieldPrecio.setText("");
				jTextAreaNumHabitacion.setText("");

			}
		});
		pack();
	}// </editor-fold>

	private void jFormattedTextFieldFechaSalidaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {

		ControladorImp.getInstancia().execute(Evento.MOSTRAR_RESERVA,
				Integer.valueOf(jFormattedTextFieldIDReserva.getText()));
		// TODO add your handling code here:
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUIMostrarReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUIMostrarReserva().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButtonAceptar;
	private javax.swing.JFormattedTextField jFormattedTextFieldDNICliente;
	private javax.swing.JFormattedTextField jFormattedTextFieldFechaEntrada;
	private javax.swing.JFormattedTextField jFormattedTextFieldFechaSalida;
	private javax.swing.JFormattedTextField jFormattedTextFieldNumHabitacion;
	private javax.swing.JFormattedTextField jFormattedTextFieldNumOcupantes;
	private javax.swing.JFormattedTextField jFormattedTextFieldPrecio;
	private javax.swing.JFormattedTextField jFormattedTextFieldIDReserva;
	private javax.swing.JLabel jLabelDNICliente;
	private javax.swing.JLabel jLabelFechaEntrada;
	private javax.swing.JLabel jLabelFechaSalida;
	private javax.swing.JLabel jLabelNumHabitacion;
	private javax.swing.JLabel jLabelNumOcupantes;
	private javax.swing.JLabel jLabelPrecio;
	private javax.swing.JLabel jLabelIDReserva;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextAreaNumHabitacion;

	// End of variables declaration

	public void actualizar(int id_evento_vista, Object datos) {
		// Borra lo anterior

		jFormattedTextFieldDNICliente.setText("");
		jFormattedTextFieldFechaEntrada.setText("dd/mm/aaaa");
		jFormattedTextFieldFechaSalida.setText("dd/mm/aaaa");
		jFormattedTextFieldNumHabitacion.setText("");
		jFormattedTextFieldNumOcupantes.setText("");
		jFormattedTextFieldPrecio.setText("");
		jTextAreaNumHabitacion.setText("");

		if (id_evento_vista == EventoVista.MOSTRAR_RESERVA_EXITO) {
			TransferReserva t = (TransferReserva) datos;

			jFormattedTextFieldDNICliente.setText(String.valueOf(t.getIdCliente()));
			jFormattedTextFieldFechaEntrada.setText(String.valueOf(t.getFechaEntrada()));
			jFormattedTextFieldFechaSalida.setText(String.valueOf(t.getFechaSalida()));
			jFormattedTextFieldNumHabitacion.setText(String.valueOf(t.getNumHabitacion()));
			jFormattedTextFieldNumOcupantes.setText(String.valueOf(t.getNumOcupantes()));
			jFormattedTextFieldPrecio.setText(String.valueOf(t.getPrecio()));


			jTextAreaNumHabitacion.append(" ID Habitaciones \n\n");

			for (int i : t.getId_Habitaciones()) {
				jTextAreaNumHabitacion.append(" " + String.valueOf(i).toString() + "\n");
			}

		} else if (id_evento_vista == EventoVista.MOSTRAR_RESERVA_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR!! No se ha encontrado la reserva que se desea mostrar",
					"Mostrar Cliente", JOptionPane.ERROR_MESSAGE);
		}

	}

}
