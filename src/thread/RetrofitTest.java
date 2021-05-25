package thread;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class RetrofitTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<NetWork> netWorkClass = NetWork.class;
        Method obtainService = netWorkClass.getMethod("obtainService", List.class);

        Annotation[] annotations = obtainService.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotations: " + annotation.toString());
        }
        for (Type genericParameterType : obtainService.getGenericParameterTypes()) {
            System.out.println("genericParameterTypes: " + genericParameterType.getTypeName());
        }
        for (Annotation[] parameterAnnotation : obtainService.getParameterAnnotations()) {
            for (Annotation annotation : parameterAnnotation) {
                System.out.println("parameterAnnotation: " + annotation.toString());
            }
        }

        Type genericReturnType = obtainService.getGenericReturnType();
        if (genericReturnType instanceof Class<?>) {
            System.out.println("111");
        }

        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType genericReturnType1 = (ParameterizedType) genericReturnType;
            Type rawType = genericReturnType1.getRawType();
            System.out.println("rawType: " + rawType);

            for (Type actualTypeArgument : genericReturnType1.getActualTypeArguments()) {
                System.out.println("actualTypeArgument: "+actualTypeArgument);
            }
        }

        System.out.println("genericReturnType： " + genericReturnType);
    }
}

class NetWork {

    @Getter
    public List<String> obtainService(@Deprecated List<String> path) {
        return null;
    }

}
