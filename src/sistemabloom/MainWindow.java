package sistemabloom;

import javax.swing.*;
import java.io.*;
import java.util.List;
import sistemabloom.Item;
import sistemabloom.ItemLoader;


public class MainWindow extends javax.swing.JFrame {
    private List<Item> listaItems;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainWindow.class.getName());

    public MainWindow() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCantidadItems = new javax.swing.JLabel();
        lblTiempoTotal = new javax.swing.JLabel();
        btnCargarArchivo = new javax.swing.JToggleButton();
        btnIniciarPrueba = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCantidadItems.setText("Cantidad de ítems: -");

        lblTiempoTotal.setText("Tiempo estimado: -");

        btnCargarArchivo.setText("Cargar archivo");
        btnCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarArchivoActionPerformed(evt);
            }
        });

        btnIniciarPrueba.setText("Iniciar prueba");
        btnIniciarPrueba.setEnabled(false);
        btnIniciarPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPruebaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTiempoTotal)
                    .addComponent(lblCantidadItems))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciarPrueba)
                    .addComponent(btnCargarArchivo))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadItems)
                    .addComponent(btnCargarArchivo))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarPrueba)
                    .addComponent(lblTiempoTotal))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnIniciarPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPruebaActionPerformed
    String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
    String rut = JOptionPane.showInputDialog(this, "Ingrese su RUT:");
    String fecha = JOptionPane.showInputDialog(this, "Ingrese la fecha (dd-mm-yyyy):");
        if (nombre != null && !nombre.isBlank() &&
            rut != null && !rut.isBlank() &&
            fecha != null && !fecha.isBlank()) {
            TestWindow ventanaPrueba = new TestWindow(listaItems, nombre.trim(), rut.trim(), fecha.trim());
            ventanaPrueba.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Debe ingresar todos los datos para continuar.");
    }//GEN-LAST:event_btnIniciarPruebaActionPerformed
 }
    private void btnCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarArchivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            try {
                listaItems = ItemLoader.cargarDesdeArchivo(archivo.getAbsolutePath());
                int cantidad = listaItems.size();
                int tiempoTotal = listaItems.stream().mapToInt(Item::getTiempoEstimado).sum();

                lblCantidadItems.setText("Cantidad de ítems: " + cantidad);
                lblTiempoTotal.setText("Tiempo estimado: " + tiempoTotal + " segundos");
                btnIniciarPrueba.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cargar archivo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCargarArchivoActionPerformed

    public static void main(String args[]) {
  
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> new MainWindow().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCargarArchivo;
    private javax.swing.JToggleButton btnIniciarPrueba;
    private javax.swing.JLabel lblCantidadItems;
    private javax.swing.JLabel lblTiempoTotal;
    // End of variables declaration//GEN-END:variables
}
