package regressioncalculator;

import java.util.Scanner;

public class RegressionCalculator {

    public static void main(String[] args) {
        Storage myData = new Storage();
        Functions myFunctions = new Functions();
        Scanner reader = new Scanner(System.in);
        int n = 0;

        // System.out.println("Enter x - y value pairs. When finished, enter \"a\" instead of a number.");
        //asks user for input pairs until "a" is entered
        /*  while (true) {
            System.out.println("Enter x" + n);
            String input1 = reader.nextLine();
            if (input1.equals("a")) {
                break;
            }
            System.out.println("Enter y" + n);
            String input2 = reader.nextLine();
            if (input2.equals("a")) {
                break;
            } */
        //creates a new x-y pair, adds it to storage, and increments sample size
        Pair xyPair = new Pair(1, 1);
        myData.add(xyPair);
        xyPair = new Pair(2, 5);
        myData.add(xyPair);
        xyPair = new Pair(3, 6);
        myData.add(xyPair);
        xyPair = new Pair(4, 8);
        myData.add(xyPair);
        xyPair = new Pair(5, 15);
        myData.add(xyPair);
        xyPair = new Pair(6, 16);
        myData.add(xyPair);
        n++;
        myData.add(6);

        System.out.println(myData);
    }

}

