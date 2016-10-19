package br.com.app.forms;

import br.com.app.Util.FabricaConexao;
import br.com.app.dao.OsDao;
import br.com.app.modelo.Cliente;
import br.com.app.modelo.OS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author paulo
 */
public class FrmOS extends javax.swing.JInternalFrame {
Connection con;
ResultSet rs;
PreparedStatement ps;
private String tipo;
OsDao dao;
 OS os ;
    public FrmOS() {
        initComponents();
        con = FabricaConexao.getConexao();
        dao= new OsDao();
        os = new OS();
        
    }
  private void pesquisacliente(){
      
      String sql = "select id ,nome ,email from cliente where nome like ?";
      try {
          ps = con.prepareStatement(sql);
          ps.setString(1, txtbuscaCliente.getText() + "%");
          rs= ps.executeQuery();
          tbCliente.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception e) {
          JOptionPane.showInternalMessageDialog(rootPane,"Erro de conexao " +e.getMessage());
        
      }
  }
  private void setarValor(){
      int setar = tbCliente.getSelectedRow();
      txtidCliente.setText(tbCliente.getModel().getValueAt(setar,0).toString());
  }
  private void adicionaOs(){
     try{
      Cliente c = new Cliente();
     
      c.setId(Integer.parseInt(txtidCliente.getText()));
      os.setCliente(c);
      os.setDefeito(txtDefeito.getText());
      os.setEquipamento(txtEquip.getText());
      os.setTipo(tipo);
      os.setSituacao(cboSituacao.getSelectedItem().toString());
      os.setTecnico(txttec.getText());
      Date data = new Date();
      os.setOs(data);
      os.setServico(txtservico.getText());
      os.setValor(Double.parseDouble(txtvalor.getText()));
      dao.salvarOs(os);
      JOptionPane.showInternalMessageDialog(rootPane, "O.S Emitida com sucesso!");
      limpaCampos();
      
     }catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
     }
      
      
  }
  
  private void limpaCampos(){
      txtDefeito.setText(null);
      txtEquip.setText(null);
      txtbuscaCliente.setText(null);
      txtservico.setText(null);
      txttec.setText(null);
      txtvalor.setText(null);
      txtidCliente.setText(null);
      txtData.setText(null);
      txtIdOs.setText(null);
      radioOrcamento.setSelected(true);
      cboSituacao.setSelectedIndex(0);
              
  }
  private OS pesquisarOS(){
      
      String num = JOptionPane.showInputDialog("Digite o numero da OS");
      try{
        
      os =  dao.pesquisarOS(Integer.parseInt(num));
      txtIdOs.setText(os.getId().toString());
      txtData.setText(os.getOs().toString());
      txtDefeito.setText(os.getDefeito());
      txtEquip.setText(os.getEquipamento());
      txtidCliente.setText(os.getCliente().getId().toString());
      txtservico.setText(os.getServico());
      txttec.setText(os.getTecnico());
      txtvalor.setText(os.getValor().toString());
      radioOrcamento.setText(tipo);
      cboSituacao.setSelectedItem(os.getSituacao());
      btnAddOs.setEnabled(false);
      txtbuscaCliente.setEnabled(false);
      tbCliente.setVisible(false);
      return os;
      }catch(Exception e){
          e.getMessage();
          return null;
      }
      
  }
  private void atualizaOS(){
      try {
          os.setDefeito(txtDefeito.getText());
          os.setEquipamento(txtEquip.getText());
          os.setServico(txtservico.getText());
          os.setTecnico(txttec.getText());
          os.setTipo(tipo);
          os.setValor(Double.parseDouble(txtvalor.getText()));
          os.setSituacao(cboSituacao.getSelectedItem().toString());
          btnAddOs.setEnabled(true);
          txtbuscaCliente.setEnabled(true);
          tbCliente.setVisible(true);
          dao.alteraOs(os);
          JOptionPane.showMessageDialog(rootPane, "OS atualizada com sucesso!!");
          limpaCampos();
          
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
  }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdOs = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        radioOrcamento = new javax.swing.JRadioButton();
        radioOS = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        cboSituacao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtbuscaCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtidCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEquip = new javax.swing.JTextField();
        txtDefeito = new javax.swing.JTextField();
        txtservico = new javax.swing.JTextField();
        txttec = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        btnAddOs = new javax.swing.JButton();
        btnpesquisarOs = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnAltera = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("OS");
        setPreferredSize(new java.awt.Dimension(480, 743));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nº O.S");

        jLabel2.setText("Data");

        txtIdOs.setEnabled(false);

        txtData.setEnabled(false);

        buttonGroup1.add(radioOrcamento);
        radioOrcamento.setText("Orçamento");
        radioOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOrcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioOS);
        radioOS.setText("Ordem de Serviço");
        radioOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioOrcamento)
                        .addGap(18, 18, 18)
                        .addComponent(radioOS)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtIdOs, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioOrcamento)
                    .addComponent(radioOS))
                .addGap(18, 18, 18))
        );

        jLabel3.setText("Situação");

        cboSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aprovado", "Abandonado", "Aguardando peça", "Bancada", "Orçamento Reprovado" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txtbuscaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscaClienteKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/1475Search.png"))); // NOI18N

        jLabel5.setText("*id");

        txtidCliente.setEnabled(false);

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCliente);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtbuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Equipamento");

        jLabel7.setText("Serviço");

        jLabel8.setText("Tecnico");

        jLabel9.setText("Defeito");

        jLabel10.setText("Valor");

        btnAddOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/1475311531_list-add-user.png"))); // NOI18N
        btnAddOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOsActionPerformed(evt);
            }
        });

        btnpesquisarOs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/Elegantes_0038_Search.png"))); // NOI18N
        btnpesquisarOs.setToolTipText("Pesquisar OS");
        btnpesquisarOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarOsActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/1475339082_list-remove-user.png"))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/Print.png"))); // NOI18N

        btnAltera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/app/icones/Botoespencil_48.png"))); // NOI18N
        btnAltera.setToolTipText("Atualiza");
        btnAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddOs, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnpesquisarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEquip)
                    .addComponent(txtDefeito)
                    .addComponent(txtservico)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txttec, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtvalor, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cboSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtservico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txttec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddOs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnpesquisarOs, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        setBounds(0, 0, 748, 739);
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscaClienteKeyReleased
       pesquisacliente();
    }//GEN-LAST:event_txtbuscaClienteKeyReleased

    private void tbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteMouseClicked
       setarValor();
    }//GEN-LAST:event_tbClienteMouseClicked

    private void radioOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOrcamentoActionPerformed
       tipo = "Orçamento";
    }//GEN-LAST:event_radioOrcamentoActionPerformed

    private void radioOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOSActionPerformed
      tipo ="OS";
    }//GEN-LAST:event_radioOSActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
       radioOrcamento.setSelected(true);
       tipo ="Orçamento";
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnAddOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOsActionPerformed
      adicionaOs();
    }//GEN-LAST:event_btnAddOsActionPerformed

    private void btnpesquisarOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarOsActionPerformed
        pesquisarOS();
    }//GEN-LAST:event_btnpesquisarOsActionPerformed

    private void btnAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraActionPerformed
        atualizaOS();
    }//GEN-LAST:event_btnAlteraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOs;
    private javax.swing.JButton btnAltera;
    private javax.swing.JButton btnpesquisarOs;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboSituacao;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioOS;
    private javax.swing.JRadioButton radioOrcamento;
    private javax.swing.JTable tbCliente;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDefeito;
    private javax.swing.JTextField txtEquip;
    private javax.swing.JTextField txtIdOs;
    private javax.swing.JTextField txtbuscaCliente;
    private javax.swing.JTextField txtidCliente;
    private javax.swing.JTextField txtservico;
    private javax.swing.JTextField txttec;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
