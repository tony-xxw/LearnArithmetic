package dagger.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnnotationsMain {


    public static void main(String[] args) {

    }


    @TestAnnotation //注解
    public void say() {

    }

    @Retention(RetentionPolicy.RUNTIME) //注解可以在运行中得到保留
/**
 @Retention(RetentionPolicy.SOURCE) //注解只保留在源码阶段,源码执行完就会忽略
 @Retention(RetentionPolicy.CLASS) //注解只会保留在编译阶段, 编译结束就会忽略

 @Documented  将注解中的元素包含到javadoc中

 @Target 指定注解运用的地方
 ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
 ElementType.CONSTRUCTOR 可以给构造方法进行注解
 ElementType.FIELD 可以给属性进行注解
 ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 ElementType.METHOD 可以给方法进行注解
 ElementType.PACKAGE 可以给一个包进行注解
 ElementType.PARAMETER 可以给一个方法内的参数进行注解
 ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举

 @Inherited 当父类被Inherited注解过,子类又无其他注解,则子类继承父类注解
 */
    public @interface TestAnnotation {

        int id() default -1;

        String msg() default "hello annotation";

    }
}
