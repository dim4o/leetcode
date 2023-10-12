package leetcode.util.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DataRace extends Thread {
    static List<Integer> arr = Collections.synchronizedList(new ArrayList<>());

    public void run() {
        Random random = new Random();
        int local = random.nextInt(10) + 1;
        arr.add(local);
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> synlist = Collections.synchronizedList(new ArrayList<>());
//        synlist.add("1");
//        synlist.add("2");

        DataRace t1 = new DataRace();
        DataRace t2 = new DataRace();
        DataRace t3 = new DataRace();
        DataRace t4 = new DataRace();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(1000);

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }

        System.out.println(DataRace.arr);

    }
}