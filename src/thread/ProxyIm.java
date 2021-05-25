package thread;

public class ProxyIm implements ProxyService {

    @Override
    public void proxyNetWork(String text) {
        System.out.println("请求网络:  " + text);
    }
}
