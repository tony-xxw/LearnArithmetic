package dagger.annotations;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.TimeoutException;

public class AnnotationsMain {


    @TestAnnotation(id = 522, msg = "annotation")
//注解
    class Test {

        @Check(10)
        int value;

        @TestAnnotation
        @Parent()
        public void say() {
        }

        @SuppressWarnings("deprecated")
        public void test1() {
            System.out.println(value);
        }

    }

    /**
     * @RetentionPolicy.RUNTIME 注解可以在运行中得到保留
     * @Retention(RetentionPolicy.SOURCE) 注解只保留在源码阶段, 源码执行完就会忽略
     * @Retention(RetentionPolicy.CLASS) 注解只会保留在编译阶段, 编译结束就会忽略
     */
    @Retention(RetentionPolicy.RUNTIME)

/**
 @Documented 将注解中的元素包含到javadoc中

 @Target 指定注解运用的地方
 ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
 ElementType.CONSTRUCTOR 可以给构造方法进行注解
 ElementType.FIELD 可以给属性进行注解
 ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 ElementType.METHOD 可以给方法进行注解
 ElementType.PACKAGE 可以给一个包进行注解
 ElementType.PARAMETER 可以给一个方法内的参数进行注解
 ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 @Repeatable 1.8加入 可重复注解



 @Deprecated 过时注解
 @SuppressWarnings 接触警告 (SuppressWarnings(deprecated))
 @SafeVarargs 安全类注解
 @Functionallnterface 函数接口注解
 */
    public @interface TestAnnotation {

        int id() default -1;

        String msg() default "hello annotation";

    }

    /**
     * @Inherited 当父类被Inherited注解过, 子类又无其他注解, 则子类继承父类注解
     */
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Parent {
    }

    @Parent
    public class A {
    }


    public @interface Check {
        int value();
    }

    public class B extends A {
    }

    @interface Persons {
        Person[] value();
    }

    @Repeatable(Persons.class)
    @interface Person {
        String role() default "";
    }

    @Person(role = "artist")
    @Person(role = "coder")
    @Person(role = "PM")
    public class SuperMan {

    }


    public static void main(String[] args) {
        boolean hasAnnotation = TestAnnotation.class.isAnnotation();

        if (hasAnnotation) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("id: " + testAnnotation.id());
            System.out.println("msg: " + testAnnotation.msg());
        }


        try {
            Field a = Test.class.getDeclaredField("value");
            a.setAccessible(true);
            Check check = a.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("a: " + check.value());
            }

            Method method = Test.class.getDeclaredMethod("say");
            if (method != null) {
                Annotation[] annotations = method.getAnnotations();
                for (int i = 0; i < annotations.length; i++) {
                    System.out.println("method: " + annotations[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
