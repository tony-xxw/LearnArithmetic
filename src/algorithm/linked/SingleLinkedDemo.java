package algorithm.linked;

public class SingleLinkedDemo {

    public static void main(String[] args) {
//
        SingleLinked singleLinked = new SingleLinked();
//        singleLinked.addNode(new Node(1, "林冲", "豹子头"));
//        singleLinked.addNode(new Node(2, "宋江", "及时雨"));
//        singleLinked.addNode(new Node(3, "鲁智深", "花和尚"));
//        singleLinked.addNode(new Node(4, "武松", "行者"));
//
//
//        singleLinked.list();
//
//        singleLinked.updateNode(new Node(2, "公孙胜", "入云龙"));
//
//        System.out.println();
//        singleLinked.list();
//
//
//        singleLinked.deleteNode(new Node(3, "鲁智深", "花和尚"));
//        System.out.println();
//        singleLinked.list();
//
//        System.out.println();

        singleLinked.addOrderNode(new Node(1, "林冲", "豹子头"));
        singleLinked.addOrderNode(new Node(4, "宋江", "及时雨"));
        singleLinked.addOrderNode(new Node(4, "宋江", "及时雨"));
        singleLinked.addOrderNode(new Node(3, "鲁智深", "花和尚"));
        singleLinked.addOrderNode(new Node(2, "武松", "行者"));

        singleLinked.list();


    }

    static class SingleLinked {
        private Node head = new Node(0, "", "");


        void addNode(Node newNode) {

            if (newNode == null) {
                System.out.println("添加的结点不能为空");
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        void deleteNode(Node node) {
            if (node == null) {
                System.out.println("添加的结点不能为空");
                return;
            }

            if (head.next == null) {
                System.out.println("链表不能为空");
                return;
            }

            Node temp = head;
            while (temp.next != null) {
                if (temp.next.no == node.no) {
                    //要删除的结点
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
        }

        void updateNode(Node node) {
            if (node == null) {
                System.out.println("添加的结点不能为空");
                return;
            }

            if (head.next == null) {
                System.out.println("链表不能为空");
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.no == node.no) {
                    temp.next.name = node.name;
                    temp.next.nikeName = node.nikeName;
                }
                temp = temp.next;
            }

        }

        void addOrderNode(Node node) {
            if (node == null) {
                System.out.println("添加的结点不能为空");
                return;
            }

            Node temp = head;
            boolean isJoin = false;
            while (temp.next != null) {
                //当前结点小于 加入结点
//                if (temp.next.no < node.no) {
//                    temp = temp.next;
//                } else {
//                    isJoin = true;
//                    break;
//                }
                if (temp.next.no > node.no) {
                    break;
                } else if (temp.next.no == node.no) {
                    isJoin = true;
                    break;
                }
                temp = temp.next;
            }
            if (isJoin) {
                System.out.println("当前英雄已在排名，无需反复添加");
            } else {
                //加入结点插入到当前结点前面,当前结点后移
                node.next = temp.next;
                temp.next = node;
            }
        }

        void list() {
            Node temp = head;
            while (temp.next != null) {
                System.out.println(temp.next);
                temp = temp.next;
            }
        }


    }

    static class Node {
        private String name;
        private String nikeName;
        private int no;
        private Node next;


        public Node(int no, String name, String nikeName) {
            this.name = name;
            this.nikeName = nikeName;
            this.no = no;
        }

        @Override
        public String toString() {
            return "Node =>  no: " + no + " name: " + name + " nikeName: " + nikeName;
        }
    }
}
