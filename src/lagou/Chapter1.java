package lagou;

public class Chapter1 {


    public static void sample1() {
        int[] a = {1, 3, 4};
        int maxVal = -1;
        int maxInx = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > maxVal) {
                maxVal = a[i];
                maxInx = i;
            }
        }
        System.out.println("maxVal: " + maxVal + "  maxIndex: " + maxInx);
    }


    public static void sample2() {
        int[] a = {1, 3, 4, 3, 4, 1, 3};
        int valMax = -1;
        int timeMax = 0;
        int timeTemp = 0;

        for (int i = 0; i < a.length; i++) {
            timeTemp = 0;

            for (int i1 = 0; i1 < a.length; i1++) {
                if (a[i] == a[i1]) {
                    timeTemp += 1;
                    if (timeTemp > timeMax) {
                        timeMax = timeTemp;
                        valMax = a[i];
                    }
                }
            }
        }

        System.out.println("重复最多的数是:  " + valMax);

    }

    public static void main(String[] args) {
        sample1();
        sample2();

    }
}
