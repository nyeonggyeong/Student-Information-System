/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.UserData;
import cse.sms.control.CMCheck;
import cse.sms.model.ClassCourse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import cse.sms.control.UserData;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author 송녕경
 */
public class CM_CourseOpen extends javax.swing.JFrame {
    
    UserData loginUser = UserData.getInstance();
    
    /**
     * Creates new form CM_CourseOpen
     */
    public CM_CourseOpen() {
        initComponents();
        setTitle("수업담당자 - 강좌개설 " + loginUser.getID());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cNum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cGrade = new javax.swing.JTextField();
        cInfor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cpName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel3.setText("최대/최소인원");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel1.setText("강좌번호");

        cNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNumActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel2.setText("강좌명");

        cName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel4.setText("학점");

        cInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cInforActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel5.setText("설명");

        jButton1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jButton1.setText("등록");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("뒤로 가기");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel6.setText("담당교수");

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 20)); // NOI18N
        jLabel7.setText("강좌 등록");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cInfor)
                                    .addComponent(cpName)
                                    .addComponent(cName)
                                    .addComponent(cNum)
                                    .addComponent(cGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel7)))
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cInforActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cInforActionPerformed

    private void cNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNumActionPerformed

    private void cNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // 뒤로 가기
        CM_CourseMenu cm = new CM_CourseMenu();
        cm.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String filePath = "classes.txt";
        
    ClassCourse classCourse = new ClassCourse(cNum.getText(), cName.getText(), cpName.getText(), cGrade.getText(), cInfor.getText());
    CMCheck ck = new CMCheck();
    
    boolean idCheck = true;
    boolean emCheck = true;
    
    emCheck = ck.emptyCheck2(cNum.getText(), cName.getText(), cpName.getText(),   cGrade.getText(), cInfor.getText());

   
    idCheck = ck.equalCehck2(filePath, cNum.getText()); // 문제

    
    if (emCheck) {
        if (idCheck) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {
                String classInfo = classCourse.getNum() + "," + classCourse.getName() + "," + classCourse.getPName() + "," + classCourse.getGrade() + "," + classCourse.getInfor();
                bw.write(classInfo);
                bw.newLine();
                JOptionPane.showMessageDialog(null, "저장되었습니다!");
                dispose();
                CM_FirstPage sf = new CM_FirstPage();
                sf.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "중복된 강좌 번호가 있습니다.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "빈칸이 있습니다. 마저 입력해주세요.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cGrade;
    private javax.swing.JTextField cInfor;
    private javax.swing.JTextField cName;
    private javax.swing.JTextField cNum;
    private javax.swing.JTextField cpName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
