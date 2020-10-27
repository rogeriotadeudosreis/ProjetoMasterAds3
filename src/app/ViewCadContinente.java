/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bll.ContinenteControle;
import model.Continente;
import enumerations.EnumSituacao;
import enumerations.EnumArquivosTXT;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roger
 */
public class ViewCadContinente extends javax.swing.JDialog {

    Enum nomeDoArquivo;
    Continente continente;
    Continente continenteAnterior;
    ContinenteControle controle;
    Date data;
    SimpleDateFormat formatar;

    /**
     * Creates new form ViewCadContinente
     */
    public ViewCadContinente(java.awt.Frame parent, boolean modal) throws ParseException {
        super(parent, modal);

        try {
            initComponents();
            nomeDoArquivo = EnumArquivosTXT.CONTINENTE;
            validaArquivo();
            continente = new Continente();
            data = new Date();
            String formato = "dd/MM/yyyy HH:mm:ss";
            formatar = new SimpleDateFormat(formato);
            controle = new ContinenteControle();
            jComboBoxSituacao.removeAllItems();
            jComboBoxSituacao.addItem("< Selecione a situação deste registro >");
            for (EnumSituacao situacao : EnumSituacao.values()) {
                jComboBoxSituacao.addItem(situacao.toString());
            }
            String dataFormatada = formatar.format(data);
            jTextFieldDataCad.setText(dataFormatada);
            jTextFieldCodigo.setEnabled(false);
            jTextFieldNome.setEnabled(false);
            jTextFieldDataCad.setEnabled(false);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro na inicialização de algum componente ou objeto\n" + erro.getMessage());
        }
    }
    
    private void validaArquivo() throws Exception{
        File arquivo = new File(nomeDoArquivo + ".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                throw new IOException("Erro ao criar o arquivo.txt de continente", ex );
            }
        }
        
    }

    private void consultaContinentes(ArrayList<Continente> listaContinentes) throws Exception {
        if (listaContinentes.size() == 0) {
            JOptionPane.showMessageDialog(null, "O banco txt de continentes, está vazio\n");
        }
        
        DefaultTableModel model = (DefaultTableModel) jTableContinente.getModel();
        model.setNumRows(0);
        Collections.sort(listaContinentes);
        for (int pos = 0; pos < listaContinentes.size(); pos++) {
            String[] linha = new String[5];
            Continente aux = listaContinentes.get(pos);
            linha[0] = "" + aux.getId();
            linha[1] = formatar.format(aux.getDatacad());
            linha[2] = aux.getCodContinente() + "";
            linha[3] = aux.getNomeContinente().toUpperCase();
            linha[4] = aux.getSituacao().toString();
            model.addRow(linha);

        }
        jTextFieldQuantRegistros.setText(listaContinentes.size() + "");
    }

    //Preenchendo os campos buscando objeto pelo id
    private void preencherCampos() throws Exception {
        try {
            int linha = jTableContinente.getSelectedRow();
            if (linha >= 0) {
                continenteAnterior = new Continente();
                String campoId = jTableContinente.getValueAt(linha, 0).toString();
                Continente aux = controle.buscarPeloId(Integer.parseInt(campoId));

                continenteAnterior.setId(aux.getId());
                String campoCod = aux.getCodContinente() + "";
                String campoData = formatar.format(aux.getDatacad());
                String campoNome = aux.getNomeContinente();
                String campoSituacao = aux.getSituacao().toString();
                jTextFieldDataCad.setText(campoData);
                jTextFieldCodigo.setText(campoCod);
                jTextFieldNome.setText(campoNome);
                jComboBoxSituacao.setSelectedItem(campoSituacao);

            }

        } catch (Exception erro) {
            throw new Exception("Erro ao clicar na tabela\n" + erro.getMessage());
        }
    }

    private void habilitarCampos() {
        jTextFieldCodigo.setEnabled(true);
        jTextFieldNome.setEnabled(true);
        jTextFieldDataCad.setEnabled(true);
    }

    private void limpaCampos() {
        jTextFieldCodigo.setText("");
        jTextFieldNome.setText("");
        jTextFieldNome.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContinente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContinente = new javax.swing.JTable();
        jTextFieldQuantRegistros = new javax.swing.JTextField();
        Excluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Consultar = new javax.swing.JButton();
        ImportarContinentes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDataCad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jButtonNovoCad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("          Manutenção de Continentes");
        setResizable(false);

        jLabel2.setText("Cód.:");

        jLabel3.setText("Nome:");

        jTextFieldCodigo.setText("101");
        jTextFieldCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCodigoKeyTyped(evt);
            }
        });

        jTextFieldNome.setText("América");
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyTyped(evt);
            }
        });

        jTableContinente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Data Cad.", "Código", "Nome", "Situação:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContinente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContinenteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContinente);
        if (jTableContinente.getColumnModel().getColumnCount() > 0) {
            jTableContinente.getColumnModel().getColumn(0).setMinWidth(60);
            jTableContinente.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTableContinente.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableContinente.getColumnModel().getColumn(1).setMinWidth(140);
            jTableContinente.getColumnModel().getColumn(1).setPreferredWidth(140);
            jTableContinente.getColumnModel().getColumn(1).setMaxWidth(140);
            jTableContinente.getColumnModel().getColumn(2).setMinWidth(60);
            jTableContinente.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableContinente.getColumnModel().getColumn(2).setMaxWidth(60);
            jTableContinente.getColumnModel().getColumn(4).setMinWidth(80);
            jTableContinente.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jTextFieldQuantRegistros.setEditable(false);

        Excluir.setText("Excluir");
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        ImportarContinentes.setText("Importar");

        jLabel4.setText("Registros.");

        jLabel5.setText("Data do Cadastro: ");

        jLabel6.setText("Situação:");

        jComboBoxSituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< Selecione a situação desse registro >" }));

        jButtonNovoCad.setText("Novo");
        jButtonNovoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoCadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContinenteLayout = new javax.swing.GroupLayout(jPanelContinente);
        jPanelContinente.setLayout(jPanelContinenteLayout);
        jPanelContinenteLayout.setHorizontalGroup(
            jPanelContinenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContinenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContinenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContinenteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContinenteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNovoCad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImportarContinentes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Consultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar))
                    .addGroup(jPanelContinenteLayout.createSequentialGroup()
                        .addComponent(jTextFieldQuantRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelContinenteLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome)))
                .addContainerGap())
        );
        jPanelContinenteLayout.setVerticalGroup(
            jPanelContinenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContinenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelContinenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContinenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDataCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelContinenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(Editar)
                    .addComponent(Excluir)
                    .addComponent(Consultar)
                    .addComponent(ImportarContinentes)
                    .addComponent(jButtonNovoCad))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelContinenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldQuantRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelContinente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelContinente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            int codigo = Integer.parseInt(jTextFieldCodigo.getText());
            String nome = jTextFieldNome.getText();
            EnumSituacao situacao = EnumSituacao.valueOf(jComboBoxSituacao.getSelectedItem().toString());
            continente.setDatacad(formatar.parse(jTextFieldDataCad.getText()));
            continente.setCodContinente(codigo);
            continente.setNomeContinente(nome);
            continente.setSituacao(situacao);

            if (jButtonSalvar.getLabel().equals("Salvar")) {
                controle.incluir(continente);
                consultaContinentes(controle.recuperar());

            } else {
                continente.setId(continenteAnterior.getId());
                controle.alterar(continente);
                consultaContinentes(controle.recuperar());
                jButtonSalvar.setText("Salvar");

                System.out.println(continente);

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        try {
            consultaContinentes(controle.recuperar());

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_ConsultarActionPerformed

    private void jTableContinenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContinenteMouseClicked
        try {
            preencherCampos();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }//GEN-LAST:event_jTableContinenteMouseClicked

    private void jButtonNovoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoCadActionPerformed
        habilitarCampos();
        limpaCampos();
        jButtonSalvar.setText("Salvar");
    }//GEN-LAST:event_jButtonNovoCadActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        jButtonSalvar.setText("Alterar");
        habilitarCampos();
        jTextFieldCodigo.requestFocus();
    }//GEN-LAST:event_EditarActionPerformed

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        try {
            continente.setNomeContinente(jTextFieldNome.getText());
            controle.excluir(continente);
            consultaContinentes(controle.recuperar());

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void jTextFieldCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodigoKeyTyped
       char valida = evt.getKeyChar();
        if (Character.isLetter(valida)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Informe apenas número !");
        }
    }//GEN-LAST:event_jTextFieldCodigoKeyTyped

    private void jTextFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyTyped
        char valida = evt.getKeyChar();
        if (Character.isDigit(valida)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Informe apenas letras !");
        }
    }//GEN-LAST:event_jTextFieldNomeKeyTyped

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
            java.util.logging.Logger.getLogger(ViewCadContinente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadContinente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadContinente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadContinente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewCadContinente dialog = new ViewCadContinente(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ViewCadContinente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Excluir;
    private javax.swing.JButton ImportarContinentes;
    private javax.swing.JButton jButtonNovoCad;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelContinente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContinente;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDataCad;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldQuantRegistros;
    // End of variables declaration//GEN-END:variables
}
