import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    @Before
    public void startTest() {
        System.out.println("Test start");
    }

    @Test
    public void Test() {
        System.out.println("Test");
    }

    @After
    public void endTest() {
        System.out.println("Test end");
    }
}
