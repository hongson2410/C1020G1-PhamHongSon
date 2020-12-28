package demo.bai19_solid.interface_segregation_principle.wrong_design;

public class Bird implements IAnimal {


    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void fly() {
        System.out.println("Code phương thức fly của bird");
    }
}
