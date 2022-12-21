public class Task {
    @Test(a = 2, b = 5)
    public void testSum(Integer a, Integer b) {
        System.out.println("Result = " + (a + b));
    }
}