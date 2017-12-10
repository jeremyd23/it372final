import model.Form;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class FormTest
{
    private static Form form;

    @Before
    public void runBeforeTests()
    {
        form = new Form(2, LocalDate.now(), "Jeremy Daker", "High", "Test of the form builder");
    }

    @Test
    public void testStatusOpen()
    {
        assertEquals("OPEN", form.getStatus());
    }

    @Test
    public void testStatusRejected()
    {
        form.setRejected(LocalDate.now());

        assertEquals("REJECTED", form.getStatus());
    }

    @Test
    public void testStatusAccepted()
    {
        form.setAccepted(LocalDate.now());
        assertEquals("ACCEPTED", form.getStatus());

        form.setRejected(LocalDate.now());
        assertEquals("ACCEPTED", form.getStatus());
    }

    @Test
    public void testStatusInitiated()
    {
        form.setStart(LocalDate.now());
        assertEquals("IN WORK", form.getStatus());
    }

    @Test
    public void testStatusDone()
    {
        form.setComplete(LocalDate.now());
        assertEquals("DONE", form.getStatus());
    }
}
