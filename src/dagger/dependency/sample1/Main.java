package dagger.dependency.sample1;

public class Main {
    public static void main(String[] args) {
        IOCSample.startService(1,1);
        IOCSample.startService(0,3);
        IOCSample.startService(1,1);
        IOCSample.startService(0,2);
        IOCSample.startService(0,4);
        IOCSample.startService(1,9);
        IOCSample.startService(1,11);
        IOCSample.startService(0,10);
        IOCSample.startService(1,5);
    }
}
