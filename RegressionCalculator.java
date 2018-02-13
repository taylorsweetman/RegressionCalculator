package regressioncalculator;

import java.util.Scanner;
import java.util.ArrayList;

public class RegressionCalculator {

    public static void main(String[] args) {
        ArrayList<Pair> inputTable = inputProcess();
        ArrayList<Pair> outputTable = mathProcess(inputTable);
        outputProcess(inputTable, outputTable);
    }

    /*Runs a process to ask the user for input Pairs. Each of these pairs is stored in an ArrayList for later processing. 
    Process breaks when user inputs the character "a".*/
    public static ArrayList<Pair> inputProcess() {
        System.out.println("Enter x - y value pairs. When finished, enter \"a\" instead of a number.");
        Scanner reader = new Scanner(System.in);
        ArrayList<Pair> inputTable = new ArrayList<>();
        int i = 0;

        while (true) {
            System.out.println("Enter x" + i);
            String xInput = reader.nextLine();
            if (endCheck(xInput)) {
                break;
            }
            System.out.println("Enter y" + i++);
            String yInput = reader.nextLine();
            if (endCheck(yInput)) {
                break;
            }
            Pair xyPair = new Pair(Double.parseDouble(xInput), Double.parseDouble(yInput));
            inputTable.add(xyPair);
        }
        return inputTable;
    }

    public static boolean endCheck(String input) {
        return input.equals("a");
    }

    /*Runs the input table through the math processes defined in MyMath class. 
    All statistics are then stored in an output table for later use.*/
    public static ArrayList<Pair> mathProcess(ArrayList<Pair> inputTable) {
        MyMath calculator = new MyMath(inputTable);
        ArrayList<Pair> outputTable = new ArrayList<>();

        double xBar = calculator.xBar();
        Pair outputPair = new Pair("xBar", xBar);
        outputTable.add(outputPair);

        double yBar = calculator.yBar();
        outputPair = new Pair("yBar", yBar);
        outputTable.add(outputPair);

        double xVar = calculator.xVar();
        outputPair = new Pair("xVar", xVar);
        outputTable.add(outputPair);

        double yVar = calculator.yVar();
        outputPair = new Pair("yVar", yVar);
        outputTable.add(outputPair);

        double xyCov = calculator.xyCov();
        outputPair = new Pair("xyCov", xyCov);
        outputTable.add(outputPair);

        double beta1 = calculator.beta1();
        outputPair = new Pair("beta1", beta1);
        outputTable.add(outputPair);

        double beta0 = calculator.beta0();
        outputPair = new Pair("beta0", beta0);
        outputTable.add(outputPair);

        return outputTable;
    }

    //This method is currently used for unit testing. Can be imporved for user readability.
    public static void outputProcess(ArrayList<Pair> inputTable, ArrayList<Pair> outputTable) {
        String dataStr = "Input Pairs\n";
        String mathStr = "Statistics\n";
        int i = 0;

        for (Pair xyPair : inputTable) {
            dataStr += "(" + xyPair.getX() + ", " + xyPair.getY() + ")\n";
        }

        for (Pair varPair : outputTable) {
            mathStr += varPair.getDescription() + "   " + varPair.getValue() + "\n";
        }
        
        MyMath newMath = new MyMath(inputTable);
        double beta0 = newMath.beta0();
        double beta1 = newMath.beta1();
                
        System.out.println(dataStr);
        System.out.println(mathStr);
        System.out.println("Linear Regression Formula\ny = " + beta0 + " + " + beta1 + " * x");
    }
}
