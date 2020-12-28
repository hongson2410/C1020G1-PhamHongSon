package demo.bai19_solid.interface_segregation_principle.true_design;

public class Dog implements IAnimal {
    @Override
    public void run() {
        System.out.println("code phương thức run của dog");
    }

}
