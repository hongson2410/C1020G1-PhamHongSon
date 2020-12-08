package bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible;

import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.animal.Animal;
import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.animal.Chicken;
import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.animal.Tiger;
import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.edible.Edible;
import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.fruit.Apple;
import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.fruit.Fruit;
import bai7_abstractclass_interface.thuc_hanh.animal_interfaceedible.fruit.Orange;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
