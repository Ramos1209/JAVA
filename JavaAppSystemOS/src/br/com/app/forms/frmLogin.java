package br.com.app.forms;

import br.com.app.Util.EntityManagerUtil;
import br.com.app.dao.UsuarioDao;
import br.com.app.modelo.Usuario;
import javax.persistence.EntityManager;

import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class frmLogin extends javax.swing.JFrame {

    UsuarioDao dao;
    EntityManager em;
    Usuario user;
    public frmLogin() {
        initComponents();
        em = EntityManagerUtil.getEntityManagerFactory();
        if (em != null) {
            lblstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/databaseOk.png")));
        } else {
            lblstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/database_close.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtsenha = new javax.swing.JPasswordField();
        lblstatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ramos system");

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLogin)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuario)
                                    .addComponent(txtsenha, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblstatus)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblstatus)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(406, 346));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //Metodo para verificar o login//
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        String login = txtUsuario.getText();
        String senha = txtsenha.getText();
        dao = new UsuarioDao();
        user = new Usuario();
        Usuario user = dao.autenticarUsuario(login, senha);
        String perfil = user.getPerfil();
        if (user != null) {
            FrmPrincipal frm = new FrmPrincipal();
            frm.setVisible(true);
             if(perfil.equals("admin")){
            FrmPrincipal.munuRelatorios.setEnabled(true);
            FrmPrincipal.menUsuario.setEnabled(true);
            FrmPrincipal.lblUsuario.setText(user.getNomeUsuario());
         
             this.dispose();
             
             }else{
             FrmPrincipal.lblUsuario.setText(user.getNomeUsuario());
              frm.setVisible(true);
              this.dispose();         
             }
          
           

        } else {
           
            JOptionPane.showMessageDialog(this, "Usuario ou senha invalidos!!!");
        }


    }//GEN-LAST:event_btnLoginActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
}
