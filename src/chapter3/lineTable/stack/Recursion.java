package chapter3.lineTable.stack;

/**
 * 递归
 */
public class Recursion {

    //迭代
    private void iteration() {
        int i = 0;
        int a[] = new int[40];
        a[0] = 0;
        a[1] = 1;
        for (i = 2; i < 13; i++) {
            a[i] = a[i - 1] + a[i - 2];
            if (i != 12) {
                System.out.print(a[i] + "=>");
            } else {
                System.out.print(a[i]);
            }

        }
    }

    private void useRecursion() {
        for (int i = 2; i < 13; i++) {
            if (i != 12) {
                System.out.print(Fbi(i) + "=>");
            } else {
                System.out.print(Fbi(i));
            }

        }
    }

    private int Fbi(int i) {
        if (i < 2) {
            return i == 0 ? 0 : 1;
        }
        return Fbi(i - 1) + Fbi(i - 2);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.iteration();

        System.out.println();
        recursion.useRecursion();
    }
}
