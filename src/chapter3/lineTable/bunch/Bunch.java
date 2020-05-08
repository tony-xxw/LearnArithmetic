package chapter3.lineTable.bunch;

public class Bunch {


    public int index(String[] T, String[] S, int pos){
        int i  = pos;
        int j = 0;
        int temp= 0;

        while (i<T.length && j <=S.length-1){
            if (T[i].equals(S[j])){
                i++;
                j++;
            }else {
                j =0;
            }

            if (j ==S.length-1){
                temp = j;
            }else {
                temp = 0;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Bunch bunch = new Bunch();
        int index =bunch.index(new String[]{"g","o","o","l","e","s","t","u","d","e","n","t"},
                new String[]{"g","o","o","l","w"},0);
        System.out.println("index: "+index);
    }
}
