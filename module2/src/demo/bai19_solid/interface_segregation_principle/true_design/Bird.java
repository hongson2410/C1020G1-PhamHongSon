package demo.bai19_solid.interface_segregation_principle.true_design;

public class Bird implements IBird {

    @Override
    public void fly() {
        System.out.println("Code phương thức fly của bird");
    }
}
