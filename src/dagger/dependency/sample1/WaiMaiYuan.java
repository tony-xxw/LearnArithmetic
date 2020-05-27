package dagger.dependency.sample1;

public abstract class WaiMaiYuan {
    protected Food food;

    WaiMaiYuan(Food food){
        this.food =food;
    }


    protected abstract void startService();
}
