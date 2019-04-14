package calculator.domain;

import java.util.ArrayList;
import calculator.logic.CalculatorProcesses;

public class Main {
	
	public static void main(String[] args) {
		CalculatorProcesses process = new CalculatorProcesses();
		ArrayList<Pair> listOfInputPairs = process.inputProcess();
		ArrayList<OutputStat> listOfStats = process.mathProcess(listOfInputPairs);
		process.outputProcess(listOfInputPairs, listOfStats);
	}

}
