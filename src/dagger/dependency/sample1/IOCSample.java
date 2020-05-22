package dagger.dependency.sample1;

public class IOCSample {

    public static void startService(int orderid, int flowid) {
        WaiMaiYuan waiMaiYuan;
        Food food;

        if (orderid == 0) {
            food = new Tomato();
        } else {
            food = new Banner();
        }

        if (flowid % 2 == 0) {
            waiMaiYuan = new Boy(food);
        } else {
            waiMaiYuan = new Girl(food);
        }

        waiMaiYuan.startService();
    }
}
