package calculator.logic;

import java.util.ArrayList;
import java.util.Scanner;
import calculator.domain.OutputStat;
import calculator.domain.Pair;
import database.DBConnection;

public class CalculatorProcesses {
	
	private Scanner reader;
	//eliminate these tables
	private ArrayList<Pair> inputTable;
	private ArrayList<OutputStat> outputTable;
	//
	private MathLogic calculator;
	private DBConnection db;
	
	
	public CalculatorProcesses() {
		reader = new Scanner(System.in);
		inputTable = new ArrayList<Pair>();
		outputTable = new ArrayList<OutputStat>();
		db = new DBConnection();
	}
	

	// need to include error handling in this method
	public ArrayList<Pair> inputProcess() {
		System.out.println("Enter x - y value pairs. When finished, hit return instead of a number.");
		int variableIndex = 1;

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
				Pair xyPair = new Pair();
				xyPair.setX(Double.parseDouble(xInput));
				xyPair.setY(Double.parseDouble(yInput));
				inputTable.add(xyPair);
				
				//persist to DB
				db.persistPair(xyPair);
				
				//increment variableIndex
				variableIndex++;
			} catch (Exception ex) {
				System.out.println("Bad Input");
			}
		}

		reader.close();
		return inputTable;
	}

	public boolean endState(String input) {
		return input.equals("");
	}

	public ArrayList<OutputStat> mathProcess(ArrayList<Pair> inputTable) {
		
		calculator = new MathLogic(inputTable);

		double xBar = calculator.xBar();
		addStatistic("xBar", xBar);

		double yBar = calculator.yBar();
		addStatistic("yBar", yBar);

		double xVar = calculator.xVar();
		addStatistic("xVar", xVar);

		double yVar = calculator.yVar();
		addStatistic("yVar", yVar);

		double xyCov = calculator.xyCov();
		addStatistic("xyCov", xyCov);

		double beta1 = calculator.beta1();
		addStatistic("beta1", beta1);

		double beta0 = calculator.beta0();
		addStatistic("beta0", beta0);

		db.close();
		return outputTable;
	}
	
	public void addStatistic(String name, double value) {
		OutputStat outputStat = new OutputStat();
		outputStat.setDescription(name);
		outputStat.setValue(value);
		db.persistStats(outputStat);
		//do away with these tables
		outputTable.add(outputStat);
	}

	public void outputProcess(ArrayList<Pair> inputPairs, ArrayList<OutputStat> outputStats) {
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
