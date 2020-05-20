package lagou;

import java.util.HashMap;

public class Chapter2 {


    //7,3,2 凑成100元 有多少种算法(暴力算法)
    public static void sample1() {
        int count = 0;
        for (int i = 0; i < (100 / 7); i++) {
            for (int j = 0; j < (100 / 3); j++) {
                for (int k = 0; k < (100 / 2); k++) {
                    if (i * 7 + j * 3 + k * 2 == 100) {
                        count += 1;
                    }
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        System.out.println("7,3,2 凑成100元 有" + count + "种算法");

    }

    public static void sample2() {
        int count = 0;
        for (int i = 0; i < (100 / 7); i++) {
            for (int j = 0; j < (100 / 3); j++) {
                if ((100 - i * 7 - j * 3) % 2 == 0) {
                    count += 1;
                }
            }
        }
        System.out.println(System.currentTimeMillis());
        System.out.println("7,3,2 凑成100元 有" + count + "种算法");
    }

    private static void sample3() {
        int[] a = {1, 3, 4, 3, 4, 1, 3};
        int valMax = -1;
        int timeMax = 0;
        int count = 0;

        HashMap<Integer, Integer> d = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (d.containsKey(a[i])) {
                d.put(a[i], d.get(a[i]) + 1);
            } else {
                d.put(a[i], 1);
            }
        }
//
        for (Integer integer : d.keySet()) {
            if (d.get(integer) > timeMax) {
                timeMax = d.get(integer);
                valMax = count;
            }
            count++;
        }

             System.out.println("重复最多的数是: " + timeMax);
    }

    public static void main(String[] args) {
        sample1();
        sample2();
        sample3();
    }
}
