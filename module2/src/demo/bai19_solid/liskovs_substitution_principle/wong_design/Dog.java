package demo.bai19_solid.liskovs_substitution_principle.wong_design;

public class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("gâu gâu");
    }
}
