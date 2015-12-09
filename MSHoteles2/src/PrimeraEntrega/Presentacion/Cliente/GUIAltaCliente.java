package PrimeraEntrega.Presentacion.Cliente;

import javax.swing.JOptionPane;

import PrimeraEntrega.Negocio.Transfer.TransferCliente;
import PrimeraEntrega.Negocio.Transfer.TransferClienteStandar;
import PrimeraEntrega.Negocio.Transfer.TransferClienteVip;
import PrimeraEntrega.Presentacion.Vista;
import PrimeraEntrega.Presentacion.Controlador.Evento;
import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;

public class GUIAltaCliente extends javax.swing.JFrame implements Vista {

	/**
	 * Creates new form GUIAltaCliente
	 */
	static private GUIAltaCliente altaCliente;

	/** Creates new form NuevoDepartamento */
	private GUIAltaCliente() {
		initComponents();
	}


	static public GUIAltaCliente obtenerInstancia() {
		if (altaCliente == null) {
			altaCliente = new GUIAltaCliente();
		}

		return altaCliente;
	}


	
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabelNombre = new javax.swing.JLabel();
		jLabelApellidos = new javax.swing.JLabel();
		jRadioButtonTipo = new javax.swing.JRadioButton();
		jLabelDNI = new javax.swing.JLabel();
		jLabelDescuento = new javax.swing.JLabel();
		jLabelPuntos = new javax.swing.JLabel();
		jFormattedTextFieldNombre = new javax.swing.JFormattedTextField();
		jFormattedTextFieldApellidos = new javax.swing.JFormattedTextField();
		jFormattedTextFieldDNI = new javax.swing.JFormattedTextField();
		jFormattedTextFieldPuntos = new javax.swing.JFormattedTextField();
		jFormattedTextFieldDescuento = new javax.swing.JFormattedTextField();
		jButtonAceptar = new javax.swing.JButton();
		jButtonCancelar = new javax.swing.JButton();
		jButtonCancelar.setVisible(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabelNombre.setText("Nombre");

		jLabelApellidos.setText("Apellidos");

		jRadioButtonTipo.setText("VIP");
		jRadioButtonTipo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonTipoActionPerformed(evt);
			}
		});
		
		jFormattedTextFieldPuntos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
		jFormattedTextFieldDescuento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
		jFormattedTextFieldDescuento.setEnabled(false);
		jLabelDNI.setText("DNI");

		jLabelDescuento.setText("Descuento");

		jLabelPuntos.setText("Puntos");

		jButtonAceptar.setText("Aceptar");
		jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAceptarActionPerformed(evt);
			}
		});

		jButtonCancelar.setText("Cancelar");
		jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCancelarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(jRadioButtonTipo))
						.addGroup(layout.createSequentialGroup().addGap(22, 22, 22)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabelDescuento)
												.addGap(18, 18, 18)
												.addComponent(jFormattedTextFieldDescuento,
														javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabelPuntos))
								.addGroup(layout.createSequentialGroup().addComponent(jButtonAceptar)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86,
												Short.MAX_VALUE)
										.addComponent(jButtonCancelar))
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabelNombre)
												.addGap(29, 29, 29).addComponent(jFormattedTextFieldNombre,
														javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
										.addGroup(
												layout.createSequentialGroup()
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabelApellidos).addComponent(jLabelDNI))
														.addGap(20, 20,
																20)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jFormattedTextFieldDNI,
																javax.swing.GroupLayout.DEFAULT_SIZE, 169,
																Short.MAX_VALUE)
														.addComponent(jFormattedTextFieldApellidos))))
										.addGap(0, 0, Short.MAX_VALUE)))))
				.addGap(18, 18, 18).addComponent(jFormattedTextFieldPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(39, 39, 39)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(jRadioButtonTipo)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelNombre).addComponent(jFormattedTextFieldNombre,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabelApellidos).addComponent(jFormattedTextFieldApellidos,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabelDNI)
						.addComponent(jFormattedTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jLabelDescuento).addComponent(jLabelPuntos)
						.addComponent(jFormattedTextFieldPuntos, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jFormattedTextFieldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jButtonAceptar).addComponent(jButtonCancelar)).addGap(16, 16, 16)));
		// Borra el los datos correspondiente al cerrar la ventana
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// Borra lo anterior
				jFormattedTextFieldDNI.setText("");
				jFormattedTextFieldDescuento.setText("");
				jFormattedTextFieldNombre.setText("");
				jFormattedTextFieldPuntos.setText("");
				jFormattedTextFieldApellidos.setText("");

			}
		});
		pack();
	}// </editor-fold>

	private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {

		TransferCliente transferCliente;

		if (jRadioButtonTipo.isSelected()) {
			transferCliente = new TransferClienteVip();

			((TransferClienteVip) transferCliente)
					.setDescuento(Integer.valueOf(jFormattedTextFieldDescuento.getText()));
		} else {
			transferCliente = new TransferClienteStandar();

			((TransferClienteStandar) transferCliente)
					.setPuntosAcumulados(Integer.valueOf(jFormattedTextFieldPuntos.getText()));
		}

		transferCliente.setDni(jFormattedTextFieldDNI.getText());
		transferCliente.setNombre(jFormattedTextFieldNombre.getText());
		transferCliente.setApellidos(jFormattedTextFieldApellidos.getText());

		ControladorImp.getInstancia().execute(Evento.ALTA_CLIENTE, transferCliente);
		// TODO add your handling code here:
	}

	private void jRadioButtonTipoActionPerformed(java.awt.event.ActionEvent evt) {
		jFormattedTextFieldDescuento.setText("");
		jFormattedTextFieldPuntos.setText("");
		if (jRadioButtonTipo.isSelected()) {
			// email
			jFormattedTextFieldDescuento.setEnabled(true);
			jFormattedTextFieldPuntos.setEnabled(false);

		} else {
			// email
			jFormattedTextFieldDescuento.setEnabled(false);
			jFormattedTextFieldPuntos.setEnabled(true);

		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUIAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUIAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUIAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUIAltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUIAltaCliente().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButtonAceptar;
	private javax.swing.JButton jButtonCancelar;
	private javax.swing.JFormattedTextField jFormattedTextFieldApellidos;
	private javax.swing.JFormattedTextField jFormattedTextFieldDNI;
	private javax.swing.JFormattedTextField jFormattedTextFieldDescuento;
	private javax.swing.JFormattedTextField jFormattedTextFieldNombre;
	private javax.swing.JFormattedTextField jFormattedTextFieldPuntos;
	private javax.swing.JLabel jLabelApellidos;
	private javax.swing.JLabel jLabelDNI;
	private javax.swing.JLabel jLabelDescuento;
	private javax.swing.JLabel jLabelNombre;
	private javax.swing.JLabel jLabelPuntos;
	private javax.swing.JRadioButton jRadioButtonTipo;

	// End of variables declaration
	@Override
	public void actualizar(int id_evento_vista, Object datos) {
		// Borra lo anterior

		jFormattedTextFieldDNI.setText("");
		jFormattedTextFieldDescuento.setText("");
		jFormattedTextFieldNombre.setText("");
		jFormattedTextFieldPuntos.setText("");
		jFormattedTextFieldApellidos.setText("");

		if (id_evento_vista == EventoVista.ALTA_CLIENTE_EXITO) {
			JOptionPane.showMessageDialog(null, "Se ha creado el cliente con exito", "Nuevo Cliente",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (id_evento_vista == EventoVista.ALTA_CLIENTE_DNI_YA_EXISTE) {
			JOptionPane.showMessageDialog(null, "ERROR!! El DNI introducido ya existe", "Nuevo Cliente",
					JOptionPane.ERROR_MESSAGE);
		} else if (id_evento_vista == EventoVista.ALTA_CLIENTE_FALLO) {
			JOptionPane.showMessageDialog(null, "ERROR!! Ha ocurrido un error con la BD", "Nuevo Cliente",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
