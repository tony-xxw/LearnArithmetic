public abstract class MyObservable {

    public abstract void subscribeActual(String text);

    public MyObservable subscribeOn() {
        return new Test1Observable(this);
    }

    public MyObservable observeOn() {
        return new Test2Observable(this);
    }

    public  static MyObservable create(ObservableOnSubscribe observableOnSubscribe) {
        return new Test3Observable(observableOnSubscribe);
    }

    public void subsribe(){
        subscribeActual("哈哈");
    }
}

interface ObservableOnSubscribe {

    /**
     * Called for each Observer that subscribes.
     * @throws Exception on error
     */
    void subscribe(String xixi) throws Exception;
}
