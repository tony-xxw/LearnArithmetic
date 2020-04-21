package chapter1;

public class ContinuousLinear {

    static class Continuous {
        int[] arr1 = new int[10];

        void init() {
            arr1[0] = 1;
            arr1[1] = 2;
            arr1[2] = 3;
            arr1[3] = 4;
            arr1[4] = 5;
            arr1[5] = 6;

        }

        public void insertElement(int i, int index) {
            if (i == arr1.length - 1) {
                return;
            } else if (i < 0 || i > arr1.length - 1) {
                return;
            } else if (i < arr1.length - 1) {
                //  插入角标值 向后移  i-1是因为 k+1 = k  所以插入i 要-1
                for (int k = arr1.length - 1; k > i - 1; k--) {
                    if (k != arr1.length - 1)
                        arr1[k + 1] = arr1[k];
                }
                arr1[i] = index;
            }
        }

        void log() {
            System.out.print(arr1);
        }


    }


    public static void main(String[] args) {
        Continuous continuous = new Continuous();
        continuous.init();
        continuous.insertElement(2, 10);
        continuous.log();

    }
}
