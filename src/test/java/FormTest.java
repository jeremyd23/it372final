import controller.Controller;
import model.Form;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertTrue;

public class FormTest
{
    @BeforeClass
    public static void runBeforeTests()
    {
        Controller.getInstance();
        Controller.getInstance().addForm("First user", "Medium", "Description of default form");
    }

    @Test
    public void testAddingForm()
    {
        //add new form
        Controller.getInstance().addForm("Jeremy Daker", "High", "Test of the form builder");

        //check requester name, description and priority are stored
        assertTrue(Controller.getInstance().getForm(2).getRequestorName() == "Jeremy Daker");
        assertTrue(Controller.getInstance().getForm(2).getDescription() == "Test of the form builder");
        assertTrue(Controller.getInstance().getForm(2).getPriority() == "High");
    }

    @Test
    public void testAutoGeneratedFields()
    {
        Controller.getInstance().addForm("Test Case", "Medium", "Test for id value");

        Form form = Controller.getInstance().getForm(3);

        //check ID was auto generated
        assertTrue(form.getId() == 3);

        //check request date was auto generated
        assertTrue(form.getRequestDate().getDayOfMonth() == LocalDate.now().getDayOfMonth());
        assertTrue(form.getRequestDate().getMonth() == LocalDate.now().getMonth());
        assertTrue(form.getRequestDate().getYear() == LocalDate.now().getYear());
    }
}
