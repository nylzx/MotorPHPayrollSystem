package com.motorph;

import com.motorph.dao.EmployeeDAO;
import com.motorph.model.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class EmployeePanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton refreshButton;
    private EmployeeDAO employeeDAO;

    public EmployeePanel() {
        employeeDAO = new EmployeeDAO();
        setLayout(new BorderLayout());

        // Table setup
        String[] columns = {
            "Employee ID", "First Name", "Last Name", "Department",
            "Position", "Rate/Day", "Email", "Contact Number"
        };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Refresh button
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> loadEmployees());

        // Top panel with button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(refreshButton);

        // Add components to main layout
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadEmployees(); // Initial load
    }

    private void loadEmployees() {
        tableModel.setRowCount(0); // clear table
        List<Employee> employees = employeeDAO.getAll();
        for (Employee e : employees) {
            tableModel.addRow(new Object[]{
                e.getEmployeeID(),
                e.getFirstName(),
                e.getLastName(),
                e.getDepartment(),
                e.getPosition(),
                e.getRatePerDay(),
                e.getEmail(),
                e.getContactNumber()
            });
        }
    }
}
