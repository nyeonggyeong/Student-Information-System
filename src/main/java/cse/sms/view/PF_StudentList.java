/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.UserData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LG
 */
public class PF_StudentList extends javax.swing.JFrame {
     UserData loginUser = UserData.getInstance();
     
    /**
     * Creates new form PF_StudentList
     */
    public PF_StudentList() {
        initComponents();
        setTitle("교수 - 수강생 목록 -" + loginUser.getID() + " " + UserData.getName());
        setLocationRelativeTo(null);
    }
    
    private String lectureNumber;
    private String lectureName;

    public PF_StudentList(String lectureNumber, String lectureName) { // 'studentclasses.txt' 파일에서 데이터를 읽어옴
        this.lectureNumber = lectureNumber;
        this.lectureName = lectureName;
        initComponents();
        setTitle("교수 - 수강생 목록 - " + lectureName+" "+loginUser.getID() + " " + UserData.getName());
        setLocationRelativeTo(null);
        fillTable(lectureNumber); // 이 부분이 추가되었습니다.
        // 이제 강의 번호와 강의명을 사용하여 수강생 목록을 불러올 수 있습니다.
    }
    
    public List<String[]> readStudentClasses(String lectureNumber) throws IOException {
    File file = new File("studentclasses.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
    List<String[]> studentClasses = new ArrayList<>();
    String line;
    while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        
        if (data.length < 3) { // 필요한 필드가 모두 있는지 확인
            continue; // 필드가 부족한 행은 건너뜁니다.
        }
        
        if (data[2].equals(lectureNumber)) {
            studentClasses.add(new String[] {data[1], data[5]}); // 학생 이름과 학과만 추가
        }
    }
    br.close();
    return studentClasses;
}   
    
    public void fillTable(String lectureNumber) {  //수강생 목록 페이지의 JTable에 데이터를 채움.
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // 테이블의 모든 행을 삭제
    try {
        List<String[]> studentClasses = readStudentClasses(lectureNumber);
        for (String[] studentClass : studentClasses) {
            model.addRow(studentClass); // 테이블에 행을 추가
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
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
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("수강생 목록");

        jButton2.setText("뒤로");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "이름", "학과"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PF_FirstPage pf = new PF_FirstPage();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
