package algorithm.tree.hash;

public class EmpLinkedList {
    private EmpNode head;

    public void addEmp(EmpNode node) {
        if (head == null) {
            head = node;
            return;
        }

        EmpNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }


    public void listEmp() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        EmpNode node = head;
        while (node.next != null) {
            System.out.println(node.toString());
            node = node.next;
        }
        System.out.println(node.toString());
    }

    public EmpNode find(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        EmpNode node = head;
        while (node.next != null) {
            if (node.id == id) {
                System.out.println("找到的雇员信息为: " + node.toString());
                break;
            }
            node = node.next;
        }
        return node;
    }

}
