package br.com.app.forms;

import br.com.app.Util.FabricaConexao;
import br.com.app.dao.ClienteDao;
import br.com.app.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class frmCliente extends javax.swing.JInternalFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    ClienteDao dao;
    Cliente cliente;
    private Integer idCli;
    public List<Cliente> lista;

    public frmCliente() {
        initComponents();
        dao = new ClienteDao();
        cliente = new Cliente();
        con = FabricaConexao.getConexao();
        idCli = 0;
    }

    private void cadastraCliente() {
        try {

            cliente.setNome(txtNome.getText());
            cliente.setEndereco(txtEnd.getText());
            cliente.setEmail(txtEmail.getText());
            dao.addCliente(cliente);
            JOptionPane.showMessageDialog(rootPane, "cliente " + cliente.getNome() + " cadastrado com sucesso!!");
            limpaCampos();
            pesquisarCliente();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Nao foi possivel cadastrar consulte o administrador" + e.getMessage());
        }
    }

    public void pesquisarCliente() {
        con = FabricaConexao.getConexao();
        String sql = "select * from  cliente where nome like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, txtBuscar.getText() + "%");
            rs = ps.executeQuery();
            tbCliente.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void setarCampos() {

        int setar = tbCliente.getSelectedRow();
        txtCod.setText(tbCliente.getModel().getValueAt(setar, 0).toString());
        txtEmail.setText(tbCliente.getModel().getValueAt(setar, 1).toString());
        txtEnd.setText(tbCliente.getModel().getValueAt(setar, 2).toString());
        txtNome.setText(tbCliente.getModel().getValueAt(setar, 3).toString());
        btnsalvar.setEnabled(false);

    }

    public void removeCliente(Integer idCli) {
        try {

            idCli = Integer.parseInt(txtCod.getText());
            if (idCli > 0) {
                dao.deleteCliente(idCli);
                int ok = JOptionPane.showConfirmDialog(this, "Deseja excluir o cliente " + cliente.getNome(), " Excluir", JOptionPane.YES_NO_OPTION);
                if (ok == JOptionPane.YES_OPTION) {
                    JOptionPane.showInternalMessageDialog(this, "Usuario " + cliente.getNome() + " deletado com sucesso!!");
                    limpaCampos();
                } else {
                    return;
                }

            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    private void alteraCliente() {
        try {
            cliente.setId(Integer.parseInt(txtCod.getText()));
            cliente.setEmail(txtEmail.getText());
            cliente.setNome(txtNome.getText());
            cliente.setEndereco(txtEnd.getText());
            dao.atualizaCliente(cliente);
            JOptionPane.showMessageDialog(rootPane, "Cliente atualizao com sucesso!!!");
            limpaCampos();
            btnsalvar.setEnabled(true);
            pesquisarCliente();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Nao foi possivel atualizar consulte o administrador" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEnd = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnsalvar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btndeletar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(480, 743));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/Elegantes_0038_Search.png"))); // NOI18N

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("E-mail:");

        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/Botoes_5110_user_add_48.png"))); // NOI18N
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/Botoespencil_48.png"))); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btndeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/1475339082_list-remove-user.png"))); // NOI18N
        btndeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletarActionPerformed(evt);
            }
        });

        jLabel5.setText("Código:");

        txtCod.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsalvar)
                                .addGap(30, 30, 30)
                                .addComponent(btnAtualizar)
                                .addGap(28, 28, 28)
                                .addComponent(btndeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(237, Short.MAX_VALUE))
        );

        setBounds(0, 0, 745, 743);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        cadastraCliente();
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        pesquisarCliente();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
        setarCampos();
    }//GEN-LAST:event_tbClienteMouseClicked

    private void btndeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletarActionPerformed
        removeCliente(idCli);
    }//GEN-LAST:event_btndeletarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       alteraCliente();
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btndeletar;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnd;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    private void limpaCampos() {
        txtCod.setText(null);
        txtNome.setText(null);
        txtEmail.setText(null);
        txtEnd.setText(null);
    }
}
