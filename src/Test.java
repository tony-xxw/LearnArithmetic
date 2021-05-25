import java.awt.event.TextEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

    public static void main(String[] args) {
        int a = 10;  // 1010
        int b = 11;  // 1011

        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);

        String dex = "class2.dex";
        System.out.println(dex.startsWith("class"));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("a");
        strings1.add("b");
        strings1.add("c");


        System.out.println("1111 " + strings.containsAll(strings1));
        System.out.println("1111 " + strings.removeAll(strings1));
        System.out.println("1111 " + strings);


        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadPoolExecutor.shutdownNow();
            }
        });
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
        weakReferenceTest();
        leakCollection();
    }


    public static void weakReferenceTest() {
        System.out.println();
        Test test = new Test();
        WeakReference<Test> stringWeakReference = new WeakReference<Test>(test);
        System.out.println(stringWeakReference.get());
        test = null;
        System.gc();
        System.out.println("gc");
        System.out.println(stringWeakReference.get());
    }

    public static void leakCollection() {
        System.out.println("集合");
        Test test = new Test();
        ArrayList<Test> tests = new ArrayList<>();
        tests.add(test);
        System.out.println(test.toString());
    }
}
