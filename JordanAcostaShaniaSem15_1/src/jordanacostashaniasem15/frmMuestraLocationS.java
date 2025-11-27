package jordanacostashaniasem15;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmMuestraLocationS extends javax.swing.JFrame {

    public frmMuestraLocationS() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigoBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEncontrado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código Locations a Buscar:");

        txtCodigoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblEncontrado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Location", "Direccion Calle", "Codigo Postal", "Ciudad", "Provincia", "Codigo Country"
            }
        ));
        jScrollPane1.setViewportView(tblEncontrado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String codBuscar;
        
        //ESTABLECIENDO LA CONEXIÓN
        Connection cn = null;
        SQLException e = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            
            cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","oracle");
            
        } catch (SQLException ex) {
            e = ex;
            JOptionPane.showMessageDialog(null,"Error de Conexión "+ e.toString()); 
        }
        
        //BUSCANDO DATOS EN LA TABLA LOCATIONS
        
        try{
            codBuscar = txtCodigoBuscar.getText();
            
            DefaultTableModel dtBuscar = new DefaultTableModel();
            tblEncontrado.setModel(dtBuscar);
            
            dtBuscar.addColumn("Codigo Location");
            dtBuscar.addColumn("Direccion Calle");
            dtBuscar.addColumn("Codigo Postal");
            dtBuscar.addColumn("Ciudad");
            dtBuscar.addColumn("Provincia");
            dtBuscar.addColumn("Codigo Country");
            
            String query = "SELECT * FROM Locations WHERE LOCATION_ID = '"+codBuscar+"'";
            PreparedStatement pstm = cn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            
            boolean found = false;
            while (rs.next()) {
                found = true;
                dtBuscar.addRow(new Object[]{
                    rs.getString("LOCATION_ID"),
                    rs.getString("STREET_ADDRESS"),
                    rs.getString("POSTAL_CODE"),
                    rs.getString("CITY"),
                    rs.getString("STATE_PROVINCE"),
                    rs.getString("COUNTRY_ID")
                });
            }
            rs.close();
            pstm.close();
            
            if (!found) {
            // Si no se encontró ninguna fila mostramos el mensaje aquí
            JOptionPane.showMessageDialog(null, "No existe LOCATION con ese ID", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
            
        } catch(SQLException ex) {
            e = ex;
            JOptionPane.showMessageDialog(null, "No existe LOCATION", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        
        try{
            cn.close();
            JOptionPane.showMessageDialog(null, "Error de cierre" + e.toString());
        } catch (SQLException ex) {
            Logger.getLogger(frmMuestraLocationS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmMuestraLocationS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMuestraLocationS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMuestraLocationS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMuestraLocationS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMuestraLocationS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEncontrado;
    private javax.swing.JTextField txtCodigoBuscar;
    // End of variables declaration//GEN-END:variables
}
