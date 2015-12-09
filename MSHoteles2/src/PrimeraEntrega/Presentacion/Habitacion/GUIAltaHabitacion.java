/**
 * 
 */
package PrimeraEntrega.Presentacion.Habitacion;

import javax.swing.JOptionPane;

import PrimeraEntrega.Negocio.Transfer.TransferHabitacion;
import PrimeraEntrega.Presentacion.Vista;
import PrimeraEntrega.Presentacion.Controlador.Evento;
import PrimeraEntrega.Presentacion.Controlador.Implementacion.ControladorImp;
import PrimeraEntrega.Presentacion.Dispatcher.EventoVista;


public class GUIAltaHabitacion extends javax.swing.JFrame implements Vista {
	
	static private GUIAltaHabitacion altaHabitacion;

	  /** Creates new form nueva Habitacion */
	  private GUIAltaHabitacion() {
	      initComponents();
	  }
	  
	  /**
	   * Obtiene la instancia de la ventana
	   * @return la instancia de la ventana
	   */
	  static public GUIAltaHabitacion obtenerInstancia(){
		   if(altaHabitacion == null){
			   altaHabitacion = new GUIAltaHabitacion();
		   }
		   
		   return altaHabitacion;
	  }

                        
    private void initComponents() {

        jLabelPiso = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jFormattedTextFieldNumero = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTipo = new javax.swing.JFormattedTextField();
        jButtonAceptar = new javax.swing.JButton();
        jFormattedTextFieldPiso = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFormattedTextFieldNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextFieldPiso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
				new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jLabelPiso.setText("Piso");

        jLabelNumero.setText("Numero");

        jLabelTipo.setText("Tipo");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonAceptarActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPiso)
                            .addComponent(jLabelTipo)
                            .addComponent(jLabelNumero))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButtonAceptar)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPiso))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonAceptar))
        );
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        		//Borra lo anterior
                jFormattedTextFieldNumero.setText("");
                jFormattedTextFieldPiso.setText("");
                jFormattedTextFieldTipo.setText("");
            
            }
        });
        pack();
    }// </editor-fold>                        

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {  
   	 
    	TransferHabitacion transferHabitacion = new TransferHabitacion();
  	 
  	   
  	   transferHabitacion.setPiso(Integer.valueOf(jFormattedTextFieldPiso.getText()));
  	   transferHabitacion.setNumero(Integer.valueOf(jFormattedTextFieldNumero.getText()));
  	   transferHabitacion.setTipo(jFormattedTextFieldTipo.getText());  
  	   
         ControladorImp.getInstancia().execute(Evento.ALTA_HABITACION, transferHabitacion);
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
            java.util.logging.Logger.getLogger(GUIAltaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAltaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAltaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAltaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAltaHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumero;
    private javax.swing.JFormattedTextField jFormattedTextFieldPiso;
    private javax.swing.JFormattedTextField jFormattedTextFieldTipo;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPiso;
    private javax.swing.JLabel jLabelTipo;
    // End of variables declaration
    @Override
	public void actualizar(int id_evento_vista, Object datos) {
		//Borra lo anterior
    	
    	 jFormattedTextFieldPiso.setText("");
         jFormattedTextFieldNumero.setText("");
         jFormattedTextFieldTipo.setText("");
         
		
		if(id_evento_vista == EventoVista.ALTA_HABITACION_EXITO){
			JOptionPane.showMessageDialog(null, "Se ha creado la Habitacion con exito", "Nuevo Habitacion", JOptionPane.INFORMATION_MESSAGE);		
		}	
	
		else if (id_evento_vista == EventoVista.ALTA_HABITACION_FALLO){
			JOptionPane.showMessageDialog(null, "ERROR!! Ha ocurrido un error con la BD", "Nuevo Habitacion", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
