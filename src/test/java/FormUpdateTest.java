import controller.Controller;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void testFormUpdates()
    {
        assertTrue(Controller.getInstance().getForm(1).getDescription().equals("Description of default form"));

        Controller.getInstance().setDescription(1, "New description");

        assertTrue(Controller.getInstance().getForm(1).getDescription().equals("New description"));
    }
}
