package dagger.dependency.sample1;

public abstract class Food {
    protected String name;

    @Override
    public String toString() {
        return name;
    }
}
