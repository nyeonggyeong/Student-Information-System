/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.UserData;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author suk22
 */
public class PF_Query extends javax.swing.JFrame {

    UserData loginUser = UserData.getInstance();

    /**
     * Creates new form PF_Query
     */
    public PF_Query() {
        initComponents();
        setTitle("교수 - 교수정보 " + loginUser.getID());
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonQuery = new javax.swing.JButton();
        pNum = new javax.swing.JTextField();
        jButt_Back = new javax.swing.JButton();
        pName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonQuery.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jButtonQuery.setText("조회");
        jButtonQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQueryActionPerformed(evt);
            }
        });

        pNum.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        jButt_Back.setText("뒤로");
        jButt_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButt_BackActionPerformed(evt);
            }
        });

        pName.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel1.setText("교수번호:");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel2.setText("이름:");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel3.setText("교수 정보 조회");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButt_Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonQuery)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pNum)
                            .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonQuery)
                    .addComponent(jButt_Back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQueryActionPerformed
        // TODO add your handling code here:
        String professorId = pNum.getText(); // 사용자가 입력한 학번
        String name = pName.getText(); // 사용자가 입력한 이름

        String studentInfo = queryStudentInfo(professorId, name);
        if (studentInfo != null) { // 교수 정보가 존재하는 경우
            JOptionPane.showMessageDialog(null, "교수 정보: \n" + studentInfo); // 교수 정보를 출력한다
        } else {
            JOptionPane.showMessageDialog(null, "교수 정보를 찾을 수 없습니다.");
        }
        SM_ProfessorMenu pf = new SM_ProfessorMenu();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonQueryActionPerformed

    private void jButt_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButt_BackActionPerformed
        // TODO add your handling code here:
        SM_ProfessorMenu pf = new SM_ProfessorMenu();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButt_BackActionPerformed
    public String queryStudentInfo(String studentId, String name) {
        String filePath = "professorInfo.txt";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(",");
                String storedId = userInfo[0].trim(); // 앞뒤 공백 제거
                String storedName = userInfo[2].trim(); // 문제점!!!
                if (storedId.equals(studentId) && storedName.equals(name)) {
                    return line; // 교수 정보를 반환함
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // 교수 정보를 찾지 못한 경우
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
            java.util.logging.Logger.getLogger(PF_Query.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PF_Query.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PF_Query.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PF_Query.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PF_Query().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButt_Back;
    private javax.swing.JButton jButtonQuery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField pName;
    private javax.swing.JTextField pNum;
    // End of variables declaration//GEN-END:variables
}
