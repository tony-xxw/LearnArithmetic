package thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("d");
        strings.add("c");
        strings.add("b");
        System.out.println(strings);
        strings.add("g");
        System.out.println(strings);

        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add("x");

        strings.addAll(strings1);
        System.out.println(strings);

        int i = 10;


        do {
            i--;
            System.out.println("1");
        } while (i > 5);

    }


}
