package chapter3.lineTable.bunch;

public class Bunch {


    public int index(String s, String t, int pos) {
        int i = pos;  //i为主串位置下标
        int j = 0;    //j为子串位置下标
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;      //i和j指向下一个位置继续比较
            } else {           /*重新匹配*/
                i = i - j + 1;  //退回上次匹配首位的下一位
                j = 0;      //返回子串的首位
            }
        }
        if (j == t.length()) {
            return i - j;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        Bunch bunch = new Bunch();
        int index = bunch.index("goodsgoogle", "google", 0);
        System.out.println("index: " + index);
    }
}
