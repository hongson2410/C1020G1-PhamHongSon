package bai10_dsa_list.bai_tap.linkedlist;

public class LinkedListTest {
    public static void display(LinkedList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + "\t");
        }
        System.out.print("\n" +"Size: ");
        System.out.println(array.size());
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst( 1);
        linkedList.add(1, 2);
        linkedList.addFirst(3);
        linkedList.add(3, 4);
        linkedList.addLast(5);
        display(linkedList);

        System.out.println(linkedList.indexOf(7));

        LinkedList<Integer> newList = new LinkedList<>();
        newList= linkedList.clone();
        newList.addLast(9);
        System.out.println("New List");
        display(newList);

        System.out.println(newList.getFirst());
        System.out.println(newList.getLast());

        newList.clear();
        display(newList);
    }
}
