/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.EnderecoDAO;
import dao.agendamentoDAO;
import entity.Agenda;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Homologação
 */
public class TelaPesquisaAgendamento extends javax.swing.JDialog {

    /**
     * Creates new form TelaPesquisaAgendamento
     */
    public TelaPesquisaAgendamento(java.awt.Frame parent, boolean modal, String nome, boolean antigas) {
        super(parent, modal);
        initComponents();
        this.name = nome;
        setLocationRelativeTo(null);
        setResizable(false);
        this.teste = antigas;
        tabelaAgendamento(nome);
    }
    String name;
    agendamentoDAO aDAO = new agendamentoDAO();
    boolean teste;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgendamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Horário Agendado - Agenda Financeira");

        tblAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Data", "Horário", "Dia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAgendamento);
        if (tblAgendamento.getColumnModel().getColumnCount() > 0) {
            tblAgendamento.getColumnModel().getColumn(0).setResizable(false);
            tblAgendamento.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblAgendamento.getColumnModel().getColumn(1).setResizable(false);
            tblAgendamento.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblAgendamento.getColumnModel().getColumn(2).setResizable(false);
            tblAgendamento.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblAgendamento.getColumnModel().getColumn(3).setResizable(false);
            tblAgendamento.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");

    public void tabelaAgendamento(String nome) {
        EnderecoDAO eDAO = new EnderecoDAO();
        DefaultTableModel model = (DefaultTableModel) this.tblAgendamento.getModel();

        if (teste) {
            List<Agenda> listaAntiga = aDAO.listarAgendamentosPessoaRealizadas(nome);
            for (int i = 0; i < listaAntiga.size(); i++) {
                model.setValueAt(listaAntiga.get(i).getPessoa().getNome(), i, 0);
                model.setValueAt(sdfD.format(listaAntiga.get(i).getData()), i, 1);
                model.setValueAt(listaAntiga.get(i).getHora(), i, 2);
                model.setValueAt(listaAntiga.get(i).getDia(), i, 3);
            }
        } else {
            List<Agenda> lista = aDAO.listarAgendamentosPessoa(nome);
            for (int i = 0; i < lista.size(); i++) {
                model.setValueAt(lista.get(i).getPessoa().getNome(), i, 0);
                model.setValueAt(sdfD.format(lista.get(i).getData()), i, 1);
                model.setValueAt(lista.get(i).getHora(), i, 2);
                model.setValueAt(lista.get(i).getDia(), i, 3);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(TelaPesquisaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPesquisaAgendamento dialog = new TelaPesquisaAgendamento(new javax.swing.JFrame(), true, null, true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAgendamento;
    // End of variables declaration//GEN-END:variables
}
