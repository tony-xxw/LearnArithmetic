package algorithm.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        Class<?> c = methodClass.class;
//        Class<?> c = new methodClass().getClass();
        Class<?> c = Class.forName("algorithm.reflection.methodClass");
        Method[] declaredMethods = c.getDeclaredMethods();
        Method[] methods = c.getMethods();
        Method add = c.getMethod("add", int.class, int.class);
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod: " + declaredMethod.toString());
        }

        for (Method method : methods) {
            System.out.println("method: " + method);
        }

        System.out.println("add: " + add.toString());
        Object o = c.newInstance();
        System.out.println("add result: "+add.invoke(o, 1, 4));

        System.out.println("-------------------------");

        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField: " + declaredField.toString());
        }
        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println("field: " + field.toString());
        }
        System.out.println("singleField" + c.getField("str"));

    }
}

class parent {
    int x = 10;

    private void test() {

    }

    public void test1() {

    }
}

class methodClass extends parent {
    private final int test = 3;
    public String str = "wxx";

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

}
