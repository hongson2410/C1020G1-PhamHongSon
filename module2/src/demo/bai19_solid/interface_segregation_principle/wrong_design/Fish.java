package demo.bai19_solid.interface_segregation_principle.wrong_design;

public class Fish implements IAnimal {
    @Override
    public void run() {

    }

    @Override
    public void swim() {
        System.out.println("Code phương thức swim() của fish");
    }

    @Override
    public void fly() {

    }

}
