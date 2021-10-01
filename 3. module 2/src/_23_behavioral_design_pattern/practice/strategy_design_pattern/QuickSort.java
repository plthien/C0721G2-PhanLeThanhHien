package _23_behavioral_design_pattern.practice.strategy_design_pattern;

import java.util.List;

public class QuickSort implements SortStrategy {
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Quick sort");
    }
}
