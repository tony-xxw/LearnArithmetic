package thread;

public class InitializationTest {
    final static InitializationTest INSTANCE = new InitializationTest();

    static {
        System.out.println(String.format("static initialization block invoked, instance = %s", INSTANCE));
    }

    {
        System.out.println(String.format("initialization block invoked, instance = %s", INSTANCE));
    }

    InitializationTest() {
        System.out.println(String.format("constructor invoked, instance = %s", INSTANCE));
    }

    public static void main(String[] a) {
        System.out.println("11");
        System.out.println(Thread.currentThread().getName());
    }
}