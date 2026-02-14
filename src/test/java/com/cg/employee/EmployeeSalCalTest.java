package com.cg.employee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeSalCalTest {


    @Test
    void testValidSalaryCalculation() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(20000, 5000, 10);

        calculator.validateSalary();
        assertEquals(27900, calculator.calculateNetSalary(), 0.01);
    }

    @Test
    void testHRA() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(20000, 5000, 10);

        assertEquals(4000, calculator.calculateHRA(), 0.01);
    }

    
    @Test
    void testDA() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(20000, 5000, 10);

        assertEquals(2000, calculator.calculateDA(), 0.01);
    }

   
    @Test
    void testGrossSalary() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(20000, 5000, 10);

        assertEquals(31000, calculator.calculateGrossSalary(), 0.01);
    }

  
    @Test
    void testNetSalary() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(20000, 5000, 10);

        assertEquals(27900, calculator.calculateNetSalary(), 0.01);
    }


    @Test
    void testZeroBasicSalary() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(0, 5000, 10);

        assertThrows(IllegalArgumentException.class, calculator::validateSalary);
    }

   
    @Test
    void testNegativeBasicSalary() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(-1000, 5000, 10);

        assertThrows(IllegalArgumentException.class, calculator::validateSalary);
    }


    @Test
    void testInvalidTaxPercent() {
        EmployeeSalCal calculator =
                new EmployeeSalCal(20000, 5000, 150);

        assertThrows(IllegalArgumentException.class, calculator::validateSalary);
    }
}