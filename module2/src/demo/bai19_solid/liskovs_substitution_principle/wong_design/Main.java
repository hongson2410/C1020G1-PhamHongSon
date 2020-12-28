package demo.bai19_solid.liskovs_substitution_principle.wong_design;

import java.util.ArrayList;
import java.util.List;

/**
 * Theo nguyên lý thay thế của Liskov thì mọi đối tượng của lớp cha có thể bị thay thế
 * bởi đối tượng của lớp con mà không làm ảnh hưởng chương trình
 */
public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        /**
         * các đối tượng của lớp IAnimal được thay bằng các đối tượng của lớp con là Dog và Cat
         */
        animals.add(new Dog());
        animals.add(new Cat());
        //Chương trình chạy đúng
        for (Animal animal : animals) {
            animal.makeNoise();
        }

        /**
         * Cho đến khi xuất hiện lớp con là MuteCat con mèo câm thì không thể phát ra tiếng động
         */
        animals.add(new MuteCat());
        for (Animal animal : animals) {
            animal.makeNoise();
        }
        /**đối tượng MuteCat không thể thay thế cho lớp cha, cách thiết kế này không tuân theo nguyên lý
         Liskov, nó không còn giữ được tính đúng đắn của chương trình
         Đây là nguyên lý dễ bị vi phạm nhất. Vì vậy hãy chỉ cho class A kế thừa được class B khi A thay
         thế được cho B
         */
    }
}
