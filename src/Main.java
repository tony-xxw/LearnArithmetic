public class Main {

    public static void main(String[] args) {
        MyObservable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(String xixi) throws Exception {
                System.out.println("subscri: " + xixi);
            }
        }).observeOn().subscribeOn().subsribe();
    }
}
