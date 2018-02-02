package regressioncalculator;

import java.util.Scanner;

public class RegressionCalculator {

    public static void main(String[] args) {
        /*fixedInput(1, 1);
        fixedInput(2, 5);
        fixedInput(3, 6);
        fixedInput(4, 8);
        fixedInput(5, 15);
        fixedInput(6, 16);*/
        inputProcess();
    }

    //creates a new x-y pair, adds it to storage, and increments sample size
    public static void inputProcess() {
        Storage myData = new Storage();
        System.out.println("Enter x - y value pairs. When finished, enter \"a\" instead of a number.");
        Scanner reader = new Scanner(System.in);
        int n = 0;

        //asks user for input pairs until "a" is entered
        while (true) {
            System.out.println("Enter x" + n);
            String input1 = reader.nextLine();
            if (input1.equals("a")) {
                break;
            }
            System.out.println("Enter y" + n);
            String input2 = reader.nextLine();
            if (input2.equals("a")) {
                break;
            }

            Pair inputPair = new Pair(Integer.parseInt(input1), Integer.parseInt(input2));
            myData.add(inputPair);
            n++;
        }
        System.out.println(myData);
    }

    public static void fixedInput(int x, int y) {
        Storage myData = new Storage();
        Pair inputPair = new Pair(x, y);
        myData.add(inputPair);
    }
}
