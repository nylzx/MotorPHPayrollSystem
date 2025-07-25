package com.motorph;

import javax.swing.*;
import java.awt.*;

public class DashboardUI extends JFrame {

    public DashboardUI() {
        setTitle("MotorPH Payroll Dashboard");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // These will be the main module panels
        tabbedPane.addTab("Employees", new EmployeePanel());
        tabbedPane.addTab("Attendance", new AttendancePanel());
        tabbedPane.addTab("Payroll", new PayrollPanel());
        tabbedPane.addTab("Payslips", new PayslipPanel());
        tabbedPane.addTab("Reports", new ReportPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DashboardUI().setVisible(true);
        });
    }
}
