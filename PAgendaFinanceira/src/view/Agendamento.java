/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AgendamentoDAO;
import dao.PessoaAgendamentoDAO;
import entity.Agenda;
import entity.DataHora;
import entity.Pessoa;
import entity.Servico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel1
 */
public class Agendamento extends javax.swing.JDialog {

    /**
     * Creates new form Agendamento
     */
    public Agendamento(java.awt.Frame parent, boolean modal, DataHora a) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.dtHora = a;
        lblData.setText(sdfD.format(dtHora.getData()));
        lblHorario.setText(sdfH.format(dtHora.getHorario()));
        lblDia.setText(dtHora.getDia());

    }
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
    DataHora dtHora;
    PessoaAgendamentoDAO pADAO = new PessoaAgendamentoDAO();
    AgendamentoDAO aDAO = new AgendamentoDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDescricao = new javax.swing.JTextArea();
        btnFinanceiro = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOrcamento = new javax.swing.JTextField();
        btnPesquisaOrcamento = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamento");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 330, -1));

        txtaDescricao.setColumns(20);
        txtaDescricao.setRows(5);
        txtaDescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 153)), "Descrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(0, 51, 153))); // NOI18N
        jScrollPane1.setViewportView(txtaDescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 128, 493, -1));

        btnFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cifrão.png"))); // NOI18N
        btnFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceiroActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinanceiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Modify.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        jPanel1.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 253, -1, -1));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 253, -1, -1));

        jLabel2.setText("Data:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lblData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 0, 0));
        lblData.setText("Data");
        jPanel1.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel4.setText("Horário:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        lblHorario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHorario.setForeground(new java.awt.Color(255, 0, 0));
        lblHorario.setText("Horário");
        jPanel1.add(lblHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel6.setText("Orçamento:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 70, -1, -1));

        txtOrcamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        jPanel1.add(txtOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 85, -1));

        btnPesquisaOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        jPanel1.add(btnPesquisaOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Apply.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 253, -1, -1));

        jLabel5.setText("Dia:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        lblDia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDia.setForeground(new java.awt.Color(255, 0, 0));
        lblDia.setText("dia");
        jPanel1.add(lblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiroActionPerformed
        Financeiro f = new Financeiro(null, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_btnFinanceiroActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Pessoa p = new Pessoa();
        Agenda a = new Agenda();
        p.setNome(txtNome.getText());
        a.setDescricao(txtaDescricao.getText());
        a.setDia(lblDia.getText());
        try {
            a.setData(sdfD.parse(lblData.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            a.setHora(sdfH.parse(lblHorario.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        pADAO.insert(p);
        a.setIdPessoa(p.getIdPessoa());
        aDAO.insert(a);

    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agendamento dialog = new Agendamento(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinanceiro;
    private javax.swing.JButton btnPesquisaOrcamento;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtOrcamento;
    private javax.swing.JTextArea txtaDescricao;
    // End of variables declaration//GEN-END:variables
}
