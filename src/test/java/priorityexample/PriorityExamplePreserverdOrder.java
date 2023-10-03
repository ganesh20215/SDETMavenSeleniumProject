package priorityexample;

import org.testng.annotations.Test;

public class PriorityExamplePreserverdOrder {

    @Test
    public void testX() {
        System.out.println("test case A");
    }

    @Test
    public void testL() {
        System.out.println("test case L");
    }

    @Test
    public void testT() {
        System.out.println("test case T");
    }

    @Test
    public void testH() {
        System.out.println("test case H");
    }

    @Test
    public void testP() {
        System.out.println("test case P");
    }
}
