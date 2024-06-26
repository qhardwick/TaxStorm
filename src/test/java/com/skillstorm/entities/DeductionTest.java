package com.skillstorm.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeductionTest {

    // Test the no-args constructor:
    @Test
    void testDeduction() {
        Deduction deduction = new Deduction();
        assertEquals(0, deduction.getId());
        assertEquals(null, deduction.getName());
        assertEquals(null, deduction.getRate());
    }
}
