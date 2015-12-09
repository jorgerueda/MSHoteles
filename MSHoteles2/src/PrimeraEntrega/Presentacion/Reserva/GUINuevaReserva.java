/**
 * 
 */
package PrimeraEntrega.Presentacion.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import PrimeraEntrega.Negocio.Transfer.TransferReserva;
import PrimeraEntrega.Presentacion.Controlador.Evento;
import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

public class GUINuevaReserva extends javax.swing.JFrame {

	static private GUINuevaReserva nuevaReserva;

	/** Creates new form NuevaReserva */
	private GUINuevaReserva() {
		initComponents();
	}

	/**
	 * Obtiene la instancia de la ventana
	 * 
	 * @return la instancia de la ventana
	 */
	static public GUINuevaReserva obtenerInstancia() {
		if (nuevaReserva == null) {
			nuevaReserva = new GUINuevaReserva();
		}

		return nuevaReserva;
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

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		
		jFormattedTextFieldNumOcupantes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
		jLabelPrecio.setText("Precio");

		jLabelFechaEntrada.setText("Fecha de Entrada");

		jLabelFechaSalida.setText("Fecha Salida");

		jFormattedTextFieldFechaEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
		jFormattedTextFieldFechaEntrada.setText("dd/mm/aaaa");
		jFormattedTextFieldFechaEntrada.setToolTipText("");

		jFormattedTextFieldFechaSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
		jFormattedTextFieldFechaSalida.setText("dd/mm/aaaa");
		jFormattedTextFieldFechaSalida.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextFieldFechaSalidaActionPerformed(evt);
			}
		});

		jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAceptarActionPerformed(evt);
			}
		});
		jLabelDNICliente.setText("DNI cliente");

		jLabelNumHabitacion.setText("num Habitacion");

		jLabelNumOcupantes.setText("num Ocupante");

		jButtonAceptar.setText("Aceptar");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelDNICliente).addComponent(jLabelPrecio))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabelNumOcupantes)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jFormattedTextFieldNumOcupantes,
														javax.swing.GroupLayout.PREFERRED_SIZE, 81,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addComponent(jLabelNumHabitacion)
												.addGap(18, 18, 18).addComponent(jFormattedTextFieldNumHabitacion,
														javax.swing.GroupLayout.PREFERRED_SIZE, 81,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addComponent(jLabelFechaSalida)
										.addGap(41, 41, 41).addComponent(jFormattedTextFieldFechaSalida,
												javax.swing.GroupLayout.PREFERRED_SIZE, 122,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGroup(layout.createSequentialGroup().addGap(212, 212, 212).addComponent(jButtonAceptar)))
				.addContainerGap(20, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(68, 68, 68)
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
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabelNumOcupantes))
						.addGap(17, 17, 17))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jFormattedTextFieldNumOcupantes, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabelDNICliente)
						.addComponent(jFormattedTextFieldDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabelNumHabitacion).addComponent(jFormattedTextFieldNumHabitacion,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
				.addComponent(jButtonAceptar).addGap(27, 27, 27)));
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

			}
		});
		pack();
	}// </editor-fold>

	private void jFormattedTextFieldFechaSalidaActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {
		if(jFormattedTextFieldDNICliente.getText().isEmpty()&&jFormattedTextFieldNumOcupantes.getText().isEmpty()&&jFormattedTextFieldPrecio.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "ERROR!! Rellene todos los campos", "Nuevo Reserva",
					JOptionPane.ERROR_MESSAGE);
		}else{
		
		TransferReserva transferReserva = new TransferReserva();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		transferReserva.setDniCliente(jFormattedTextFieldDNICliente.getText());
		transferReserva.setNumOcupantes(Integer.valueOf(jFormattedTextFieldNumOcupantes.getText()));

		try {
			transferReserva.setFechaEntrada(
					new java.sql.Date(formatter.parse(jFormattedTextFieldFechaEntrada.getText()).getTime()));
			transferReserva.setFechaSalida(
					new java.sql.Date(formatter.parse(jFormattedTextFieldFechaSalida.getText()).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		transferReserva.setPrecio(Integer.valueOf(jFormattedTextFieldPrecio.getText()));

		ControladorImp.getInstancia().execute(Evento.ALTA_RESERVA, transferReserva);
		}
		// TODO add your handling code here:
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUINuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUINuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUINuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUINuevaReserva.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUINuevaReserva().setVisible(true);
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
	private javax.swing.JLabel jLabelDNICliente;
	private javax.swing.JLabel jLabelFechaEntrada;
	private javax.swing.JLabel jLabelFechaSalida;
	private javax.swing.JLabel jLabelNumHabitacion;
	private javax.swing.JLabel jLabelNumOcupantes;
	private javax.swing.JLabel jLabelPrecio;
	// End of variables declaration

	public void actualizar(int id_evento_vista, Object datos) {
		// Borra lo anterior

		jFormattedTextFieldDNICliente.setText("");
		jFormattedTextFieldFechaEntrada.setText("dd/mm/aaaa");
		jFormattedTextFieldFechaSalida.setText("dd/mm/aaaa");
		jFormattedTextFieldNumHabitacion.setText("");
		jFormattedTextFieldNumOcupantes.setText("");
		jFormattedTextFieldPrecio.setText("");

		if (id_evento_vista == EventoVista.ALTA_RESERVA_EXITO) {
			JOptionPane.showMessageDialog(null, "Se ha creado la reserva con exito", "Nueva Reserva",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (id_evento_vista == EventoVista.ALTA_RESERVA_CLIENTE_NO_EXISTE) {
			JOptionPane.showMessageDialog(null, "ERROR!! El Cliente introducido no existe", "Nuevo REserva",
					JOptionPane.ERROR_MESSAGE);
		} else if (id_evento_vista == EventoVista.ALTA_RESERVA_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR!! Ha ocurrido un error con la BD", "Nuevo Reserva",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
