package _21_design_pattern.practice.factory_method;

public class Dog extends Animal {

    @Override
    public String makeSound() {
        return "Woof";
    }
}
