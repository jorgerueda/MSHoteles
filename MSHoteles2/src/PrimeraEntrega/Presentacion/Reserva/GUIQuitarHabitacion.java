/**
 * 
 */
package PrimeraEntrega.Presentacion.Reserva;

import javax.swing.JOptionPane;

import PrimeraEntrega.Negocio.Transfer.TransferReserva;
import PrimeraEntrega.Presentacion.Controlador.Evento;
import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

public class GUIQuitarHabitacion extends javax.swing.JFrame {

	/**
	 * Creates new form GUIQuitarHabitacion
	 */
	static private GUIQuitarHabitacion quitarHabitacion;

	/** Creates new form NuevaReserva */
	private GUIQuitarHabitacion() {
		initComponents();
	}

	/**
	 * Obtiene la instancia de la ventana
	 * 
	 * @return la instancia de la ventana
	 */
	static public GUIQuitarHabitacion obtenerInstancia() {
		if (quitarHabitacion == null) {
			quitarHabitacion = new GUIQuitarHabitacion();
		}

		return quitarHabitacion;
	}

	private void initComponents() {

		jLabelIDReserva = new javax.swing.JLabel();
		jLabelNumHabitacion = new javax.swing.JLabel();
		jFormattedTextFieldIDReserva = new javax.swing.JFormattedTextField();
		jFormattedTextFieldnumHabitacion = new javax.swing.JFormattedTextField();
		jButtonAceptar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabelIDReserva.setText("id Reserva");

		jLabelNumHabitacion.setText("num Habitacion");

		jFormattedTextFieldIDReserva.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jFormattedTextFieldIDReservaActionPerformed(evt);
			}
		});

		jButtonAceptar.setText("Quitar");
		jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAceptarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabelNumHabitacion).addComponent(jLabelIDReserva))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jFormattedTextFieldIDReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 71,
								Short.MAX_VALUE)
						.addComponent(jFormattedTextFieldnumHabitacion)).addGap(43, 43, 43))
				.addGroup(layout.createSequentialGroup().addGap(74, 74, 74).addComponent(jButtonAceptar)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(21, 21, 21)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelIDReserva).addComponent(jFormattedTextFieldIDReserva,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabelNumHabitacion).addComponent(jFormattedTextFieldnumHabitacion,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
				.addComponent(jButtonAceptar)));
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// Borra lo anterior
				jFormattedTextFieldIDReserva.setText("");
				jFormattedTextFieldnumHabitacion.setText("");

			}
		});

		pack();
	}// </editor-fold>

	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {

		TransferReserva transferReserva = new TransferReserva();
		transferReserva.setNumHabitacion(Integer.valueOf(jFormattedTextFieldnumHabitacion.getText()));
		transferReserva.setID_Reserva(Integer.valueOf(jFormattedTextFieldIDReserva.getText()));

		ControladorImp.getInstancia().execute(Evento.QUITAR_HABITACION, transferReserva);
		// TODO add your handling code here:
	}

	private void jFormattedTextFieldIDReservaActionPerformed(java.awt.event.ActionEvent evt) {
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
			java.util.logging.Logger.getLogger(GUIQuitarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUIQuitarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUIQuitarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUIQuitarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUIQuitarHabitacion().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButtonAceptar;
	private javax.swing.JFormattedTextField jFormattedTextFieldIDReserva;
	private javax.swing.JFormattedTextField jFormattedTextFieldnumHabitacion;
	private javax.swing.JLabel jLabelIDReserva;
	private javax.swing.JLabel jLabelNumHabitacion;

	// End of variables declaration
	public void actualizar(int id_evento_vista, Object datos) {
		// Borra lo anterior
		jFormattedTextFieldIDReserva.setText("");
		jFormattedTextFieldnumHabitacion.setText("");

		if (id_evento_vista == EventoVista.QUITAR_HABITACION_EXITO) {
			JOptionPane.showMessageDialog(null, "Se ha anadido la habitacion con exito", "Anadir Habitacion",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (id_evento_vista == EventoVista.QUITAR_HABITACION_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR!! Ha ocurrido un error con la BD", "Anadir Habitacion",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}