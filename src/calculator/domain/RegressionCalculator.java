package calculator.domain;

import java.util.Scanner;
import java.util.ArrayList;
import calculator.logic.MyMath;

public class RegressionCalculator {

    public static void main(String[] args) {
        ArrayList<Pair> inputTable = inputProcess();
        ArrayList<Pair> outputTable = mathProcess(inputTable);
        outputProcess(inputTable, outputTable);
    }

    //need to include error handling in this method
    public static ArrayList<Pair> inputProcess() {
        System.out.println("Enter x - y value pairs. When finished, hit return instead of a number.");
        Scanner reader = new Scanner(System.in);
        ArrayList<Pair> inputTable = new ArrayList<Pair>();
        int variableIndex = 0;

        while (true) {
            System.out.println("Enter x" + variableIndex);
            String xInput = reader.nextLine();
            if (endState(xInput)) {
                break;
            }
            
            System.out.println("Enter y" + variableIndex++);
            String yInput = reader.nextLine();
            if (endState(yInput)) {
                break;
            }
            
            //if bad output occurs, it breaks the while loop before reaching this block
            try {
            	Pair xyPair = new Pair(Double.parseDouble(xInput), Double.parseDouble(yInput));
            	inputTable.add(xyPair);
            } catch(Exception ex) {
            	System.out.println("Bad Input");
            }
        }
        
        reader.close();
        return inputTable;
    }

    public static boolean endState(String input) {
        return input.equals("");
    }

    public static ArrayList<Pair> mathProcess(ArrayList<Pair> inputTable) {
        MyMath calculator = new MyMath(inputTable);
        ArrayList<Pair> outputTable = new ArrayList<Pair>();

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

    public static void outputProcess(ArrayList<Pair> inputTable, ArrayList<Pair> outputTable) {
        String dataStr = "";
        String mathStr = "";
        
        //creates a string of all the input pairs for display
        for (Pair xyPair : inputTable) {
            dataStr += "(" + xyPair.getX() + ", " + xyPair.getY() + ")\n";
        }

        //creates a string of all the descriptive statistics for display
        for (Pair varPair : outputTable) {
            mathStr += varPair.getDescription() + "   " + varPair.getVariable() + "\n";
        }
        
        System.out.println(dataStr);
        System.out.println(mathStr);
    }
}
