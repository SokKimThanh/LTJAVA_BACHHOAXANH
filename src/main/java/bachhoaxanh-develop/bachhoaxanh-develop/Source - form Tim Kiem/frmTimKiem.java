/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Imac
 */
public class frmTimKiem extends javax.swing.JFrame {

    /**
     * Creates new form frmTimKiem
     */
    public frmTimKiem() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmDangNhap = new javax.swing.JFrame();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lblThongTin = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbbMenu = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        lblHangKhuyenMai = new javax.swing.JLabel();
        lblTopSeller = new javax.swing.JLabel();

        frmDangNhap.setResizable(false);
        frmDangNhap.setSize(new java.awt.Dimension(400, 400));

        btnDangNhap.setText("Đăng nhập");

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmDangNhapLayout = new javax.swing.GroupLayout(frmDangNhap.getContentPane());
        frmDangNhap.getContentPane().setLayout(frmDangNhapLayout);
        frmDangNhapLayout.setHorizontalGroup(
            frmDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmDangNhapLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(frmDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        frmDangNhapLayout.setVerticalGroup(
            frmDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmDangNhapLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btnDangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnThoat)
                .addGap(63, 63, 63))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);
        setSize(new java.awt.Dimension(1247, 738));

        lblThongTin.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        lblThongTin.setText("Thông tin cá nhân");
        lblThongTin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThongTin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongTinMouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jButton2.setText("Đăng ký");

        jButton3.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jButton3.setText("Đăng nhập");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbbMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thịt, cá, trứng", "Rau, củ, quả, nấm" }));

        txtTimKiem.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        lblHangKhuyenMai.setFont(new java.awt.Font("Calibri", 2, 20)); // NOI18N
        lblHangKhuyenMai.setForeground(new java.awt.Color(51, 153, 255));
        lblHangKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHangKhuyenMai.setText("Hàng khuyến mãi");
        lblHangKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHangKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHangKhuyenMaiMouseClicked(evt);
            }
        });

        lblTopSeller.setFont(new java.awt.Font("Calibri", 2, 20)); // NOI18N
        lblTopSeller.setForeground(new java.awt.Color(51, 153, 255));
        lblTopSeller.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopSeller.setText("Top Seller");
        lblTopSeller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTopSeller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTopSellerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblThongTin)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHangKhuyenMai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTopSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addComponent(lblThongTin)
                .addGap(95, 95, 95)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHangKhuyenMai)
                    .addComponent(lblTopSeller))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblThongTinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinMouseClicked
        frmThongTin thongTin = new frmThongTin();
        thongTin.setVisible(true);
        thongTin.requestFocus();
    }//GEN-LAST:event_lblThongTinMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        frmDangNhap.setVisible(true);
        frmDangNhap.requestFocus();
        frmDangNhap.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        frmDangNhap.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void lblHangKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHangKhuyenMaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHangKhuyenMaiMouseClicked

    private void lblTopSellerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTopSellerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTopSellerMouseClicked

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
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTimKiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTimKiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbbMenu;
    private javax.swing.JFrame frmDangNhap;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel lblHangKhuyenMai;
    private javax.swing.JLabel lblThongTin;
    private javax.swing.JLabel lblTopSeller;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
