package _04_class_object.exercise;

public class StopWatchMain {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int [] arr = new int[100000];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (int) Math.round(Math.random()* 100 );
        }
        stopWatch.start();
        System.out.println("Start is " + stopWatch.getStartTime());
        for (int i = 0; i < arr.length -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        stopWatch.stop();
        System.out.println("End is " + stopWatch.getEndTime());
        System.out.println("Distance is " + stopWatch.getElapsedTime());
    }
}
