/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Controller;
import Modelo.Empleados;
import Modelo.Pacientes;
import Modelo.Visitas;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author NotebookSFC
 */
public class frmAlta extends javax.swing.JFrame {

    /**
     * Creates new form frmAlta
     */
    public frmAlta() {
        initComponents();
        Controller gestor = new Controller();
        ArrayList recepcionista = gestor.obtenerEmpleado();
        ArrayList paciente = gestor.obtenerPacientes();
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (Object object : recepcionista) 
        {
            modelo.addElement(object);
        }
        cborecepcionista.setModel(modelo);
        
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
        for (Object object : paciente) 
        {
            modelo2.addElement(object);
        }
        cbopaciente.setModel(modelo2);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnregistrar = new javax.swing.JButton();
        btnlistado = new javax.swing.JButton();
        btnreportes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtduracion = new javax.swing.JTextField();
        cbopaciente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cborecepcionista = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 51));
        setName("ALTA"); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 500));
        setSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        btnlistado.setText("Listado");
        btnlistado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnlistado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        btnreportes.setText("Reportes");
        btnreportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreportesActionPerformed(evt);
            }
        });
        getContentPane().add(btnreportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        jLabel3.setText("Alta de Visitas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel7.setText("Legajo Recepcionista: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel8.setText("Paciente: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel9.setText("Duracion: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 150, -1));
        getContentPane().add(txtduracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 150, -1));

        getContentPane().add(cbopaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 150, -1));

        jLabel10.setFont(new java.awt.Font("Candara", 0, 12)); // NOI18N
        jLabel10.setText("Nombre:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        getContentPane().add(cborecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnreportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreportesActionPerformed
        frmReporte reporte = new frmReporte();
        reporte.setVisible(true);
    }//GEN-LAST:event_btnreportesActionPerformed

    private void btnlistadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistadoActionPerformed
        frmListado listado = new frmListado();
        listado.setVisible(true);
    }//GEN-LAST:event_btnlistadoActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
            Pacientes paciente = (Pacientes)cbopaciente.getSelectedItem();
            Empleados empleado = (Empleados)cborecepcionista.getSelectedItem();
            String nombre = txtnombre.getText();
            int duracion = Integer.parseInt(txtduracion.getText());

            Visitas v = new Visitas(0, empleado, paciente, nombre, duracion);
            Controller gestor = new Controller();
            gestor.agregarVisita(v);

        
            JOptionPane.showMessageDialog(null, "Registro exitoso!");
    }//GEN-LAST:event_btnregistrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAlta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlistado;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnreportes;
    private javax.swing.JComboBox<String> cbopaciente;
    private javax.swing.JComboBox<String> cborecepcionista;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtduracion;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
