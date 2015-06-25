/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.agendamentoDAO;
import entity.Agenda;
import entity.DataHora;
import entity.Pessoa;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel1
 */
public final class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        dataTela();
        iconeTela();
        tabelaPrincipal();
        atualizaTabela();
        atualizaDiaSemanaTela();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    agendamentoDAO aDAO = new agendamentoDAO();
    List<Agenda> listaAgendamentos;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisaHoraMarcada = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtHorario = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrincipal = new javax.swing.JTable();
        lblDiaSemana = new javax.swing.JLabel();
        txtData = new com.toedter.calendar.JDateChooser();
        btnProximoHorario = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCadCliente = new javax.swing.JButton();
        btnOrcamento = new javax.swing.JButton();
        btnFinanceiro = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnServico = new javax.swing.JButton();
        btnConfiguracao = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal - Agenda Financeira");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 153)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 51, 153)), "Consulta Horário Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 153))); // NOI18N

        jLabel3.setText("Nome:");

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));

        btnPesquisaHoraMarcada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnPesquisaHoraMarcada.setText("Nome");
        btnPesquisaHoraMarcada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaHoraMarcadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisaHoraMarcada, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnPesquisaHoraMarcada, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 13, 630, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Data");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txtHorario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        try {
            txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel2.add(txtHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 42, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Horário");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 599, -1, -1));

        tblPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        tblPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário", "Cliente", "Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblPrincipalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPrincipalMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrincipal);
        if (tblPrincipal.getColumnModel().getColumnCount() > 0) {
            tblPrincipal.getColumnModel().getColumn(0).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblPrincipal.getColumnModel().getColumn(1).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblPrincipal.getColumnModel().getColumn(2).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 211, 637, 382));

        lblDiaSemana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDiaSemana.setForeground(new java.awt.Color(255, 51, 51));
        lblDiaSemana.setText("diaSemana");
        jPanel2.add(lblDiaSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));
        jPanel2.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 147, -1));

        btnProximoHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Find.png"))); // NOI18N
        btnProximoHorario.setText("Próximo Horário");
        btnProximoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoHorarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnProximoHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 161, -1, 46));

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 153)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add.png"))); // NOI18N
        btnCadCliente.setText("Cad. Pessoa");
        btnCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadClienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnCadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 13, 185, -1));

        btnOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cadastro perguntads.png"))); // NOI18N
        btnOrcamento.setText("Orçamento");
        btnOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrcamentoActionPerformed(evt);
            }
        });
        jPanel3.add(btnOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 13, 185, 75));

        btnFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/financeiro.png"))); // NOI18N
        btnFinanceiro.setText("Financeiro");
        btnFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceiroActionPerformed(evt);
            }
        });
        jPanel3.add(btnFinanceiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 99, 185, -1));

        btnProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/estoque.png"))); // NOI18N
        btnProduto.setText("Produtos");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });
        jPanel3.add(btnProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 99, 185, 75));

        btnServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Serviços.png"))); // NOI18N
        btnServico.setText("Serviços");
        btnServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicoActionPerformed(evt);
            }
        });
        jPanel3.add(btnServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 13, 185, 75));

        btnConfiguracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuração.png"))); // NOI18N
        btnConfiguracao.setText("Configurações");
        btnConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracaoActionPerformed(evt);
            }
        });
        jPanel3.add(btnConfiguracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 99, 185, 75));

        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Financeiro 16.png"))); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.png"))); // NOI18N

        jMenu1.setText("Cadastros");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Financeiro");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadClienteActionPerformed
        TelaCadastroPessoa Cp = new TelaCadastroPessoa(this, rootPaneCheckingEnabled);
        Cp.setVisible(true);
    }//GEN-LAST:event_btnCadClienteActionPerformed

    private void btnFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiroActionPerformed
        Financeiro f = new Financeiro(this, rootPaneCheckingEnabled);
        f.setVisible(true);
    }//GEN-LAST:event_btnFinanceiroActionPerformed

    private void btnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrcamentoActionPerformed
        Orcamento o = new Orcamento(this, rootPaneCheckingEnabled);
        o.setVisible(true);
    }//GEN-LAST:event_btnOrcamentoActionPerformed

    private void btnConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracaoActionPerformed
        Configuracoes c = new Configuracoes(this, rootPaneCheckingEnabled);
        c.setVisible(true);
    }//GEN-LAST:event_btnConfiguracaoActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        Produtos p = new Produtos(this, rootPaneCheckingEnabled);
        p.setVisible(true);
        setResizable(false);
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicoActionPerformed
        TelaServico s = new TelaServico(this, rootPaneCheckingEnabled);
        s.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_btnServicoActionPerformed

    private void tblPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMousePressed
        DataHora dt = new DataHora();
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
        int linha = tblPrincipal.getSelectedRow();

        if (evt.getClickCount() == 2) {
            dt.setData(txtData.getDate());
            try {
                dt.setHorario(sdfH.parse(tblPrincipal.getValueAt(linha, 0).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            dt.setDia(lblDiaSemana.getText());

            if (tblPrincipal.getValueAt(linha, 1).toString().equals("")) {
                Agendamento a = new Agendamento(this, rootPaneCheckingEnabled, dt);
                a.setVisible(true);
            } else {

            }
        }
        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_tblPrincipalMousePressed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        Caixa c = new Caixa(this, rootPaneCheckingEnabled);
        c.setVisible(true);
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int sel = tblPrincipal.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Selecione o agendamento a ser excluído");
        } else {
            int linha = tblPrincipal.getSelectedRow();
            String tbl = tblPrincipal.getValueAt(linha, 1).toString();
            if ((tbl.equals(""))) {
                JOptionPane.showMessageDialog(this, "Selecione um Agendamento para Exclusão");
            } else {
                int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja Excluir o  Agendamento?", "Exclusão", 0, 0);
                if (confirmacao == 0) {
                    //pega a linha da Tabela que foi selecionada pelo usuário
                    int line = tblPrincipal.getSelectedRow();
                    String hora = tblPrincipal.getValueAt(linha, 0).toString();
                    Date dt = txtData.getDate();
                    java.sql.Date data;
                    data = new java.sql.Date(dt.getTime());
                    agendamentoDAO aDAO = new agendamentoDAO();

                    aDAO.delete(hora, data);
                    this.limparTabela();
                    this.atualizaTabela();
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMouseEntered
        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_tblPrincipalMouseEntered

    private void tblPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMouseExited
        limparTabela();
        atualizaTabela();
        atualizaDiaSemanaTela();
    }//GEN-LAST:event_tblPrincipalMouseExited

    private void btnPesquisaHoraMarcadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaHoraMarcadaActionPerformed
        String nome = txtNome.getText();
        TelaPesquisaAgendamento tela = new TelaPesquisaAgendamento(this, rootPaneCheckingEnabled, nome);
        tela.setVisible(true);
    }//GEN-LAST:event_btnPesquisaHoraMarcadaActionPerformed

    private void btnProximoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoHorarioActionPerformed
        TelaProximoHorario tela = new TelaProximoHorario(this, rootPaneCheckingEnabled);
        tela.setVisible(true);
    }//GEN-LAST:event_btnProximoHorarioActionPerformed

    public void dataTela() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date();
            txtData.setDate(data);
            lblDiaSemana.setText(formatter.format(Calendar.DAY_OF_WEEK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_WEEK);
        diaDaSemana(dia);

    }

    public void iconeTela() {
        URL url = this.getClass().getResource("agendaFinanceira.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage("C:\\imagens\\agendaFinanceira.png");
        this.setIconImage(iconeTitulo);
        Agenda agenda = new Agenda();
    }

    public void diaDaSemana(int dia) {
        String diaDaSemana[] = {"Domingo", "Segunda-Feira", "Terça-Feira",
            "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"};
        lblDiaSemana.setText(diaDaSemana[dia - 1]);
    }

    private void tabelaPrincipal() {

        Pessoa p = new Pessoa();
        Agenda a = new Agenda();
        agendamentoDAO aDAO = new agendamentoDAO();
        ArrayList<String> listaPeriodo = new ArrayList<>();

        //Seta a hora inicial  
        Calendar inicial = Calendar.getInstance();
        inicial.set(Calendar.HOUR_OF_DAY, 8);
        inicial.set(Calendar.MINUTE, 0);

        //Seta hora final
        Calendar Final = Calendar.getInstance();
        Final.set(Calendar.HOUR_OF_DAY, 18);
        Final.set(Calendar.MINUTE, 0);

        //Periodo a ser somado  
        int minute = 30;

        //Guarda o dia inicial  e final
        int diaInicial = inicial.get(Calendar.DAY_OF_MONTH);
        int diaFinal = Final.get(Calendar.DAY_OF_MONTH);

        //Enquanto o horário inicial for menor que o final add lista
        while (inicial.before(Final)) {
            //Pega a hora e minuto e formata para 00:00  
            listaPeriodo.add(String.format("%02d", inicial.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d", inicial.get(Calendar.MINUTE)));

            //Soma o minuto  
            inicial.add(Calendar.MINUTE, minute);

        }

        //pega o modelo da Tabela e coloca na variavel "model"
        DefaultTableModel model
                = (DefaultTableModel) this.tblPrincipal.getModel();

        //laço para inserir o número de linhas igual ao da lista
        for (int i = 0; i < listaPeriodo.size(); i++) {
            model.addRow(new Object[]{});
            model.setValueAt(listaPeriodo.get(i), i, 0);

        }
    }

    public void atualizaTabela() {
        Agenda a = new Agenda();
        DefaultTableModel model
                = (DefaultTableModel) this.tblPrincipal.getModel();

        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm:ss");

        String verificaHora;
        Date dt = txtData.getDate();
        java.sql.Date data;
        data = new java.sql.Date(dt.getTime());
        String dataAtual = sdfD.format(new Date());
        String dat = sdfD.format(txtData.getDate());
        if (!dat.equals(dataAtual)) {
            tblPrincipal.setBackground(Color.pink);
        }else{
            tblPrincipal.setBackground(null);
        }
        listaAgendamentos = aDAO.listarAgendamentos(data);
        for (int j = 0; j < tblPrincipal.getRowCount(); j++) {
            verificaHora = tblPrincipal.getValueAt(j, 0).toString() + ":00";
            for (int i = 0; i < listaAgendamentos.size(); i++) {
                if (listaAgendamentos.get(i).getHora().toString().equals(verificaHora)) {
                    model.setValueAt(listaAgendamentos.get(i), j, 2);
                    model.setValueAt(listaAgendamentos.get(i).getPessoa().getNome(), j, 1);
                }
            }
        }
    }

    public void atualizaDiaSemanaTela() {
        SimpleDateFormat sdfD = new SimpleDateFormat("dd/MM/yyyy");
        String diaTela = sdfD.format(txtData.getDate());
        Date data = new Date(txtData.getDate().getTime());
        Calendar c = new GregorianCalendar();
        c.setTime(data);
        int dia = c.get(c.DAY_OF_WEEK);
        diaDaSemana(dia);
    }

    public void limparTabela() {
        DefaultTableModel model
                = (DefaultTableModel) this.tblPrincipal.getModel();
        String text = "";
        for (int i = 0; i < tblPrincipal.getRowCount(); i++) {
            model.setValueAt(text, i, 2);
            model.setValueAt(text, i, 1);
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCliente;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnConfiguracao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinanceiro;
    private javax.swing.JButton btnOrcamento;
    private javax.swing.JButton btnPesquisaHoraMarcada;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnProximoHorario;
    private javax.swing.JButton btnServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaSemana;
    private javax.swing.JTable tblPrincipal;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
