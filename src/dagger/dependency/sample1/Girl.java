package dagger.dependency.sample1;

public class Girl extends WaiMaiYuan {

    Girl(Food food) {
        super(food);
    }

    @Override
    protected void startService() {
        System.out.println("女孩开始服务,食物为: " + food);
    }
}
