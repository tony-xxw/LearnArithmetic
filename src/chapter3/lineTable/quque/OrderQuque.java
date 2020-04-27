package chapter3.lineTable.quque;

import java.util.Queue;

/**
 * 顺序队列
 */
public class OrderQuque {
    private String[] strings = new String[10];
    int position = 0;

    private void push(String element) {
        if (position > strings.length - 1) {
            System.out.println("队列已满");
            return;
        }
        strings[position] = element;
        position++;

    }

    private void pop() {
        for (int i = 0; i < strings.length; i++) {
            //头部弹出
            if (i != 0) {
                strings[i - 1] = strings[i];
            }
        }
        position--;

    }

    private String peek() {
        return strings[0];
    }

    private void size() {
        System.out.println("队列元素个数: " + position);
    }

    private void log() {
        String content = "";
        for (int i = 0; i < strings.length; i++) {

            if (strings[i]==null){
                continue;
            }

            if (i == strings.length - 1) {
                content = content + strings[i] ;
            } else {
                content = content + strings[i]+ "=>";
            }
        }
        System.out.println(content);
    }

    public static void main(String[] args) {
        OrderQuque quque = new OrderQuque();
        quque.push("a");
        quque.push("b");
        quque.push("c");
        quque.push("d");
        quque.push("e");

        quque.log();
        quque.size();

        quque.pop();
        quque.pop();
        quque.pop();
        quque.pop();
        quque.pop();
        quque.log();
        quque.size();
    }
}
