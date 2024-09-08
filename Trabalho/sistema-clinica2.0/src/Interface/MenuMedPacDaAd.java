/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import atoresPrincipais.Clinica;
import atoresPrincipais.Medico;
import atoresSecundários.Paciente;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel
 */
public class MenuMedPacDaAd extends javax.swing.JFrame {

    /**
     * Creates new form MenuMedPacDaAd
     */
    Clinica clinica;
    Medico medico;
    Paciente paciente;
    
    public MenuMedPacDaAd(Clinica clinica, Medico medico, Paciente paciente) {
        this.clinica = clinica;
        this.medico = medico;
        this.paciente = paciente;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameCadastro = new javax.swing.JFrame();
        jCheckBoxFuma = new javax.swing.JCheckBox();
        jCheckBoxBebe = new javax.swing.JCheckBox();
        jCheckBoxDoenca = new javax.swing.JCheckBox();
        jCheckBoxDiabete = new javax.swing.JCheckBox();
        jCheckBoxColesterol = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCirurgia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAlergia = new javax.swing.JTextField();
        jButtonSalvarCad = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonImprimir = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonHome = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();

        jFrameCadastro.setSize(new java.awt.Dimension(293, 454));

        jCheckBoxFuma.setText("Fuma");

        jCheckBoxBebe.setText("Bebe");

        jCheckBoxDoenca.setText("Doença Cardiaca");

        jCheckBoxDiabete.setText("Diabetes");

        jCheckBoxColesterol.setText("Colesterol");

        jLabel2.setText("Cirurgias: (separado por virgula)");

        jLabel3.setText("Alergias: (Separado por virugila)");

        jButtonSalvarCad.setText("Cadastrar");
        jButtonSalvarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarCadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrameCadastroLayout = new javax.swing.GroupLayout(jFrameCadastro.getContentPane());
        jFrameCadastro.getContentPane().setLayout(jFrameCadastroLayout);
        jFrameCadastroLayout.setHorizontalGroup(
            jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameCadastroLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrameCadastroLayout.createSequentialGroup()
                        .addComponent(jCheckBoxColesterol)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jFrameCadastroLayout.createSequentialGroup()
                        .addGroup(jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxFuma)
                            .addComponent(jCheckBoxDoenca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxBebe)
                            .addComponent(jCheckBoxDiabete))
                        .addGap(32, 32, 32))
                    .addGroup(jFrameCadastroLayout.createSequentialGroup()
                        .addGroup(jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonSalvarCad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldCirurgia)
                                .addComponent(jTextFieldAlergia, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jFrameCadastroLayout.setVerticalGroup(
            jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameCadastroLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxFuma)
                    .addComponent(jCheckBoxBebe))
                .addGap(35, 35, 35)
                .addGroup(jFrameCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxDoenca)
                    .addComponent(jCheckBoxDiabete))
                .addGap(31, 31, 31)
                .addComponent(jCheckBoxColesterol)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButtonSalvarCad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(198, 469));

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Dados Adicionais");

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar (N)");

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

        jButtonHome.setText("H");
        jButtonHome.setFocusable(false);
        jButtonHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonHome);

        jButtonAnterior.setText("A");
        jButtonAnterior.setFocusable(false);
        jButtonAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAnterior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        jFrameCadastro.setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        dispose();
        MenuEntrar main = new MenuEntrar(clinica);
        main.setVisible(true);
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        dispose();
        MenuMedPac menMedP = new MenuMedPac(clinica, medico, paciente);
        menMedP.setVisible(true);
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonSalvarCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarCadActionPerformed
        
        if(paciente.getDadosAdicionais() == null){
        boolean fuma = jCheckBoxFuma.isEnabled();
        boolean bebe = jCheckBoxBebe.isEnabled();
        boolean doenca = jCheckBoxDoenca.isEnabled();
        boolean diabetes = jCheckBoxDiabete.isEnabled();
        boolean colesterol = jCheckBoxColesterol.isEnabled();
        
        List<String> Cirurgias = Arrays.asList(jTextFieldCirurgia.getText().split("\\s*,\\s*"));
        
        List<String> alergias = Arrays.asList(jTextFieldAlergia.getText().split("\\s*,\\s*"));
        
        medico.cadastraDadosAdicionais(paciente.getCpf(), fuma, bebe, colesterol, diabetes, doenca, Cirurgias, alergias);
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else{
             JOptionPane.showMessageDialog(null, "Dados já cadastrados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSalvarCadActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        medico.removeDadosAdicionais(paciente.getCpf());
        JOptionPane.showMessageDialog(null, "Dados removidos!", "Remoção de dados adicionais", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        if(paciente.getDadosAdicionais() == null){
            JOptionPane.showMessageDialog(null, "Sem dados adicionais", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, paciente.getDadosAdicionais().imprimirDadosAdicionais(), "Dados Adicionais", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSalvarCad;
    private javax.swing.JCheckBox jCheckBoxBebe;
    private javax.swing.JCheckBox jCheckBoxColesterol;
    private javax.swing.JCheckBox jCheckBoxDiabete;
    private javax.swing.JCheckBox jCheckBoxDoenca;
    private javax.swing.JCheckBox jCheckBoxFuma;
    private javax.swing.JFrame jFrameCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldAlergia;
    private javax.swing.JTextField jTextFieldCirurgia;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
