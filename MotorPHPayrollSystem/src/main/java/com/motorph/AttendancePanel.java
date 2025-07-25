package com.motorph;

import com.motorph.dao.AttendanceRecordDAO;
import com.motorph.model.AttendanceRecord;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AttendancePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private AttendanceRecordDAO attendanceDAO = new AttendanceRecordDAO();

    public AttendancePanel() {
        setLayout(new BorderLayout());

        // Table setup
        String[] columns = {"Attendance ID", "Employee ID", "Date", "Login", "Logout"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        loadAttendanceData();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Button controls
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(e -> showAttendanceForm(null));
        editButton.addActionListener(e -> editSelectedRecord());
        deleteButton.addActionListener(e -> deleteSelectedRecord());
    }

    private void loadAttendanceData() {
        tableModel.setRowCount(0);
        List<AttendanceRecord> list = attendanceDAO.getAll();
        for (AttendanceRecord a : list) {
            tableModel.addRow(new Object[]{
                a.getAttendanceID(),
                a.getEmployeeID(),
                a.getDate(),
                a.getLogin(),
                a.getLogout()
            });
        }
    }

    private void showAttendanceForm(AttendanceRecord record) {
        JTextField empIdField = new JTextField(record != null ? String.valueOf(record.getEmployeeID()) : "");
        JTextField dateField = new JTextField(record != null ? record.getDate().toString() : "YYYY-MM-DD");
        JTextField loginField = new JTextField(record != null ? record.getLogin().toString() : "HH:MM:SS");
        JTextField logoutField = new JTextField(record != null ? record.getLogout().toString() : "HH:MM:SS");

        JPanel form = new JPanel(new GridLayout(0, 1));
        form.add(new JLabel("Employee ID:"));
        form.add(empIdField);
        form.add(new JLabel("Date (YYYY-MM-DD):"));
        form.add(dateField);
        form.add(new JLabel("Login (HH:MM:SS):"));
        form.add(loginField);
        form.add(new JLabel("Logout (HH:MM:SS):"));
        form.add(logoutField);

        int result = JOptionPane.showConfirmDialog(this, form,
                (record == null ? "Add" : "Edit") + " Attendance", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            AttendanceRecord newRecord = new AttendanceRecord();
            newRecord.setEmployeeID(Integer.parseInt(empIdField.getText()));
            newRecord.setDate(Date.valueOf(dateField.getText()));
            newRecord.setLogin(Time.valueOf(loginField.getText()));
            newRecord.setLogout(Time.valueOf(logoutField.getText()));

            if (record == null) {
                attendanceDAO.insert(newRecord);
            } else {
                newRecord.setAttendanceID(record.getAttendanceID());
                attendanceDAO.update(newRecord);
            }

            loadAttendanceData();
        }
    }

    private void editSelectedRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
            return;
        }

        int attendanceID = (int) tableModel.getValueAt(selectedRow, 0);
        AttendanceRecord record = attendanceDAO.getById(attendanceID);
        if (record != null) {
            showAttendanceForm(record);
        }
    }

    private void deleteSelectedRecord() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int attendanceID = (int) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Delete attendance ID " + attendanceID + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            attendanceDAO.delete(attendanceID);
            loadAttendanceData();
        }
    }
}
