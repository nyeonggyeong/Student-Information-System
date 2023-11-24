/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.UserData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author 원채연
 */
public class CM_CourseDelete extends javax.swing.JFrame {
    UserData loginUser = UserData.getInstance();
    /**
     * Creates new form CM_CouseDelete
     */
    public CM_CourseDelete() {
        initComponents();
        setTitle("수업담당자 - 강좌삭제 " + loginUser.getID());
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

        jLabel1 = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        cNum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cName = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel1.setText("강좌번호");

        jButtonDelete.setText("삭제");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel2.setText("강좌명");

        jButton2.setText("뒤로 가기");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cNum, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cNum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // 뒤로 가기
        CM_CourseMenu cm = new CM_CourseMenu();
        cm.setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
                // TODO add your handling code here:
     String deleteNum = cNum.getText(); // 사용자가 입력한 강좌 번호
    String deleteResidentName = cName.getText(); // 사용자가 입력한 강좌명

    boolean deleted = deletecourseInfo(deleteNum, deleteResidentName);
    if (deleted) {
        JOptionPane.showMessageDialog(null, "강좌 정보가 삭제되었습니다.");
    } else {
        JOptionPane.showMessageDialog(null, "강좌 정보를 찾을 수 없습니다.");
    }
    }                                             
 public boolean deletecourseInfo(String deleteNum, String deleteResidentName) {
    String filePath = "classes.txt";
    File inputFile = new File(filePath);
    File tempFile = new File("temp.txt");
    BufferedReader reader;
    BufferedWriter writer;

    try {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"));

        String line;
        boolean deleted = false; // 삭제 여부 확인을 위한 플래그

        while ((line = reader.readLine()) != null) {
            String[] userInfo = line.split(",");
            String storedName = userInfo[0].trim();
            String storedResidentNum = userInfo[1].trim();

            if (storedName.equals(deleteNum) && storedResidentNum.equals(deleteResidentName)) {
                deleted = true; // 삭제 플래그를 true로 설정하여 삭제 여부를 확인
                continue; // 삭제할 강좌 정보는 쓰지 않고 건너뜀
            }

            writer.write(line);
            writer.newLine();
        }

        writer.close();
        reader.close();

        if (deleted) {
            // 기존 파일 삭제하고 임시 파일 이름 변경
            inputFile.delete();
            tempFile.renameTo(inputFile);
            return true;
        } else {
            // 삭제할 강좌 정보가 없는 경우 임시 파일 삭제
            tempFile.delete();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return false;
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cName;
    private javax.swing.JTextField cNum;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
