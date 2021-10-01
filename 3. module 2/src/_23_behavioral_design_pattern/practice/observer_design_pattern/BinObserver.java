package _23_behavioral_design_pattern.practice.observer_design_pattern;

public class BinObserver extends Observer {

    public BinObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.print(" " + Integer.toBinaryString(subject.getState()));
    }
}
