package calculator.domain;

import java.util.Scanner;
import java.util.ArrayList;
import calculator.logic.MathLogic;

public class RegressionCalculator {

	public static void main(String[] args) {
		ArrayList<Pair> listOfInputPairs = inputProcess();
		ArrayList<OutputStat> listOfStats = mathProcess(listOfInputPairs);
		outputProcess(listOfInputPairs, listOfStats);
	}

	// need to include error handling in this method
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

			System.out.println("Enter y" + variableIndex);
			String yInput = reader.nextLine();
			if (endState(yInput)) {
				break;
			}

			// if bad output occurs, it breaks the while loop before reaching this block
			try {
				Pair xyPair = new Pair(Double.parseDouble(xInput), Double.parseDouble(yInput), variableIndex);
				inputTable.add(xyPair);
				variableIndex++;
			} catch (Exception ex) {
				System.out.println("Bad Input");
			}
		}

		reader.close();
		return inputTable;
	}

	public static boolean endState(String input) {
		return input.equals("");
	}

	public static ArrayList<OutputStat> mathProcess(ArrayList<Pair> inputTable) {
		MathLogic calculator = new MathLogic(inputTable);
		ArrayList<OutputStat> outputTable = new ArrayList<OutputStat>();

		double xBar = calculator.xBar();
		OutputStat outputStat = new OutputStat("xBar", xBar);
		outputTable.add(outputStat);

		double yBar = calculator.yBar();
		outputStat = new OutputStat("yBar", yBar);
		outputTable.add(outputStat);

		double xVar = calculator.xVar();
		outputStat = new OutputStat("xVar", xVar);
		outputTable.add(outputStat);

		double yVar = calculator.yVar();
		outputStat = new OutputStat("yVar", yVar);
		outputTable.add(outputStat);

		double xyCov = calculator.xyCov();
		outputStat = new OutputStat("xyCov", xyCov);
		outputTable.add(outputStat);

		double beta1 = calculator.beta1();
		outputStat = new OutputStat("beta1", beta1);
		outputTable.add(outputStat);

		double beta0 = calculator.beta0();
		outputStat = new OutputStat("beta0", beta0);
		outputTable.add(outputStat);

		return outputTable;
	}

	public static void outputProcess(ArrayList<Pair> inputPairs, ArrayList<OutputStat> outputStats) {
		String inputPairsString = "";
		String outputStatsString = "";

		// creates a string of all the input pairs for display
		for (Pair xyPair : inputPairs) {
			inputPairsString += "(" + xyPair.getX() + ", " + xyPair.getY() + ")\n";
		}

		// creates a string of all the descriptive statistics for display
		for (OutputStat stat : outputStats) {
			outputStatsString += stat.getDescription() + "   " + stat.getValue() + "\n";
		}

		System.out.println(inputPairsString);
		System.out.println(outputStatsString);
	}
}
