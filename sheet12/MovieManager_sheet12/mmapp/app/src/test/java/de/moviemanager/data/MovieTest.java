package de.moviemanager.data;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MovieTest {
    @Test
    void testLendMovie(){
        final Movie m = createNewMovie(0, "Star Wars");
        Date today = new Date();

        // precondition
        assertNull(m.getLendDate());

        // test
        m.setLendDate(today);
        assertNotNull(m.getLendDate());
    }


    @Test
    void testIsLent(){
        final Movie m = createNewMovie(0, "Star Wars");
        Date today = new Date();

        // precondition
        assertEquals(m.isLent(), false);

        // test
        m.setLendDate(today);
        assertEquals(m.isLent(), true);
    }

    @Test
    void testReturnMovie(){
        final Movie m = createNewMovie(0, "Star Wars");
        Date today = new Date();
        m.setLendDate(today);

        // precondition
        assertEquals(m.isLent(), true);

        // test
        m.setLendDate(null);
        assertEquals(m.isLent(), false);
    }

    @Test
    void testChangeReturnDate(){
        final Movie m = createNewMovie(0, "Star Wars");
        Date today = new Date();
        Date tomorrow = addDays(today, 1);

        m.setLendDate(today);
        Date firstLendDate = m.getLendDate();

        // test
        m.setLendDate(tomorrow);
        Date newLendDate = m.getLendDate();
        assertNotEquals(newLendDate, firstLendDate);

    }

    private Date addDays(Date d, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, days);
        return cal.getTime();

    }


    private Movie createNewMovie(int id, String title){
        final Movie movie = new Movie(id);
        movie.setTitle(title);
        return movie;
    }







}
