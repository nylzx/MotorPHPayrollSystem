
package com.motorph.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

import com.motorph.util.DBConnection;

public class MotorPHMainUI extends JFrame {

    private JTable employeeTable;

    public MotorPHMainUI() {
        setTitle("MotorPH Payroll System");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Dashboard", createDashboardPanel());
        tabbedPane.addTab("Employees", createEmployeesPanel());
        tabbedPane.addTab("Attendance", createAttendancePanel());
        tabbedPane.addTab("Payroll", createPayrollPanel());
        tabbedPane.addTab("Reports", createReportsPanel());

        add(tabbedPane);
        loadEmployeeData();
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Welcome to MotorPH Payroll System!"));
        return panel;
    }

    private JPanel createEmployeesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Employee List");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        employeeTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createAttendancePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Attendance Module (To be implemented)"), BorderLayout.NORTH);
        return panel;
    }

    private JPanel createPayrollPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Payroll Summary Panel (To be implemented)"), BorderLayout.NORTH);
        return panel;
    }

    private JPanel createReportsPanel() {
        JPanel panel = new JPanel();
        JButton viewReportButton = new JButton("View Payslip Report");
        viewReportButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Report feature coming soon!"));
        panel.add(viewReportButton);
        return panel;
    }

    private void loadEmployeeData() {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT employeeID, firstName, lastName, department, position FROM employee_information")) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            Vector<String> columnNames = new Vector<>();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            Vector<Vector<Object>> data = new Vector<>();
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    row.add(rs.getObject(columnIndex));
                }
                data.add(row);
            }

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            employeeTable.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading employee data.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            new MotorPHMainUI().setVisible(true);
        });
    }
}
