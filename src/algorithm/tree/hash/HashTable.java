package algorithm.tree.hash;

import java.util.Scanner;

public class HashTable {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable(7);

        String key = "";

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("添加雇员");
            System.out.println("显示雇员");
            System.out.println("查找雇员");
            System.out.println("退出");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入一个id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    EmpNode empNode = new EmpNode(name, id);
                    hashTable.addEmp(empNode);
                    break;
                case "show":
                    hashTable.listEmp();
                    break;
                case "find":
                    System.out.println("请输入一个id");
                    int empId = scanner.nextInt();
                    hashTable.findEmp(empId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }


    }

    private EmpLinkedList[] empLinkedList;
    int mSize;

    public HashTable(int size) {
        mSize = size;
        empLinkedList = new EmpLinkedList[size];
        for (int i = 0; i < empLinkedList.length; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    void addEmp(EmpNode empNode) {
        int no = hash(empNode.id);
        empLinkedList[no].addEmp(empNode);
    }

    void listEmp() {
        for (EmpLinkedList linkedList : empLinkedList) {
            linkedList.listEmp();
        }
    }

    void findEmp(int id) {
        int hash = hash(id);
        EmpNode empNode = empLinkedList[hash].find(id);
        System.out.println(empNode);
    }

    int hash(int id) {
        return id % mSize;

    }
}
