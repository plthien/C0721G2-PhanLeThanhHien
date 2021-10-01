package _23_behavioral_design_pattern.practice.observer_design_pattern;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
