/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.agendamentoDAO;
import entity.Agenda;
import entity.Pessoa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public class TelaProximoHorario extends javax.swing.JDialog {

    /**
     * Creates new form TelaProximoHorario
     */
    public TelaProximoHorario(java.awt.Frame parent, boolean modal, Date data) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        tabelaHorarioLivre();
        this.dt = data;
    }

    Date dt;
    List<Agenda> listaOcupados;
    SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblHorarioLivre = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Próximo Horário - Agenda Financeira");

        tblHorarioLivre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblHorarioLivre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Data", "Horário"
            }
        ));
        tblHorarioLivre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblHorarioLivreMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblHorarioLivre);
        if (tblHorarioLivre.getColumnModel().getColumnCount() > 0) {
            tblHorarioLivre.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblHorarioLivre.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblHorarioLivre.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHorarioLivreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHorarioLivreMousePressed

    }//GEN-LAST:event_tblHorarioLivreMousePressed

    private void tabelaHorarioLivre() {
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        Pessoa p = new Pessoa();
        Agenda a = new Agenda();
        agendamentoDAO aDAO = new agendamentoDAO();
        ArrayList<String> listaPeriodo = new ArrayList<>();

        Calendar inicial = Calendar.getInstance();
        inicial.set(Calendar.HOUR_OF_DAY, 8);
        inicial.set(Calendar.MINUTE, 0);

        Calendar Final = Calendar.getInstance();
        Final.set(Calendar.HOUR_OF_DAY, 18);
        Final.set(Calendar.MINUTE, 0);

        int minute = 30;

        int diaInicial = inicial.get(Calendar.DAY_OF_MONTH);
        int diaFinal = Final.get(Calendar.DAY_OF_MONTH);

        while (inicial.before(Final)) {
            listaPeriodo.add(String.format("%02d",
                    inicial.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d", inicial.get(Calendar.MINUTE)));
            inicial.add(Calendar.MINUTE, minute);
        }

        GregorianCalendar calInicio = new GregorianCalendar();
        calInicio.add(GregorianCalendar.DAY_OF_MONTH, 1);
        dt = calInicio.getTime();
        java.sql.Date dia;
        dia = new java.sql.Date(dt.getTime());

        //pega o modelo da Tabela e coloca na variavel "model"
        DefaultTableModel model
                = (DefaultTableModel) this.tblHorarioLivre.getModel();
        tblHorarioLivre.getColumnModel().getColumn(0).setCellRenderer(direita);
        //laço para inserir o número de linhas igual ao da lista
        for (int i = 0; i < listaPeriodo.size(); i++) {
            model.addRow(new Object[]{});
            model.setValueAt(sdfD.format(dia), i, 1);
            model.setValueAt(listaPeriodo.get(i), i, 2);

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
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProximoHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaProximoHorario dialog = new TelaProximoHorario(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHorarioLivre;
    // End of variables declaration//GEN-END:variables
}
