package thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain {
    public static void main(String[] args) {
        ProxyService proxyService = new ProxyIm();
        ProxyService o = (ProxyService) Proxy.newProxyInstance(ProxyIm.class.getClassLoader(), ProxyIm.class.getInterfaces(), new ProxyInvacationHandler(proxyService));
        o.proxyNetWork("嘻嘻");
    }
}

class ProxyInvacationHandler implements InvocationHandler {

    private final ProxyService proxyService;

    ProxyInvacationHandler(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---before---");
        Object invoke = method.invoke(proxyService, args);
        System.out.println("---after---");
        return invoke;
    }
}
