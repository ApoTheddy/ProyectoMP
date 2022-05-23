package screens;

import utilClass.LoginController;

public class frmLoginScreen extends javax.swing.JFrame {

    private final LoginController login = new LoginController();

    public frmLoginScreen() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jtxtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtnIngresar = new javax.swing.JButton();
        jtxtPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jesus\\Desktop\\Java\\ProyectoMP\\src\\main\\java\\assets\\login_image.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 590));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 625));

        jtxtEmail.setFont(new java.awt.Font("Victor Mono SemiBold", 1, 12)); // NOI18N
        jtxtEmail.setForeground(new java.awt.Color(0, 0, 0));
        jtxtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel10.add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 243, 67));

        jLabel1.setFont(new java.awt.Font("Luckiest Guy", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("BIENVENIDO");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jbtnIngresar.setBackground(new java.awt.Color(0, 0, 153));
        jbtnIngresar.setFont(new java.awt.Font("Victor Mono Medium", 1, 14)); // NOI18N
        jbtnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnIngresar.setText("Ingresar");
        jbtnIngresar.setBorder(null);
        jbtnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIngresarActionPerformed(evt);
            }
        });
        jPanel10.add(jbtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 175, 32));

        jtxtPassword.setFont(new java.awt.Font("Victor Mono SemiBold", 1, 12)); // NOI18N
        jtxtPassword.setForeground(new java.awt.Color(0, 0, 0));
        jtxtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel10.add(jtxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 243, 67));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 390, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIngresarActionPerformed
        String email = jtxtEmail.getText(), password = jtxtPassword.getText();
        if (login.singIn(email, password))
            this.dispose();
    }//GEN-LAST:event_jbtnIngresarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new frmLoginScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbtnIngresar;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtPassword;
    // End of variables declaration//GEN-END:variables
}
