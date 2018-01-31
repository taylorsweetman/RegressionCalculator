package regressioncalculator;

import java.util.Scanner;

public class RegressionCalculator {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Storage DB = new Storage();
        int n = 0;

        System.out.println("Enter x - y value pairs. When finished, enter a instead of a number.");
        
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
            Pair xyPair = new Pair(input1, input2);
            DB.add(xyPair);
            n++;
        }
        
        DB.add(n);
        
        System.out.println(DB);
    }
}
