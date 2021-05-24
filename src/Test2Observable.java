public class Test2Observable extends MyObservable {
    @Override
    public void subscribeActual(String text) {
        System.out.println("2: "+text);
        observable.subsribe();
    }

    public Test2Observable(MyObservable observable) {
        this.observable = observable;
    }

    private  MyObservable observable;
}