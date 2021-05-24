public class Test3Observable extends MyObservable {
    public Test3Observable(ObservableOnSubscribe observable) {
        this.observable = observable;
    }

    private  ObservableOnSubscribe observable;


    @Override
    public void subscribeActual(String text) {
        System.out.println("3: "+text);
        try {
            observable.subscribe("嘻嘻");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
