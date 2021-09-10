package _07_abstract_interface.practice;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Chicken: tuck tac !";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
