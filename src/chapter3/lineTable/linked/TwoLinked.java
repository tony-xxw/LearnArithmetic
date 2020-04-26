package chapter3.lineTable.linked;

public class TwoLinked {
    private int size;

    private Node head = new Node(null, "head", null);

    void addNode(String content) {
        Node newNode = new Node(content);

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
        size++;
    }

    private void log() {
        Node temp = head;
        String content = "";
        while (temp.next != null) {
            if (temp.content.equals("head")) {
                content = content + ("pre: null cur: " + temp.content + " next: " + temp.next.content + "\n");
            } else {
                content = content + ("pre: " + temp.pre.content + " cur: " + temp.content + " next: " + temp.next.content) + "\n";
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            content = content + ("pre: " + temp.pre.content + " cur: " + temp.content + " next: end") + "\n";
        }
        System.out.println(content);
    }

    private void deleteNode(int index) {
        if (index<0 || index>getSize()){
            return;
        }
        Node pre = head;
        Node cur = pre.next;
        int  position = 1;
        while (cur.next!=null){
            if (position == index){
                pre.next = cur.next;
                cur.next.pre = pre;
                size--;
                break;
            }
            position++;
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        TwoLinked twoLinked = new TwoLinked();
        twoLinked.addNode("a");
        twoLinked.addNode("b");
        twoLinked.addNode("c");
        twoLinked.addNode("d");
        twoLinked.log();
        System.out.println("size: " + twoLinked.getSize());

        System.out.println();
        twoLinked.deleteNode(1);
        twoLinked.log();
        System.out.println("size: " + twoLinked.getSize());

    }
}
