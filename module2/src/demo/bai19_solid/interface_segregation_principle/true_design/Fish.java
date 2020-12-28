package demo.bai19_solid.interface_segregation_principle.true_design;

public class Fish implements IFish {
    @Override
    public void swim() {
        System.out.println("Code phương thức swim() của fish");
    }

}
