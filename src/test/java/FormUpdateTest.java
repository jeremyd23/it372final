import controller.Controller;
import model.Dates;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class FormUpdateTest
{
    @BeforeClass
    public static void runBeforeTests()
    {
        Controller.getInstance();
        Controller.getInstance().addForm("First user", "Medium", "Description of default form");
    }

    @Test
    public void testDescriptionUpdate()
    {
        assertTrue(Controller.getInstance().getForm(1).getDescription().equals("Description of default form"));

        Controller.getInstance().setDescription(1, "New description");

        assertTrue(Controller.getInstance().getForm(1).getDescription().equals("New description"));
    }

    @Test
    public void testPriorityUpdate()
    {
        assertTrue(Controller.getInstance().getForm(1).getPriority().equals("Medium"));

        Controller.getInstance().setPriority(1, "High");

        assertTrue(Controller.getInstance().getForm(1).getPriority().equals("High"));
    }

    @Test
    public void testImpactUpdate()
    {
        assertTrue(Controller.getInstance().getForm(1).getImpact().equals(""));

        Controller.getInstance().updateImpact(1, "Test impact");

        assertTrue(Controller.getInstance().getForm(1).getImpact().equals("Test impact"));
    }

    @Test
    public void testEstimateEffortUpdate()
    {
        assertTrue(Controller.getInstance().getForm(1).getEstimatedEffort() == 0);

        Controller.getInstance().updateEffort(1, 5);

        assertTrue(Controller.getInstance().getForm(1).getEstimatedEffort() == 5);
    }

    @Test
    public void testDateUpdate()
    {
        //get current dates of form
        HashMap<Dates, LocalDate> dates = Controller.getInstance().getForm(1).getDates();

        //assert default null values
        for(Map.Entry date : dates.entrySet())
        {
            assertTrue(date.getValue() == null);
        }

        //create new HashMap of dates
        HashMap<Dates, LocalDate> newDates = new HashMap<>();

        //assign dates
        for(Map.Entry date : dates.entrySet())
        {
            newDates.put((Dates)date.getKey(), LocalDate.now());
        }

        //update form with new dates
        Controller.getInstance().updateDate(1, newDates);

        //get current dates of form
        dates = Controller.getInstance().getForm(1).getDates();

        //check that new dates are found.
        for(Map.Entry date : dates.entrySet())
        {
            LocalDate testDate = (LocalDate)date.getValue();

            assertTrue(testDate.getDayOfMonth() == LocalDate.now().getDayOfMonth());
            assertTrue(testDate.getMonth() == LocalDate.now().getMonth());
            assertTrue(testDate.getYear() == LocalDate.now().getYear());
        }
    }
}