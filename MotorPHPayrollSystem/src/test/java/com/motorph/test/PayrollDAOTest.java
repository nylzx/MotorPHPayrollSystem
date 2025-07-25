package com.motorph.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.motorph.dao.PayrollDAO;
import com.motorph.model.Payroll;

public class PayrollDAOTest {

    @Test
    public void testGetByEmployeeID() {
        PayrollDAO dao = new PayrollDAO();
        Payroll payroll = dao.getByEmployeeID(1); // make sure employeeID 1 exists in DB
        assertNotNull(payroll, "Payroll should not be null");
        assertTrue(payroll.getNetPay() >= 0, "Net pay should be non-negative");
    }
}
