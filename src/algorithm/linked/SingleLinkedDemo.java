package algorithm.linked;

public class SingleLinkedDemo {

    public static void main(String[] args) {

        singleLinked();
    }

    static void JosephSample() {
        JosephLinkedList josephLinkedList = new JosephLinkedList();
        josephLinkedList.addNode(5);

        josephLinkedList.list();
        josephLinkedList.start(1, 2, 5);
    }


    static void doubleLinked() {
        DoubleLinked singleLinked = new DoubleLinked();
        System.out.println("双向链表新增");
        singleLinked.addOrderNode(new Node(1, "林冲", "豹子头"));
        singleLinked.addOrderNode(new Node(3, "宋江", "及时雨"));
        singleLinked.addOrderNode(new Node(2, "鲁智深", "花和尚"));
        singleLinked.addOrderNode(new Node(4, "武松", "行者"));
        singleLinked.list();

        System.out.println("双向链表修改");
        singleLinked.updateNode(new Node(2, "公孙胜", "入云龙"));
        singleLinked.list();


        System.out.println("双向链表删除");
        singleLinked.deleteNode(new Node(3, "鲁智深", "花和尚"));
        singleLinked.list();
//
    }

    static void singleLinked() {
        SingleLinked singleLinked = new SingleLinked();
//        System.out.println("新增单向链表");
//        singleLinked.addNodeExe(new Node(1, "林冲", "豹子头"));
//        singleLinked.addNodeExe(new Node(2, "宋江", "及时雨"));
//        singleLinked.addNodeExe(new Node(3, "鲁智深", "花和尚"));
//        singleLinked.addNodeExe(new Node(4, "武松", "行者"));
//        singleLinked.listExe();
//
//        System.out.println();
//        System.out.println("更新单向链表");
//        singleLinked.updateNodeExe(new Node(2, "公孙胜", "入云龙"));
//        singleLinked.list();
//
//
//        System.out.println();
//        System.out.println("删除单向链表");
//        singleLinked.deleteNode(new Node(3, "鲁智深", "花和尚"));
//        singleLinked.list();


        System.out.println("按顺序添加单向链表");
        singleLinked.addSortNode(new Node(1, "林冲", "豹子头"));
        singleLinked.addSortNode(new Node(4, "宋江", "及时雨"));
        singleLinked.addSortNode(new Node(4, "宋江", "及时雨"));
        singleLinked.addSortNode(new Node(2, "鲁智深", "花和尚"));
        singleLinked.addSortNode(new Node(3, "武松", "行者"));
        singleLinked.list();
        System.out.println("链表节点个数");
        System.out.println(singleLinked.getSize());
        System.out.println("倒数第K个结点");
        singleLinked.bottomIndex(1);
        System.out.println();
        System.out.println("链表反转");
        singleLinked.reverse();
        singleLinked.list();
        System.out.println("逆向打印");
        singleLinked.reverseLog();
        System.out.println("合并两个单链表");
        SingleLinked singleLinked1 = new SingleLinked();
        singleLinked1.addNode(new Node(5, "Wynne", "哈哈哈"));
        singleLinked1.addNode(new Node(6, "XXW", "哈哈哈"));
        singleLinked1.addNode(new Node(7, "向鲜汶", "嘻嘻嘻"));

        singleLinked.mergeLinkedList(singleLinked1).list();
    }

}
