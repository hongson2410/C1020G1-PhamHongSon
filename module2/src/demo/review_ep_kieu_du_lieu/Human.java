package demo.review_ep_kieu_du_lieu;

public class Human extends Person {
    public Human() {
        super();
    }

    public Human(String name, int age) {
        super(name, age);
    }

    public void showInfo(){
        System.out.println("Human:" + super.getName());
    }
}
