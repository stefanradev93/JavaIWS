package de.moviemanager.data;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;


import de.util.DateUtils;

import static de.util.DateUtils.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DueDateTest {
    @Test
    void testSetDueDateWithNoExistingDueDate() {
        final Movie m1 = new Movie(0);

        assertNull(m1.getDueDate());
        m1.setDueDate(DateUtils.textToDate("dd.MM.YYYY","22.10.2020"));

        assertEquals(DateUtils.textToDate("dd.MM.YYYY","22.10.2020"),m1.getDueDate());



    }

    @Test
    void testSetDueDateWithExistingDueDate() {
        final Movie m1 = new Movie(0);


        m1.setDueDate(DateUtils.textToDate("dd.MM.YYYY","22.10.2020"));

        assertEquals(DateUtils.textToDate("dd.MM.YYYY","22.10.2020"),m1.getDueDate());


        m1.setDueDate(DateUtils.textToDate("dd.MM.YYYY","25.10.2020"));

        assertEquals(DateUtils.textToDate("dd.MM.YYYY","25.10.2020"),m1.getDueDate());


    }


    @Test
    void testIsLoanedWithExistingDueDate() {
        final Movie m1 = new Movie(0);


        m1.setDueDate(DateUtils.textToDate("dd.MM.YYYY","22.10.2020"));

        assertEquals(DateUtils.textToDate("dd.MM.YYYY","22.10.2020"),m1.getDueDate());




        assertTrue(m1.isLoaned());




    }

    @Test
    void testIsLoanedWithoutExistingDueDate() {
        final Movie m1 = new Movie(0);




        m1.setDueDate(null);


        assertNull(m1.getDueDate());

        assertFalse(m1.isLoaned());


    }

    @Test
    void testIsOverdueWithExistingDueDateandOverdue() {
        final Movie m1 = new Movie(0);

        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


        m1.setDueDate(DateUtils.textToDate(formatter,"28-01-2010"));

        assertEquals(DateUtils.textToDate(formatter,"28-01-2010"),m1.getDueDate());




        assertTrue(m1.isOverdue());




    }

    @Test
    void testIsOverdueWithExistingDueDateandNotOverdue() {
        final Movie m1 = new Movie(0);

        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");




        m1.setDueDate(DateUtils.textToDate(formatter,"28-02-2020"));

        assertFalse(m1.isOverdue());



    }

    @Test
    void testIsOverdueWithoutExistingDueDate() {
        final Movie m1 = new Movie(0);
        m1.setDueDate(null);


        assertNull(m1.getDueDate());

        assertFalse(m1.isOverdue());



    }




}
