package regressioncalculator;

import java.util.Scanner;

public class RegressionCalculator {

    public static void main(String[] args) {
        Pair xyPair = new Pair();
        inputProcess(xyPair);
        outputProcess(xyPair);
    }

    public static void inputProcess(Pair xyPair) {
        System.out.println("Enter x - y value pairs. When finished, enter \"a\" instead of a number.");
        Scanner reader = new Scanner(System.in);
        int i = 0;

        while (true) {
            System.out.println("Enter x" + i);
            String xInput = reader.nextLine();
            if (endCheck(xInput)) {
                break;
            }
            System.out.println("Enter y" + i++);
            String yInput = reader.nextLine();
            if(endCheck(yInput)){
                break;
            }
            
            xyPair = new Pair (Double.parseDouble(xInput), Double.parseDouble(yInput));
            xyPair.addToTable();
        }
    }
    
    public static boolean endCheck(String input){
        return input.equals("a");
    }
    
    public static void outputProcess(Pair xyPair){
        System.out.println(xyPair);
    }
}
