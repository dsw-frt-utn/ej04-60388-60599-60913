/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domain.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AgregarVehiculosView extends javax.swing.JFrame {
    private ListarVehiculosView listaView;
    
    
    public AgregarVehiculosView() {
        initComponents();
        cargarTiposVehiculo();
        cargarSucursales();
        actualizarCamposSegunTipo();
    }

    public AgregarVehiculosView(ListarVehiculosView listaView) {
        initComponents();
        
        this.listaView = listaView;
        
        cargarTiposVehiculo();
        cargarSucursales();
        actualizarCamposSegunTipo();
    }

    private void cargarTiposVehiculo() {
        tipocb.setModel(
            new DefaultComboBoxModel<>(new String[] { "ELECTRICO", "COMBUSTIBLE" })
        );
    }
    
    private void cargarSucursales() {
        sucursalcb.removeAllItems();

        for (Sucursal s : Controlador.getSucursales()) {
            sucursalcb.addItem(s);
        }
    }
    
    private void actualizarCamposSegunTipo() {
        String tipo = tipocb.getSelectedItem().toString();

        if (tipo.equals("ELECTRICO")) {
            lblKwhBase.setVisible(true);
            txtKwhBase.setVisible(true);
            txtKwhBase.setText("");

            lblKmLitros.setVisible(false);
            txtKmLitros.setVisible(false);
            txtKmLitros.setText("");

            lblLitrosExtras.setVisible(false);
            txtLitrosExtras.setVisible(false);
            txtLitrosExtras.setText("");

            if (txtKwhBase.getText().trim().isEmpty()) {
                txtKwhBase.setText("16");
            }

        } else {
            lblKwhBase.setVisible(false);
            txtKwhBase.setVisible(false);
            txtKwhBase.setText("");

            lblKmLitros.setVisible(true);
            txtKmLitros.setVisible(true);

            lblLitrosExtras.setVisible(true);
            txtLitrosExtras.setVisible(true);
        }

        revalidate();
        repaint();
    }
    
        private void limpiarCampos() {
        txtPatente.setText("");
        txtMarca.setText("");
        txtPais.setText("");
        txtModelo.setText("");
        txtAnio.setText("");
        txtCapacidad.setText("");
        txtKwhBase.setText("");
        txtKmLitros.setText("");
        txtLitrosExtras.setText("");

        if (tipocb.getItemCount() > 0) {
            tipocb.setSelectedIndex(0);
        }

        if (sucursalcb.getItemCount() > 0) {
            sucursalcb.setSelectedIndex(0);
        }

        actualizarCamposSegunTipo();
    }
    
    private void guardarVehiculo() {
        try {
            String tipo = tipocb.getSelectedItem().toString();
            String patente = txtPatente.getText().trim();
            String nombreMarca = txtMarca.getText().trim();
            String pais = txtPais.getText().trim();
            String modelo = txtModelo.getText().trim();

            if (patente.isEmpty() || nombreMarca.isEmpty() || pais.isEmpty() || modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos de texto.");
                return;
            }

            if (Controlador.existeVehiculo(patente)) {
                JOptionPane.showMessageDialog(this, "Ya existe un vehículo con esa patente.");
                return;
            }

            int anio = Integer.parseInt(txtAnio.getText().trim());
            double capacidad = Double.parseDouble(txtCapacidad.getText().trim());

            Sucursal sucursal = (Sucursal) sucursalcb.getSelectedItem();

            if (sucursal == null) {
                JOptionPane.showMessageDialog(this, "Seleccione una sucursal.");
                return;
            }

            Marca marca = new Marca(nombreMarca, pais);
            Vehiculo vehiculo;

            if (tipo.equals("ELECTRICO")) {
                double kwhBase = Double.parseDouble(txtKwhBase.getText().trim());

                vehiculo = new VehiculoElectrico(
                    patente,
                    marca,
                    modelo,
                    anio,
                    capacidad,
                    sucursal,
                    kwhBase
                );
            } else {
                double kmLitros = Double.parseDouble(txtKmLitros.getText().trim());
                double litrosExtras = Double.parseDouble(txtLitrosExtras.getText().trim());

                vehiculo = new VehiculoCombustible(
                    patente,
                    marca,
                    modelo,
                    anio,
                    capacidad,
                    sucursal,
                    kmLitros,
                    litrosExtras
                );
            }

            Controlador.agregarVehiculo(vehiculo);
            
            if (listaView != null) {
                listaView.refrescarTabla();
            }

            JOptionPane.showMessageDialog(this, "Vehículo agregado correctamente.");
            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Revise los campos numéricos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }
   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tipocb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPatente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sucursalcb = new javax.swing.JComboBox<>();
        lblKmLitros = new javax.swing.JLabel();
        txtKmLitros = new javax.swing.JTextField();
        lblLitrosExtras = new javax.swing.JLabel();
        txtLitrosExtras = new javax.swing.JTextField();
        agregarVehiculo = new javax.swing.JButton();
        lblKwhBase = new javax.swing.JLabel();
        txtKwhBase = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Logística - Agregar Vehículos");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel2.setText("TIPO DE VEHICULO:");

        tipocb.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        tipocb.setForeground(new java.awt.Color(255, 153, 51));
        tipocb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eléctrico", "Combustible" }));
        tipocb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipocbActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("PATENTE:");

        txtPatente.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtPatente.setForeground(new java.awt.Color(255, 153, 51));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel4.setText("MARCA:");

        txtMarca.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(255, 153, 51));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel5.setText("MODELO:");

        txtModelo.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(255, 153, 51));

        txtAnio.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtAnio.setForeground(new java.awt.Color(255, 153, 51));
        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel6.setText("AÑO:");

        txtPais.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtPais.setForeground(new java.awt.Color(255, 153, 51));
        txtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel7.setText("PAÍS:");

        txtCapacidad.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtCapacidad.setForeground(new java.awt.Color(255, 153, 51));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel8.setText("CAPACIDAD:");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel9.setText("SUCURSAL:");

        sucursalcb.setForeground(new java.awt.Color(255, 153, 51));

        lblKmLitros.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblKmLitros.setText("KM/LITROS:");

        txtKmLitros.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtKmLitros.setForeground(new java.awt.Color(255, 153, 51));

        lblLitrosExtras.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblLitrosExtras.setText("LITROS EXTRAS:");

        txtLitrosExtras.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtLitrosExtras.setForeground(new java.awt.Color(255, 153, 51));

        agregarVehiculo.setBackground(new java.awt.Color(255, 255, 153));
        agregarVehiculo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        agregarVehiculo.setForeground(new java.awt.Color(255, 102, 0));
        agregarVehiculo.setText("Agregar Vehiculo");
        agregarVehiculo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 51), 2, true));
        agregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarVehiculoActionPerformed(evt);
            }
        });

        lblKwhBase.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        lblKwhBase.setText("KWH BASE:");

        txtKwhBase.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtKwhBase.setForeground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblKmLitros)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKmLitros, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sucursalcb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblKwhBase)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKwhBase, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tipocb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPatente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMarca))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtModelo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCapacidad)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAnio))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(lblLitrosExtras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLitrosExtras))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(agregarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tipocb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPatente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(sucursalcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKwhBase)
                    .addComponent(txtKwhBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKmLitros)
                    .addComponent(txtKmLitros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLitrosExtras)
                    .addComponent(txtLitrosExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(agregarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void txtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisActionPerformed

    private void agregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarVehiculoActionPerformed
        guardarVehiculo();
    }//GEN-LAST:event_agregarVehiculoActionPerformed

    private void tipocbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipocbActionPerformed
        actualizarCamposSegunTipo();
    }//GEN-LAST:event_tipocbActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarVehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarVehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarVehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarVehiculosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarVehiculosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarVehiculo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblKmLitros;
    private javax.swing.JLabel lblKwhBase;
    private javax.swing.JLabel lblLitrosExtras;
    private javax.swing.JComboBox<Sucursal> sucursalcb;
    private javax.swing.JComboBox<String> tipocb;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtKmLitros;
    private javax.swing.JTextField txtKwhBase;
    private javax.swing.JTextField txtLitrosExtras;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPatente;
    // End of variables declaration//GEN-END:variables
}
