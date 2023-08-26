
package Interfaz;
import org.jpl7.Query;

public class interfaz extends javax.swing.JFrame {

    public interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        label_diagnostico = new javax.swing.JLabel();
        btn_enviar = new javax.swing.JToggleButton();
        label_pregunta = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(132, 37, 220));
        jLabel1.setText("Sistema Experto - Monitoreo de la violencia y acoso escolar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 1240, 50));

        label_diagnostico.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_diagnostico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_diagnostico, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 304, 29));

        btn_enviar.setBackground(new java.awt.Color(0, 0, 0));
        btn_enviar.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        btn_enviar.setForeground(new java.awt.Color(255, 255, 255));
        btn_enviar.setText("Iniciar Test");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 560, 160));

        label_pregunta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label_pregunta.setForeground(new java.awt.Color(255, 0, 0));
        label_pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 304, 29));

        btn_salir.setBackground(new java.awt.Color(0, 0, 0));
        btn_salir.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setText("Salir");
        btn_salir.setBorder(new javax.swing.border.MatteBorder(null));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 640, 70));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 1140, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pngwing.com (5).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, -60, 800, 1200));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Este programa sirve para identificar el abuso en los niños de las instituciones educativas, atraves de su comportamiento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 990, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sugerencia: Responda con la verdad las preguntas del Test");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 560, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        // TODO add your handling code here:
        String conexion = "consult('Test_Actor.pl')";
        Query objConsulta = new Query (conexion);
        
        if (objConsulta.hasSolution()){
            System.out.println(conexion + "" + (objConsulta.hasMoreSolutions() ? "ACEPTADO" : "FALLADO"));
            String predicado = "start.";
            Query a = new Query(predicado);
            String diagnostico = a.oneSolution().get("Paciente")+", usted probablementen tenga "+a.oneSolution().get("Enfermedad");
            label_diagnostico.setText(diagnostico);
            /*String rpta = txt_respuesta.getText();
            String pregunta = label_pregunta.getText();*/
            
        }
    }//GEN-LAST:event_btn_enviarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_enviar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_diagnostico;
    private javax.swing.JLabel label_pregunta;
    // End of variables declaration//GEN-END:variables
}
