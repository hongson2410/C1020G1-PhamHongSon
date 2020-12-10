package bai8_dsa_list.thuc_hanh.linkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList linkedList = new MyLinkedList(10);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(13);

        linkedList.add(4, 9);
        linkedList.add(4, 7);
        linkedList.add(4, 10);
        linkedList.printList();

        System.out.println(linkedList.get(2));
    }
}

