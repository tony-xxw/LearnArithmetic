package chapter3.lineTable.bunch;

import java.util.Arrays;

/**
 * KPM匹配算法
 */
public class KpmBunch {

    public int[] getNext(String t) {
        int length = t.length();
        int[] nexts = new int[length];
        int i = 1, j = 0;
        nexts[0] =0;
        while (i < length ) {
            if (j == 0 || t.charAt(i) == t.charAt(j)) {
                nexts[++i] = ++j;
            } else {
                j = nexts[j];
            }
        }
        return nexts;
    }

    public int indexKmp(String str, String t, int pos) {
        int i = pos;
        int j = 0;
        int[] next = getNext(t);
        while (i < str.length() && j < t.length()) {
            if (j == -1 || str.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == t.length()) {
            return i - j;
        }
        return -1;
    }


    public static void main(String[] args) {
        KpmBunch kpmBunch = new KpmBunch();
        System.out.println(Arrays.toString(kpmBunch.getNext("ababaaaba")));
//        System.out.println("index: "+kpmBunch.indexKmp("goodgoogle","google",0));

    }
}
