public class Test1Observable extends MyObservable {

    public Test1Observable(MyObservable observable) {
        this.observable = observable;
    }

    private  MyObservable observable;
    @Override
    public void subscribeActual(String text) {
        System.out.println("1: "+text);
        observable.subsribe();
    }
}