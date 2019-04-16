package calculator.logic;

import java.util.ArrayList;
import java.util.Scanner;
import calculator.domain.OutputStat;
import calculator.domain.Pair;
import database.DBConnection;

public class CalculatorProcesses {

	private Scanner reader;
	private ArrayList<Pair> inputTable;
	private ArrayList<OutputStat> outputTable;
	private MathLogic calculator;
	private DBConnection db;

	public CalculatorProcesses() {
		reader = new Scanner(System.in);
		inputTable = new ArrayList<Pair>();
		outputTable = new ArrayList<OutputStat>();
		db = new DBConnection();
	}

	public ArrayList<Pair> inputProcess() {
		System.out.println("Enter x - y variable pairs. When finished, hit return instead of an x variable.");
		int variableIndex = 0;

		// continuously asks the user for input until the user hits return in lieu of a
		// variable
		while (true) {
			System.out.println("Enter x" + variableIndex);

			// translates user input to a double type; returns -9999 in the case the user
			// wishes to exit process
			double xValue = readInputFromUser();
			if (xValue == -9999) {
				break;
			}

			System.out.println("Enter y" + variableIndex);
			double yValue = readInputFromUser();
			// if the user wishes to exit before giving the final y value, this loop will
			// force them to enter one
			while (yValue == -9999) {
				System.out.println("Cannot exit program since each x variable must have a "
						+ "corresponding y value. Please enter the corresponding y value, then exit the program.");
				yValue = readInputFromUser();
			}

			// creates xyPair and inputs user's variables for each
			Pair xyPair = new Pair();
			xyPair.setX(xValue);
			xyPair.setY(yValue);
			inputTable.add(xyPair);

			// persist to DB
			db.persistPair(xyPair);

			// increment variableIndex
			variableIndex++;
		}

		reader.close();
		return inputTable;
	}

	public double readInputFromUser() {
		String stringInput;
		double inputValue;

		while (true) {
			try {
				stringInput = reader.nextLine();
				// if user hits return w/o a number, return -9999 to indicate they wish to end
				// process
				if (stringInput.equals("")) {
					return -9999;
				}
				inputValue = Double.parseDouble(stringInput);
				
			} catch (NumberFormatException badInput) {
				System.out.println("The input must be a number, please try again.");
				continue;
			}
			return inputValue;
		}
	}

	/*uses the logic from MathLogic to calculate the needed statistics from the user input pairs
	adds these needed statistics to an ArrayList for later display
	also persists output stats to database via addStatistic method*/
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
		
		double rSquared = calculator.rSquared();
		addStatistic("rSquared", rSquared);

		db.close();
		return outputTable;
	}

	//adds OutputStat objects to outputTable and persists them to the DB
	public void addStatistic(String name, double value) {
		OutputStat outputStat = new OutputStat();
		outputStat.setDescription(name);
		outputStat.setValue(value);
		db.persistStats(outputStat);
		outputTable.add(outputStat);
	}

	public void outputProcess(ArrayList<Pair> inputPairs, ArrayList<OutputStat> outputStats) {
		String inputPairsString = "---Input x, y pairs---\n";
		String outputStatsString = "---Statistics---\n";

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
