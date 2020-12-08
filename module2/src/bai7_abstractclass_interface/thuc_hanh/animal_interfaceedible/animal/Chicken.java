package bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.animal;

import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
