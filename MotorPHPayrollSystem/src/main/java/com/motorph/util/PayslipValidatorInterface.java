package com.motorph.util;

import java.util.Date;

public interface PayslipValidatorInterface {
        boolean isPayslipReady(int employeeId, Date startDate, Date endDate);

    public boolean validate();
}