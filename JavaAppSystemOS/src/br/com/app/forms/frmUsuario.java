package br.com.app.forms;

import br.com.app.dao.UsuarioDao;
import br.com.app.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class frmUsuario extends javax.swing.JInternalFrame {

    String nome;
    UsuarioDao dao;
    EntityManager em;
    Usuario usuario;

    public frmUsuario() {
        initComponents();
        dao = new UsuarioDao();
        usuario = new Usuario();
    }

    private void CadastraUsuario() {
        try {
           
            usuario.setNomeUsuario(txtNome.getText());
            usuario.setLogin(txtlogin.getText());
            usuario.setSenha(txtSenha.getText());
            usuario.setPerfil(cbbPerfil.getSelectedItem().toString());
            if (usuario.getId() == null) {
                dao.AddUsuario(usuario);
                JOptionPane.showMessageDialog(this, "Usuario Cadastrado com sucesso!");
                limpaCampos();
            } else {
           
                JOptionPane.showMessageDialog(this, "Nao foi possivel adicionar!!!");
                limpaCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro " + e.getMessage());
        }
    }

    private Usuario BuscaPorNome(String nome) {
        try {
            nome = txtNome.getText();
            dao = new UsuarioDao();
            usuario = dao.BuscarPorNome(nome);
            if (usuario != null) {

                txtSenha.setText(usuario.getSenha());
                txtlogin.setText(usuario.getLogin());
                cbbPerfil.setSelectedItem(usuario.getPerfil());
            } else {
                JOptionPane.showMessageDialog(this, "Usuario " + usuario.getNomeUsuario()+  "  nao encontrado ,tente nome completo!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return usuario;
    }
    private void limpaCampos(){
        txtid.setText("");
        txtNome.setText(null);
        txtSenha.setText(null);
        txtlogin.setText(null);
        txtid.setText(null);
        cbbPerfil.setSelectedIndex(0);
    }

    private void deletarUsuario(Usuario usuario){
        try {
            if(txtid.getText()!=null){
                dao.deletar(usuario);
               int ok = JOptionPane.showConfirmDialog(this,"Deseja excluir o usuario" + usuario.getNomeUsuario(), "Excluir", JOptionPane.YES_NO_OPTION);
                if(ok == JOptionPane.YES_OPTION){
                    JOptionPane.showInternalMessageDialog(this,"Usuario " + usuario.getNomeUsuario() + "deletado com sucesso!!");
                    limpaCampos();
                }else{
                    return;
                }
                    
            }
        } catch (Exception e) {
            
        }
        
    }
    private void updateUsuario(Usuario usuario){
        try {
               if(usuario.getId()!=null){
               usuario.setSenha(txtSenha.getText());
               usuario.setNomeUsuario(txtNome.getText());
               usuario.setLogin(txtlogin.getText());
               usuario.setPerfil(cbbPerfil.getSelectedItem().toString());
           
                dao.atualiza(usuario);
                JOptionPane.showInternalMessageDialog(this, "Usuario "  + usuario.getNomeUsuario()  +   "atualizado com sucesso!!");
                limpaCampos();
            }else{
                return;
            }
            
            
        } catch (Exception e) {
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtlogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        cbbPerfil = new javax.swing.JComboBox<>();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btndeletar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tela de Cadastro");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(480, 743));

        jLabel1.setText("Codigio");

        jLabel2.setText("Nome");

        jLabel3.setText("Login");

        jLabel4.setText("Senha");

        jLabel5.setText("Perfil");

        cbbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/1475311531_list-add-user.png"))); // NOI18N
        btnNovo.setToolTipText("Novo");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/1475311513_edit.png"))); // NOI18N
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/Elegantes_0038_Search.png"))); // NOI18N
        btnbuscar.setToolTipText("Buscar");
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btndeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/1475339082_list-remove-user.png"))); // NOI18N
        btndeletar.setToolTipText("Remover");
        btndeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btndeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addComponent(txtSenha)))))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btndeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(305, 305, 305))
        );

        setBounds(0, 0, 746, 742);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        BuscaPorNome(nome);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        CadastraUsuario();

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btndeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletarActionPerformed
        deletarUsuario(usuario);
    }//GEN-LAST:event_btndeletarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        updateUsuario(usuario);
    }//GEN-LAST:event_btnAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btndeletar;
    private javax.swing.JComboBox<String> cbbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlogin;
    // End of variables declaration//GEN-END:variables
}
