package regressioncalculator;

import java.util.Scanner;

public class RegressionCalculator {
    

    public static void main(String[] args) {
        Storage myData = new Storage();
        Functions myFunctions = new Functions();
        Scanner reader = new Scanner(System.in);
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
            myData.add(xyPair);
            n++;
        }
        myData.add(n);
        
        System.out.println(myData);
        
        
    }
}
