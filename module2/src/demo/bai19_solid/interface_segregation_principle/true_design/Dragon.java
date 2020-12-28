package demo.bai19_solid.interface_segregation_principle.true_design;

public class Dragon implements IFish, IBird {

    @Override
    public void swim() {
        System.out.println("Code phương thức swim của Dragon");
    }

    @Override
    public void fly() {
        System.out.println("Code phương thức fly của Dragon");
    }
}
