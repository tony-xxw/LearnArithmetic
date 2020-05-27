package dagger.dependency.sample1;

public class Boy extends WaiMaiYuan {

    Boy(Food food) {
        super(food);
    }

    @Override
    protected void startService() {
        System.out.println("男孩开始服务,送的食物是: " + food);
    }
}
