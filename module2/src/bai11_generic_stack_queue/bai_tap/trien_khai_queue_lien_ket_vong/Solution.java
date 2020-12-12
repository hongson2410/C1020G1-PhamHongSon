package bai11_generic_stack_queue.bai_tap.trien_khai_queue_lien_ket_vong;

public class Solution {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        System.out.println(queue.displayQueue());
        queue.enQueue(2);
        System.out.println(queue.displayQueue());
        queue.enQueue(3);
        System.out.println(queue.displayQueue());
        queue.enQueue(4);
        System.out.println(queue.displayQueue());
        queue.enQueue(5);
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

    }
}
