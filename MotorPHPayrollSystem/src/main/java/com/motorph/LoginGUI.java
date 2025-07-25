package com.motorph;

import com.motorph.util.LoginAuthenticator;
import com.motorph.util.LoginSessionManager;
import com.motorph.model.Employee;
import com.motorph.dao.EmployeeDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JLabel messageLabel;

    public LoginGUI() {
        setTitle("MotorPH Payroll Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        messageLabel = new JLabel(" ", JLabel.CENTER);

        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("Username (Employee ID):"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        add(panel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String userInput = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (!userInput.matches("\\d+")) {
            messageLabel.setText("Invalid Employee ID format.");
            return;
        }

        int employeeID = Integer.parseInt(userInput);

        if (!LoginAuthenticator.authenticate(employeeID, password)) {
            messageLabel.setText("Login failed!");
            JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Employee user = new EmployeeDAO().getById(employeeID);
            if (user != null) {
                LoginSessionManager.login(user);
                messageLabel.setText("Welcome " + user.getFirstName() + "!");
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // TODO: Open main dashboard or home window here
                dispose(); // close login window
            } else {
                messageLabel.setText("User not found.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginGUI().setVisible(true));
    }
}
