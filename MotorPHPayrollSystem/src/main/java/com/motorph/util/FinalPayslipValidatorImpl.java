package com.motorph.util;

import com.motorph.dao.PayrollDAO;
import com.motorph.model.Payroll;
import java.util.Date;

public class FinalPayslipValidatorImpl implements PayslipValidatorInterface {

    public boolean validate() {
        PayrollDAO payrollDAO = new PayrollDAO();

        // Example: Get payroll for employeeID = 1 (this can be dynamic in your real code)
        Payroll payroll = payrollDAO.getByEmployeeID(1);

        if (payroll == null) {
            System.out.println("? No payroll record found.");
            return false;
        }

        // Validation rules
        if (payroll.getNetPay() <= 0) {
            System.out.println("? Net pay must be greater than 0.");
            return false;
        }

        if (payroll.getGrossPay() < payroll.getNetPay()) {
            System.out.println("? Gross pay should not be less than net pay.");
            return false;
        }

        if (payroll.getWorkHours() <= 0) {
            System.out.println("? Work hours should be more than 0.");
            return false;
        }

        // Passed all checks
        System.out.println("? Payslip validated successfully.");
        return true;
    }

    public boolean isPayslipReady(int employeeId, Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

