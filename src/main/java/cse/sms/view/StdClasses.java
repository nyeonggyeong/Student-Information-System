/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cse.sms.view;

import cse.sms.control.UserData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import cse.sms.model.Student;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 원채연
 */
public class StdClasses extends javax.swing.JFrame {

    UserData loginUser = UserData.getInstance();
    int grade = 0;

    /**
     * Creates new form StdClasses
     */
    public StdClasses() {
        initComponents();
        setTitle("수강 신청" + loginUser.getID());
        InputclassInfo();   //개설 강의 보이기
        InputstdInfo();     //현재 신청 내역 보이기
    }

    private void InputclassInfo() {  //강의 가능 수업 목록

        try {
            File file = new File("classes.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] dataRow = temp.split(",");
                model.addRow(dataRow);
            }

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void OutputstdInfo() {    //학생 수강 내역 파일로 입력
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("studentclasses.txt", true));
            //Student std = new Student(); 일단 안가져오고임의로 그냥 내이름 넣어둠
            String stdnum = "20223160";
            String name = "원채연";

            bw.write(stdnum);
            bw.write(name);
            bw.flush();

        } catch (Exception ex) {
            ex.getStackTrace();
        }

    }

    private void OutputstdclassInfo(int i) {    //학생 수강 내역 파일로 입력
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("studentclasses.txt", true));  //true면 이어쓰기임
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                bw.write(jTable1.getValueAt(i, j).toString() + ",");
            }
            bw.newLine();
            bw.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private void InputstdInfo() {    //학생 수강 내역 파일에서 출력
        try {
            BufferedReader br = new BufferedReader(new FileReader("studentclasses.txt"));
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setNumRows(0);    //Row 0해서 리셋

            String temp;
            while ((temp = br.readLine()) != null) {
                String[] dataRow = temp.split(",");
                String inputStr[] = new String[6];

                inputStr[0] = dataRow[2];    //강좌번호
                inputStr[1] = dataRow[3];    //강좌명
                inputStr[2] = dataRow[4];    //학점
                inputStr[3] = dataRow[5];    //학과
                inputStr[4] = dataRow[6];    //교수
                inputStr[5] = dataRow[7];    //설명

                model.addRow(inputStr);

            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    private int gradeCheck(int i) {

        TableModel model = jTable1.getModel();
        int a = Integer.parseInt(model.getValueAt(i, 2).toString());
        int CheckNum = grade;

        if (CheckNum + a > 18) {   //현재 수강 학점 + 신청하려는 수강 학점 > 18
            JOptionPane.showMessageDialog(null, "수강 가능 학점을 초과하였습니다.");
            return 1;
        }
        return 0;
    }

    public int DoubleCheck(int selectedline) {

        try {
            TableModel model = jTable1.getModel();
            String selectedclassnum = (model.getValueAt(selectedline, 0).toString()); //선택한 줄의 classnumber
            BufferedReader br = new BufferedReader(new FileReader("studentclasses.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] classInfo = line.split(",");
                String storedclassnum = classInfo[2]; // 수강 내역 파일에 있는 classnumber

                if (storedclassnum.equals(selectedclassnum)) {  //두개 비교
                    JOptionPane.showMessageDialog(null, "이미 수강한 강의 입니다.");
                    return 2; // 이미 수강한 강의임
                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return 0;
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
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "번호", "이름", "학점", "학과", "교수", "설명"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setLabel("신청");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "번호", "이름", "학점", "학과", "교수", "설명"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(297, 297, 297)
                            .addComponent(jButton1))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int a = 0;  //이상 없으면 0
        int i = jTable1.getSelectedRow();   //몇번째 줄인지
        a += DoubleCheck(i); // 중복 수강 체크
        a += gradeCheck(i);   //수강 학점 체크

        if (a == 0) {   //문제 없으면 수강내역 파일에 값저장, 아래에 내역 띄우기
            OutputstdInfo();            //학번,이름 저장
            OutputstdclassInfo(i);      //수강내역 파일에 저장
            InputstdInfo();                 //화면에 보이기

            TableModel model = jTable1.getModel();
            grade += Integer.parseInt(model.getValueAt(i, 2).toString());   //학점 더하기

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
