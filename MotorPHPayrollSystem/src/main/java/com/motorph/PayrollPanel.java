package com.motorph;

import com.motorph.dao.EmployeeDAO;
import com.motorph.dao.AllowanceDAO;
import com.motorph.model.Employee;
import com.motorph.model.Allowance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PayrollPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private AllowanceDAO allowanceDAO = new AllowanceDAO();

    public PayrollPanel() {
        setLayout(new BorderLayout());

        // Table
        String[] columns = {"Emp ID", "Name", "Rate/Day", "Rice", "Phone", "Clothing", "Total Allowance", "Gross Pay"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        loadPayrollData();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton refreshBtn = new JButton("Refresh");
        buttonPanel.add(refreshBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        refreshBtn.addActionListener(e -> loadPayrollData());
    }

    private void loadPayrollData() {
        tableModel.setRowCount(0);
        List<Employee> employees = employeeDAO.getAll();
        List<Allowance> allowances = allowanceDAO.getAll();

        for (Employee emp : employees) {
            Allowance allow = allowances.stream()
                    .filter(a -> a.getEmployeeID() == emp.getEmployeeID())
                    .findFirst()
                    .orElse(null);

            double rice = allow != null ? allow.getRiceSubsidy() : 0;
            double phone = allow != null ? allow.getPhoneAllowance() : 0;
            double clothing = allow != null ? allow.getClothingAllowance() : 0;
            double totalAllowance = rice + phone + clothing;
            double gross = emp.getRatePerDay() + totalAllowance;

            tableModel.addRow(new Object[]{
                emp.getEmployeeID(),
                emp.getFirstName() + " " + emp.getLastName(),
                emp.getRatePerDay(),
                rice,
                phone,
                clothing,
                totalAllowance,
                gross
            });
        }
    }
}
