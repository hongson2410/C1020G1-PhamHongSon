package bai11_generic_stack_queue.bai_tap.trien_khai_queue_lien_ket_vong;

public class Queue<T> {
    private Node front;
    private Node rear;

    public Queue() {
    }

    public void enQueue(T element) {
        Node temp = new Node(element);
        if (front == null) {
            front= rear = temp;
            rear.setLink(front);
            return;
        }
        rear.setLink(temp);
        rear = temp;
        rear.setLink(front);
    }

    public T deQueue() {
        if (front == null) {
            return null;
        }
        T temp = (T) front.getData();

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.getLink();
            rear.setLink(front);
        }
        return temp;
    }

    public String displayQueue(){
        Node temp = front;
        String display = "";
        while(front != temp.getLink() ){
            display += (T)temp.getData()+"\t";
            temp = temp.getLink();
        }
        return display;
    }
}
