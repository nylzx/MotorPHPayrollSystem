package com.motorph;

import com.motorph.dao.EmployeeDAO;
import com.motorph.model.Employee;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.motorph.util.DBConnection;

public class PayslipPanel extends JPanel {

    private JComboBox<Employee> employeeCombo;
    private JButton generateButton;
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public PayslipPanel() {
        setLayout(new FlowLayout());

        employeeCombo = new JComboBox<>();
        generateButton = new JButton("Generate Payslip");

        loadEmployees();

        add(new JLabel("Select Employee:"));
        add(employeeCombo);
        add(generateButton);

        generateButton.addActionListener(e -> generatePayslip());
    }

    private void loadEmployees() {
        List<Employee> employees = employeeDAO.getAll();
        for (Employee emp : employees) {
            employeeCombo.addItem(emp);
        }
    }

    private void generatePayslip() {
        Employee selected = (Employee) employeeCombo.getSelectedItem();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Please select an employee.");
            return;
        }

        try {
            InputStream reportStream = getClass().getResourceAsStream("/reports/payslip_template.jrxml");
            JasperReport report = JasperCompileManager.compileReport(reportStream);

            Map<String, Object> params = new HashMap<>();
            params.put("EMPLOYEE_ID", selected.getEmployeeID());

            Connection conn = DBConnection.getConnection();
            JasperPrint filledReport = JasperFillManager.fillReport(report, params, conn);

            JasperViewer viewer = new JasperViewer(filledReport, false);
            viewer.setTitle("Payslip for " + selected.getFirstName());
            viewer.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating payslip:\n" + e.getMessage());
        }
    }
}
