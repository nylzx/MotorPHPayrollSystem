package com.motorph;

import com.motorph.dao.EmployeeDAO;
import com.motorph.dao.AttendanceRecordDAO;
import com.motorph.dao.AllowanceDAO;
import com.motorph.model.Employee;
import com.motorph.model.AttendanceRecord;
import com.motorph.model.Allowance;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ReportPanel extends JPanel {

    private JTextArea summaryArea;
    private JButton refreshButton;

    public ReportPanel() {
        setLayout(new BorderLayout());

        summaryArea = new JTextArea(25, 70);
        summaryArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        summaryArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(summaryArea);

        refreshButton = new JButton("Generate Summary");
        refreshButton.addActionListener(e -> generateSummary());

        add(scroll, BorderLayout.CENTER);
        add(refreshButton, BorderLayout.SOUTH);

        generateSummary(); // Load on startup
    }

    private void generateSummary() {
        StringBuilder sb = new StringBuilder();

        EmployeeDAO employeeDAO = new EmployeeDAO();
        AttendanceRecordDAO attendanceDAO = new AttendanceRecordDAO();
        AllowanceDAO allowanceDAO = new AllowanceDAO();

        List<Employee> employees = employeeDAO.getAll();
        List<AttendanceRecord> attendance = attendanceDAO.getAll();
        List<Allowance> allowances = allowanceDAO.getAll();

        sb.append("📊 MOTORPH PAYROLL REPORT SUMMARY\n\n");

        sb.append("👥 Total Employees: ").append(employees.size()).append("\n");

        Map<String, Long> deptCounts = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        sb.append("\n🗂 Department Distribution:\n");
        deptCounts.forEach((dept, count) ->
                sb.append("  - ").append(dept).append(": ").append(count).append(" employees\n"));

        sb.append("\n🕒 Total Attendance Records: ").append(attendance.size()).append("\n");

        sb.append("\n💰 Top 5 Highest Earners:\n");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getRatePerDay).reversed())
                .limit(5)
                .forEach(e -> sb.append("  - ")
                        .append(e.getFirstName()).append(" ").append(e.getLastName())
                        .append(" | ₱").append(String.format("%.2f", e.getRatePerDay())).append("/day\n"));

        sb.append("\n✅ Allowance Overview:\n");
        sb.append("  Total Allowance Entries: ").append(allowances.size()).append("\n");

        double totalRice = allowances.stream().mapToDouble(Allowance::getRiceSubsidy).sum();
        double totalPhone = allowances.stream().mapToDouble(Allowance::getPhoneAllowance).sum();
        double totalClothing = allowances.stream().mapToDouble(Allowance::getClothingAllowance).sum();

        sb.append("  ➤ Total Rice Subsidy: ₱").append(String.format("%.2f", totalRice)).append("\n");
        sb.append("  ➤ Total Phone Allowance: ₱").append(String.format("%.2f", totalPhone)).append("\n");
        sb.append("  ➤ Total Clothing Allowance: ₱").append(String.format("%.2f", totalClothing)).append("\n");

        summaryArea.setText(sb.toString());
    }
}
